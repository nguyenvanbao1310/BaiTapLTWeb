/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.business;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author ASUS
 */
public class Product implements Serializable{
    private String name;
    private double price;
    private String proId;
    
    public Product(String name, double price, String proId)
    {
        this.name = name;
        this.price = price;
        this.proId = proId;
    }
    
     public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public String getProId(){
        return proId;
    }
    
    public void setProId(String proId){
        this.proId = proId;
    }
}
