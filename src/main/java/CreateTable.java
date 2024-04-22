/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author albusaidi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:1527/sample";
        String username = "app";
        String password = "app";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();

            // Create JobDescriptions table
            String createJobDescriptionsTable = "CREATE TABLE IF NOT EXISTS job_descriptions (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "title VARCHAR(255) NOT NULL," +
                    "keywords VARCHAR(255)," +
                    "description TEXT," +
                    "paymentOffer DOUBLE NOT NULL," +
                    "open BOOLEAN NOT NULL DEFAULT TRUE," +
                    "assignedFreelancer_id INT," +
                    "FOREIGN KEY (assignedFreelancer_id) REFERENCES freelancers(id)" +
                    ")";
            statement.executeUpdate(createJobDescriptionsTable);

            // Create Freelancers table
            String createFreelancersTable = "CREATE TABLE IF NOT EXISTS freelancers (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL," +
                    "skills TEXT," +
                    "message TEXT" +
                    ")";
            statement.executeUpdate(createFreelancersTable);

            // Create Providers table
            String createProvidersTable = "CREATE TABLE IF NOT EXISTS providers (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "password VARCHAR(255) NOT NULL" +
                    ")";
            statement.executeUpdate(createProvidersTable);

            // Create Administrators table
            String createAdministratorsTable = "CREATE TABLE IF NOT EXISTS administrators (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "username VARCHAR(255) NOT NULL," +
                    "password VARCHAR(255) NOT NULL" +
                    ")";
            statement.executeUpdate(createAdministratorsTable);

            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

