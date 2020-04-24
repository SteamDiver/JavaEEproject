package ru.vsu.demo.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/demo";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASS = "postgres";

    private static EntityManager instance;

    public static EntityManager getInstance() {
        if (instance == null) {
            instance = new EntityManager();
        }
        return instance;
    }

    private EntityManager() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public <R> List<R> executeQuery(String query, Mapper<R> mapper) {
        try (
                Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS);
                Statement statement = connection.createStatement();
            ) {
            ResultSet resultSet = statement.executeQuery(query);
            List<R> items = new ArrayList<>();
            while (resultSet.next()) {
                R item = mapper.map(resultSet);
                items.add(item);
            }
            return items;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
