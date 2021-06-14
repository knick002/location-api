# About 
Location-api is a restapi for crud operations for geolocations stored in location_api db
It is a spring boot application with mysql as backend

# Compile 
mvn clean install 

# Run
mvn spring-boot:run
or
java -jar target/location-api-0.0.1-SNAPSHOT.jar

# Setup MySQL db
DB commands are stored under location-api/src/main/resources/db
location_api_createdb.sql -> to create user and grant permissions
location_api_createuser.sql -> to create db and tables

# Swagger docs:
http://localhost:8080/swagger-ui.html#/ -> view UI
http://localhost:8080/v2/api-docs -> json

# Actuators 
## Health EndPoint
http://localhost:8080/manage/health
=> {"status":"UP","components":{"db":{"status":"UP","details":{"database":"MySQL","validationQuery":"isValid()"}},"ping":{"status":"UP"}}}

# Sample Test Data
## To create a geolocation
curl -X POST -H 'Content-Type: application/json' -i http://localhost:8080/api/v1/geolocation --data '{"id":null, "latitude":131.4, "longitude":-132.4,"created":null}'

