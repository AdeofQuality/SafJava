package Business;

import Persistence.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.JTable;

// @author efapro01.23 Roberto Carvalho

public class ProgramController 
{
    
    // ::::::::::::::::::::
    // Variables
    // ::::::::::::::::::::
    
    public DbWorker dbWorker;
    
    // ::::::::::::::::::::
    // Constructors
    // ::::::::::::::::::::
    
    public ProgramController() throws SQLException { dbWorker = new DbWorker(); }

    // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    // Methods
    // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    ////////////////
    //  Deceased  //
    ////////////////
    
    // C R U D

    /* Select */ public void deceased_SelectAll (JTable table) throws SQLException { try { dbWorker.deceased_SelectAll(table); } catch (SQLException e) { System.out.println(e.getMessage()); } }
    /* Add    */ public void deceased_Add       (Deceased obj) throws SQLException { try { dbWorker.deceased_Add(obj);         } catch (SQLException e) { System.out.println(e.getMessage()); } }
    /* Update */ public void deceased_Update    (Deceased obj) throws SQLException { try { dbWorker.deceased_Update(obj);      } catch (SQLException e) { System.out.println(e.getMessage()); } }
    /* Remove */ public void deceased_Remove    (Deceased obj) throws SQLException { try { dbWorker.deceased_Remove(obj);      } catch (SQLException e) { System.out.println(e.getMessage()); } }
          
    ////////////////
    //  Family    //
    ////////////////
    
    // C R U D

    /* Select */ public void family_SelectAll (JTable table) throws SQLException { try { dbWorker.family_SelectAll(table); } catch (SQLException e) { System.out.println(e.getMessage()); } }
    /* Add    */ public void family_Add       (Family obj  ) throws SQLException { try { dbWorker.family_Add(obj);         } catch (SQLException e) { System.out.println(e.getMessage()); } }
    /* Update */ public void family_Update    (Family obj  ) throws SQLException { try { dbWorker.family_Update(obj);      } catch (SQLException e) { System.out.println(e.getMessage()); } }
    /* Remove */ public void family_Remove    (Family obj  ) throws SQLException { try { dbWorker.family_Remove(obj);      } catch (SQLException e) { System.out.println(e.getMessage()); } }
    
    ////////////////
    //  Service   //
    ////////////////
    
    // C R U D
    
    /* Select */ public void service_SelectAll (JTable table) throws SQLException { try { dbWorker.service_SelectAll(table); } catch (SQLException e) { System.out.println(e.getMessage()); } }
    /* Add    */ public void service_Add       (Service obj ) throws SQLException { try { dbWorker.service_Add(obj);         } catch (SQLException e) { System.out.println(e.getMessage()); } }
    /* Update */ public void service_Update    (Service obj ) throws SQLException { try { dbWorker.service_Update(obj);      } catch (SQLException e) { System.out.println(e.getMessage()); } }
    /* Remove */ public void service_Remove    (Service obj ) throws SQLException { try { dbWorker.service_Remove(obj);      } catch (SQLException e) { System.out.println(e.getMessage()); } }
    
    ////////////////
    //  Search    //
    ////////////////
    
    // --------------------------
    // For Family
    // --------------------------
    /* Fill table             */ public void search_SelectAllFamilyNames          (JTable table)              throws SQLException { try { dbWorker.search_SelectAllFamilyNames(table); }               catch (SQLException e) { System.out.println(e.getMessage()); } }
    /* By ID                  */ public void search_SelectFamilyById              (Service obj, JTable table) throws SQLException { try { dbWorker.search_SelectFamilyById(obj, table); }              catch (SQLException e) { System.out.println(e.getMessage()); } }  
    /* By Table list (filter) */ public void search_SelectFamilyByTableListFilter (Family obj, JTable table)  throws SQLException { try { dbWorker.search_SelectFamilyByTableListFilter(obj, table); } catch (SQLException e) { System.out.println(e.getMessage()); } }    
    
    // --------------------------
    // For Deceased
    // --------------------------
    /* Fill table             */ public void search_SelectAllDeceasedNames         (JTable table)               throws SQLException { try { dbWorker.search_SelectAllDeceasedNames(table); }               catch (SQLException e) { System.out.println(e.getMessage()); } }
    /* By ID                  */ public void search_SelectDeceasedById             (Service obj, JTable table)  throws SQLException { try { dbWorker.search_SelectDeceasedById(obj, table); }              catch (SQLException e) { System.out.println(e.getMessage()); } }  
    /* By Table list (filter) */ public void search_SelectDeceasedByTableListFilter(Deceased obj, JTable table) throws SQLException { try { dbWorker.search_SelectDeceasedByTableListFilter(obj, table); } catch (SQLException e) { System.out.println(e.getMessage()); } }  
    
    // --------------------------
    // For Service
    // --------------------------
    /* Filter        */ public void search_Filter    (Service obj, JTable table) throws SQLException { try { dbWorker.search_Filter(obj, table);} catch (SQLException e) { System.out.println(e.getMessage()); } }
    /* Show All      */ public void search_SelectAll (JTable table)              throws SQLException { try { dbWorker.search_SelectAll(table); }  catch (SQLException e) { System.out.println(e.getMessage()); } }
    
    
}
