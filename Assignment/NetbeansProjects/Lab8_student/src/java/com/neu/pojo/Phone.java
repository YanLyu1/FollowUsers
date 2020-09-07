/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.pojo;

/**
 *
 * @author root
 */
public class Phone {
    private long phId;
    private int phoneNumber;
    //
    private User user;

    public Phone() {
    }

    public Phone(int i) {
        this.phoneNumber =  i;
    }

    public long getPhId() {
        return phId;
    }

    public void setPhId(long phId) {
        this.phId = phId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}
