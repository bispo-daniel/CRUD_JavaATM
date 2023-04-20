# CRUD on MySQL database with Java
    My first project with JDBC.

    ATM in Java with database connectivity. An application supported by swing to be user friendly.

    The application is based on two menus:
        Landing page, with it's functions: Login, Create client, create account and exit system.
        User menu, with it's functions: Transfer, withdraw, deposit functions and exit account.

    Note: The user menu is only displayed when a user is logged.

    Note: There is still functions to be developed, such as update and delete, to account and client.

# Challenges and learning
    I have learned about the referenced library MySQL Connector J;

    I have learned the basic imports to connect to a database with jdbc
        Connection;
        DriverManager;

    I have learned the basic import to execute a statement with parameters in a database with jdbc
        PreparedStatement;
        
    I have learned about the basic import to execute a simple query in the database with jdbc
        Statement;
        ResultSet;

    To create the login functionality was a real cool challenge to solve, 
    because i had to think about the state and tests to make the functionality properly work. 
    Passing the welcome message was cool incrementation.

    At first, faced some issues not importing the J connector.

    Also when the sql classes weren't surrounded by try...catch blocks.

# Project based on this database:
https://github.com/bispo-daniel/SQL_Scripts/tree/main/atmDB

# Screenshots
## `Landing page`
![all-text](https://github.com/bispo-daniel/CRUD_JavaATM/blob/main/LandingPageScreenshot.png)

## `User page`
![all-text](https://github.com/bispo-daniel/CRUD_JavaATM/blob/main/UserPageScreenshot.png)