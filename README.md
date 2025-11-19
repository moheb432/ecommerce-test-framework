# ecommerce-test-framework
A complete QA testing repository for an E-Commerce API, containing:  • Manual Testing documentation • Postman test collections for functional and regression validation • Automated API Testing framework using RestAssured + TestNG + Cucumber • Performance &amp; Load Testing using Apache JMeter  This project demonstrates end-to-end testing coverage
## Test cases 
| TestCase ID | Test Case Title / Objective | Pre-condition | Test Data | Steps | Expected Results | Status | Actual Results | Execution Status | Attachment | Requirement ID | Type | Prio | Sev |
|-------------|----------------------------|----------------|-----------|-------|------------------|--------|----------------|------------------|------------|-----------------|------|------|-----|
| TC_LOGIN_001 | Successful login with valid credentials | None | Email + Valid Password | 1. POST /login | Login successful (200), token returned | New | - | Not Executed | - | API-LOGIN-01 | Functional | High | High |
| TC_LOGIN_002 | Login with wrong password | None | Correct email + wrong password | 1. POST /login | 401 Unauthorized | New | - | Not Executed | - | API-LOGIN-02 | Negative | High | Medium |
| TC_LOGIN_003 | Login with invalid email format | None | Invalid email | 1. POST /login | 400 Invalid email format | New | - | Not Executed | - | API-LOGIN-03 | Validation | Medium | Low |
| TC_PRD_001 | Successfully add product | Login completed | Valid product fields | 1. POST /product | Product added successfully (201) | New | - | Not Executed | - | API-PROD-01 | Functional | High | High 
| TC_PRD_002 | Add product with missing name | Login completed | Name empty | 1. POST /product | 500 Server/App validation error | New | - | Not Executed | - | API-PROD-02 | Negative | High | Medium |
| TC_PRD_003 | Add product with missing price | Login completed | Price empty | 1. POST /product | 500 Server/App validation error | New | - | Not Executed | - | API-PROD-03 | Negative | Medium | Medium |
| TC_ORD_001 | Successfully add order | Login completed, product added | Valid product + order details | 1. POST /order | Order added successfully (201) | New | - | Not Executed | - | API-ORD-01 | Functional | High | High |
| TC_ORD_002 | Add order without product existing | Login completed | Invalid product ID | 1. POST /order | 500 Business logic error | New | - | Not Executed | - | API-ORD-02 | Negative | High | High |
| TC_ORD_003 | Add order without token | Product exists | Valid data | 1. POST /order no token | 401 Unauthorized | New | - | Not Executed | - | API-ORD-03 | Security | High | High |
| TC_DEL_PRD_001 | Delete an existing product successfully | Login completed, product exists | Product ID valid | 1. DELETE /product/{id} | 200 Product deleted | New | - | Not Executed | - | API-DEL-PROD-01 | Functional | High | High |
| TC_DEL_PRD_002 | Delete product without token | Product exists | Product ID valid | 1. DELETE /product/{id} no token | 401 Unauthorized | New | - | Not Executed | - | API-DEL-PROD-02 | Security | High | High |
| TC_DEL_ORD_001 | Delete existing order successfully | Login completed, product + order exist | Order ID valid | 1. DELETE /order/{id} | 200 Order deleted | New | - | Not Executed | - | API-DEL-ORD-01 | Functional | High | High |
