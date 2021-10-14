
package library_system_project;

import java.sql.*;
import javax.swing.JOptionPane;

public class DbConnection {
    static Connection connect;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_USERNAME = "root";
    static final String DB_PASSWORD = "";
    static final String DB_NAME = "tablelibrary";
    static final String DB_URL = "jdbc:mysql://localhost/";
    
    public static Connection
            getConnection(){
                try{
                    int db_exist = 0;
                    Class.forName(JDBC_DRIVER);
                    connect = DriverManager.getConnection(DB_URL + DB_NAME, DB_USERNAME, DB_PASSWORD);
                    return connect;
                
                }catch(ClassNotFoundException | SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                    return null;
                }
            }
}
