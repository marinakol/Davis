/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toba.business;

import java.io.Serializable;

public class User1 implements Serializable {

    private String username;
    private String password;

    public User1() {
        username = "";
        password = "";

    }

    public User1(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
}
