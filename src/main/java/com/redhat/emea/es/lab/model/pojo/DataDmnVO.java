
package com.redhat.emea.es.lab.model.pojo;

import java.io.Serializable;

import org.kie.dmn.feel.lang.FEELProperty;
import org.kie.dmn.feel.lang.FEELType;


@FEELType
public class DataDmnVO
    implements Serializable
{

    private final static long serialVersionUID = 1L;

    protected String city;
    protected Integer temperatura;
    protected Integer humedad;

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    @FEELProperty("temp")
    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer value) {
        this.temperatura = value;
    }

    public Integer getHumedad() {
        return humedad;
    }

    public void setHumedad(Integer value) {
        this.humedad = value;
    }

}
