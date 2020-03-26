
````
               _   _           _
              | | | |         | |
  _ __ ___  __| | | |__   __ _| |_
 | '__/ _ \/ _` | | '_ \ / _` | __|
 | | |  __/ (_| | | | | | (_| | |_
 |_|  \___|\__,_| |_| |_|\__,_|\__|

````

# Create Java Classes from Schemas (XSD)

Execute:

````
> cd rh-dm-7-datamodels-examples
> mvn clean package -P jaxb

````


# Execute Tests

## DMN Tests

Edit `src/test/resources/testng/testng_suite_dmn_01.xml` and change `enabled` attribute to true;

````
<test name="FUN001" enabled="true" preserve-order="true" verbose="10" time-out="30000" parallel="false">
````

Execute:

````
> cd rh-dm-7-datamodels-examples
> mvn clean package -P tests

````


> Review the parameters in  `src/test/resources/testng/testng_suite_dmn_01.xml`.



## CEP

Edit `src/test/resources/testng/testng_suite_cep_01.xml` and change `enabled` attribute to true;

````
<test name="FUN001" enabled="true" preserve-order="true" verbose="10" time-out="30000" parallel="false">
````

Execute:

````
> cd rh-dm-7-datamodels-examples
> mvn clean package -P tests

````


> Review the parameters in  `src/test/resources/testng/testng_suite_cep_01.xml`.




# Sessions

**TODO**




# References

<https://www.baeldung.com/jaxb-unmarshalling-dates>


