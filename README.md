# 🔗 Link Shortener - Backend

This is the backend for the Link Shortener application, built using **Spring Boot** and **MongoDB**. It handles URL shortening and redirection logic.

---

## 📦 Tech Stack

- Java 17+
- Spring Boot
- MongoDB (Atlas)
- Maven
- REST APIs
- Hosted on [Koyeb](https://www.koyeb.com/)

---

## 🚀 Getting Started (Local Setup)

### 1. Clone the Repository

git clone https://github.com/gudurukhasim/Linkshortner-backend.git

###2.Configure MongoDB

Update your MongoDB URI and PORT in src/main/resources/application.properties

spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>/linkshortener

if you using mangodb local  : mongodb://localhost:27017/linkdb  it look like this 

server.port=8081

###3. configuring the URLs in Controller

change the URL to generate short url based on local run machine 

go to controller  src/main/example/conroller/ShortenerController.java  "https://glad-sibeal-khasim-c57c075f.koyeb.app/"  replace this url with  "http://localhost:8081/"

change the URL to redirect to home when enetered wrong code 

go to controller  src/main/example/conroller/ShortenerController.java  "https://linkshortner-frontend.vercel.app/error?type=expired_or_not_found" replace this with "http://localhost:5173/error?type=expired_or_not_found"

###4.Run the Application

using an IDE, run the main() method from : com.example.LinkShortenerApplication

using the terminal ./mvnw spring-boot:run




