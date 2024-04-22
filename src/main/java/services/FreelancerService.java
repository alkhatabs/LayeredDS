/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author albusaidi
 */

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import entities.Freelancer;
import entities.JobDescription;

@Named
@ApplicationScoped
public class FreelancerService {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager entityManager;

    @Transactional
    public void createFreelancer(Freelancer freelancer) {
        entityManager.persist(freelancer);
    }

    public List<Freelancer> getAllFreelancers() {
        return entityManager.createQuery("SELECT f FROM Freelancer f", Freelancer.class).getResultList();
    }

    public Freelancer getFreelancerById(long id) {
        return entityManager.find(Freelancer.class, id);
    }

    @Transactional
    public void updateFreelancer(Freelancer freelancer) {
        entityManager.merge(freelancer);
    }

    @Transactional
    public void deleteFreelancer(Freelancer freelancer) {
        entityManager.remove(entityManager.contains(freelancer) ? freelancer : entityManager.merge(freelancer));
    }
    
    public List<JobDescription> getAllOpenJobOffers() {
        return entityManager.createQuery("SELECT j FROM JobDescription j WHERE j.open = true", JobDescription.class).getResultList();
    }

    public List<JobDescription> searchJobOffersByKeyword(String searchKeyword) {
        return entityManager.createQuery("SELECT j FROM JobDescription j WHERE j.keywords LIKE :searchKeyword AND j.open = true", JobDescription.class)
                             .setParameter("searchKeyword", "%" + searchKeyword + "%")
                             .getResultList();
    }

    public JobDescription getJobOfferById(long jobId) {
        return entityManager.find(JobDescription.class, jobId);
    }

    @Transactional
    public String offerToUndertakeJob(Freelancer freelancer, JobDescription jobDescription) {
        if (!jobDescription.isOpen()) {
            throw new IllegalStateException("Job is already taken");
        }
        jobDescription.setOpen(false);
        jobDescription.setAssignedFreelancer(freelancer);
        entityManager.merge(jobDescription);
        return "jobOffered";
    }

    @Transactional
    public void revokeOffer(Freelancer freelancer, JobDescription jobDescription) {
        if (!jobDescription.isOpen() && jobDescription.getAssignedFreelancer() != null && jobDescription.getAssignedFreelancer().equals(freelancer)) {
            jobDescription.setOpen(true);
            jobDescription.setAssignedFreelancer(null);
        }
    }

    @Transactional
    public void updateFreelancerProfile(Freelancer freelancer) {
        entityManager.merge(freelancer);
    }

    public double getPaymentAmount(Freelancer freelancer) {
        List<JobDescription> completedJobs = entityManager.createQuery("SELECT j FROM JobDescription j WHERE j.assignedFreelancer = :freelancer AND j.open = false", JobDescription.class)
                                                         .setParameter("freelancer", freelancer)
                                                         .getResultList();
        double totalPayment = 0.0;
        for (JobDescription job : completedJobs) {
            totalPayment += job.getPaymentOffer();
        }
        return totalPayment;
    }

    // Add more methods as needed for additional business logic
}
