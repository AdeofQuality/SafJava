package Business;

// @author efapro01.23 Roberto Carvalho

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


public class Service 
{
    
    // ::::::::::::::::
    // Variables
    // ::::::::::::::::
    
    private int id;
    private int familyID;
    private int deceasedID;
    private String comment;
    private Date date;
    private double price;
    private boolean checkPay;
    
    // ::::::::::::::::
    // Constructor
    // ::::::::::::::::

    public Service() 
    { }

    public Service(int id, int familyID, int deceasedID, String comment, Date date, double price, boolean checkPay) 
    {
        this.id = id;
        this.familyID = familyID;
        this.deceasedID = deceasedID;
        this.comment = comment;
        this.date = date;
        this.price = price;
        this.checkPay = checkPay;
    }

    public int getId()    
    {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFamilyID() {
        return familyID;
    }

    public void setFamilyID(int familyID) {
        this.familyID = familyID;
    }

    public int getDeceasedID() {
        return deceasedID;
    }

    public void setDeceasedID(int deceasedID) {
        this.deceasedID = deceasedID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCheckPay() {
        return checkPay;
    }

    // ::::::::::::::::
    // Gets & Sets
    // ::::::::::::::::
    public void setCheckPay(boolean checkPay) {
        this.checkPay = checkPay;
    }

    // ::::::::::::::::
    // HashCode Equals
    // ::::::::::::::::

    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + this.familyID;
        hash = 79 * hash + this.deceasedID;
        hash = 79 * hash + Objects.hashCode(this.comment);
        hash = 79 * hash + Objects.hashCode(this.date);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 79 * hash + (this.checkPay ? 1 : 0);
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
        final Service other = (Service) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.familyID != other.familyID) {
            return false;
        }
        if (this.deceasedID != other.deceasedID) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.checkPay != other.checkPay) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }
    

    // ::::::::::::::::
    // toString
    // ::::::::::::::::
    
    // toString to use in service_Add
    public String displayAllVariablesFor_Service_Add() 
    {
        return "\nFamily Id: " + familyID + "\nDeceased Id: " + deceasedID + "\nComment: " + comment + "\nDate: " + date + "\nPrice: " + price + "\nPay: " + checkPay;
    }
    
    // toString to use in service_Update
    public String displayAllVariablesFor_Service_Update() 
    {
        return "\nFamily Id: " + familyID + "\nDeceased Id: " + deceasedID + "\nComment: " + comment + "\nDate: " + date + "\nPrice: " + price + "\nPay: " + checkPay;
    }
    
    // Regular NETBEANS automated toString

    @Override
    public String toString() 
    {
        return "Service{" + "id=" + id + ", familyID=" + familyID + ", deceasedID=" + deceasedID + ", comment=" + comment + ", date=" + date + ", price=" + price + ", checkPay=" + checkPay + '}';
    }
    
 
}
