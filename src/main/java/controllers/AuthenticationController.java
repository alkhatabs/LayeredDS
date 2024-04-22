/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author albusaidi
 */


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

import services.AuthenticationService;

@Named(value = "authenticationController")
@RequestScoped
public class AuthenticationController {
    
    @Inject
    private AuthenticationService authenticationService;

    private String username;
    private String password;

    public String login() {
        boolean loggedIn = authenticationService.authenticate(username, password);
        if (loggedIn) {
            // Redirect user to a secured page
            return "securedPage"; // Example navigation case
        } else {
            // Display login error message
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_ERROR,
                "Login Failed",
                "Invalid username or password."
            ));
            return null; // Stay on the same page
        }
    }

    public String logout() {
        // Implement logout logic, e.g., invalidate session
        // Redirect user to the login page
        return "login"; // Example navigation case
    }

    // Getter and setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
