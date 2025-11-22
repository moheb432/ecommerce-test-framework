# ecommerce-test-framework
A complete QA testing repository for an E-Commerce API, containing:  • Manual Testing documentation • Postman test collections for functional and regression validation • Automated API Testing framework using RestAssured + TestNG + Cucumber • Performance &amp; Load Testing using Apache JMeter  This project demonstrates end-to-end testing coverage

## 📚 Project Scope

This repository includes:
* **Manual Test Documentation**
* **Postman Functional & Regression Collections**
* **Automated API Testing Framework**

  * Java
  * REST Assured
  * Cucumber (BDD)
  * TestNG
* **Performance and Load Testing**

  * Apache JMeter


## 🧩 Used language 

| Category             | Tools                                        |
| -------------------- | -------------------------------------------- |
| Language             | Java                                         |
| Automation Framework | REST Assured + TestNG + Cucumber             |
| Test Runner          | Maven                                        |
| Manual Testing       | Postman                                      |
| Performance Testing  | JMeter                                       |
| Reporting            | Cucumber HTML Reports, TestNG Execution Logs |

---

## 🚀 Features

✔ BDD using Gherkin
✔ Request/Response validation with REST Assured
✔ Data-driven execution via CSV and Examples
✔ End-to-end scenario chaining
✔ Modular and reusable utilities
✔ Supports regression and negative testing
✔ Continuous test reporting


#  Test Case Samples

| TestCase ID    | Title            | Pre-condition  | Steps                | Expected Result       | Type       | Priority |
| -------------- | ---------------- | -------------- | -------------------- | --------------------- | ---------- | -------- |
| TC_LOGIN_001   | Successful login | None           | POST /login          | Token returned (200)  | Functional | High     |
| TC_PRD_001     | Add new product  | Logged in      | POST /product        | Product created (201) | Functional | High     |
| TC_ORD_001     | Add order        | Product exists | POST /order          | Order created (201)   | Functional | High     |
| TC_DEL_PRD_001 | Delete product   | Product exists | DELETE /product/{id} | Product deleted (200) | Functional | High     |

📎 Full test suite and bug reports:
[https://docs.google.com/spreadsheets/d/1WQCFs7W8hVGIZ4bgPn9ORz6M2nqb7BldCLi13V_ZzH8/edit?usp=sharing](https://docs.google.com/spreadsheets/d/1WQCFs7W8hVGIZ4bgPn9ORz6M2nqb7BldCLi13V_ZzH8/edit?usp=sharing)

---

# 📊 Execution Summary

* **26 Total Test Cases**
* **18 Passed**
* **8 Failed**

### 🔎 Defects Identified

| Bug ID  | Description                                     | Expected            | Actual                  | Severity |
| ------- | ----------------------------------------------- | ------------------- | ----------------------- | -------- |
| BUG-001 | Negative product price accepted                 | Should reject       | API accepts -500        | High     |
| BUG-002 | Empty `productFor` allowed                      | Should be mandatory | API accepts empty value | Medium   |
| BUG-003 | Special characters allowed in `productCategory` | Should be rejected  | API accepts @Fashion!   | Medium   |

Execution performed:

1. **Manually via Postman**
2. **Automated using REST Assured & Cucumber**

---

#  Data-Driven Postman Execution

* CSV file used for multi-scenario testing
* 14+ iterations executed

Observed issues:

1. Product creation often exceeds **2 seconds**
2. No validation on:

   * `productCategory`
   * `productFor`
3. API accepts **negative product prices**

<img width="1185" height="630" alt="image" src="https://github.com/user-attachments/assets/a837312d-37a5-4492-9f05-fae783156f0f" />

---


#  Automated Test Framework (REST Assured + BDD)

## 🔐 Login API

**Validates:**

* Successful authentication
* Invalid credentials

##  Add Product API

**Validates:**

* Correct product creation
* Missing or invalid payload fields
* Special character handling
* Authorization rules

---

##  Add Order API

**Validates:**

* Correct order creation
* Missing or invalid product IDs
* Unauthorized access

---
## Preformance Tesrting Jmeter 
### load test 
  done on no of users 20 iterations 10 and ramptime 10secs   
| Requests  | Average response time |errors      |Throughhout                   | Severity |
| ------- | ----------------------------------------------- | ------------------- | ----------------------- | -------- |
| Login | 2500| 0% | API accepts -500        | High     |
| create product | 1500| 0% | API accepts empty value | Medium   |
| place an order  | 1500` | 0%  | API accepts @Fashion!   | Medium   |




## ✨ Framework Highlights

* **Cucumber BDD** for readable test scripts
* **REST Assured** for robust API interaction
* **DTO mapping using Jackson**
* **Test data controlled via CSV and Examples**
* **Scalable & maintainable structure**
#  Author

**Moheb Ashraf**
Rest Assured & API Automation Engineer

---

