# <center>E-Commerce API

Application where a customer can create orders, save them as invoices, and view them.

## Project assignments:

- This is a service that manages Users, Products, and Comments.
- An email and a phone number can only belong to one user.
- Registration cannot be done with the same username, phone number, or email.
- User type can be either individual or company.

## <center>Endpoints

---

### Save Comment

Saves a new comment with the provided information.

- URL: `/api/v1/comments`
- Method: `POST`
- Request Body: CommentSaveRequest
  - `comment`: The content of the comment
  - `itemId`: The ID of the item associated with the comment
  - `userId`: The ID of the user associated with the comment

- Returns: The saved comment details

---

### Delete Comment by ID

Deletes a comment with the specified ID.

- URL: `/api/v1/comments/{id}`
- Method: `DELETE`
- Path Variable:
  - `id`: The ID of the comment to delete

---

### Find Comments by User ID

Retrieves a list of comments associated with the specified user ID.

- URL: `/api/v1/comments/userid`
- Method: `GET`
- Query Parameter:
  - `userId`: The ID of the user
- Returns: A list of comments

---

### Find Comments by Item ID

Retrieves a list of comments associated with the specified item ID.

- URL: `/api/v1/comments/itemid`
- Method: `GET`
- Query Parameter:
  - `itemId`: The ID of the item
- Returns: A list of comments

---

### Save Item

Saves a new item with the provided information.

- URL: `/api/v1/items`
- Method: `POST`
- Request Body: ItemSaveRequest
  - `name`: The name of the item
  - `description`: The description of the item
  - `price`: The price of the item
- Returns: The saved item details

---

### Find All Items

Retrieves a list of all items.

- URL: `/api/v1/items`
- Method: `GET`
- Returns: A list of items

---

### Find Item by ID

Retrieves the details of an item with the specified ID.

- URL: `/api/v1/items/{id}`
- Method: `GET`
- Path Variable:
  - `id`: The ID of the item
- Returns: The item details

---

### Delete Item by ID

Deletes an item with the specified ID.

- URL: `/api/v1/items/{id}`
- Method: `DELETE`
- Path Variable:
  - `id`: The ID of the item to delete

---

### Update Item Price by ID

Updates the price of an item with the specified ID.

- URL: `/api/v1/items/{id}`
- Method: `PUT`
- Path Variable:
  - `id`: The ID of the item to update
- Request Body: ItemPriceUpdateRequest
  - `price`: The new price of the item
- Returns: The updated item details

---

### Save User

Saves a new user with the provided information.

- URL: `/api/v1/users`
- Method: `POST`
- Request Body: UserSaveRequest
  - `username`: The username of the user
  - `password`: The password of the user
  - `phoneNumber`: The phone number of the user
  - `email`: The email of the user
  - `userType`: The type of the user (INDIVIDUAL or CORPORATE)
- Returns: The saved user details

---

### Find All Users

Retrieves a list of all users.

- URL: `/api/v1/users`
- Method: `GET`
- Returns: A list of users

---

### Find User by ID

Retrieves the details of a user with the specified ID.

- URL: `/api/v1/users/{id}`
- Method: `GET`
- Path Variable:
  - `id`: The ID of the user
- Returns: The user details

---

### Find User by Username

Retrieves the details of a user with the specified username.

- URL: `/api/v1/users/username`
- Method: `GET`
- Query Parameter:
  - `username`: The username of the user
- Returns: The user details

---

### Delete User by ID

Deletes a user with the specified ID.

- URL: `/api/v1/users/{id}`
- Method: `DELETE`
- Path Variable:
  - `id`: The ID of the user to delete
- Returns: Empty response

---

### Delete User by Username and Phone Number

Deletes a user with the specified username and phone number.

- URL: `/api/v1/users/username`
- Method: `DELETE`
- Query Parameters:
  - `username`: The username of the user
  - `phoneNumber`: The phone number of the user
- Returns: Empty response