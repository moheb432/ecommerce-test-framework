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
- **Users:** 20
- **Iterations:** 10
- **Ramp-up:** 10 seconds
- **duration assertion:** 1.5 seconds

| Request Name         | Avg Response Time (ms) | Throughput | Error % |
|---------------------|----------------------|------------|---------|
| tLoginRequest        | 991                  | 5secs     | 45.5    |
| Createnewproduct     | 1232                 | 4secs        | 18    |
| createorderrequest   | 460                  | 5secs     | 0    |
| DeleteAddedOrder     | 416                  | 5secs     | 2.5    |
| DeleteAddedProduct   | 399                  | 5secs        | 22    |

> Login requests : 20 users, 1 iteration, 10s ramp-up → 50% errors
> on 1500 ms max response assertion → failed for >5 users
> So even light load breaks the SLA (Service Level Agreement) of 1.5s response.


### Stress test 
- **Users:** 50
- **Iterations:** 10
- **Ramp-up:** 20 seconds
- **duration assertion:** 1.5 seconds
> for more info about the stress test please check this pdf : [Uploading index.html…]()


| Request Name         | Avg Response Time (ms) | Throughput | Error % |
|---------------------|----------------------|------------|---------|
| tLoginRequest        | 1872                  | 3.2secs     | 28    |
| Createnewproduct     | 2674                 | 3.2secs        | 70    |
| createorderrequest   | 1000                  | 3.2secs     | 8    |
| DeleteAddedOrder     | 1000                  | 3.2secs     | 23    |
| DeleteAddedProduct   | 940                  | 3.2secs        | 29    |

<img width="713" height="343" alt="image" src="https://github.com/user-attachments/assets/9beb2b25-248f-44bc-8ef1-0aed559186f3" />

<img width="1168" height="495" alt="image" src="https://github.com/user-attachments/assets/753ef1f1-3044-47a4-90a9-46583838fe75" />

## Ramp up test 
# Ramp-Up Test

**Steps:**
1. Test Plan → Add → Threads (Users) → Concurrency Thread Group
2. Configure:
   - **Target Concurrency**: Desired number of users 100
   - **Ramp-Up Time**: Time to reach that number 60 secs
   - **Ramp-Up Steps**: How many increments to increase through 20
   - **Hold Target Rate Time**: Duration to keep max load 60 secs
   


| Request Name         | Avg Response Time (ms) | Throughput | Error % |
|---------------------|----------------------|------------|---------|
| tLoginRequest        | 1872                  | 4.55secs     | 74.42    |
| Createnewproduct     | 2674                 | 4.29	secs        | 89.52    |
| createorderrequest   | 1000                  | 4.25secs     | 52.05    |
| DeleteAddedOrder     | 1000                  | 	4.17secs     | 62.22    |
| DeleteAddedProduct   | 940                  | 3.2secs        | 54.24    |


<img width="940" height="337" alt="image" src="https://github.com/user-attachments/assets/182dc0ec-4b47-4a84-8d31-3920fa320396" />

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

