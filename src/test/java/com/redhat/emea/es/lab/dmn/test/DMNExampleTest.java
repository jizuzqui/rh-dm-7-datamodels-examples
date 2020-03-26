package com.redhat.emea.es.lab.dmn.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.executor.ExecutionResults;
import org.kie.dmn.api.core.DMNContext;
import org.kie.dmn.api.core.DMNDecisionResult;
import org.kie.dmn.api.core.DMNMessage;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.client.DMNServicesClient;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;
import org.kie.dmn.api.core.DMNResult;
import org.kie.server.api.model.ServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;
import com.redhat.emea.es.lab.model.dmn.exafeel.DataDmn;
import com.redhat.emea.es.lab.model.dmn.exafeel.Violation;
import com.redhat.emea.es.lab.model.pojo.DataDmnVO;
import com.redhat.emea.es.lab.model.dmn.exafeel.Driver;
import com.redhat.emea.es.lab.model.dmn.exafeel.JavaPojoUtilDate;

public class DMNExampleTest {

    private static final Logger log = LoggerFactory.getLogger(DMNExampleTest.class);
    public static final String GRP_DM = "grp_dm";

    private KieServicesConfiguration config = null;
    private String CONTAINER = null;

    private Integer tst_Temp = 20;
    private Integer tst_Humedad = 60;

    @BeforeSuite(groups = { GRP_DM })
    @Parameters(value = { "url", "user", "password", "timeout", "dmn_container_01" })
    public void setUp(String url, String user, String password, String timeout, String container) throws Exception {
        log.debug("setUp()--->Init");
        this.config = KieServicesFactory.newRestConfiguration(url, user, password);
        config.setTimeout(Long.parseLong(timeout));
        this.CONTAINER = container;
        log.debug("setUp()--->End");
    }

    @Test(groups = { GRP_DM }, enabled = true)
    @Parameters(value = { "dmn_container_01", "dmn_name_01", "dmn_namespace_01" })
    public void test01(String dmncontainer, String dmnname, String dmnnamespace) {
        // we can choose between XSTREAM, JSON and JAXB - default is JAXB
        this.config.setMarshallingFormat(MarshallingFormat.JSON);
        //
        KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(this.config);
        DMNServicesClient client = kieServicesClient.getServicesClient(DMNServicesClient.class);
        DMNContext context = client.newContext();
        //
        Map<String, Object> dats = new HashMap<>();
        dats.put("city", "bcn");
        dats.put("Temp Media", this.tst_Temp);
        dats.put("humedad", this.tst_Humedad);
        // dats.put("temp", 10);
        // dats.put("humedad", 60);
        // dats.put("temp", 20);
        // dats.put("humedad", 40);
        context.set("Datos", dats);
        //
        ServiceResponse<DMNResult> serviceResult = client.evaluateAll(dmncontainer, dmnnamespace, dmnname, context);
        DMNResult dmnResult = serviceResult.getResult();
        for (DMNDecisionResult dr : dmnResult.getDecisionResults()) {
            log.info("test01() with Map--->DecisionId--------: '{}'", dr.getDecisionId());
            log.info("test01() with Map--->Name--------------: '{}'", dr.getDecisionName());
            log.info("test01() with Map--->Status------------: '{}'", dr.getEvaluationStatus());
            log.info("test01() with Map--->Result in String--: '{}'", dr.getResult());
            if (dr.getResult() != null) {
                log.info("test01() with Map--->Result Class Name-: '{}'", dr.getResult().getClass().getName());
            }
            for (DMNMessage msg : dr.getMessages()) {
                log.info("test01() with Map--->Message: '{}'", msg);
            }
        }
    }

    @Test(groups = { GRP_DM }, enabled = true)
    @Parameters(value = { "dmn_container_01", "dmn_name_01", "dmn_namespace_01" })
    public void test02(String dmncontainer, String dmnname, String dmnnamespace) {
        // we can choose between XSTREAM, JSON and JAXB - default is JAXB
        this.config.setMarshallingFormat(MarshallingFormat.JSON);
        //
        //
        KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(this.config);
        DMNServicesClient client = kieServicesClient.getServicesClient(DMNServicesClient.class);
        DMNContext context = client.newContext();
        //
        DataDmn data = new DataDmn();
        data.setCity("mad");
        data.setTemperatura(this.tst_Temp);
        data.setHumedad(this.tst_Humedad);;
        context.set("Datos", data);
        //
        ServiceResponse<DMNResult> serviceResult = client.evaluateAll(dmncontainer, dmnnamespace, dmnname, context);
        DMNResult dmnResult = serviceResult.getResult();
        for (DMNDecisionResult dr : dmnResult.getDecisionResults()) {
            log.info("test02() with POJO JAXB--->DecisionId--------: '{}'", dr.getDecisionId());
            log.info("test02() with POJO JAXB--->Name--------------: '{}'", dr.getDecisionName());
            log.info("test02() with POJO JAXB--->Status------------: '{}'", dr.getEvaluationStatus());
            log.info("test02() with POJO JAXB--->Result in String--: '{}'", dr.getResult());
            if (dr.getResult() != null) {
                log.info("test02() with POJO JAXB--->Result Class Name-: '{}'", dr.getResult().getClass().getName());
            }
            for (DMNMessage msg : dr.getMessages()) {
                log.info("test02() with POJO JAXB--->Message: '{}'", msg);
            }
        }
    }

    @Test(groups = { GRP_DM }, enabled = true)
    @Parameters(value = { "dmn_container_01", "dmn_name_01", "dmn_namespace_01" })
    public void test03(String dmncontainer, String dmnname, String dmnnamespace) {
        // we can choose between XSTREAM, JSON and JAXB - default is JAXB
        this.config.setMarshallingFormat(MarshallingFormat.JSON);
        //
        //
        KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(this.config);
        DMNServicesClient client = kieServicesClient.getServicesClient(DMNServicesClient.class);
        DMNContext context = client.newContext();
        //
        DataDmnVO data = new DataDmnVO();
        data.setCity("mad");
        data.setTemperatura(this.tst_Temp);
        data.setHumedad(this.tst_Humedad);
        context.set("Datos", data);
        //
        ServiceResponse<DMNResult> serviceResult = client.evaluateAll(dmncontainer, dmnnamespace, dmnname, context);
        DMNResult dmnResult = serviceResult.getResult();
        for (DMNDecisionResult dr : dmnResult.getDecisionResults()) {
            log.info("test02() with POJO--->DecisionId--------: '{}'", dr.getDecisionId());
            log.info("test02() with POJO--->Name--------------: '{}'", dr.getDecisionName());
            log.info("test02() with POJO--->Status------------: '{}'", dr.getEvaluationStatus());
            log.info("test02() with POJO--->Result in String--: '{}'", dr.getResult());
            if (dr.getResult() != null) {
                log.info("test02() with POJO--->Result Class Name-: '{}'", dr.getResult().getClass().getName());
            }
            for (DMNMessage msg : dr.getMessages()) {
                log.info("test02() with POJO--->Message: '{}'", msg);
            }
        }
    }

    @Test(groups = { GRP_DM }, enabled = false)
    public void test03() {
        // String urlServiceRest =
        // "http://nvecesdev:9080/kie-server/services/rest/server";
        String urlServiceRest = "http://127.0.0.1:6080/kie-server/services/rest/server";
        String user = "rhdm";
        String password = "redhat00";
        String containerId = "prj-dmn-01_1.0.0-SNAPSHOT";
        String modelNamespace = "https://github.com/kiegroup/drools/kie-dmn/_A4BCA8B8-CF08-433F-93B2-A2598F19ECFF";
        String modelName = "Traffic ViolationStructure";

        String alias = "prj-dmn-01";
        KieServicesConfiguration configuration = KieServicesFactory.newRestConfiguration(urlServiceRest, user,
                password);
        // we can choose between XSTREAM, JSON and JAXB - default is JAXB
        configuration.setMarshallingFormat(MarshallingFormat.JSON);
        // the time that the client can wait for a server response
        configuration.setTimeout(15000);
        log.info("test02()--->MarshallingFormat:'{}'", configuration.getMarshallingFormat());

        KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(configuration);
        DMNServicesClient client = kieServicesClient.getServicesClient(DMNServicesClient.class);
        DMNContext context = client.newContext();

        Map<String, Object> driver = new HashMap<>();
        driver.put("Points", 3);
        driver.put("Age", 27);

        Map<String, Object> violation = new HashMap<>();
        violation.put("Type", "speed");
        violation.put("Speed Limit", 30);
        violation.put("Actual Speed", 90);
        //
        context.set("tDriver", driver);
        context.set("tViolation", violation);

        ServiceResponse<DMNResult> serviceResult = client.evaluateAll(containerId, modelNamespace, modelName, context);
        DMNResult dmnResult = serviceResult.getResult();
        for (DMNDecisionResult dr : dmnResult.getDecisionResults()) {
            log.info("test02()--->DecisionId--------: '{}'", dr.getDecisionId());
            log.info("test02()--->Name--------------: '{}'", dr.getDecisionName());
            log.info("test02()--->Status------------: '{}'", dr.getEvaluationStatus());
            log.info("test02()--->Result------------: '{}'", dr.getResult());
            if (dr.getResult() != null) {
                log.info("test02()--->Result Class Name-: '{}'", dr.getResult().getClass().getName());
                for (DMNMessage msg : dr.getMessages()) {
                    log.info("test02()--->Message: '{}'", msg);
                }
            }
        }
    }

    @Test(groups = { GRP_DM }, enabled = false)
    public void test04() {
        // String urlServiceRest =
        // "http://nvecesdev:9080/kie-server/services/rest/server";
        String urlServiceRest = "http://127.0.0.1:6080/kie-server/services/rest/server";
        String user = "rhdm";
        String password = "redhat00";
        String containerId = "prj-dmn-01_1.0.0-SNAPSHOT";
        String modelNamespace = "https://github.com/kiegroup/drools/kie-dmn/_A5BCA8B8-CF08-433F-93B2-A2598F19ECFF";
        String modelName = "Traffic Violation With Java";

        String alias = "prj-dmn-01";
        KieServicesConfiguration configuration = KieServicesFactory.newRestConfiguration(urlServiceRest, user,
                password);
        // we can choose between XSTREAM, JSON and JAXB - default is JAXB
        configuration.setMarshallingFormat(MarshallingFormat.JSON);
        // the time that the client can wait for a server response
        configuration.setTimeout(15000);
        log.info("test03()--->MarshallingFormat:'{}'", configuration.getMarshallingFormat());

        KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(configuration);
        DMNServicesClient client = kieServicesClient.getServicesClient(DMNServicesClient.class);
        DMNContext context = client.newContext();
        Driver driver = new Driver();
        driver.setName("John");
        driver.setPoints(13);
        driver.setAge(33);
        Violation violation = new Violation();
        violation.setSpeedLimit(50);
        violation.setActualSpeed(100);
        violation.setType("speed");
        context.set("Driver", driver);
        context.set("Violation", violation);

        ServiceResponse<DMNResult> serviceResult = client.evaluateAll(containerId, modelNamespace, modelName, context);
        DMNResult dmnResult = serviceResult.getResult();
        for (DMNDecisionResult dr : dmnResult.getDecisionResults()) {
            log.info("test03()--->DecisionId--------: '{}'", dr.getDecisionId());
            log.info("test03()--->Name--------------: '{}'", dr.getDecisionName());
            log.info("test03()--->Status------------: '{}'", dr.getEvaluationStatus());
            log.info("test03()--->Result------------: '{}'", dr.getResult());
            if (dr.getResult() != null) {
                log.info("test03()--->Result Class Name-: '{}'", dr.getResult().getClass().getName());
                for (DMNMessage msg : dr.getMessages()) {
                    log.info("test03()--->Message: '{}'", msg);
                }
            }
        }
    }

    @Test(groups = { GRP_DM }, enabled = false)
    public void test05() {
        // String urlServiceRest =
        // "http://nvecesdev:9080/kie-server/services/rest/server";
        String urlServiceRest = "http://127.0.0.1:6080/kie-server/services/rest/server";
        String user = "rhdm";
        String password = "redhat00";
        String containerId = "prj-dmn-01_1.0.0-SNAPSHOT";
        String modelNamespace = "https://github.com/kiegroup/drools/kie-dmn/_5eaccc88-cbf0-4c58-945a-952d8bf974ed";
        String modelName = "TestPojo";

        String alias = "prj-dmn-01";
        KieServicesConfiguration configuration = KieServicesFactory.newRestConfiguration(urlServiceRest, user,
                password);
        // we can choose between XSTREAM, JSON and JAXB - default is JAXB
        configuration.setMarshallingFormat(MarshallingFormat.JSON);
        // the time that the client can wait for a server response
        configuration.setTimeout(15000);
        log.info("test04()--->MarshallingFormat:'{}'", configuration.getMarshallingFormat());

        KieServicesClient kieServicesClient = KieServicesFactory.newKieServicesClient(configuration);
        DMNServicesClient client = kieServicesClient.getServicesClient(DMNServicesClient.class);
        DMNContext context = client.newContext();
        JavaPojoUtilDate data = new JavaPojoUtilDate();
        data.setInitial("Mr");
        data.setName("Toni");
        data.setWhen(new java.util.Date(2020, 0, 28, 10, 15));

        context.set("my data", data);

        ServiceResponse<DMNResult> serviceResult = client.evaluateAll(containerId, modelNamespace, modelName, context);
        DMNResult dmnResult = serviceResult.getResult();
        for (DMNDecisionResult dr : dmnResult.getDecisionResults()) {
            log.info("test04()--->DecisionId--------: '{}'", dr.getDecisionId());
            log.info("test04()--->Name--------------: '{}'", dr.getDecisionName());
            log.info("test04()--->Status------------: '{}'", dr.getEvaluationStatus());
            log.info("test04()--->Result------------: '{}'", dr.getResult());
            if (dr.getResult() != null) {
                log.info("test04()--->Result Class Name-: '{}'", dr.getResult().getClass().getName());
                for (DMNMessage msg : dr.getMessages()) {
                    log.info("test04()--->Message: '{}'", msg);
                }
            }
        }
    }

    private Violation generateViolationtInfo() {
        Violation violationInfo = new Violation();
        violationInfo.setActualSpeed(130);
        violationInfo.setSpeedLimit(40);
        violationInfo.setCode("code01");
        return violationInfo;
    }

    @Test(groups = { GRP_DM }, enabled = false)
    public void testFireRules01() {
        try {
            ksFireAllRule(this.generateViolationtInfo());
        } catch (Exception e) {
            log.error("testFireRules01()--->" + e.getMessage(), e);
            Assert.fail(e.getMessage(), e);
        }
    }

    private void ksFireAllRule(Violation violation) throws Exception {
        String urlServiceRest = "http://127.0.0.1:6080/kie-server/services/rest/server";
        String user = "rhdm";
        String password = "redhat00";
        String CONTAINER = "com.redhat.emea.es.bcn.lab.iberdrola:rh-dm-7-rules-drl-01:1.0-SNAPSHOT";
        this.config = KieServicesFactory.newRestConfiguration(urlServiceRest, user, password);
        // config.setTimeout(Long.parseLong(timeout));

        config.setMarshallingFormat(MarshallingFormat.JSON);
        // config.setMarshallingFormat(MarshallingFormat.JAXB);
        // config.setMarshallingFormat(MarshallingFormat.XSTREAM);
        Map<String, String> headers = null;
        config.setHeaders(headers);
        // Generate Clients
        KieServicesClient client = KieServicesFactory.newKieServicesClient(config);
        RuleServicesClient ruleClient = client.getServicesClient(RuleServicesClient.class);
        // Generate Commands
        KieCommands cmdFactory = KieServices.Factory.get().getCommands();
        List<Command> commands = new ArrayList<Command>();
        //
        commands.add(cmdFactory.newInsert(violation, "violation"));
        // commands.add(cmdFactory.newInsert(this.generateResponseInfo(),
        // "responseInfo"));
        commands.add(cmdFactory.newFireAllRules());
        //
        BatchExecutionCommand command = cmdFactory.newBatchExecution(commands, "default-stateless-ksession");
        // BatchExecutionCommand command = cmdFactory.newBatchExecution(commands);
        ServiceResponse<ExecutionResults> response = null;// ruleClient.executeCommandsWithResults(CONTAINER, command);
        ExecutionResults results = response.getResult();

        if (results == null) {
            throw new Exception(response.toString());
        }
        //
        log.info("ksFireAllRule()--->Msg: {}", response.getMsg());
        /*
         * Collection<String> identifiers = results.getIdentifiers(); for (String
         * identifier : identifiers) { Object fact = results.getValue(identifier);
         * log.info("ksFireAllRule()-->fact: {} {}", identifier, fact); }
         */
    }

}
