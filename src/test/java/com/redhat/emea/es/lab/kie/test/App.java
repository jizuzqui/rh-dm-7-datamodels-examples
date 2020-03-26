package com.redhat.emea.es.lab.kie.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.redhat.emea.es.lab.model.mock.Incident;
import com.redhat.emea.es.lab.model.mock.Priority;
import com.redhat.emea.es.lab.model.mock.Status;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import java.util.ArrayList;
import java.util.List;

import org.drools.compiler.kproject.ReleaseIdImpl;
import org.kie.internal.command.CommandFactory;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    private String G = "com.redhat.emea.es.mock";
    private String A = "rh-mock-test-001";
    private String V = "2.0-SNAPSHOT";

    private KieSession kSession;
    private KieServices kieServices;
    private ReleaseIdImpl releaseId;
    private KieContainer kContainer;
    private KieScanner kScanner;

    public static final void main(String[] args) {
        log.info("main");
        App app = new App();
        app.test();
    }

    public void test() {
        // try {
        log.info("Before KieServices.Factory.get");
        kieServices = KieServices.Factory.get();
        log.info("Before newReleasID");
        ReleaseId releaseID = kieServices.newReleaseId(G, A, V);
        log.info("Before newKieContainer");
        kContainer = kieServices.newKieContainer(releaseID);
        //kScanner = kieServices.newKieScanner(kContainer, "/serveis/dades/lab/jboss/rhdm/m2rhdmrepo");
//        kScanner = kieServices.newKieScanner(kContainer, "/serveis/dades/lab/jboss/rhdm/m2repo");
        log.info("Before newKieScanner");
        kScanner = kieServices.newKieScanner(kContainer);
        log.info("Before newKieSession");
        StatelessKieSession statelessKieSession = kContainer.newStatelessKieSession();
        //kSession = kContainer.newKieSession();
        //
        kScanner.start(5000);
        //kScanner.scanNow();
        //
        try {
            log.info("Before newKieSession -100-");
            log.info("Before First checkSession");
            this.fireRules(statelessKieSession);
            //this.checkKSession(true, kSession);
            log.info("Before For");
            //int i = 0;
            for (int i = 0; i < 5; i++) {
            //while(true) {
                Thread.sleep(10000);
                kSession = kContainer.newKieSession();
                log.info("test()--->Index: '{}', Class: '{}'", i++,kSession.getClass().getName());
                //this.checkKSession(true, kSession);
                this.fireRules(statelessKieSession);
            }
        } catch (Exception e) {
            log.error("Exception", e);
        }finally {
            log.info("Before Stop");
            kScanner.stop();
            kScanner.shutdown();
        }
        //
        /*
         * kSession releaseId = new ReleaseIdImpl(G, A, V); kContainer =
         * kieServices.newKieContainer(releaseId); kScanner =
         * kieServices.newKieScanner(kContainer); kSession = kContainer.newKieSession();
         * kScanner.start(3000); while (true) { Thread.sleep(3000);
         * log.info("test()--->End");
         *
         * kSession.fireAllRules(); log.info("main"); }
         */
        // } catch (java.lang.InterruptedException e) {

        // }
        log.info("test()--->End");
    }


    private void fireRules( StatelessKieSession ksession) {
        List<String> list = new ArrayList<String>();
        //ksession.setGlobal("messages", list);
        List cmds = new ArrayList();
        Incident incident = new Incident();
        incident.setContractId("10");
        incident.setPriority(Priority.CRITICAL);
        incident.setStatus(Status.OPEN);
        ksession.setGlobal("messages", list);
        cmds.add(CommandFactory.newInsert(incident));
        cmds.add(CommandFactory.newSetGlobal("messages", list, true));
        //cmds.add(CommandFactory.newFireAllRules());
        ExecutionResults bresults = ksession.execute(CommandFactory.newBatchExecution(cmds));
        list = (List<String>) ksession.getGlobals().get("messages");
        log.info("checkSession()--->messages: {}", list);
        for(String tmp : list) {
            log.info("checkSession()--->messages: {}", tmp);
        }

    }

    private void checkKSession(boolean dispose, KieSession ksession) {
        List<String> list = new ArrayList<String>();
        //ksession.setGlobal("messages", list);
        List cmds = new ArrayList();
        Incident incident = new Incident();
        incident.setContractId("10");
        cmds.add(CommandFactory.newInsert(incident));
        cmds.add(CommandFactory.newSetGlobal("messages", list, true));
        cmds.add(CommandFactory.newFireAllRules());
        ExecutionResults bresults = kSession.execute(CommandFactory.newBatchExecution(cmds));
        list = (List<String>) kSession.getGlobal("messages");
        log.info("checkSession()--->messages: {}", list);
        for(String tmp : list) {
            log.info("checkSession()--->messages: {}", tmp);
        }
        if(dispose) {
          ksession.dispose();
        }

    }

}
