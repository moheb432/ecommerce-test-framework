Feature: End-to-End Scenario Ecommerce Management Workflow
  @smokers
  Scenario Outline: Verify user can log in and successfully add a product

    Given the user provides valid login details "<email>" "<Password>"
    When the user sends a POST HTTP request to log in
    Then the API call should be successful with status code <SC_Login>


    Given the user provided a valid token
    And  the user provided a product details "<productName>" "<UserId>" "<productFor>" "<productCategory>" "<productPrice>" "<productImage>"
    When the user sends a POST HTTP request to add product
    Then The API should give response code <SC_AddProduct>
    And verify the product is Added, get request on the product Id with statuscode <SC_GetProduct>

    Given the user provided a valid token and a valid productId and the order "<country>"
    When the user sends a POST HTTP request to create order
    Then The API should give response code <SC_AddOrder> he API should give message Orders added successfully and the Order ID
    And verify the Order is Added, get request on the Order Id with statuscode <SC_GetOrder>

    Given the user provided a valid token ,orderID to Delete
    When The user sends a DELETE HTTP request to his orders
    Then The API should give <SC_DeleteOrder> statuscode
    And verify the Order is Deleted , get request on the Order Id with statuscode <SC_Get_DeleteOrder>


    Given the user provided a valid token ,productId to Delete
    When The user sends a DELETE HTTP request to his Products
    Then The API should give <SC_DeleteProduct> statuscode
    And verify the Order is Deleted , get request on the product Id with statuscode <SC_Get_DeleteProduct>

#/-----------------------------------------------------------------------------------------------------------------

    Examples:
      | email                   | Password   | SC_Login | productName                                                                                         | UserId                   | productFor | productCategory | productPrice | productImage     | country | SC_AddProduct | SC_GetProduct | SC_AddOrder | SC_GetOrder | SC_DeleteOrder | SC_DeleteProduct | SC_Get_DeleteOrder |  |  | SC_Get_DeleteProduct |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                                | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | 500          | target/zara.jpeg | egypt   | 201           | 200           | 201         | 200         | 200            | 200              | 400                |  |  | 400                  |
      | mohebashraf46@gmail.com | mokol 5657 | 400      | Zara                                                                                                | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | 500          | target/zara.jpeg | egypt   | 201           | 200           | 201         | 200         | 200            | 200              | 400                |  |  | 400                  |
      | mohebashraf46           | Moheb 1997 | 400      | Zara                                                                                                | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | 500          | target/zara.jpeg | egypt   | 201           | 200           | 201         | 200         | 200            | 200              | 400                |  |  | 400                  |
      | mohebashraf46@gmail.com |            | 400      | Zara                                                                                                | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | 500          | target/zara.jpeg | egypt   | 201           | 200           | 201         | 200         | 200            | 200              | 400                |  |  | 400                  |
      |                         | Moheb 1997 | 400      | Zara                                                                                                | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | 500          | target/zara.jpeg | egypt   | 201           | 200           | 201         | 200         | 200            | 200              | 400                |  |  | 400                  |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | @#%55                                                                                               | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | 500          | target/zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      |                                                                                                     | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | 500          | target/zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | zaraaaaaaaaaaaaaaaaaasraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | 500          | target/zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                                | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         |              | target/zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                                | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | abdc@50      | target/zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                                | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | -100         | target/zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                                | 68fdd1d5f669d6cb0a2ca741 | Women      | @%50            | 500          | target/zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                                | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | 500          | target/zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                                | exmaple@anamesh3rfny.com | Women      | Clothes         | 500          | target/zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                                |                          | Women      | Clothes         | 500          | target/zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                                | 68fdd1d5f669d6cb0a2ca741 |            | Clothes         | 500          | target/zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                                | 68fdd1d5f669d6cb0a2ca741 | #$%@       | Clothes         | 500          | target/zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                                | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | 500          | target/zara.jpeg |         | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                                | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | 500          | target/zara.jpeg | @#$55   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |

@smokers2
 Scenario Outline: Verify system rejects adding product twice with same name

    Given the user provides valid login details "<email>" "<Password>"
    When the user sends a POST HTTP request to log in
    Then the API call should be successful with status code <SC_Login>


    Given the user provided a valid token
    And  the user provided a product details "<productName>" "<UserId>" "<productFor>" "<productCategory>" "<productPrice>" "<productImage>"
    When the user sends a POST HTTP request to add product
    Then The API should give response code <SC_AddProduct>
    And verify the product is Added, get request on the product Id with statuscode <SC_GetProduct>
    
    Given the user provided a valid token
    And  the user provided a product details "<productName>" "<UserId>" "<productFor>" "<productCategory>" "<productPrice>" "<productImage>"
    When the user sends a POST HTTP request to add product
    Then The API should give response code 500


    Examples:
      | email                   | Password   | SC_Login | productName | UserId                   | productFor | productCategory | productPrice | productImage     | country | SC_AddProduct | SC_GetProduct | SC_AddOrder | SC_GetOrder | SC_DeleteOrder | SC_DeleteProduct | SC_Get_DeleteOrder |  |  | SC_Get_DeleteProduct |
      | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara        | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | 500          | target/zara.jpeg | egypt   | 201           | 200           | 201         | 200         | 200            | 200              | 400                |  |  | 400                  |

#/-----------------------------------------------------------------------------------------------------------------

  @smokers3
  Scenario Outline: Verify System rejects all requests with unauthorized user "invalid-token"

    Given the user provided a valid token
    And  the user provided a product details "<productName>" "<UserId>" "<productFor>" "<productCategory>" "<productPrice>" "<productImage>"
    When the user sends a POST HTTP request to add product
    Then The API should give response code <SC_AddProduct>
    And verify the product is Added, get request on the product Id with statuscode <SC_GetProduct>

    Given the user provided a valid token and a valid productId and the order "<country>"
    When the user sends a POST HTTP request to create order
    Then The API should give response code <SC_AddOrder> he API should give message Orders added successfully and the Order ID
    And verify the Order is Added, get request on the Order Id with statuscode <SC_GetOrder>

    Given the user provided a valid token ,orderID to Delete
    When The user sends a DELETE HTTP request to his orders
    Then The API should give <SC_DeleteOrder> statuscode
    And verify the Order is Deleted , get request on the Order Id with statuscode <SC_Get_DeleteOrder>


    Given the user provided a valid token ,productId to Delete
    When The user sends a DELETE HTTP request to his Products
    Then The API should give <SC_DeleteProduct> statuscode
    And verify the Order is Deleted , get request on the product Id with statuscode <SC_Get_DeleteProduct>

#/-----------------------------------------------------------------------------------------------------------------

    Examples:
      | productName | UserId                   | productFor | productCategory | productPrice | productImage     | country | SC_AddProduct | SC_GetProduct | SC_AddOrder | SC_GetOrder | SC_DeleteOrder | SC_DeleteProduct | SC_Get_DeleteOrder |  |  | SC_Get_DeleteProduct |
      | Zara        | 68fdd1d5f669d6cb0a2ca741 | Women      | Clothes         | 500          | target/zara.jpeg | egypt   | 401           | 401           | 401         | 401         | 401            | 401              | 401                |  |  | 401                  |









