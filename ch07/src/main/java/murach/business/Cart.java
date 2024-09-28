/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.business;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class Cart implements Serializable{
    private ArrayList<Items> listItems;
    
    public Cart (){
       this.listItems= new ArrayList<Items>();
    }
    
    public ArrayList<Items> getCart(){
        return listItems;
    }
    
    public void setCart (ArrayList<Items> listItems){
        this.listItems = listItems;
    }
    
    public void handleId(Cart a, Product pro, String id){
        for(Items i: a.getCart()){
            if(i.getPro().getProId().equals(id)){
                i.setQuantity(i.getQuantity()+1);
                return;
            }
        }
        addProduct(a,pro,1);
    }
    
    public void addProduct(Cart a, Product pro, int quantity){
        Items add = new Items(pro,quantity);
        a.getCart().add(add);
    }
    
    public void updateCart(Cart a, String id, int quantity){
        for(Items i: a.getCart()){
            if(i.getPro().getProId().equals(id)){
                i.setQuantity(quantity);
                return;
            }
        }
    }
    
    public void removeCart(Cart a, String id){
        a.getCart().removeIf(item -> item.getPro().getProId().equals(id));
    }
    
}
