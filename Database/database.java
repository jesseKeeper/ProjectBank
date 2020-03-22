/*
    javac -cp jSerialComm.jar;mysqlConnector.jar;jdbc.jar;. *.java
    java -cp jSerialComm.jar;mysqlConnector.jar;. Program
*/

import java.sql.*;

public class database{
    private Connection connected;

    /*
        GUI moet een eigen rol krijgen met alleen aanpassen van saldo, pogingen. De rest moet hij kunnen opvragen
    */

    database(){

    }

    public void connectToDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String DbUrl     = "jdbc:mysql://145.24.222.195/Bank3C?"; // bankdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
            String user     = "ubuntu-0967350";
            String pass     = "C44xV8";
            connected = DriverManager.getConnection(DbUrl, user, pass);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}