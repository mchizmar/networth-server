# Open FaaS Experiment

## Intro
This project is an experiment with OpenFaaS (OF) developed to test-and-learn capabilities of the tool from a developers 
perspective. 
Notes - What is this experiment trying to answer?: 
+ Builds on the Serverless SoD - https://pages.github.nwie.net/Nationwide/Architecture-Standards/sod/sod-serverless.html
+ What is OpenFaaS and how is it different from Cloud platform FaaS offerings like AWS Lambda? 
+ Why use OpenFaaS? 
+ When to use OpenFaaS over Cloud platform offerings? What design patterns align to OpenFaaS? 
+ How is OpenFaaS deployed? 
+ How can OF be tested? 
+ How is OF debugged? 
+ How does it fit with our current Technology stack? Jenkins, Concourse, Harness..
+ How does it run in the Serverless Framework? 

## Prerequisites 
To run this experiment you will need: 
* Local Docker Engine like [Docker Desktop](https://www.docker.com/products/docker-desktop).
* Local Kubernetes.

## Docker Configuration
This project creates 2 images and one network. 
A network is created and the 2 containers are set to run within this network to enable container-to-conainer

An H2 database Docker image is used by this demo and its corresponding Dockerfile is in openfaas/docker-h2. Its a simplified version of the docker file found [here](https://hub.docker.com/r/buildo/h2database).
The H2 container can be started independently by the openfaas/docker-h2/docker-run-h2.sh script; however, this script is used in the comprehensive project start and stop scripts docker-run.sh and docker-stop.sh. 
Only use this if you want to run a stand alone h2 instance. 
The script does the following: 
* Assumes the networth network has already been created. 
* Starts a container called h2. 
* The container binds to local ports 8082 and 1521
* [http://localhost:8082](http://localhost:8082) is the h2 admin user interface to use to query the DB. 
    - On the login screen, set the "JDBC URL" to "jdbc:h2:/h2-data/test"
    - Click "Connect", leave "sa" in the username and password empty. 
    - A test database will automatically be created or connected to when you connect. 
* [http://localhost:1521](http://localhost:1521).
    - Port used for jdbc connections only.
    - Project data source is configured to use this port. 
    
Finally, a networth image is created for hosting REST APIs for the project. Networth is a SpringBoot project and the 
Dockerfile is in the home directory of the project.

The netowrth and h2 containers are meant to be run using docker-run.sh and docker-stop.sh. These scripts try to ensure the 
environment is set up correctly by: 
* creating the networth network. 
* starting the h2 db and binding the 8082/1521 ports. 
* starting the networh APIs and binding to port 8080. 
* HATEOAS RESTful APIs are available [http://localhost:8080/api](http://localhost:8080/api)
 

# Notes

This project builds a SpringBoot app with web services and an embedded h2 DB. 
It will build a single docker image and the container will expose the webservices and DB to you localhost. 

1. The first thing you must do is package this maven project. This builds the jar in the ./target directory
that is copied onto your docker image: mvn package

2. Once the project is packaged, all you need to do is run docker-run.sh. Review the comments in this file to understand 
what its doing. 

3. You can now access the application through localhost.
* http://localhost:8080/api - the REST api browser for this project. This project uses HATEOS apis. 
* http://localhost:8082 - webui for the in memory h2 DB. You can connect without a password. 

# Creating a New Function
Java function
Pattern - Proxy to CRUD REST API - fn -> SpringBoot REST API -> DB
1. Create a new java function using faas-cli
    - faas-cli template store list
    - faas-cli new --lang java8 java-function
        - this pulls all templates not just java8 for some reason. 
2.Errors!!! I

3. Switched to python b/c java8 was a massive failure. 
Followed these instructions: https://blog.alexellis.io/first-faas-python-function/
Was able to build the function, but got errors deploying which did not show up in the deploy command. 
Ran and completed fine. 
    - faas-cli deploy -f ./hello-python.yml

OF GW UI says the function is in a constant state of "Not Ready"
Go check the logs 
kubectl logs -n openfaas-fn deploy/hello-python
Error from server (BadRequest): container "hello-python" in pod "hello-python-55b44d58bf-g5b7c" is waiting to start: trying and failing to pull image

This appears to be a bug in OF that it ALWAYS tries to pull the image from an external docker repo regardless if the image is already on the docker host. 
The image is added to the docker host during the faas-cli build step. 

Investigating brought me to this https://github.com/openfaas-incubator/ofc-bootstrap/pull/141
The OF GW pod config needs to be set with a pull policy ifNotPresent. Check the existing pod setting: 
 k describe pod -n openfaas gateway-7cb6dbbf4b-q5hnw | grep image_pull
      image_pull_policy:                      Always

Need to set Always to ifNotPresent. Need to redeploy openfaas. 
I think this can be accomplished by performing a k8s apply command. But I dont have that experience yet. 


