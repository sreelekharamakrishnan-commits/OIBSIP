ATM Interface

Project Description

The ATM Interface is a console-based Java application that simulates the basic operations of an Automated Teller Machine (ATM). The application allows users to securely log in using a User ID and PIN and perform common banking transactions.

Features

- User authentication using User ID and PIN
- Maximum of 3 login attempts
- Transaction History
- Cash Withdrawal
- Cash Deposit
- Money Transfer between accounts
- Balance validation
- Current balance display
- Transaction logging using ArrayList
- Object-Oriented Programming using multiple Java classes

Technologies Used

- Java
- Java Collections – ArrayList
- Object-Oriented Programming
- Command Prompt
- Notepad

Project Structure

ATMInterface/
│
├── Main.java
├── ATM.java
├── Account.java
├── Bank.java
├── Transaction.java
└── README.md

Sample Login Details

User ID: user1
PIN: 1234
Account ID: ACC001
Initial Balance: ₹10000

Another sample account:

User ID: user2
PIN: 5678
Account ID: ACC002
Initial Balance: ₹5000

How to Run

Open Command Prompt inside the project folder.

Compile all Java files:

javac *.java

Run the application:

java Main

ATM Menu

===== ATM MENU =====
1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit

OOP Concepts Used

- Class and Objects – Used to represent ATM, Bank, Account and Transaction.
- Encapsulation – Account details are maintained using private variables and public methods.
- ArrayList – Used to store transaction history and bank accounts.
- Methods – Used to perform deposit, withdrawal, transfer and authentication operations.

Expected Outcome

The application successfully simulates basic ATM operations through a console interface. Users can authenticate themselves, check transaction history, deposit money, withdraw money, transfer money to another account and quit the application.

Internship Task

Organization: OASIS INFOBYTE
Program: SIP – Java Development
Task: Task 3 – ATM Interface