# Prototype

### Problem statement:

 
- Use nodejs to pull the data to populate countries drop down
- Use nunjucks templating engine to populate the user screen, served by nodejs
(preferably use express as web server)
- Post data back to Java API (you can proxy it through nodejs, and you may perform any
validation)
- Java app should be built on top of Spring boot and use h2 (or use mongo) to persist the
data.
- Optional: Have an additional read only end point in Java app to retrieve any API data.


### Design Overview

## MongoDB
- DB-Name: testdb. Document: userdata
- expected configured uri: ```mongodb://localhost:27017/nodetest```

## Java Spring Boot

- JDK Version: 1.8
- Spring Boot V2
- Server port: 8080

### Model
- UserData model that accepts name,sex,age, and country. Fields id and dateCreated are defaulted
- Null check for each member variables.
- provides methods for controller/repository to add a user and get list of all users.

### API
 #### POST
 Request:
```POST /userData HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: b1471858-1f50-819e-4e33-1ab0fe18c1f1

{
	"name": "John",
	"sex": "Male",
	"age": 29,
	"country": "India"
}
```

Response:
```
{
    "name": "John",
    "sex": "Male",
    "age": 29,
    "country": "India",
    "dateCreated": "2020-12-09T06:26:50.624+00:00"
}
```

#### GET

Request:
```
GET /userData HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 53b31969-1f7f-58e6-46d9-0c515a7a1c1c
```
Response
```
[
    {
        "name": "John",
        "sex": "Male",
        "age": 29,
        "country": "India",
        "dateCreated": "2020-12-08T10:40:47.169+00:00"
    },
    {
        "name": "Anu",
        "sex": "Female",
        "age": 29,
        "country": "India",
        "dateCreated": "2020-12-08T14:49:28.267+00:00"
    }
]
```

## Node.js

Packages used:
```
{
    "chai": "For Tests",
    "express": "For UI REST endpoints",
    "mocha": "For Tests",
    "node-fetch": "To get list of contries from public api",
    "nunjucks": "For template rendering"
 }
```

Server port: 3000
Web APP URL: ```http://localhost:3000/```
Run command: ```node index.js```
Test command: ```npm run test```

### UI APIs

 Get '/'
 - This returns the nunjucks html page template with template-data contries fetched from public api.
 
 Post '/'
 - Accepts user registration data.
 - Transfer the json data to API server and ensures successful user registration
 - Return a template with success message addressing the user (done via nunjucks templating) 
 
 ### Front End
 
 HTML 5, Bootstrap 4 (used for layout and css), JavaScript (no external libraries)
 
 Registration Home: https://github.com/johnsjohn/prototype-for-scrumconnect/blob/master/scrumconnect-ui/demo/form.png
 Confirmation Page: https://github.com/johnsjohn/prototype-for-scrumconnect/blob/master/scrumconnect-ui/demo/confirmation.png
 

