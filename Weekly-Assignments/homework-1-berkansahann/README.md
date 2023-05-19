# Country API

## Project assignments:
Entity Country: It will include the fields id, name, and president.
Write an API that saves a country.
Write an API that retrieves all countries.
Write an API that retrieves a country by its ID.
Write an API that updates the president of a country.
This API allows you to manage country data, including their ID, name, and president entity.

## Endpoints

### Create a Country

- URL: `/countries`
- Method: `POST`
- Description: Creates a new country with the provided data.
- Request Body:
  ```json
  {
    "name": "Country Name",
    "president": "President Name"
  }
