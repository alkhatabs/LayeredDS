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
import entities.JobDescription;
import services.FreelancerService;

import java.util.List;

@Named(value = "freelancerController")
@RequestScoped
public class FreelancerController {
    
    @Inject
    private FreelancerService freelancerService;

    private String keyword;
    private long jobId;
    private Freelancer freelancer;
    private JobDescription selectedJob;

    public List<JobDescription> browseJobOffers() {
        return freelancerService.getAllOpenJobOffers();
    }

    public List<JobDescription> searchByKeyword() {
        return freelancerService.searchJobOffersByKeyword(keyword);
    }

    public JobDescription searchById() {
        return freelancerService.getJobOfferById(jobId);
    }

    public String offerToUndertakeJob(JobDescription jobDescription) {
        String result = freelancerService.offerToUndertakeJob(freelancer, jobDescription);
        if ("jobOffered".equals(result)) {
            return "jobOffered"; // Example navigation case
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_ERROR,
                "Offer Failed",
                "The job offer could not be made."
            ));
            return null;
        }
    }

    public void revokeOffer(JobDescription jobDescription) {
        freelancerService.revokeOffer(freelancer, jobDescription);
    }

    public void editProfile() {
        freelancerService.updateFreelancerProfile(freelancer);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
            "Success", "Profile updated successfully."
        ));
    }

    public double getPaymentAmount() {
        return freelancerService.getPaymentAmount(freelancer);
    }

    // Getter and setter methods
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public Freelancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    public JobDescription getSelectedJob() {
        return selectedJob;
    }

    public void setSelectedJob(JobDescription selectedJob) {
        this.selectedJob = selectedJob;
    }
}
