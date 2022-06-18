/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package egoproj_nb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PgConnector {
        static Connection c =null;
	Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
			c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ego_db","postgres","1234");
			c.setAutoCommit(false);
                        System.out.println("Veri Tabanı bağlı");
			return c;
                        
                        
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
                
		
	}
        
        static ResultSet listele(String sorgu){
            try {
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(sorgu);
                return rs;
            } catch (SQLException sQLException) {                
                return null;
            }            
        }
        
        static ResultSet ekle(String sorgu){
            try {
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(sorgu);
                return rs;
            } catch (SQLException sQLException) {                
                return null;
            }            
        }
}