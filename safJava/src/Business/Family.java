package Business;

// @author efapro01.23 Roberto Carvalho

import java.util.Objects;


public class Family 
{
    
    // ::::::::::::::::
    // Variables
    // ::::::::::::::::
    
    private int id;
    private String name;
    private String contact;
    private String address;
    private String relation;
    private String Photo;
    
    // ::::::::::::::::
    // Constructor
    // ::::::::::::::::
    
    // Blank
    public Family() { }
        
    // All
    public Family(int id, String name, String contact, String address, String relation, String Photo) 
    {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.relation = relation;
        this.Photo = Photo;
    }
   
    // ::::::::::::::::
    // Gets & Sets
    // ::::::::::::::::
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }
    
    // ::::::::::::::::
    // HashCode Equals
    // ::::::::::::::::
    
    @Override
    public int hashCode() 
    {
        int hash = 5;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.contact);
        hash = 13 * hash + Objects.hashCode(this.address);
        hash = 13 * hash + Objects.hashCode(this.relation);
        hash = 13 * hash + Objects.hashCode(this.Photo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Family other = (Family) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.contact, other.contact)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.relation, other.relation)) {
            return false;
        }
        return Objects.equals(this.Photo, other.Photo);
    }

    // ::::::::::::::::
    // toString
    // ::::::::::::::::
    
    // toString to use in family_Add
    public String displayAllVariablesFor_Family_Add() 
    {
        return "\nName: " + name + "\nContact: " + contact + "\nAddress: " + address + "\nRelation: " + relation + "\nPhoto: " + Photo;
    }
        
    // toString to use in family_Update
    public String displayAllVariablesFor_Family_Update() 
    {
        return "\nId: " + id + "\nName: " + name + "\nContact: " + contact + "\nAddress: " + address + "\nRelation: " + relation + "\nPhoto: " + Photo;
    }
    
    // Regular NETBEANS automated toString
    @Override
    public String toString() 
    {
        return "Family{" + "id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address + ", relation=" + relation + ", Photo=" + Photo + '}';
    }

}
