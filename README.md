# weather-application

 Weather Info Application

A Spring Boot application that retrieves weather information for multiple cities using the OpenWeatherMap API.  
Authentication and authorization are handled via Auth0 using OAuth2 login.  
Only authenticated users can access weather data.

Technologies Used

- Java 17 (or higher)
- Spring Boot 3
- Auth0
- OpenWeatherMap API
- Caffeine Cache
- Thymeleaf for rendering HTML

# Project Setup

1.step

Configure application.properties

 Application name and port
spring.application.name=weatherinfo
server.port=8080

 Auth0 Config
spring.security.oauth2.client.registration.auth0.client-id=YOUR_AUTH0_CLIENT_ID
spring.security.oauth2.client.registration.auth0.client-secret=YOUR_AUTH0_CLIENT_SECRET
spring.security.oauth2.client.registration.auth0.scope=openid,profile,email
spring.security.oauth2.client.registration.auth0.redirect-uri=http://localhost:8080/login/oauth2/code/auth0
spring.security.oauth2.client.registration.auth0.client-name=Auth0

spring.security.oauth2.client.provider.auth0.issuer-uri=https://YOUR_AUTH0_DOMAIN/
spring.security.oauth2.client.provider.auth0.authorization-uri=https://YOUR_AUTH0_DOMAIN/authorize
spring.security.oauth2.client.provider.auth0.token-uri=https://YOUR_AUTH0_DOMAIN/oauth/token
spring.security.oauth2.client.provider.auth0.user-info-uri=https://YOUR_AUTH0_DOMAIN/userinfo
spring.security.oauth2.client.provider.auth0.user-name-attribute=sub

 OpenWeatherMap API Config
openweathermap.api.key=YOUR_OPENWEATHERMAP_API_KEY
openweathermap.api.url=http://api.openweathermap.org/data/2.5/weather

 Cache Config
spring.cache.type=caffeine
spring.cache.caffeine.spec=expireAfterWrite=5m

-----------------------------------------------------------------------

2.step

build and run
check:- http://localhost:8080 (login will display)





