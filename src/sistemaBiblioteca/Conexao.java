/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaBiblioteca;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author marci
 */

public class Conexao {
     private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca3";
    private static final String USER = "root";
    private static final String PASS = "senac";
    
    // Método de conexão com o banco de dados
    public static Connection conexaoBanco() {
        Connection con = null;
        
        try {
            // Registra o driver JDBC
            Class.forName(DRIVER);
            
            // Estabelece a conexão com o banco de dados
            con = DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException ex) {
            // Tratar erro de não encontrar a classe do driver
            JOptionPane.showMessageDialog(null, "Erro ao carregar o driver JDBC: " + ex.getMessage(), "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (SQLException ex) {
            // Tratar erro de conexão com o banco de dados
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados: " + ex.getMessage(), "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        
        return con;  // Retorna a conexão (null se houve erro)
    }
}
