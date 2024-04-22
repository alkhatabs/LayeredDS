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

import entities.Freelancer;
import entities.JobProvider;
import services.AdministratorService;

@Named(value = "administratorController")
@RequestScoped
public class AdministratorController {

    @Inject
    private AdministratorService administratorService;

    private Freelancer freelancer;
    private JobProvider jobProvider;

    public void registerFreelancer() {
        administratorService.registerFreelancer(freelancer);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                "Success", "Freelancer registered successfully."
        ));
    }

    public void removeFreelancer() {
        long freelancerId = freelancer.getId(); // Assuming getId() returns the ID of the freelancer
        administratorService.removeFreelancer(freelancerId);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                "Success", "Freelancer removed successfully."
        ));
    }

    public void registerJobProvider() {
        administratorService.registerJobProvider(jobProvider);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                "Success", "Job provider registered successfully."
        ));
    }

    public void removeJobProvider() {
        long jobProviderId = jobProvider.getId(); // Assuming getId() returns the ID of the job provider
        administratorService.removeJobProvider(jobProviderId);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                "Success", "Job provider removed successfully."
        ));
    }

    public void removeJobDescription(long jobId) {
        administratorService.removeJobDescription(jobId);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                "Success", "Job description removed successfully."
        ));
    }

    // Getter and setter methods
    public Freelancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    public JobProvider getJobProvider() {
        return jobProvider;
    }

    public void setJobProvider(JobProvider jobProvider) {
        this.jobProvider = jobProvider;
    }
}
