# Open FaaS Experiment

## Prerequisites 
To run this experiment you will need: 
* Local Docker Engine like [Docker Desktop](https://www.docker.com/products/docker-desktop).
* Local Kubernetes (k8s).

## Getting started: Creating a DB
This project uses a simple H2 database that runs as a docker container with from a image hosted on Dockerhub [here](https://hub.docker.com/r/buildo/h2database).
On a Mac or Linux, you can run the start-h2.sh in this directory which is a simple wrapper for the docker command. 
This performs the following: 
* Starts a container called my-h2 in docker that is visible by running docker ps. 
* The container binds to [http://localhost:8082](http://localhost:8082).
* On the login screen, set the "JDBC URL" to "jdbc:h2:/h2-data/test/". When you click connect (next step) a test database will automatically be created or connected to if it already exists. The test DB is used by the OpenFaaS services
demoed in this project and you must use the URL as its specified above. 
* Click "connect" leaving "sa" as the user without a password.  