package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistroApp {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_datos";
    private static final String USER = "root"; //cambia segun tu configuracion!
    private static final String PASSWORD = "Tapiero123";

    public static void main(String[] args) {
        JFrame frame = new JFrame("REGISTRO DE DATOS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
    }   

}