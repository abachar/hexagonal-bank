# Hexagonal Bank

> Bank account kata with an hexagonal architecture.

Think of your personal bank account experience When in doubt, go for the simplest solution

# Requirements
- Deposit and Withdrawal
- Account statement (date, amount, balance)
- Operation printing
- Transfer order

# User Stories

##### US 1: Create account
**In order to** save money  
**As a** natural person  
**I want to** create a new account in my favorite bank  
> POST /v1.0/accounts

##### US 2: Deposit money
**In order to** save money  
**As a** bank client  
**I want to** make a deposit in my account  
> POST /v1.0/accounts/{accountId}/deposits

##### US 3: Withdrawal money
**In order to** retrieve some or all of my savings  
**As a** bank client  
**I want to** make a withdrawal from my account  
> POST /v1.0/accounts/{accountId}/withdrawals

##### US 4: Print history
**In order to** check my operations  
**As a** bank client  
**I want to** see the history (operation, date, amount, balance)  of my operations  
> GET /v1.0/accounts/{accountId}/history

##### US 5: Create transfer order
**In order to** pay my rent  
**As a** bank client  
**I want to** create a transfer order to an other account  
> POST /v1.0/accounts/{accountId}/transfer-orders  
> To check the existence of the payee's account you can use the open bank api  
> GET http://api.openbank.com/v2.0.0/accounts/{iban}  

##### US 6: Execution of the transfer orders
**In order to** to execute all transfer orders  
**As a** bank  
**I want to** have a scheduled timer that triggers all transfer orders  
> Use @Scheduled and Messaging
