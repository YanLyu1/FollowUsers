/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.pojo;

import java.util.Set;

/**
 *
 * @author root
 */
public class User {
    private long userID;
    private String fname;
    private String lname;
    //one-to-many
    private Set<Phone> phoneNos;
    private Set<Email> emails;

    public User() {
    }

    public Set<Email> getEmails() {
        return emails;
    }

    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }
    

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public Set<Phone> getPhoneNos() {
        return phoneNos;
    }

    public void setPhoneNos(Set<Phone> phoneNos) {
        this.phoneNos = phoneNos;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    
}
