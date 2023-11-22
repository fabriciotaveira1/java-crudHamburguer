/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAO {

    Connection con; 
    PreparedStatement pst; 
    ResultSet rs; 

    public void abrirBanco() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/crudJava";
            String user = "root";
            String password = "";
            con = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Conecção realizada com sucesso");
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe não encontraada, adicione o drive a biblioteca ");
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {//tratamento de erro de SQL
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public void fecharBanco() throws Exception {
        if (pst != null) {
            pst.close();
            System.out.println("Execução query fechada\n");
        }
    }
}
