package Persistence;

import java.sql.*;

// @author efapro01.23 Roberto Carvalho

public class ConnectionManager 
{
    
    // ::::::::::::::::
    // Variables
    // ::::::::::::::::
    
    private static final String URL = "jdbc:mysql://62.28.39.135:3306/safjava";
    private static final String USERNAME = "Raquel";
    private static final String PASSWORD = "Silva1234";
    private static Connection connection;
    private static int counter;
    
    // ::::::::::::::::
    // Constructor
    // ::::::::::::::::
    
    // Useless (?)
    public ConnectionManager() 
    { 
        counter = 0;
    }

    // ::::::::::::::::
    // Methods
    // ::::::::::::::::
    
    // Get Connection
    public static Connection getConnection() throws SQLException 
    {
        
        if (connection == null || connection.isClosed()) 
        {
            try 
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);        
            } 
            catch (ClassNotFoundException e) 
            {
                System.out.println("getConnection() Failure");
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }    
        }
        
        return connection;
        
    }
    
    // Close Connection
    public static void closeConnection() throws SQLException 
    {
        
        if (connection != null && !connection.isClosed()) 
        {
            try 
            { 
                connection.close();

                // Counter
                counter = counter + 1;
                System.out.println("Connection Closed Successfully (Connection Counter: "+counter+")");
            } 
            catch (SQLException e)
            { System.out.println(e.getMessage()); } 
            finally 
            { connection = null; }
        }
        
    }
    
}

    
