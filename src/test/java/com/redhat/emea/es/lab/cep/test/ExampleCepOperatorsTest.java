package com.redhat.emea.es.lab.cep.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.redhat.emea.es.lab.kie.BaseKieTest;
import com.redhat.emea.es.lab.model.cep.commerce.ABoxEvent;

public class ExampleCepOperatorsTest extends BaseKieTest {

    private static final Logger log = LoggerFactory.getLogger(ExampleCepOperatorsTest.class);

    @Test(groups = { GRP_DM }, enabled = true, priority = 1)
    @Parameters(value = { "ksessioncep" })
    public void testFireUntilHalt(String ksessionname) {
        execFireUntilHalt(ksessionname);
    }

    @Test(groups = { GRP_DM }, enabled = true, priority = 10)
    @Parameters(value = { "ksessioncep" })
    public void testAccumulateRules01(String ksessionname) {
        String entrypoint = "country-A";
        try {
            for (int i = 0; i < 1; i++) {
                KieCommands cmdFactory = KieServices.Factory.get().getCommands();
                log.debug("testAccumulateRules01()--->KieCommands implementation: '{}'",
                        cmdFactory.getClass().getName());
                List<Command> commands = new ArrayList<Command>();
                //
                ABoxEvent boxevent = new ABoxEvent();
                boxevent.setMachineid("MAC-A");
                boxevent.setBox(80);
                boxevent.setEventid(UUID.randomUUID().toString());
                commands.add(cmdFactory.newInsert(boxevent, "", true, entrypoint));
                BatchExecutionCommand command = cmdFactory.newBatchExecution(commands, ksessionname);
                ksFireAllRule(command);
                TimeUnit.SECONDS.sleep(2);
                //
                commands = new ArrayList<Command>();
                boxevent = new ABoxEvent();
                boxevent.setMachineid("MAC-B");
                boxevent.setBox(70);
                boxevent.setEventid(UUID.randomUUID().toString());
                // Generate Commands
                commands.add(cmdFactory.newInsert(boxevent, "", true, entrypoint));
                command = cmdFactory.newBatchExecution(commands, ksessionname);
                ksFireAllRule(command);
                TimeUnit.SECONDS.sleep(2);
                //
                commands = new ArrayList<Command>();
                boxevent = new ABoxEvent();
                boxevent.setMachineid("MAC-A");
                boxevent.setBox(100);
                boxevent.setEventid(UUID.randomUUID().toString());
                // Generate Commands
                commands.add(cmdFactory.newInsert(boxevent, "", true, entrypoint));
                command = cmdFactory.newBatchExecution(commands, ksessionname);
                ksFireAllRule(command);
                TimeUnit.SECONDS.sleep(2);
                //
                commands = new ArrayList<Command>();
                boxevent = new ABoxEvent();
                boxevent.setMachineid("MAC-B");
                boxevent.setBox(400);
                boxevent.setEventid(UUID.randomUUID().toString());
                // Generate Commands
                commands.add(cmdFactory.newInsert(boxevent, "", true, entrypoint));
                command = cmdFactory.newBatchExecution(commands, ksessionname);
                ksFireAllRule(command);
                TimeUnit.SECONDS.sleep(2);

                log.debug("testAccumulateRules01()--->Inserted Item: '{}'. Box: '{}'", i, boxevent.getBox());
            }
            //

        } catch (Exception e) {
            log.error("testAccumulateRules01()--->" + e.getMessage(), e);
            Assert.fail(e.getMessage(), e);
        }
    }

    @Test(groups = { GRP_DM }, enabled = true, priority = 20)
    @Parameters(value = { "ksessioncep" })
    public void testDispose(String ksessionname) {
        try {

            // Generate Commands
            KieCommands cmdFactory = KieServices.Factory.get().getCommands();
            log.debug("testAccumulateRules02()--->KieCommands implementation: '{}'", cmdFactory.getClass().getName());
            List<Command> commands = new ArrayList<Command>();
            //
            commands.add(cmdFactory.newDispose());
            BatchExecutionCommand command = cmdFactory.newBatchExecution(commands, ksessionname);
            ksFireAllRule(command);
            log.debug("testAccumulateRules02()--->Dispose");
            //

        } catch (Exception e) {
            log.error("testAccumulateRules02()--->" + e.getMessage(), e);
            Assert.fail(e.getMessage(), e);
        }
    }

    @Test(groups = { GRP_DM }, enabled = false, priority = 10)
    @Parameters(value = { "ksessioncep" })
    public void testAccumulateRules02(String ksessionname) {
        String entrypoint = "country-A";
        try {
            for (int i = 0; i < 1; i++) {
                ABoxEvent boxevent = new ABoxEvent();
                boxevent.setMachineid("MAC-A");
                boxevent.setBox(10);
                // Generate Commands
                KieCommands cmdFactory = KieServices.Factory.get().getCommands();
                log.debug("testAccumulateRules02()--->KieCommands implementation: '{}'",
                        cmdFactory.getClass().getName());
                List<Command> commands = new ArrayList<Command>();
                //
                commands.add(cmdFactory.newInsert(boxevent, "", true, entrypoint));
                BatchExecutionCommand command = cmdFactory.newBatchExecution(commands, ksessionname);
                ksFireAllRule(command);
                TimeUnit.SECONDS.sleep(1);
                log.debug("testAccumulateRules02()--->Inserted Item: '{}'. Box: '{}'", i, boxevent.getBox());
            }
            //

        } catch (Exception e) {
            log.error("testAccumulateRules02()--->" + e.getMessage(), e);
            Assert.fail(e.getMessage(), e);
        }
    }

}
