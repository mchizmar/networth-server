
# Notes
This application builds a mvn SpringBoot application associated with a simple networth calculator. 
There are 2 parts: 
+ Spring app with HATEOS REST API exposed on 8080:  http://localhost:8080/api
+ External h2 DB with an exposed webui on 8082:  http://localhost:8082
+ The h2 DB server is exposed on 1521

The app and db run in separate docker containers on the networth-net network and can be stared/stopped using
+ docker-start.sh
+ docker-stop.sh

You can now access the application through localhost.
* http://localhost:8080/api - the REST api browser for this project. This project uses HATEOS apis. 
* http://localhost:8082 - webui for the in memory h2 DB. You can connect without a password. 
