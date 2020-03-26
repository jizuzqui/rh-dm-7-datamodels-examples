package com.redhat.emea.es.lab.kie.test;

import org.drools.compiler.kproject.ReleaseIdImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class KieScannerTest {

    private static final Logger log = LoggerFactory.getLogger(KieScannerTest.class);


    final static String G = "com.redhat.emea.es.mock";
    final static String A = "rh-mock-test-001";
    final static String V = "1.0-SNAPSHOT";

    private KieSession kSession;
    private KieServices kieServices;
    private ReleaseIdImpl releaseId;
    private KieContainer kContainer;
    private KieScanner kScanner;


    public static final String GRP_DM = "grp_dm";

    //@BeforeSuite(alwaysRun = true)
    public void setUp() {
            log.debug("setUp()--->Init");
    }

    //@AfterSuite(alwaysRun = true)
    public void tearDown() {
            log.debug("tearDown()--->Init");
    }


    //@Test(groups = { GRP_DM }, enabled = false)
    public void fireRules() throws InterruptedException {
        kieServices = KieServices.Factory.get();
        releaseId = new ReleaseIdImpl(G, A, V);
        kContainer = kieServices.newKieContainer(releaseId);
        kScanner = kieServices.newKieScanner(kContainer);
        kSession = kContainer.newKieSession();
        kScanner.start(3000);
        while (true) {
            Thread.sleep(3000);
            kSession.fireAllRules();
        }
    }
}
