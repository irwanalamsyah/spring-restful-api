# User API Spec
## Register User
- Endpoint : POST /api/users
Request Body:
```json
{   
    "username": "veldora",
    "password": "inipassword",
    "name": "Veldora Tempest"
}
```
Response Body (Success):
```json
{
  "data": "OK"
}
```

Response Body (Failed):
```json
{
  "data": "Failed!!!",
  "errors": "Username must not blank"
}
```


## Login User
- Endpoint : POST /api/auth/login

Request Body:
```json
{   
    "username": "veldora",
    "password": "inipassword",
    "name": "Veldora Tempest"
}
```
Response Body (Success):
```json
{
  "data": {
    "token": "TOKEN",
    "expiredAt": 2334546556 // milisecond
  }
}
```

Response Body (Failed, 401):
```json
{
  "errors": "username or password wrong"
}
```

## Get User
- Endpoint : GET /api/users/current

Request Header :
- X-API-TOKEN: Token (Mandatory)

Response Body (Success):
```json
{
  "data": {
    "username": "irwanalamsyah",
    "name": "Irwan Alamsyah"
  }
}
```

Response Body (Failed, 402):
```json
{
  "errors": "Unauthorized"
}
```

## Update User
- Endpoint : PATCH /api/users/current

PATCH for partial update

Request Header :
- X-API-TOKEN: Token (Mandatory)

Request Body:
```json
{
  "name": "Irwan Alamsyah", // if only update name
  "password": "new password" // if only update password
}
```

Response Body (Success):
```json
{
  "data": {
    "username": "irwanalamsyah",
    "name": "Irwan Alamsyah"
  }
}
```

Response Body (Failed, 402):
```json
{
  "errors": "Unauthorized"
}
```

## Logout User
- Endpoint : DELETE /api/auth/logout

Request Header :
- X-API-TOKEN: Token (Mandatory)

Response Body (Success):
```json
{
  "data": "OK"
}
```