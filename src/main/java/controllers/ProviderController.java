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

import entities.JobDescription;
import services.ProviderService;

import java.util.List;

@Named (value = "providerController")
@RequestScoped
public class ProviderController {
    
    @Inject
    private ProviderService providerService;

    private JobDescription newJobDescription;
    private JobDescription selectedJobDescription;

    public ProviderController() {
        newJobDescription = new JobDescription();
    }

    public String createJob() {
        providerService.createJob(newJobDescription);
        newJobDescription = new JobDescription(); // Clear the form
        return "jobCreated"; // Example navigation case
    }

    public List<JobDescription> listJobs() {
        return providerService.getAllJobDescriptions();
    }

    public void removeJob(JobDescription jobDescription) {
        providerService.removeJob(jobDescription);
    }

    public void viewFreelancerProfile(JobDescription jobDescription) {
        // Implement logic to view freelancer profile based on jobDescription
    }

    public void acceptFreelancer(JobDescription jobDescription) {
        providerService.acceptFreelancer(jobDescription);
    }

    // Getter and setter methods
    public JobDescription getNewJobDescription() {
        return newJobDescription;
    }

    public void setNewJobDescription(JobDescription newJobDescription) {
        this.newJobDescription = newJobDescription;
    }

    public JobDescription getSelectedJobDescription() {
        return selectedJobDescription;
    }

    public void setSelectedJobDescription(JobDescription selectedJobDescription) {
        this.selectedJobDescription = selectedJobDescription;
    }
}
