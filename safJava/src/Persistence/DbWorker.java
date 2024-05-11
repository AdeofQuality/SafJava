package Persistence;

import Persistence.DbAdapter;
import Business.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JList;
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
    
    ////////////////
    //  Search    //
    ////////////////
    
    // --------------------------
    // For Family
    // --------------------------
    /* Fill table             */ public void search_SelectAllFamilyNames(JTable table)                      throws SQLException { dbAdapter.search_SelectAllFamilyNames(table); }
    /* By ID                  */ public void search_SelectFamilyById(Service obj, JTable table)             throws SQLException { dbAdapter.search_SelectFamilyById(obj, table); }
    /* By Table list (filter) */ public void search_SelectFamilyByTableListFilter(Family obj, JTable table) throws SQLException { dbAdapter.search_SelectFamilyByTableListFilter(obj, table); }  
    
    
    // --------------------------
    // For Deceased
    // --------------------------
    /* Fill table             */ public void search_SelectAllDeceasedNames(JTable table)                        throws SQLException { dbAdapter.search_SelectAllDeceasedNames(table); }
    /* By ID                  */ public void search_SelectDeceasedById(Service obj, JTable table)               throws SQLException { dbAdapter.search_SelectDeceasedById(obj, table); }
    /* By Table list (filter) */ public void search_SelectDeceasedByTableListFilter(Deceased obj, JTable table) throws SQLException { dbAdapter.search_SelectDeceasedByTableListFilter(obj, table); }  
    
    
    // --------------------------
    // For Services
    // --------------------------
    /* Filter        */ public void search_Filter(Service obj, JTable table) throws SQLException { dbAdapter.search_Filter(obj, table); }
    /* Show All      */ public void search_SelectAll(JTable table)           throws SQLException { dbAdapter.search_SelectAll(table); }
}
