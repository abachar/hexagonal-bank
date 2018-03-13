Feature: Create account
  In order to save money
  As a natural person
  I want to create a new account in my favorite bank

  Scenario: Create an account with balance 0.0
    Given abachar born on Sep 26, 1983
    When he opens a bank account
    Then the initial balance is 0.0 EUR
