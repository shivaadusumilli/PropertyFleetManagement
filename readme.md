# Create network within Docker
docker network create property-network

# Create DB Docker Container
docker run --name mysql-container \
--network property-network \
-e MYSQL_ROOT_PASSWORD=rootpassword \
-e MYSQL_DATABASE=property_fleet_db \
-e MYSQL_USER=user \
-e MYSQL_PASSWORD=userpassword \
-p 3306:3306 \
-d mysql:8.0


# Start spring boot project
./mvnw spring-boot:run


# start mysql with docker-compose file
docker-compose up -d






# Steps to Run this Application

# Build spring boot app
./mvnw clean package
# Build docker image based on DockerFile
docker build -t spring-boot-app .
# Start Docker setup
docker-compose up -d
