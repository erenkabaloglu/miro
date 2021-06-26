Feature: Signup feature
    As a user, I want to register to miro



Scenario Outline: Successful signup
    Given I am at the signup page
    And Following signup data
      |name  |email  |password  |reference  |acceptTerms  |subscribe  |
      |<name>|<email>|<password>|<reference>|<acceptTerms>|<subscribe>|
    When I fill signup form
    And I click submit
    Then Check your email should be displayed

    Examples:
     |name          |email  |password|reference   |acceptTerms|subscribe|
     |eren kabaloglu|#RANDOM|12345678|Social Media|true       |true     |
     |eren kabaloglu|#RANDOM|12345678|            |true       |true     |
     |eren kabaloglu|#RANDOM|12345678|Social Media|true       |false    |
     |eren kabaloglu|#RANDOM|12345678|            |true       |false    |



Scenario Outline: Invalid signup
  Given I am at the signup page
  And Following signup data
    |name  |email  |password  |reference  |acceptTerms  |subscribe  |
    |<name>|<email>|<password>|           |<acceptTerms>|           |
  When I fill signup form
  And I click submit
  Then <errorMessage> should be displayed

  Examples:
    |name          |email  |password|acceptTerms|errorMessage  |
    |              |#RANDOM|12345678|true       |NAME_ERROR    |
    |eren kabaloglu|       |12345678|true       |EMAIL_ERROR   |
    |eren kabaloglu|#RANDOM|        |true       |PASSWORD_ERROR|
    |eren kabaloglu|#RANDOM|12345678|           |TERMS_ERROR   |



Scenario Outline: Invalid email
  Given I am at the signup page
  And Following signup data
    |name  |email  |password  |reference  |acceptTerms  |subscribe  |
    |<name>|<email>|<password>|           |<acceptTerms>|           |
  When I fill signup form
  And I click submit
  Then <errorMessage> should be displayed

  Examples:
    |name          |email              |password|acceptTerms|errorMessage  |
    |eren kabaloglu|eren@kabaloglu.coma|12345678|true       |INVALID_EMAIL |
    |eren kabaloglu|eren@kabaloglu     |12345678|true       |INVALID_EMAIL |
    |eren kabaloglu|erenkabaloglu.com  |12345678|true       |INVALID_EMAIL |
    |eren kabaloglu|eren@@kabaloglu.com|12345678|true       |INVALID_EMAIL |
    |eren kabaloglu|eren@kabaloglu..com|12345678|true       |INVALID_EMAIL |


Scenario Outline: Password hints
  Given I am at the signup page
  When I input password with <password>
  Then <hint> password hint should be displayed

  Examples:
    |password   |hint            |
    |1234567    |INVALID_PASSWORD|
    |12345678   |SOSO_PASSWORD   |
    |9760aBcD2  |GOOD_PASSWORD   |
    |9760aBcD2*!|GREAT_PASSWORD  |