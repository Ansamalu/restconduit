Feature: Interact in the website conduit
  As a web user
  I want to interact with the website
  to put my skills into practice

  @post_login
  Scenario: Login successfully
    Given Anni enter the page Conduit
    When she enter the personal credentials
    Then she should login successfully