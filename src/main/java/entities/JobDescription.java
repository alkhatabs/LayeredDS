/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author albusaidi
 */


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "job_descriptions")
public class JobDescription implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String title;
    private String keywords;
    private String description;
    private double paymentOffer;
    private boolean open; // Indicates whether the job is open or closed
    
    @ManyToOne
    private Freelancer assignedFreelancer; // Represents the freelancer assigned to the job
    
    // Constructors, getters, and setters
    public JobDescription() {
    }

    public JobDescription(String title, String keywords, String description, double paymentOffer) {
        this.title = title;
        this.keywords = keywords;
        this.description = description;
        this.paymentOffer = paymentOffer;
        this.open = true; // By default, a newly created job is open
    }

    // Getters and setters for attributes
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
    
    public Freelancer getAssignedFreelancer() {
        return assignedFreelancer;
    }

    public void setAssignedFreelancer(Freelancer freelancer) {
        this.assignedFreelancer = freelancer;
    }
    
    public boolean hasAssignedFreelancer() {
        return assignedFreelancer != null;
    }

    // Add more attributes, getters, and setters as needed
}
