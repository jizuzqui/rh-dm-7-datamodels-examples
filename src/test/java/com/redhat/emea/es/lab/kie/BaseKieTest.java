package com.redhat.emea.es.lab.kie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.drools.core.command.runtime.rule.FireUntilHaltCommand;
import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.api.model.KieServiceResponse.ResponseType;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.redhat.emea.es.lab.model.mock.Incident;

public abstract class BaseKieTest {

    private static final Logger log = LoggerFactory.getLogger(BaseKieTest.class);
    public static final String GRP_DM = "grp_cep";

    protected KieServicesConfiguration config = null;
    protected KieServicesClient client;
    // private RuleServicesClient ruleClient;

    protected String CONTAINER = null;

    @BeforeSuite(groups = { GRP_DM })
    @Parameters(value = { "url", "user", "password", "timeout", "container" })
    public void setUp(String url, String user, String password, String timeout, String container) throws Exception {
        log.debug("setUp()--->Init");
        this.config = KieServicesFactory.newRestConfiguration(url, user, password);
        this.config.setTimeout(Long.parseLong(timeout));
        this.config.setMarshallingFormat(MarshallingFormat.JSON);
        // config.setMarshallingFormat(MarshallingFormat.JAXB);
        // config.setMarshallingFormat(MarshallingFormat.XSTREAM);
        Map<String, String> headers = null;
        this.config.setHeaders(headers);
        this.CONTAINER = container;
        // Generate Clients
        this.client = KieServicesFactory.newKieServicesClient(config);
        // this.ruleClient = client.getServicesClient(RuleServicesClient.class);
        log.debug("setUp()--->End");
    }

    public void execFireUntilHalt(String ksessionname) {
        try {
            config.setMarshallingFormat(MarshallingFormat.JSON);
            Map<String, String> headers = null;
            config.setHeaders(headers);
            // Generate Clients
            // Generate Commands
            KieCommands cmdFactory = KieServices.Factory.get().getCommands();
            log.debug("testFireUntilHalt()--->KieCommands implementation: '{}'", cmdFactory.getClass().getName());
            List<Command> commands = new ArrayList<Command>();
            //
            Command fireUntilHaltCommand = new FireUntilHaltCommand();
            commands.add(fireUntilHaltCommand);
            BatchExecutionCommand command = cmdFactory.newBatchExecution(commands, ksessionname);
            //
            ksFireAllRule(command);
        } catch (Exception e) {
            log.error("testFireUntilHalt()--->" + e.getMessage(), e);
            Assert.fail(e.getMessage(), e);
        }
    }

    public void ksFireAllRule(BatchExecutionCommand command) throws Exception {
        //
        RuleServicesClient ruleClient = this.client.getServicesClient(RuleServicesClient.class);
        ServiceResponse<ExecutionResults> response = ruleClient.executeCommandsWithResults(CONTAINER, command);
        //
        if (response.getType() == ResponseType.SUCCESS) {
            log.info("ksFireAllRule()--->Commands executed with success! Response: ");
            log.info("ksFireAllRule()--->Result: '{}'", response.getResult());
        } else {
            log.info("ksFireAllRule()--->Error executing rules. Message: ");
            log.info("ksFireAllRule()--->Message: '{}'", response.getMsg());
        }
        //
        ExecutionResults results = response.getResult();
        if (results == null) {
            throw new Exception(response.toString());
        }
        //
        log.info("ksFireAllRule()--->Msg: {}", response.getMsg());
        Collection<String> identifiers = results.getIdentifiers();
        for (String identifier : identifiers) {
            Object fact = results.getValue(identifier);
            log.info("ksFireAllRule()-->fact: {} {}", identifier, fact);
        }
    }

    public void execQuery(String identifier, String queryName, BatchExecutionCommand command) throws Exception {
        RuleServicesClient ruleClient = this.client.getServicesClient(RuleServicesClient.class);
        //
        ServiceResponse<ExecutionResults> response = ruleClient.executeCommandsWithResults(CONTAINER, command);

        if (response.getType() == ResponseType.SUCCESS) {
            log.info("execQuery()--->Commands executed with success! Response: ");
            log.info("execQuery()--->Result: '{}'", response.getResult());
        } else {
            log.info("execQuery()--->Error executing rules. Message: ");
            log.info("execQuery()--->Message: '{}'", response.getMsg());
        }

        ExecutionResults results = response.getResult();
        if (results == null) {
            throw new Exception(response.toString());
        }
        log.info("execQuery()--->Value:: {}", results.getValue(identifier));

        log.info("execQuery()--->Msg: {}", response.getMsg());
        QueryResults qresults = (QueryResults) results.getValue(queryName);
        log.info("execQuery()--->QueryResults Size: {}", qresults.size());

        for (QueryResultsRow row : qresults) {
            log.info("execQuery()--->Row------: '{}'", row);
            Incident incident = (Incident) row.get("$inc");
            if (incident != null) {
                log.info("execQuery()--->Incident-: '{}'. Status: '{}'", incident.getContractId(),
                        incident.getStatus());
            }
        }
        //
        Collection<String> identifiers = results.getIdentifiers();
        for (String item : identifiers) {
            Object fact = results.getValue(item);
            log.info("execQuery()-->fact: {} {}", item, fact);
        }
    }

}
