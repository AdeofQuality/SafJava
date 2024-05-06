package Persistence;

import Business.*;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// @author efapro01.23 Roberto Carvalho

public class DbAdapter 
{
    
    // ::::::::::::::::::::
    // Variables
    // ::::::::::::::::::::
    
    private ConnectionManager connectionManager;
    
    // ::::::::::::::::::::
    // Constructors
    // ::::::::::::::::::::
    
    public DbAdapter() 
    { }
    
    // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    // Methods
    // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    
    ////////////////
    //  Deceased  //
    ////////////////
    
    // C R U D

   // Select All - Retrieves all records from DB and populates a JTable with the information
    public void deceased_SelectAll(JTable table) throws SQLException 
    {
        /* Open db connection */ Connection connection = connectionManager.getConnection();
        
        /* model obj (to store the db data) */ DefaultTableModel model = new DefaultTableModel();
        
        // Set column names in model for the table
        model.setColumnIdentifiers
        ( 
            new Object[] 
            { 
                "ID", 
                "Name", 
                "Age", 
                "Sex", 
                "Comment", 
                "Photo" 
            } 
        );

        try 
        {
            // List to be used later to fill the data base 
            List<Deceased> deceasedList = new ArrayList<>();

            /* Prepare query */ PreparedStatement pt = connection.prepareStatement("SELECT * FROM Deceased");
            /* Execute query */ ResultSet rs = pt.executeQuery(); 

            // Iterate through results from query 
            while (rs.next()) 
            {
                // The process here: 
                // ResultSet -> var -> obj -> ArrayList
                
                // Create variables (from ResultSet)
                /* Id      */ int id = rs.getInt("Id");
                /* Name    */ String name = rs.getString("Name");
                /* Age     */ int age = rs.getInt("Age");
                /* Sex     */ char sex = rs.getString("Sex").charAt(0);
                /* Comment */ String comment = rs.getString("Comment");
                /* Photo   */ String photo = rs.getString("Photo");
                
                // Create obj (from variables)
                /* Obj     */ Deceased deceased = new Deceased();
                /* Id      */ deceased.setId(id);
                /* Name    */ deceased.setName(name);
                /* Age     */ deceased.setAge(age);
                /* Sex     */ deceased.setSex(sex);
                /* Comment */ deceased.setComment(comment);
                /* Photo   */ deceased.setPhoto(photo);

                // Add obj to list
                deceasedList.add(deceased);
            }
            
            // Add row to the DefaultTableModel (model)
            for (Deceased deceased : deceasedList) { model.addRow(new Object[]{deceased.getId(), deceased.getName(), deceased.getAge(), deceased.getSex(), deceased.getComment(), deceased.getPhoto()}); }
            
            // Set the model to the JTable
            table.setModel(model);
        } 
        /* Catch Errors and log */ catch (SQLException e) { System.out.println(e.getMessage()); } 
        /* Close db connection  */ finally { connectionManager.closeConnection(); }
    }
    
    // Add - Add new record to Data Base
    public void deceased_Add(Deceased obj) throws SQLException  
    {
        /* Open db connection */ Connection connection = connectionManager.getConnection();
        
        try 
        {
            /* Prepare query */ PreparedStatement pt = connection.prepareStatement ( "INSERT INTO Deceased (Name, Age, Sex, Comment, Photo) VALUES (?, ?, ?, ?, ?);" );

            /* Name    */ pt.setString(1, obj.getName());
            /* Age     */ pt.setInt(2, obj.getAge());
            /* Sex     */ pt.setString(3, Character.toString(obj.getSex()));
            /* Comment */ pt.setString(4, obj.getComment());
            /* Photo   */ pt.setString(5, obj.getPhoto());

            /* Execute query */ pt.executeUpdate();
        }
        /* Catch Errors and log */ catch (SQLException e) { System.out.println(e.getMessage()); } 
        /* Close db connection  */ finally { ConnectionManager.closeConnection(); }
    }
    
    // Update - Update record in Data Base
    public void deceased_Update(Deceased obj) throws SQLException 
    {
        /* Open db connection */ Connection connection = connectionManager.getConnection();
        
        try 
        {
            /* Prepare query */ PreparedStatement pt = connection.prepareStatement("UPDATE Deceased SET Name = ?, Age = ?, Sex = ?, Comment = ?, Photo = ? WHERE Id = ?");

            /* Name    */ pt.setString(1, obj.getName());
            /* Age     */ pt.setInt(2, obj.getAge());
            /* Sex     */ pt.setString(3, Character.toString(obj.getSex()));
            /* Comment */ pt.setString(4, obj.getComment());
            /* Photo   */ pt.setString(5, obj.getPhoto());
            /* Id      */ pt.setInt(6, obj.getId());
            
            /* Execute query / Inform succes/failure in console */ int rowsAffected = pt.executeUpdate(); if (rowsAffected > 0) { System.out.println("Record updated successfully"); } else { System.out.println("Record not found or not updated"); }
        } 
        /* Catch Errors and log */ catch (SQLException e) { System.out.println(e.getMessage()); }
        /* Close db connection  */ finally { ConnectionManager.closeConnection(); }
    }
    
    // Remove - Remove record in Data Base
    public void deceased_Remove(Deceased obj) throws SQLException 
    {
        /* Prepare query */ Connection connection = connectionManager.getConnection();

        try 
        {
            /* Prepare query */ PreparedStatement pt = connection.prepareStatement("DELETE FROM Deceased WHERE Id = ?");

            /* Id */ pt.setInt(1, obj.getId());

            /* Execute query */ pt.executeUpdate();
        } 
        /* Catch Errors and log */ catch (SQLException e) { System.out.println(e.getMessage()); }
        /* Close db connection  */ finally { ConnectionManager.closeConnection(); }
    }
    
    ////////////////
    //  Family    //
    ////////////////
    
    // C R U D
    
    // Select All - Retrieves all records from DB and populates a JTable with the information
    public void family_SelectAll(JTable table) throws SQLException 
    {
        /* Open db connection */ Connection connection = connectionManager.getConnection();
        
        /* model obj (to store the db data) */ DefaultTableModel model = new DefaultTableModel();
        
        // Set column names in model for the table
        model.setColumnIdentifiers
        ( 
            new Object[] 
            { 
                "ID", 
                "Name", 
                "Contact", 
                "Address", 
                "Relation", 
                "Photo" 
            } 
        );

        try 
        {
            // List to be used later to fill the data base 
            List<Family> familyList = new ArrayList<>();

            /* Prepare query */ PreparedStatement pt = connection.prepareStatement("SELECT * FROM Family");
            /* Execute query */ ResultSet rs = pt.executeQuery(); 

            // Iterate through results from query 
            while (rs.next()) 
            {
                // The process here: 
                // ResultSet -> var -> obj -> ArrayList
                
                // Create variables (from ResultSet)
                /* Id       */ int id = rs.getInt("Id");
                /* Name     */ String name = rs.getString("Name");
                /* Contact  */ String contact = rs.getString("Contact");
                /* Address  */ String address = rs.getString("Address");
                /* Relation */ String relation = rs.getString("Relation");
                /* Photo    */ String photo = rs.getString("Photo");
                
                // Create obj (from variables)
                /* Obj      */ Family family = new Family();
                /* Id       */ family.setId(id);
                /* Name     */ family.setName(name);
                /* Contact  */ family.setContact(contact);
                /* Address  */ family.setAddress(address);
                /* Relation */ family.setRelation(relation);
                /* Photo    */ family.setPhoto(photo);

                // Add obj to list
                familyList.add(family);
            }
            
            // Add row to the DefaultTableModel (model)
            for (Family family : familyList) { model.addRow(new Object[]{family.getId(), family.getName(), family.getContact(), family.getAddress(), family.getRelation(), family.getPhoto()}); }
            
            // Set the model to the JTable
            table.setModel(model);
        } 
        /* Catch Errors and log */ catch (SQLException e) { System.out.println(e.getMessage()); } 
        /* Close db connection  */ finally { connectionManager.closeConnection(); }
    }
  
    // Add - Add new record to Data Base
    public void family_Add(Family obj) throws SQLException  
    {
        /* Open db connection */ Connection connection = connectionManager.getConnection();
        
        try 
        {
            /* Prepare query */ PreparedStatement pt = connection.prepareStatement ( "INSERT INTO Family (Name, Contact, Address, Relation, Photo) VALUES (?, ?, ?, ?, ?);" );

            /* Name     */ pt.setString(1, obj.getName());
            /* Contact  */ pt.setString(2, obj.getContact());
            /* Address  */ pt.setString(3, obj.getAddress());
            /* Relation */ pt.setString(4, obj.getRelation());
            /* Photo    */ pt.setString(5, obj.getPhoto());

            /* Execute query */ pt.executeUpdate();
        }
        /* Catch Errors and log */ catch (SQLException e) { System.out.println(e.getMessage()); } 
        /* Close db connection  */ finally { ConnectionManager.closeConnection(); }
    }
    
    // Update - Update record in Data Base
    public void family_Update(Family obj) throws SQLException 
    {
        /* Open db connection */ Connection connection = connectionManager.getConnection();
        
        try 
        {
            /* Prepare query */ PreparedStatement pt = connection.prepareStatement("UPDATE Family SET Name = ?, Contact = ?, Address = ?, Relation = ?, Photo = ? WHERE Id = ?");

            /* Name     */ pt.setString(1, obj.getName());
            /* Contact  */ pt.setString(2, obj.getContact());
            /* Address  */ pt.setString(3, obj.getAddress());
            /* Relation */ pt.setString(4, obj.getRelation());
            /* Photo    */ pt.setString(5, obj.getPhoto());
            /* Id       */ pt.setInt(6, obj.getId());
            
            /* Execute query / Inform succes/failure in console */ int rowsAffected = pt.executeUpdate(); if (rowsAffected > 0) { System.out.println("Record updated successfully"); } else { System.out.println("Record not found or not updated"); }
        } 
        /* Catch Errors and log */ catch (SQLException e) { System.out.println(e.getMessage()); }
        /* Close db connection  */ finally { ConnectionManager.closeConnection(); }
    }
    
    // Remove - Remove record in Data Base
    public void family_Remove(Family obj) throws SQLException 
    {
        /* Prepare query */ Connection connection = connectionManager.getConnection();

        try 
        {
            /* Prepare query */ PreparedStatement pt = connection.prepareStatement("DELETE FROM Family WHERE Id = ?");

            /* Id */ pt.setInt(1, obj.getId());

            /* Execute query */ pt.executeUpdate();
        } 
        /* Catch Errors and log */ catch (SQLException e) { System.out.println(e.getMessage()); }
        /* Close db connection  */ finally { ConnectionManager.closeConnection(); }
    }
    
    
    ////////////////
    //  Service   //
    ////////////////
    
    // C R U D
    
    // Select All - Retrieves all records from DB and populates a JTable with the information
     public void service_SelectAll(JTable table) throws SQLException 
    {
        /* Open db connection */ Connection connection = connectionManager.getConnection();
        
        /* model obj (to store the db data) */ DefaultTableModel model = new DefaultTableModel();
        
        // Set column names in model for the table
        model.setColumnIdentifiers
        ( 
            new Object[] 
            { 
                "ID", 
                "FamilyId", 
                "DeceasedId", 
                "Comment", 
                "Date", 
                "Price",
                "CheckPay"
            } 
        );

        try 
        {
            // List to be used later to fill the data base 
            List<Service> serviceList = new ArrayList<>();

            /* Prepare query */ PreparedStatement pt = connection.prepareStatement("SELECT * FROM Service");
            /* Execute query */ ResultSet rs = pt.executeQuery(); 

            // Iterate through results from query 
            while (rs.next()) 
            {
                // The process here: 
                // ResultSet -> var -> obj -> ArrayList
                
                // Create variables (from ResultSet)
                /* Id           */ int id = rs.getInt("Id");
                /* Family Id    */ int fmId = rs.getInt("FamilyId");
                /* Deceased Id  */ int dcId = rs.getInt("DeceasedId");
                /* Comment      */ String comment = rs.getString("Comment");
                /* Date         */ Date date = rs.getDate("Date");
                /* Price        */ double price = rs.getDouble("Price");
                /* CheckPay     */ boolean checkPay = rs.getBoolean("CheckPay");
                
                // Create obj (from variables)
                /* Obj         */ Service service = new Service();
                /* Id          */ service.setId(id);
                /* Family Id   */ service.setFamilyID(fmId);
                /* Deceased Id */ service.setDeceasedID(dcId);
                /* Comment     */ service.setComment(comment);
                /* Date        */ service.setDate(date);
                /* Price       */ service.setPrice(price);
                /* CheckPay    */ service.setCheckPay(checkPay);

                // Add obj to list
                serviceList.add(service);
            }
            
            // Add row to the DefaultTableModel (model)
            for (Service service : serviceList) {
            model.addRow(new Object[]{service.getId(), service.getFamilyID(), service.getDeceasedID(), service.getComment(), service.getDate(), service.getPrice(), service.isCheckPay()});
        }
            
            // Set the model to the JTable
            table.setModel(model);
        } 
        /* Catch Errors and log */ catch (SQLException e) { System.out.println(e.getMessage()); } 
        /* Close db connection  */ finally { connectionManager.closeConnection(); }
    }
  
    // Add - Add new record to Data Base
    public void service_Add(Service obj) throws SQLException  
    {   
        /* Open db connection */ Connection connection = connectionManager.getConnection();

        try 
        {
            /* Prepare query */ PreparedStatement pt = connection.prepareStatement("INSERT INTO Service (FamilyId, DeceasedId, Comment, Date, Price, CheckPay) VALUES (?, ?, ?, ?, ?, ?)");

            /* FamilyId   */ pt.setInt(1, obj.getFamilyID());
            /* DeceasedId */ pt.setInt(2, obj.getDeceasedID());
            /* Comment    */ pt.setString (3, obj.getComment());
            /* Date       */ java.util.Date utilDate = obj.getDate(); java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); pt.setDate(4, sqlDate);
            /* Price      */ pt.setDouble (5, obj.getPrice());
            /* CheckPay   */ pt.setBoolean(6, obj.isCheckPay());

            /* Execute query */ pt.executeUpdate();
        }
        /* Catch Errors and log */ catch (SQLException e) { System.out.println(e.getMessage()); } 
        /* Close db connection  */ finally { ConnectionManager.closeConnection(); }
    }
    
    // Update - Update record in Data Base
    public void service_Update(Service obj) throws SQLException 
    {
        /* Open db connection */ Connection connection = connectionManager.getConnection();
        
        try 
        {
            /* Prepare query */ PreparedStatement pt = connection.prepareStatement("UPDATE Service SET FamilyId = ?, DeceasedId = ?, Comment = ?, Date = ?, Price = ?, CheckPay = ? WHERE Id = ?");

            /* FamilyId   */ pt.setInt(1, obj.getFamilyID());
            /* DeceasedId */ pt.setInt(2, obj.getDeceasedID());
            /* Comment    */ pt.setString (3, obj.getComment());
            /* Date       */ java.util.Date utilDate = obj.getDate(); java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); pt.setDate(4, sqlDate);
            /* Price      */ pt.setDouble (5, obj.getPrice());
            /* CheckPay   */ pt.setBoolean(6, obj.isCheckPay());
            /* Id         */ pt.setInt(7, obj.getId());
            
            /* Execute query / Inform succes/failure in console */ int rowsAffected = pt.executeUpdate(); if (rowsAffected > 0) { System.out.println("Record updated successfully"); } else { System.out.println("Record not found or not updated"); }
        } 
        /* Catch Errors and log */ catch (SQLException e) { System.out.println(e.getMessage()); }
        /* Close db connection  */ finally { ConnectionManager.closeConnection(); }
    }
   
    // Remove - Remove record in Data Base
    public void service_Remove(Service obj) throws SQLException 
    {
        /* Prepare query */ Connection connection = connectionManager.getConnection();

        try 
        {
            /* Prepare query */ PreparedStatement pt = connection.prepareStatement("DELETE FROM Service WHERE Id = ?");

            /* Id */ pt.setInt(1, obj.getId());

            /* Execute query */ pt.executeUpdate();
        } 
        /* Catch Errors and log */ catch (SQLException e) { System.out.println(e.getMessage()); }
        /* Close db connection  */ finally { ConnectionManager.closeConnection(); }
    }
    
}


