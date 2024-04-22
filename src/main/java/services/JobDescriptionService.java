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

@Named(value = "jobDescriptionService")
@ApplicationScoped
public class JobDescriptionService {
    
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager entityManager;

    @Transactional
    public void createJobDescription(JobDescription jobDescription) {
        entityManager.persist(jobDescription);
    }

    public List<JobDescription> getAllJobDescriptions() {
        return entityManager.createQuery("SELECT j FROM JobDescription j", JobDescription.class).getResultList();
    }

    public JobDescription getJobDescriptionById(long id) {
        return entityManager.find(JobDescription.class, id);
    }

    @Transactional
    public void removeJobDescription(JobDescription jobDescription) {
        entityManager.remove(jobDescription);
    }

    // You can add more methods for updating and deleting job descriptions as needed
}
