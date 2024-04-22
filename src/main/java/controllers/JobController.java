/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author albusaidi
 */

import entities.JobDescription;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import services.JobDescriptionService;

import java.util.List;

@Named(value = "jobController")
@RequestScoped
public class JobController {

    @Inject
    private JobDescriptionService jobDescriptionService;

    private String title;
    private String keywords;
    private String description;
    private double paymentOffer;

    private List<JobDescription> jobList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPaymentOffer() {
        return paymentOffer;
    }

    public void setPaymentOffer(double paymentOffer) {
        this.paymentOffer = paymentOffer;
    }

    public List<JobDescription> getJobList() {
        return jobList;
    }

    public void setJobList(List<JobDescription> jobList) {
        this.jobList = jobList;
    }

    public void createJob() {
        JobDescription jobDescription = new JobDescription(title, keywords, description, paymentOffer);
        jobDescriptionService.createJobDescription(jobDescription);
        this.jobList = jobDescriptionService.getAllJobDescriptions();
    }

    // You can add more methods as needed
}
