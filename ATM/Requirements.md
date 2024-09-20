# Problem Statement
1. Design ATM machine
2. Design the cash withdrawal feature as well
3. ATM will have the following capabilities:
	1. Cash Withdrawal
	2. Balance Check
	3. Pin Change
4. We will have 4 types of rupee notes: 2000, 500, 200, 100

# Approach
1. We will use state design pattern for different ATM States, states are:
    1. Idle State (insertCard)
    2. Selection State (select Operation)
    3. Pin Authentication State (authenticatePin)
    4. CashWithdrawal State
    5. CheckBalance State
    6. PinChange State
    7. Exit State

2. We will use chain or responsibility pattern for cash withdrawal
