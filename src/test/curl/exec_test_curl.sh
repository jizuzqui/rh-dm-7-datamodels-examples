#!/bin/bash

USERNAME=rhdm
PASSWORD=redhat00
containerId=rh-dm-7-pmml-example-01_1.0.0-SNAPSHOT
DMN_FILE=dmn_test_01.json

curl -v --insecure -H  "Content-Type: application/json" -u "${USERNAME}:${PASSWORD}" --data @${DMN_FILE} -X POST "http://127.0.0.1:6080/kie-server/services/rest/server/containers/${containerId}/dmn"


# EOF