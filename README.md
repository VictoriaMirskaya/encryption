## How to use an application

1. Run Postgre sql locally.
   
2. Create a database "encryption":
username=postgres, 
password=postgres

3. Create a table: use file "src/main/sql/CreateTablesScript.sql".

4. Add test data to table: use file "src/main/sql/TestData.sql".

5. Run the project application inside the IDEA. Run the class "src/main/java/com/concord/encryption/EncryptionApplication.java".

6. You can use swagger for requests: "http://localhost:8080/swagger-ui/#/".