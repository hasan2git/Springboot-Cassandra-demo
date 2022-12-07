This is demo application for sprinboot cassandra integration.
It contains Create/Read functionality of users.

REST API Details
---------------------------------------
Create new user
POST - /cassandrademo/users

Retrieve all user
GET - /cassandrademo/users

Retrieve user by firstName
GET - /cassandrademo/users/{firstName}
----------------------------------------

Run Apllication
----------------
1.Run the SpringbootCassandraApplication. [port used : 8992]
2.Use Postman to test the api.
3. Sample user for create user :

{
    "id":1,
    "firstName":"Hasanath",
    "lastName":"Hossain"
}

Setup Cassandra Database
---------------------------------------
docker pull cassandra:latest
docker images
docker run -d --name cassandra-demo -p 9042:9042 cassandra
docker exec -it cassandra-demo bash
cqlsh
cqlsh> describe keyspaces;
>CREATE KEYSPACE demokeyspace
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};
>use demokeyspace;
>create table UserData(id int PRIMARY KEY,firstName text,lastName text);
---------------------------------------


