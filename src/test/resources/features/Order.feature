@placeOdrder
Feature: Place order

  Scenario Outline: Place a order using <scenario> credit card
    Given that it is on the index page
    When I search for MacBook Pro
    And add to cart
    And click on place holder
    And fill in the fields with the following information
      | name        | <name>    |
      | Country     | <country> |
      | City        | <city>    |
      | Credit Card | <card>    |
      | Month       | <month>   |
      | Year        | <year>    |
    Then validate the following information
      | Amount | 1100 USD |
      | Name   | <name>   |

    Examples:
      | scenario | name          | country       | city         | card             | month | year |
      | AMEX     | John Doe      | Portugual     | Lisbon       | 375567668884617  | 02    | 2030 |
      | VISA     | Percy Clayton | United States | Jacksonville | 4411732769254916 | 4     | 2029 |


  Scenario: Place an order without using a credit card
    Given that it is on the index page
    When I search for MacBook Pro
    And add to cart
    And click on place holder
    And dont fill in the credit card field
    Then validate the error message "Please fill out Name and Creditcard."
