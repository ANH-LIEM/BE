## Import database

1. Create database `ITSS`

    ```bash
    mysql -u [username] -p [password]
    create database ITSS;
    exit;
    ```
2. Import database

    From root project:
    ```bash
    mysql -u [username] -p [password] ITSS < database/database.sql
    ```