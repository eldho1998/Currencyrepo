## Currency Conversion API

A straightforward API built using Spring Boot for converting currencies. It allows users to:

### Retrieve exchange rates between different currencies.

### Convert a specified amount from one currency to another using the exchange rate.

- Available Endpoints

1. Get Exchange Rate
2. URL: /api/rate
   Method: GET

Query Parameters:

from: The base currency code (e.g., USD).
to: The target currency code (e.g., INR).

- Responses:

200 OK: Returns the exchange rate as a double.
400 Bad Request: When invalid parameters are provided.
Currency Conversion
URL: /api/convert
Method: POST

- Request Body:

json
Copy
Edit
{
"fromCurrency": "USD",
"toCurrency": "INR",
"amount": 100
}

- Response:

json
Copy
Edit
{
"fromCurrency": "USD",
"toCurrency": "INR",
"amount": 100,
"convertedAmount": 8579.679
}

- Response Status:

200 OK: Successfully converted.
400 Bad Request: When input parameters are incorrect.
Setting Up Locally

## Requirements

### JDK (Java Development Kit)

### Maven (for building)

### Open Exchange Rates API app ID

Steps
Clone the repository:
bash
Copy
Edit

### git clone https://github.com/eldho1998/CurrencyConverterRepo.git

cd currency-converter-api
Configure environment variables:

- Set the EXCHANGE_API_URL environment variable, or alternatively, define it directly in ExternalApiClient.java (line 15).

Build the project:

bash
Copy
Edit
mvn clean install
Start the application:
bash
Copy
Edit
mvn spring-boot:run
The API will be available at http://localhost:8080.

### Running Unit Tests

bash
Copy
Edit
mvn test
