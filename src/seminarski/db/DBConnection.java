/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seminarski.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
    
    private DBConnection(){
        String url="jdbc:mysql://localhost:3306/seminarski";
        String user="root";
        String password="";
        try{
        connection=DriverManager.getConnection(url, user, password);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public static DBConnection getInstance(){
        if(instance==null){
            instance=new DBConnection();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return connection;
    }
}
