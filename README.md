# -_ejemplo_de_programa_java_Insertar_Consultar_registros_mysql_- :.  

<img width="600" height="600" alt="image" src="https://github.com/user-attachments/assets/f0c7c61b-a604-41dc-b70c-40435cccfb6b" />  
  
# Ejemplo de Programa en Java para Insertar y Consultar Registros en MySQL:

Este documento describe cómo crear un programa en Java utilizando IntelliJ para insertar y consultar 
registros en una base de datos MySQL. 

Usaremos Swing para la interfaz gráfica y JDBC para la conexión a la base de datos.

## Configuración del Entorno
**Instalación de MySQL**:
   - Asegúrate de que MySQL esté en funcionamiento.

**Creación de la Base de Datos**:
   - Crea una base de datos, por ejemplo, `mi_base_datos`, y una tabla llamada `registros` con la siguiente estructura:

   ```sql
   CREATE DATABASE mi_base_datos;
   USE mi_base_datos;
   CREATE TABLE registros (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nombre VARCHAR(100),
       edad INT
   );
   
   <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.29</version> <!-- Asegúrate de usar la versión más reciente -->
   </dependency>

```

```

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
    private static final String USER = "tu_usuario"; // Cambia según tu configuración
    private static final String PASSWORD = "tu_contraseña"; // Cambia según tu configuración

    public static void main(String[] args) {
        JFrame frame = new JFrame("Registro de Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Nombre:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel edadLabel = new JLabel("Edad:");
        edadLabel.setBounds(10, 50, 80, 25);
        panel.add(edadLabel);

        JTextField edadText = new JTextField(20);
        edadText.setBounds(100, 50, 165, 25);
        panel.add(edadText);

        JButton insertButton = new JButton("Insertar");
        insertButton.setBounds(10, 80, 120, 25);
        panel.add(insertButton);

        JButton queryButton = new JButton("Consultar");
        queryButton.setBounds(150, 80, 120, 25);
        panel.add(queryButton);

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = userText.getText();
                int edad = Integer.parseInt(edadText.getText());
                insertRegistro(nombre, edad);
            }
        });

        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queryRegistros();
            }
        });
    }

    private static void insertRegistro(String nombre, int edad) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO registros (nombre, edad) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setInt(2, edad);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro insertado con éxito");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al insertar registro");
        }
    }

    private static void queryRegistros() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM registros";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder resultados = new StringBuilder();
            while (resultSet.next()) {
                resultados.append("ID: ").append(resultSet.getInt("id"))
                          .append(", Nombre: ").append(resultSet.getString("nombre"))
                          .append(", Edad: ").append(resultSet.getInt("edad"))
                          .append("\n");
            }
            JOptionPane.showMessageDialog(null, resultados.toString());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al consultar registros");
        }
    }
}

```

**Ejecucion del Programa: Abre IntelliJ y crea un nuevo proyecto Java.
Agrega el código anterior en la clase principal.
Asegúrate de que el conector de MySQL esté en tu classpath.**

**Ejecuta el programa.**
**Este formato es más legible y esta estructurado para facilitar la comprension.**
:. . / .     
