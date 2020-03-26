
package com.redhat.emea.es.lab.model.mock;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.redhat.emea.es.lab.model.mock package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.redhat.emea.es.lab.model.mock
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Contract }
     * 
     */
    public Contract createContract() {
        return new Contract();
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

    /**
     * Create an instance of {@link AggregateDay }
     * 
     */
    public AggregateDay createAggregateDay() {
        return new AggregateDay();
    }

    /**
     * Create an instance of {@link Tax }
     * 
     */
    public Tax createTax() {
        return new Tax();
    }

    /**
     * Create an instance of {@link FirmwareVersion }
     * 
     */
    public FirmwareVersion createFirmwareVersion() {
        return new FirmwareVersion();
    }

    /**
     * Create an instance of {@link Incident }
     * 
     */
    public Incident createIncident() {
        return new Incident();
    }

}
