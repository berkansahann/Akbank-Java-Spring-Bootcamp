# <center>Customer Invoice Service

Application where a customer can create orders, save them as invoices, and view them.

## Project assignments:

1. Create a Maven project.
2. Implement the necessary Maven commands and include the output in the README file.
3. Implement listing operations using Java Streams.
4. List all customers.
5. Implement the functionality to create a new customer.
6. List customers whose names contain the letter 'C'.
7. List the total amount of invoices for customers registered in June.
8. List all invoices in the system.
9. List invoices with amounts greater than 1500 TL.
10. Calculate the average amount of invoices with amounts greater than 1500 TL.
11. List the names of customers with invoices below 500 TL.
12. List the sectors of companies whose average invoice amount in June is below 750, and include the code snippet for this functionality.

## Project Requirements

- JDK 17 or above
- Maven

## Project Installation

1. Download the project as a zip file.
2. Open the project on IDE.
3. Install the necessary dependencies from `pom.xml`.
4. Add a database connection and necessary dependencies in `pom.xml`. 
5. Build the project for mapper etc.
6. Run the application.

## <center>Customer Endpoints

### Save Customer

Used to save a customer.

- Method: POST
- Path: /api/v1/customers
- Request Body: `CustomerSaveRequest`
- Response Body: `CustomerDTO`

Example Usage:
```http
POST /api/v1/customers
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```
---
### Find Customer by ID

Used to retrieve a customer by ID.

- Method: GET
- Path: /api/v1/customers/{id}
- Path Variable: id (Long)
- Response Body: CustomerDTO

Example Usage:

```http
GET /api/v1/customers/1
```
---
### Find All Customers

Used to retrieve all customers.

- Method: GET
- Path: /api/v1/customers
- Response Body: List: List<CustomerDTO>

Example Usage:

```http
GET /api/v1/customers
```
---
### Find Customers by Name Contains Character

Used to retrieve customers whose name contains the specified character.

- Method: GET
- Path: /api/v1/customers/search
- Query Parameter: character (String)
- Response Body: List: List<CustomerDTO>

Example Usage:

```http
GET /api/v1/customers/search?character=A
```
---
### Calculate Total Amount by Registered Month

Used to calculate the total amount for customers registered in the specified month.

- Method: GET
- Path: /api/v1/customers/total-amount
- Query Parameter: month (String, format: MMMM)
- Response Body: Double

Example Usage:

```http
GET /api/v1/customers/total-amount?month=June
```
---
### Find Customer Names by Amount Lower Than

Used to retrieve the names of customers whose invoices' amount is lower than the specified amount.

- Method: GET
- Path: /api/v1/customers/amount-lower-than
- Query Parameter: amount (Double)
- Response Body: List: List<String>

Example Usage:

```http
GET /api/v1/customers/amount-lower-than?amount=500.0
```
---
### Find Sectors by Average Amount and Month

Used to retrieve the sectors of customers whose average amount in the specified month is higher than the specified amount.

- Method: GET
- Path: /api/v1/customers/sector
- Query Parameter: month (String, format: MMMM)
- Query Parameter: amount (Double)
- Response Body: List: List<String>

Example Usage:

```http
GET /api/v1/customers/sector?month=June&amount=750.0
```
---
## <center>Invoice Endpoints

### Save Invoice

Save an invoice.

- Method: POST
- Path: /api/v1/invoices
- Request Body: `InvoiceSaveRequest`
- Response Body: `RestResponse<InvoiceDTO>`

Example Usage:
```http
POST /api/v1/invoices
Content-Type: application/json

{
  "customerId": 1,
  "amount": 100.0
}
```
---
### Find All Invoices

Get all invoices.

- Method: GET
- Path: /api/v1/invoices
- Response Body: RestResponse<List<InvoiceDTO>>
- Example Usage:

```http
GET /api/v1/invoices
```
---
### Find Invoices by Amount Greater Than

Get invoices with amount greater than the specified amount.

- Method: GET
- Path: /api/v1/invoices/amount-greater-than
- Query Parameter: amount (Double)
- Response Body: RestResponse<List<InvoiceDTO>>

Example Usage:

```http
GET /api/v1/invoices/amount-greater-than?amount=500.0
```
---
### Find Average Amount of Invoices by Amount Greater Than

Get the average amount of invoices with amount greater than the specified amount.

- Method: GET
- Path: /api/v1/invoices/amount-greater-than/average
- Query Parameter: amount (Double)
- Response Body: RestResponse<Double>

Example Usage:

```http
GET /api/v1/invoices/amount-greater-than/average?amount=500.0
```
---