# finance-record-service
A toy service for experimenting with hooking up Dropwizard to MariaDB and doing automated testing against the DB running in Docker.

## Build and Run Locally
Get a MariaDB database - https://hub.docker.com/_/mariadb/
```
docker run --name test-mariadb -e MYSQL_ROOT_PASSWORD=<SET-YOUR-PASSWORD> -d mariadb:latest
# Update your applications yaml config files.
```
TODO - Need to employ a strategy to obscure the private database info in the configs.

Building and running a basic dropwizard service as a JAR file.
We will be using maven-jar-plugin and maven-shade-plugin to construct a jar file with our required dependencies.
* http://www.dropwizard.io/1.1.0/docs/getting-started.html#running-your-application
```
mvn package
java -jar -Xmx500m target/finance-record-service-0.0.1-SNAPSHOT.jar server hello-world.yml
```
