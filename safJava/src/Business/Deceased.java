package Business;

// @author efapro01.23 Roberto Carvalho

import java.util.Objects;


public class Deceased 
{
    
    // ::::::::::::::::
    // Variables
    // ::::::::::::::::
    
    private int id;
    private String name;
    private int age;
    private char sex;
    private String Comment;
    private String Photo;
    
    // ::::::::::::::::
    // Constructor
    // ::::::::::::::::
    
    // Blank
    public Deceased() { }
    
    // All
    public Deceased(int id, String name, int age, char sex, String Comment, String Photo) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.Comment = Comment;
        this.Photo = Photo;
    }
    
    // ::::::::::::::::
    // Gets & Sets
    // ::::::::::::::::
    
    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getAge() 
    {
        return age;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
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
        int hash = 3;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + this.age;
        hash = 83 * hash + this.sex;
        hash = 83 * hash + Objects.hashCode(this.Comment);
        hash = 83 * hash + Objects.hashCode(this.Photo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) 
        {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Deceased other = (Deceased) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (this.sex != other.sex) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.Comment, other.Comment)) {
            return false;
        }
        return Objects.equals(this.Photo, other.Photo);
    }
    
    // ::::::::::::::::
    // toString
    // ::::::::::::::::
    
    // toString to use in deceased_Add
    public String displayAllVariablesFor_Deceased_Add() 
    {
        return "\nName: " + name + "\nAge: " + age + "\nSex: " + sex + "\nComment: " + Comment + "\nPhoto: " + Photo;
    }
    
    // toString to use in deceased_Update
    public String displayAllVariablesFor_Deceased_Update() 
    {
        return "\nId: " + id + "\nName: " + name + "\nAge: " + age + "\nSex: " + sex + "\nComment: " + Comment + "\nPhoto: " + Photo;
    }
    
    // Regular NETBEANS automated toString
    @Override
    public String toString() 
    {
        return "Deceased{" + "id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", Comment=" + Comment + ", Photo=" + Photo + '}';
    }
    
    
 
    
}
