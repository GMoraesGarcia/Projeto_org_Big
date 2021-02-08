/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import ConexaoBanco.ConnectBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ti
 */
public class LoginDAO {
    
    public boolean getUsuario(LoginDados loginDados) throws SQLException{
        String sql = "select * from login where nome_usuario = ? and senha = ?";
        
         try (Connection conn = ConnectBd.obterConexao(); // abre e fecha a conexão
                PreparedStatement stmt = conn.prepareStatement(sql);) {
             
             stmt.setString(1, loginDados.getNomeUsuario());
             stmt.setString(2, loginDados.getSenha());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return true;         
                }
            }
        }
         return false;
  
    }
    
    public boolean getUsuarioPc (String nome, String sobrenome) throws SQLException{
        String sql = ("select * from usuarios where nome = ? and sobreNome = ?");
        
          try (Connection conn = ConnectBd.obterConexao(); // abre e fecha a conexão
                PreparedStatement stmt = conn.prepareStatement(sql);) {
             
             stmt.setString(1, nome);
             stmt.setString(2, sobrenome);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return true;         
                }
            }
        }
         return false;
    
    }
    
    public void addLogin (LoginDados login) throws SQLException{
        String sql = "insert into login (nome_usuario,senha,tipo,data_cadastro) values (?,?,?,sysdate())";
        
         try (Connection conn = ConnectBd.obterConexao(); // abre e fecha a conexão
                PreparedStatement stmt = conn.prepareStatement(sql);) {
             stmt.setString(1,login.getNomeUsuario());
             stmt.setString(2, login.getSenha());
             stmt.setString(3, login.getTipo());
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
             
             stmt.execute();
              conn.commit();
             
         }
         catch(SQLException e){
             System.out.println(e);
         }
    }
    
}
