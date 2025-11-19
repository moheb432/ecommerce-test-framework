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
# API Test Execution Report

**Summary:** 18 out of 26 test cases passed, 8 failed.

| Bug ID | Description                                           | Steps to Reproduce                                       | Expected Result                        | Actual Result                                     | Severity |
|--------|-------------------------------------------------------|---------------------------------------------------------|----------------------------------------|--------------------------------------------------|----------|
| BUG-001 | API accepts negative numbers in `productPrice`       | Send POST request with `productPrice = -500`           | API should reject negative prices      | API accepts negative price                        | High     |
| BUG-002 | API accepts empty `productFor` field                | Send POST request with `productFor = ""`               | API should require a valid value       | API accepts empty value                           | Medium   |
| BUG-003 | API accepts special characters in `productCategory` | Send POST request with `productCategory = "@Fashion!"` | API should reject special characters   | API accepts special characters                     | Medium   |

All test cases were executed **twice**:  
1. **Manual execution** using Postman  
2. **Automated execution** using Rest Assured
 
# Postman testing using the Testcases_csv_data
In **Postman**, all test cases were executed using a **CSV file** to supply test data.  
At least **10 different data sets** were used for execution.
on runing more than 14 iteration on the 25 testcase written above it was noticed that 
1. **Adding product takes more than 2secs to run
2. **the Api is careless about Both productCategory and ProductFor case if both of them special character or empty
3. the -ve price may be added on the API  
as shown in figure below

<img width="1185" height="630" alt="image" src="https://github.com/user-attachments/assets/a837312d-37a5-4492-9f05-fae783156f0f" />

