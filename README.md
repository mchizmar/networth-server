#Notes
This project builds a SpringBoot project with web services and an embedded h2 DB. 
It will build a single docker image and the container will expose the webservices and DB to you localhost. 

1. The first thing you must do is package this maven project. This builds the jar in the ./target directory
that is copied onto your docker image: mvn package

2. Once the project is packaged, all you need to do is run docker-run.sh. Review the comments in this file to understand 
what its doing. 

3. You can now access the application through localhost.
* http://localhost:8080/api - the REST api browser for this project. This project uses HATEOS apis. 
* http://localhost:8082 - webui for the in memory h2 DB. You can connect without a password. 