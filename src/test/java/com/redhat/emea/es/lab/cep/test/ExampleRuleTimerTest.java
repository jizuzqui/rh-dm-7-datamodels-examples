package com.redhat.emea.es.lab.cep.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.drools.core.command.runtime.rule.FireUntilHaltCommand;
import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.redhat.emea.es.lab.kie.BaseKieTest;
import com.redhat.emea.es.lab.model.mock.Incident;
import com.redhat.emea.es.lab.model.mock.Status;

public class ExampleRuleTimerTest extends BaseKieTest {

    private static final Logger log = LoggerFactory.getLogger(ExampleRuleTimerTest.class);

    @Test(groups = { GRP_DM }, enabled = true, priority = 1)
    @Parameters(value = { "ksessiontimer" })
    public void testFireUntilHalt(String ksessionname) {
        execFireUntilHalt(ksessionname);
    }

    @Test(groups = { GRP_DM }, enabled = false, priority = 20)
    @Parameters(value = { "ksessiontimer" })
    public void testFireRules01(String ksessionname) {
        try {
            //
            // Command haltCommand = new HaltCommand();
            // commands.add(haltCommand);
            // commands.add(cmdFactory.newFireAllRules());

            String entrypoint = "entrypublic";
            UUID uuid = UUID.randomUUID();
            Incident incident = new Incident();
            incident.setContractId(uuid.toString());
            incident.setStatus(Status.OPEN);
            // Generate Commands
            KieCommands cmdFactory = KieServices.Factory.get().getCommands();
            log.debug("ksFireAllRule()--->KieCommands implementation: '{}'", cmdFactory.getClass().getName());
            List<Command> commands = new ArrayList<Command>();
            //
            commands.add(cmdFactory.newInsert(incident, "incident", true, entrypoint));

            Incident incident2 = new Incident();
            incident2.setContractId(UUID.randomUUID().toString());
            incident2.setStatus(Status.OPEN);
            commands.add(cmdFactory.newInsert(incident2, "incident2", true, entrypoint));
            Incident incident3 = new Incident();
            incident3.setContractId(UUID.randomUUID().toString());
            incident3.setStatus(Status.WORKINPROGRESS);
            commands.add(cmdFactory.newInsert(incident3, "incident3", true, entrypoint));
            //
            BatchExecutionCommand command = cmdFactory.newBatchExecution(commands, ksessionname);
            ksFireAllRule(command);
        } catch (Exception e) {
            log.error("testFireRules01()--->" + e.getMessage(), e);
            Assert.fail(e.getMessage(), e);
        }
    }

    @Test(groups = { GRP_DM }, enabled = true, priority = 50)
    @Parameters(value = { "ksessiontimer" })
    public void testQuery01(String ksessionname) {
        try {
            String identifier = "incidentsOpen";
            String queryName = "incidentsOpen";
            log.info("testQuery01()--->Identifier: '{}', QueryName: '{}', KBase: '{}'", identifier, queryName,
                    ksessionname);
            KieCommands cmdFactory = KieServices.Factory.get().getCommands();
            //
            List<Command> commands = new ArrayList<Command>();
            commands.add(cmdFactory.newQuery(identifier, queryName));
            BatchExecutionCommand command = cmdFactory.newBatchExecution(commands, ksessionname);
            execQuery(identifier, queryName, command);
            log.info("testQuery01()--->End");
        } catch (Exception e) {
            log.error("testQuery01()--->" + e.getMessage(), e);
            Assert.fail(e.getMessage(), e);
        }
    }

    @Test(groups = { GRP_DM }, enabled = true, priority = 50)
    @Parameters(value = { "ksessiontimer" })
    public void testQuery02(String ksessionname) {
        try {
            String identifier = "incidentsByStatus";
            String queryName = "incidentsByStatus";
            log.info("testQuery02()--->Identifier: '{}', QueryName: '{}', KBase: '{}'", identifier, queryName,
                    ksessionname);
            KieCommands cmdFactory = KieServices.Factory.get().getCommands();
            //
            List<Command> commands = new ArrayList<Command>();
            Object[] arguments = { Status.WORKINPROGRESS };
            commands.add(cmdFactory.newQuery(identifier, queryName, arguments));
            BatchExecutionCommand command = cmdFactory.newBatchExecution(commands, ksessionname);
            execQuery(identifier, queryName, command);
            log.info("testQuery02()--->End");
        } catch (Exception e) {
            log.error("testQuery02()--->" + e.getMessage(), e);
            Assert.fail(e.getMessage(), e);
        }
    }

    @Test(groups = { GRP_DM }, enabled = true, priority = 60)
    @Parameters(value = { "ksessiontimer" })
    public void testQuery03(String ksessionname) {
        try {
            String identifier = "allIncidents";
            String queryName = "allIncidents";
            log.info("testQuery03()--->Identifier: '{}', QueryName: '{}', KBase: '{}'", identifier, queryName,
                    ksessionname);
            KieCommands cmdFactory = KieServices.Factory.get().getCommands();
            //
            List<Command> commands = new ArrayList<Command>();
            commands.add(cmdFactory.newQuery(identifier, queryName));
            BatchExecutionCommand command = cmdFactory.newBatchExecution(commands, ksessionname);
            execQuery(identifier, queryName, command);
            log.info("testQuery03()--->End");
        } catch (Exception e) {
            log.error("testQuery03()--->" + e.getMessage(), e);
            Assert.fail(e.getMessage(), e);
        }
    }

}
