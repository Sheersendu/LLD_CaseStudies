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
	1. Idle State
	2. Has Card State
	3. Pin Authentication State
	4. Selection State
	5. CashWithdrawal State
	6. CheckBalance State
	7. PinChange State
	8. Exit State

2. We will use chain or responsibility pattern for cash withdrawal