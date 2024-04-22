/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author albusaidi
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Freelancer;
import entities.JobProvider;
import entities.JobDescription;
public class AdministratorService {

    private final String url = "jdbc:mysql://localhost:1527/sample";
    private final String username = "app";
    private final String password = "app";

    public void registerFreelancer(Freelancer freelancer) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO freelancers (name, skills, message) VALUES (?, ?, ?)")) {
            statement.setString(1, freelancer.getName());
            statement.setString(2, freelancer.getSkills());
            statement.setString(3, freelancer.getMessage());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeFreelancer(long freelancerId) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM freelancers WHERE id = ?")) {
            statement.setLong(1, freelancerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registerJobProvider(JobProvider jobProvider) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO job_providers (name) VALUES (?)")) {
            statement.setString(1, jobProvider.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeJobProvider(long jobProviderId) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM job_providers WHERE id = ?")) {
            statement.setLong(1, jobProviderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addJob(JobDescription jobDescription) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO job_descriptions (title, keywords, description, paymentOffer) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, jobDescription.getTitle());
            statement.setString(2, jobDescription.getKeywords());
            statement.setString(3, jobDescription.getDescription());
            statement.setDouble(4, jobDescription.getPaymentOffer());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeJob(long jobId) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM job_descriptions WHERE id = ?")) {
            statement.setLong(1, jobId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
