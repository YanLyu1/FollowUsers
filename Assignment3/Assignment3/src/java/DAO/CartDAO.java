/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Product;
import Pojo.ShoppingCart;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
public class CartDAO {
    
    public HttpSession getOriInfo_session (HttpSession session){
        //for storing information
        ShoppingCart shoppingCart;
        //get original bookList or create new
        if(session.getAttribute("products") != null){
            shoppingCart = (ShoppingCart)session.getAttribute("products");
        }else{
            shoppingCart = new ShoppingCart();
        }
        session.setAttribute("products", shoppingCart);
        //return the old infromation
        return session;
    }
    
    public void addCart(HttpSession session, String[] products) {
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("products");
        ArrayList<Product> productList = shoppingCart.getCart();
        for(String item : products){
            Product product = new Product();
            product.setName(item);
            productList.add(product);
            productList = removeDuplicate(productList);
            }
        shoppingCart.setCart(productList);
        session.setAttribute("products", shoppingCart);
    }
    

    public HttpSession deleteItems(HttpSession session, String[] deleteProducts) {
        ShoppingCart productItems = (ShoppingCart) session.getAttribute("products");

         if(deleteProducts != null){
            for(int i = 0; i < productItems.getCart().size(); i++){
                for(String deleteBook : deleteProducts){
                    if(productItems.getCart().get(i).getName().equals(deleteBook))
                        productItems.getCart().remove(i);
                }
            }
            session.setAttribute("products", productItems);
        }
        return session;
    }
    
    public ArrayList<Product> removeDuplicate(ArrayList<Product> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).getName().equals(list.get(i).getName())) {
                    list.remove(j);
                }
            }
        }
        return list;
    }
 }
