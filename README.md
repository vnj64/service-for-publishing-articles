# service-for-publishing-articles
docker run --name publish_service -e POSTGRES_USER=hahaton -e POSTGRES_PASSWORD=hahaton -p 38747:5432 -d postgres

## Project setup.
```bash
# Clone repository
git clone git@github.com:vnj64/service-for-publishing-articles.git

# Move to the root.
cd service-for-publishing-articles/

# Create docker container with PostgreSQL
docker run --name {container_name} -e POSTGRES_USER={postgres_user} -e POSTGRES_PASSWORD={postgres_password} -p {port}:5432 -d postgres

# Set environment variables on application.properties
spring.datasource.url=jdbc:postgresql://localhost:{port}/{postgres_user}
spring.datasource.username={postgres_user}
spring.datasource.password={postgres_password}

server.port=3030
server.address={your_address / or delete this string}

# Run the maven collector.
./mvnw spring-boot:run
or
run BookShopApplication from your IDE.
```