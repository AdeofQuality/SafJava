/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

// @author efapro01.23 Roberto Carvalho

import java.util.Objects;


public class FamilyItem 
{
    
    // ::::::::::::::::
    // Variables
    // ::::::::::::::::
    
    private int id;
    private String name;

    // ::::::::::::::::
    // Constructor
    // ::::::::::::::::
    
    // Blank
    public FamilyItem() 
    {}
    
    public FamilyItem(int id, String name) 
    {
        this.id = id;
        this.name = name;
    }
    
    // ::::::::::::::::
    // Gets & Sets
    // ::::::::::::::::

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
    
    // ::::::::::::::::
    // HashCode Equals
    // ::::::::::::::::

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FamilyItem other = (FamilyItem) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

    // ::::::::::::::::
    // toString
    // ::::::::::::::::

    @Override
    public String toString() 
    {
        return name;
    }
    
}
