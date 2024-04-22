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
import services.AdministratorService;

@Named(value = "adminManageEntitiesController")
@RequestScoped
public class AdminManageEntitiesController {
    
    @Inject
    private AdministratorService administratorService;

    // Freelancer attributes
    private String freelancerName;
    private String freelancerSkills;
    private String freelancerMessage;
    private long freelancerIdToRemove;

    // Job attributes
    private String jobTitle;
    private String jobKeywords;
    private String jobDescription;
    private double jobPaymentOffer;
    private long jobIdToRemove;

    // Provider attributes
    private String providerName;
    private String providerEmail;
    private String providerPassword;
    private long providerIdToRemove;

    // Methods for adding and removing entities
    public void addFreelancer() {
        administratorService.registerFreelancer(new Freelancer(freelancerName, freelancerSkills, freelancerMessage));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
            "Success", "Freelancer added successfully."
        ));
    }

    public void removeFreelancer() {
        administratorService.removeFreelancer(freelancerIdToRemove);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
            "Success", "Freelancer removed successfully."
        ));
    }

    public void addJob() {
        administratorService.addJob(new JobDescription(jobTitle, jobKeywords, jobDescription, jobPaymentOffer));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
            "Success", "Job added successfully."
        ));
    }

    public void removeJob() {
        administratorService.removeJob(jobIdToRemove);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
            "Success", "Job removed successfully."
        ));
    }

    public void addProvider() {
        administratorService.registerJobProvider(new JobProvider(providerName, providerEmail, providerPassword));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
            "Success", "Provider added successfully."
        ));
    }

    public void removeProvider() {
        administratorService.removeJobProvider(providerIdToRemove);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
            "Success", "Provider removed successfully."
        ));
    }

    // Getters and setters for all attributes
}

