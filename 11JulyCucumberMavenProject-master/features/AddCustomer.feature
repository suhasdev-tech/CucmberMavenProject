Feature: Customer

  Scenario Outline: Add New Customer
    Given User lauch chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    And  User enter email as "<email>" and password as "<password>"
    And User click on Login button 
    Then User can view Dashboard
    When Click on customers menu
    And Click on customers menu item
    And Click on add new button
    Then User can view add new customer page
    When User enter customer info as "<newEmail>" and "<newPass>" and "<fname>" and "<lname>" and "<gender>" and "<comName>" and "<adminContent>"
    And click on save button
    Then user can view confirmation msg "The new customer has been added successfully."
    And  close browser.
    
    Examples:
   |email|password|newEmail|newPass|fname|lname|gender|comName|adminContent|
   |admin@yourstore.com|admin|braj78@gmail.com|1234|Bali1|Raj|Male|ABC|Test1|
   |admin@yourstore.com|admin|mayuriP89@gmail.com|5678|Mayuri2|Bali|Female|XYZ|Test2|
   |admin@yourstore.com|admin|RajB34@gmail.com|59878|Raj|Bali2|Male|PQR|Test3|
     
