#!/bin/bash


URL="http://sr-recruit.herokuapp.com/"


curl  -i -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d @resume.json ${URL}






