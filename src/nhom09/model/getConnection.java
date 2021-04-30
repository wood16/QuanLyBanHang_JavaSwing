/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom09.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class getConnection {
    
    public static Connection getDataConnection(){
        Connection c =null;
        try {
			Class.forName("com.mysql.jdbc.Driver");
		c =	DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/quanlybanhang?autoReconnect=true&useSSL=false", "root", "lam0.1.6.99");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return c;
    }
       
}
