# ecommerce-test-framework
A complete QA testing repository for an E-Commerce API, containing:  • Manual Testing documentation • Postman test collections for functional and regression validation • Automated API Testing framework using RestAssured + TestNG + Cucumber • Performance &amp; Load Testing using Apache JMeter  This project demonstrates end-to-end testing coverage
## samples of Test cases 
| TestCase ID | Test Case Title / Objective | Pre-condition | Test Data | Steps | Expected Results | Status | Actual Results | Execution Status | Attachment | Requirement ID | Type | Prio | Sev |
|-------------|----------------------------|----------------|-----------|-------|------------------|--------|----------------|------------------|------------|-----------------|------|------|-----|
| TC_LOGIN_001 | Successful login with valid credentials | None | Email + Valid Password | 1. POST /login | Login successful (200), token returned | New | - | Not Executed | - | API-LOGIN-01 | Functional | High | High |
| TC_PRD_001 | Successfully add product | Login completed | Valid product fields | 1. POST /product | Product added successfully (201) | New | - | Not Executed | - | API-PROD-01 | Functional | High | High 
| TC_ORD_001 | Successfully add order | Login completed, product added | Valid product + order details | 1. POST /order | Order added successfully (201) | New | - | Not Executed | - | API-ORD-01 | Functional | High | High |
| TC_DEL_PRD_001 | Delete an existing product successfully | Login completed, product exists | Product ID valid | 1. DELETE /product/{id} | 200 Product deleted | New | - | Not Executed | - | API-DEL-PROD-01 | Functional | High | High |

### for further information about the test cases and  BUg report check this Goolge sheet: https://docs.google.com/spreadsheets/d/1WQCFs7W8hVGIZ4bgPn9ORz6M2nqb7BldCLi13V_ZzH8/edit?usp=sharing

