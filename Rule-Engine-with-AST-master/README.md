
# Rule Engine with AST

This project is a Rule Engine built using an Abstract Syntax Tree (AST) approach, allowing the evaluation of user eligibility based on specific attributes like age, department, income, and spend. It features dynamic rule creation, combination, and evaluation with a backend powered by Spring Boot, MySQL, and JPA.


## Features

**Rule Creation and Evaluation:** Define and evaluate rules based on user conditions such as age and salary, and combine them using logical operators (e.g., AND, OR).

**Dynamic Rule Management:** Supports creation, combination, and modification of rules in a flexible and scalable manner.

**Three-Tier Architecture:** Simple UI, API & Backend, and Data layer.

**Persistent Storage:** Rules are stored in MySQL.



## Technologies Used

- Java 17
- Spring Boot 3.3.4
- Spring Data JPA
- MySQL
- Lombok (to reduce boilerplate code)
## Data Structure

The AST is represented with a Node data structure:

**type:** Defines node type (operator for AND/OR or operand for conditions).

**left:** Reference to the left child node.

**right:** Reference to the right child node.

**value:** Optional, storing values for operand nodes (e.g., age, department).
## Sample Rules


**Rule 1:**
```bash
  ((age > 30 AND department = 'Sales') OR (age < 25 AND department = 'Marketing')) AND (salary > 50000 OR experience > 5)
```
**Rule 2:**
```bash
 ((age > 30 AND department = 'Marketing')) AND (salary > 20000 OR experience > 5)
```

## Database Design

**Database:** MySQL

**Schema:** Designed to store rules and metadata, including AST nodes for each rule. Each rule is broken down and stored to optimize retrieval and evaluation.
## Project Setup

**Prerequisites**
- Java 17
- MySQL

**How to Run**

- Clone the Repository:

```bash
 git clone https://github.com/priyanshu724/zeotap-Rule-Engine-with-AST.git
```

**Set up MySQL:**

- Create a database named rule_engine_db.

- Update application.properties in src/main/resources with your MySQL credentials:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/rule_engine_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```
**Run the Application:**

```bash
mvn spring-boot:run
```
**Access the Application:**

Both the backend API and UI are available at
 ```bash
http://localhost:8081
```
## API Endpoints

 **Create Rule**

- Endpoint: POST /api/rules/create
- Request Body: A raw rule string, e.g., "(age > 30 AND department = 'Sales')"
- Response: AST representation of the rule
**Combine Rules**
- Endpoint: POST /api/rules/combine
- Request Body: Two rules and an operator (AND or OR)
- Response: Combined rule as an AST

**Evaluate Rule**
- Endpoint: POST /api/rules/evaluate
- Request Body: JSON with rule AST and user data, e.g., {"age": 35, "department": "Sales"}
- Response: Boolean (true or false) based on evaluation
## Test Cases
**AST Creation:**
Verify the AST representation by creating rules with create_rule.

**Rule Combination:**
Combine rule1 and rule2 using combine_rules and confirm combined logic.

**Rule Evaluation:**
Use evaluate_rule with different data JSONs to validate rule evaluation.

**Edge Cases:**
Test additional scenarios and combinations for robustness.
## Future Improvements

**Enhanced Logic Support:** Add additional logical operators and support for complex data types to broaden rule functionality.

**User Interface Enhancements:** Continue to work on the visualization feature to display a structured tree representation of the AST. Once the issue with the current visualization implementation is resolved, this feature will enhance the UI by providing a clear view of the AST structure for combined, created, or evaluated rules.