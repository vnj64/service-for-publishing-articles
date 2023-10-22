## <h1 align="center">Inkwell</h1>
<img src="readme_assets/project_page.png">

### About project.
Web service for creating and publishing anonymous articles. The URL of each article is generated by the generation function, which contains the transliteration of the title of the article, and the date of publication.
[**_Enjoy here_**](https://inkwell-five.vercel.app/Komanda-Obez-n-vozn-vykatilareliz-22-10)!

### Technology stack.
- Java 17
- Spring Boot
- PostgreSQL
- Liquibase
- Hibernate JPA
- Docker

### Project setup.

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

server.port=8080
server.address={your_address / or delete this string}

# Run the maven collector.
./mvnw spring-boot:run
or
run BookShopApplication from your IDE.
```

### API.
```http request
GET https://publishing-service-pn20.onrender.com/api/articles?id=Kejs-est-otVebpraktik-blog-platforma-test-2023-10-21
```
```http request
POST https://publishing-service-pn20.onrender.com/api/articles
```
The POST request has a request body in the format:
```json
{
  "title": "Кейс от Вебпрактик (блог-платформа)",
  "coverImage": "coverImage",
  "name": "author",
  "date": "2023-10-22",
  "body": "it`s a body",
  "theme": "testTheme"
}
```

### Collaborators.
- [vnJ](https://github.com/vnj64) - Backend Java Developer
- [Zakhar](https://github.com/ZakharEvv) - Backend Java Developer
- [0xNikitox](https://github.com/darkystacks) - Frontend Developer
### Issue.
If you have any ideas, how we can impove this project or any complaints, please write an [issue](https://github.com/vnj64/service-for-publishing-articles/issues), or text me on [telegram](https://t.me/arszdarszd) **^^**.