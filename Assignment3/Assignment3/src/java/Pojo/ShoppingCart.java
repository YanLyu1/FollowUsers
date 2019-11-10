/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class ShoppingCart {
    ArrayList<Product> cart;
    
    public ShoppingCart(){
     cart = new ArrayList<>();
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }
}
