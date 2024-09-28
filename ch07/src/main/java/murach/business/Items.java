/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.business;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class Items implements Serializable {
    private Product pro;
    private int quantity;
    
    public Items(Product pro, int quantity){
        this.pro = pro;
        this.quantity = quantity;
    }
    
    public Product getPro(){
        return pro;
    }
    
    public void setPro(Product pro){
        this.pro = pro;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
  
}
