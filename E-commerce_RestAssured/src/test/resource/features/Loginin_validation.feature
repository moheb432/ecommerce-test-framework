Feature: End-to-End Happy Scenario Product Management Workflow

 Scenario Outline: Verify user can log in and successfully add a product

    Given the user provides valid login details "<email>" "<Password>"
    When the user sends a POST HTTP request to log in
    Then the API call should be successful with status code <SC_Login>


    Given the user provided a valid token
    And  the user provided a product details "<productName>" "<productFor>" "<productCategory>" "<productPrice>" "<productImage>"
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

   Examples:
     | email                   | Password   | SC_Login | productName                                                                                      | productFor | productCategory | productPrice | productImage                                            | country | SC_AddProduct | SC_GetProduct | SC_AddOrder | SC_GetOrder | SC_DeleteOrder | SC_DeleteProduct | SC_Get_DeleteOrder |  |  | SC_Get_DeleteProduct |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                             | Women      | Clothes         | 500          | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 201           | 200           | 201         | 200         | 200            | 200              | 400                |  |  | 400                  |
     | mohebashraf46@gmail.com | moheb 1997 | 400      | Zara                                                                                             | Women      | Clothes         | 500          | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 201           | 200           | 201         | 200         | 200            | 200              | 400                |  |  | 400                  |
     | mohebashraf46@gmai.com  | Moheb 1997 | 400      | Zara                                                                                             | Women      | Clothes         | 500          | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 201           | 200           | 201         | 200         | 200            | 200              | 400                |  |  | 400                  |
     |                         | Moheb 1997 | 400      | Zara                                                                                             | Women      | Clothes         | 500          | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 201           | 200           | 201         | 200         | 200            | 200              | 400                |  |  | 400                  |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                             | Women      | Clothes         |              | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      |                                                                                                  | Women      | Clothes         | 500          | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                             | Women      | Clothes         | @#%$         | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      |                                                                                                  | Women      | Clothes         | 500          | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                             | Women      | Clothes         |              | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                             | Women      | Clothes         | @#%$         | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                             | Women      |                 | 500          | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                             |            | Clothes         | 500          | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                             | Women      | 12345           | 500          | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                             | @@@###     | Clothes         | 500          | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                             | Women      | Clothes         | -100         | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                             | Women      | Clothes         | 50abc        | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zaraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa | Women      | Clothes         | 500          | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | egypt   | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |
     | mohebashraf46@gmail.com | Moheb 1997 | 200      | Zara                                                                                             | Women      | Clothes         | 500          | C:\Users\moheb\IdeaProjects\E-commerce\target\zara.jpeg | 1234    | 500           | 500           | 500         | 500         | 500            | 500              | 500                |  |  | 500                  |