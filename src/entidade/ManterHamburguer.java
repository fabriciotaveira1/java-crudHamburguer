/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import controle.hamburguer;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;


public class ManterHamburguer extends DAO {

    public void insert(hamburguer h) throws Exception {
        try {
            abrirBanco();
            String query = "INSERT INTO hamburguer(codigo,nome,valor) " + "values(null,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, h.getNome());
            pst.setInt(2, h.getValor());
            pst.execute();
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    //listando 
            public ArrayList<hamburguer> PesquisarTudo () throws Exception {
       ArrayList<hamburguer> hamburguers = new ArrayList<hamburguer>();
         try{
         abrirBanco();  
         String query = "select codigo, nome FROM hamburguer";
         pst = (PreparedStatement) con.prepareStatement(query);
         ResultSet tr = pst.executeQuery();
         hamburguer h ;
         while (tr.next()){               
           h = new hamburguer();
           h.setCodigo(tr.getInt("codigo"));
           h.setNome(tr.getString("nome"));
           hamburguers.add(h);
         } 
         fecharBanco();
       }catch (Exception e){
           System.out.println("Error " + e.getMessage());
     } 
       return hamburguers;
     }
            
  public void PesquisarHamburguer(hamburguer h) throws Exception {
        try {
            abrirBanco();
            String query = "select * FROM hamburguer where codigo=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, h.getCodigo());
            ResultSet tr = pst.executeQuery();
            if (tr.next()) {
                h.setCodigo(tr.getInt("codigo"));
                h.setNome(tr.getString("nome"));
                h.setValor(tr.getInt("valor"));
            } else {
              //  JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado! ");
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }    
  
  public void alterarHamburguer(hamburguer h) throws Exception {
        abrirBanco();
        //JOptionPane.showMessageDialog(null, a.getNome()+ a.getEmail() + a.getIdade());
        String query = "UPDATE hamburguer set nome = ?,valor = ? where codigo=?";
        pst = (PreparedStatement) con.prepareStatement(query);
        pst.setString(1, h.getNome());
        pst.setInt(2, h.getValor());
        pst.setInt(3, h.getCodigo());
        pst.executeUpdate();
        fecharBanco();
    }
  
  public void deletarHamburguer(hamburguer h) throws Exception{
      abrirBanco();
      String query = "DELETE FROM hamburguer where codigo=?";
      pst = (PreparedStatement) con.prepareStatement(query);
      pst.setInt(1, h.getCodigo());
      pst.executeUpdate();
      fecharBanco();
  }
}
