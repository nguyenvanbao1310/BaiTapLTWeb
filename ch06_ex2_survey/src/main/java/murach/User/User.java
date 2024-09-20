package murach.User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;

/**
 *
 * @author ASUS
 */

public class User implements Serializable
{
    
    private String firstName;
    private String lastName;
    private String email;
    private String radio;
    private String check;
    private String option;
    
    public User(){
        firstName ="";
        lastName = "";
        email = "";
        radio="";
        check="";
        option="";
    }
    
    public User(String firstName, String lastName, String email,
    String radio, String check, String option)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.radio = radio;
        this.check = check;
        this.option = option;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setlastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
   
    public String getRadio(){
        return radio;
    }
    
    public void setRadio(String radio){
        this.radio = radio;
    }
    
    public String getCheck(){
        return check;
    }
    
    public void setCheck(String check){
        this.check = check;
    }
    
    public String getOption(){
        return option;
    }
    
    public void setOption(String option){
        this.option = option;
    }
}
