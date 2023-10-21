## <h1 align="center">Inkwell</h1>
![Main page](https://thumb.cloud.mail.ru/thumb/xw1/%D0%A1%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0%20%D1%81%D1%82%D0%B0%D1%82%D1%8C%D0%B8%20%282%29.png)
### About us

* Web service for creating and publishing anonymous articles *

### Project setup

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