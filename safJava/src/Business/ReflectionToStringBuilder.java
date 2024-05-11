// @author efapro01.23 Roberto Carvalho

package business;

import java.lang.reflect.Field;

public class ReflectionToStringBuilder 
{
    // ::::::::::::::::::::
    // Constructor
    // ::::::::::::::::::::
    public ReflectionToStringBuilder() 
    { }
    
    // ::::::::::::::::::::
    // Methods
    // ::::::::::::::::::::
    public String buildString(Object obj) 
    {   
        java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
        Field[] fields = this.getClass().getDeclaredFields();
        
        for (Field field : fields) 
        {
            field.setAccessible(true);
            try 
            { 
                stringBuilder.append(field.getName()).append(": ").append(field.get(this)).append("\n"); 
            } 
            catch (IllegalAccessException e) 
            { 
                System.out.println(e.getMessage()); 
            }
        }
        
        return stringBuilder.toString();
    }
}