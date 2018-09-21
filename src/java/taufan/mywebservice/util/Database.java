/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taufan.mywebservice.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Taufan Septaufani
 */
public class Database {
    private Connection connection;
    private String userName = "postgres";
    private String password = "";
    private String hostName = "localhost";
    private String dbName = "karyawan";
    
    public Database(){
        try{
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            DriverManager.registerDriver(new org.postgresql.Driver());
        }catch(SQLException e){
            //NestedException
            throw new NestedException("Error driver : "+e.getMessage(),e,0);
        }
        try{
            //connection = DriverManager.getConnection("jdbc:mysql://"+hostName+":3306/"+dbName+"?user="+userName+"&password="+password);
            connection = DriverManager.getConnection("jdbc:postgresql://"+hostName+"/"+dbName, userName, password);
        }catch(Exception e){
            //NestedException
            throw new NestedException("Error connection : "+e.getMessage(),e,0);
        }
    }
    public Connection getConnection(){
        return connection;
    }
    public void closeConnection(){
        try{
            connection.close();
        }catch(Exception e){
            //NestedException
            throw new NestedException("Error close connection : "+e.getMessage(),e,0);
        }
    }
}
