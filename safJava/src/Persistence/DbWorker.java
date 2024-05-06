package Persistence;

import Persistence.DbAdapter;
import Business.*;
import java.sql.SQLException;
import javax.swing.JTable;

// @author efapro01.23 Roberto Carvalho

public class DbWorker 
{
    
    // ::::::::::::::::::::
    // Variables
    // ::::::::::::::::::::
    
    public DbAdapter dbAdapter;
    
    // ::::::::::::::::::::
    // Constructors
    // ::::::::::::::::::::
    
    public DbWorker() throws SQLException { dbAdapter = new DbAdapter(); }
    
    // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    // Methods
    // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    
    ////////////////
    //  Deceased  //
    ////////////////
    
    // C R U D

    /* Select */ public void deceased_SelectAll(JTable table) throws SQLException { dbAdapter.deceased_SelectAll(table); }
    /* Add    */ public void deceased_Add(Deceased obj)       throws SQLException { dbAdapter.deceased_Add(obj); }
    /* Update */ public void deceased_Update(Deceased obj)    throws SQLException { dbAdapter.deceased_Update(obj); }
    /* Remove */ public void deceased_Remove(Deceased obj)    throws SQLException { dbAdapter.deceased_Remove(obj); }
    
    ////////////////
    //  Family    //
    ////////////////
    
    // C R U D
    
    /* Select */ public void family_SelectAll(JTable table) throws SQLException { dbAdapter.family_SelectAll(table); }
    /* Add    */ public void family_Add(Family obj)         throws SQLException { dbAdapter.family_Add(obj); }
    /* Update */ public void family_Update(Family obj)      throws SQLException { dbAdapter.family_Update(obj); }
    /* Remove */ public void family_Remove(Family obj)      throws SQLException { dbAdapter.family_Remove(obj); }
    
    ////////////////
    //  Service   //
    ////////////////
    
    // C R U D
    
    /* Select */ public void service_SelectAll(JTable table) throws SQLException { dbAdapter.service_SelectAll(table); }
    /* Add    */ public void service_Add(Service obj)        throws SQLException { dbAdapter.service_Add(obj); }    
    /* Update */ public void service_Update(Service obj)     throws SQLException { dbAdapter.service_Update(obj); }
    /* Remove */ public void service_Remove(Service obj)     throws SQLException { dbAdapter.service_Remove(obj); }
    
}
