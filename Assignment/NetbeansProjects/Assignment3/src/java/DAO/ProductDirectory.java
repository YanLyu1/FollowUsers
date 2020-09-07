/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Product;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class ProductDirectory {
    private ArrayList<Product> products;
    
    public ProductDirectory(){
        products = new ArrayList<>();
        
        Product product1 = new Product();
        product1.setName("Java Servlet Programming");
        product1.setPrice("$ 29.95");
        product1.setType("book");
        Product product2 = new Product();
        product2.setName("Oracle Database Programming");
        product2.setPrice("$ 48.95");
        product2.setType("book");
        Product product3 = new Product();
        product3.setName("System Analysis and Design with UML");
        product3.setPrice("$ 29.95");
        product3.setType("book");
        Product product4 = new Product();
        product4.setName("Object Oriented Software Engineering");
        product4.setPrice("$ 29.95");
        product4.setType("book");
        Product product5 = new Product();
        product5.setName("Java Web Service");
        product5.setPrice("$ 29.95");
        product5.setType("book");
        Product product6 = new Product();
        product6.setName("I am going to tell you a secret by Madonna");
        product6.setPrice("$ 26.99");
        product6.setType("music");
        Product product7 = new Product();
        product7.setName("Baby one more time by Betney spear");
        product7.setPrice("$ 27.99");
        product7.setType("music");
        Product product8 = new Product();
        product8.setName("Justified bu Justin Timberlake");
        product8.setPrice("$ 28.99");
        product8.setType("music");
        Product product9 = new Product();
        product9.setName("Loose by Nelly Furtado");
        product9.setPrice("$ 29.99");
        product9.setType("music");
        Product product10 = new Product();
        product10.setName("Gold Digger by Kenys Westusic");
        product10.setPrice("$ 25.99");
        product10.setType("music");
        Product product11 = new Product();
        product11.setName("Apple Mac Pro with 13.3s Display");
        product11.setPrice("$ 1299.99");
        product11.setType("computer");
        Product product12 = new Product();
        product12.setName("Asus Laptop with centro 2 Balck");
        product12.setPrice("$ 1399.99");
        product12.setType("computer");
        Product product13 = new Product();
        product13.setName("HP Pavhon with centro 2 DV 7");
        product13.setPrice("$ 1499.99");
        product13.setType("computer");
        Product product14 = new Product();
        product14.setName("Toshba saellte Laptop with centro 2 - Copper");
        product14.setPrice("$ 1599.99");
        product14.setType("computer");
        Product product15 = new Product();
        product15.setName("Sony VAIO Laptop with Core 2Duo Compolitan Pink");
        product15.setPrice("$ 1699.99");
        product15.setType("computer");

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        products.add(product9);
        products.add(product10);
        products.add(product11);
        products.add(product12);
        products.add(product13);
        products.add(product14);
        products.add(product15);
    }
    
    

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    
        
}
