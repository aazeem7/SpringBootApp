# Request Payload

POST http://localhost:8080/api/student/save
payload: 
	{
    "firstname": "John",
    "lastname": "Doe",
    "age": 28,
    "address": {
        "addressLine1": "Line 1",
        "addressLine2": "Line 2",
        "zipCode": 600007,
        "city": "Pune",
        "state": "Maharashtra",
        "country": "India"
    },
    "project": {
        "projectName": "JavaApp",
        "description": "This is a Java App"
    },
    "subjects": [
        {
            "subjectId": 301,
            "subjectName": "Physics"
        },
        {
            "subjectId": 302,
            "subjectName": "Chemistry"
        },
        {
            "subjectId": 303,
            "subjectName": "Maths"
        }
    ]
}

# Find By Id
- GET http://localhost:8080/api/student/1

# Get All
- GET http://localhost:8080/api/student/getAll
