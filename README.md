# Players REST API
This is a Spring Boot application that provides a REST API for retrieving players information from the csv located at `src/main/resources/db/player.csv`.
It uses h2 in-memory DB and can be run locally.

## Prerequisites
- Java 8 or later
- Maven

## Getting Started
1. Clone the repository: `git clone https://github.com/polina-dulman/intuit-players-assigment.git`
2. Navigate to the project directory: `cd intuit-players-assignment`
3. Build the project: `mvn clean install`
5. Run the application: `mvn spring-boot:run`
   
The application will start running at `http://localhost:8080`.

## Endpoints
### Get All Players
`GET /api/players`
This endpoint returns a list of all players.

### Get Player by ID
`GET /api/players/{id}`
This endpoint returns a player with the specified ID.

# What I would do additionally or differently if you had infinite time:
* I would deploy the application on one docker container and the DB on other.
* I would use MySQL or Postgres DB.
* Would add some functionality: in addition to pagination, I would add the abilty to select specific fields to retrieve, filtering and sorting results (i.e. switching to GraphQL). Assuming no other CRUD functionality is needed by the product requirements.
* Would invest time in performance and fault and recovery testing
* Would create a deployment pipepline with environment for integration and e2e testing
