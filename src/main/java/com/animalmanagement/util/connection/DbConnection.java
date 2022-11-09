package com.animalmanagement.util.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is used to create a connection between JDK to the JDBC.
 */
public class DbConnection {
    
    static Connection con = null;

    /**
     * It is a private constructor. 
     * It will not allow to create objects of this class outside of the class.
     * It is used to load the driver and create the connection.
     */
    private DbConnection () {
        try {
       //     Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:8080/ideastoit","root","Printf");
            
        } catch(SQLException e) {
            e.printStackTrace();
        } 
      
    }

    /**
     * It is used to create a new object.
     * It creates a new instance of type DbConnection and  connects the database by using constructor. 
     * 
     * @ return con. It returns the connection con if connection is or connection is closed.
     *
     */
    public static Connection getDbConnection() throws SQLException{
	if ( con == null || con.isClosed()) {
	    DbConnection db = new DbConnection();
        }
        return con;
    }
}
