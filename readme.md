# Springboot-Cassandra-demo
This is demo application to connect cassandra using spring-boot-starter-data-cassandra.
We have shared example of CRUD functionality here. We have used cassandra docker image from dockerhub to run cassandra db.

## REST API Details
Create new user
<br>POST - /cassandrademo/users

Retrieve all user
<br>GET - /cassandrademo/users

Retrieve user by firstName
<br>GET - /cassandrademo/users/{firstName}

Update user
<br>PUT - /cassandrademo/users

Delete user
<br>DELETE - /cassandrademo/users/{id}

## Maven Configuration
Add below springboot starter dpenedency in pom.xml
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-cassandra</artifactId>
</dependency>
```
## Setup Cassandra Docker
Make sure you have docker desktop installed in you windows machine and then execute below commands to 
1. pull cassandra image.
2. Run cassandra db.
3. Create keyspace.
4. Create table.
 
```shell
docker pull cassandra:latest
docker images
docker run -d --name cassandra-demo -p 9042:9042 cassandra
docker exec -it cassandra-demo bash
cqlsh
cqlsh> describe keyspaces;
cqlsh>CREATE KEYSPACE demokeyspace
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};
cqlsh>use demokeyspace;
cqlsh:demokeyspace>create table UserData(id int PRIMARY KEY,firstName text,lastName text);
```
## Run Apllication
1.Run the SpringbootCassandraApplication. [port used : 8992]
<br>2.Use Postman to test the api.
<br>3. Sample user for create user :
<br>
```json
{
    "id":1,
    "firstName":"Hasanath",
    "lastName":"Hossain"
}
```