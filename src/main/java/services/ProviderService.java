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

import entities.JobDescription;

@Named
@ApplicationScoped
public class ProviderService {
    
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager entityManager;

    @Transactional
    public void createJob(JobDescription jobDescription) {
        entityManager.persist(jobDescription);
    }

    public List<JobDescription> getAllJobDescriptions() {
        return entityManager.createQuery("SELECT j FROM JobDescription j", JobDescription.class).getResultList();
    }

    @Transactional
    public void removeJob(JobDescription jobDescription) {
        entityManager.remove(jobDescription);
    }

    @Transactional
    public void acceptFreelancer(JobDescription jobDescription) {
        // Implement logic to accept a freelancer for the job
        // This may involve updating the job status, assigning the job to the freelancer, etc.
    }
}
