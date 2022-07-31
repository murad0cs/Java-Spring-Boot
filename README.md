# Java-Spring-Boot

Problem 2: 
Make an application in spring boot which takes http request and returns json CRUD a user with
            user 
{	name, 
dob, 
address, 
email, 
gender		} 
api endpoints: get-users http method: 
GET show json of all created users create-user http method: 
POST show the newly created user update-user http method: 
PUT show the newly updated user delete-user http method: 
DELETE show delete confirmation
  Additional task: 1) validate email address 2) Process Gender using ENUM 
Example Request: http://localhost:8080/create-user 
Request Body:
 {“name”: “john doe”, “dob”: “30-01-2022” “address”: “Rampura, Dhaka”, “email”: “john@gmail.com”, “gender”: “MALE”}
 
For testing this crud opetion you need to use Postman or Insomnia.
