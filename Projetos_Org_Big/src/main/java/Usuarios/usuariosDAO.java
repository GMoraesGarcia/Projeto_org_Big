/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.sql.Connection;
import ConexaoBanco.*;

/**
 *
 * @author Ti
 */
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class usuariosDAO {
    
    public void addUser(UsuarioDados user) throws SQLException{
        String sql = "insert into usuarios (nome,sobreNome,funcao,data_cadastr) values(?,?,?,sysdate())";
          try (Connection conn = ConnectBd.obterConexao()) {
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERACOES EM CASOS DE ERROS
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, user.getNome());
                stmt.setString(2, user.getSobreNome());
                stmt.setString(3, user.getFuncao());
               
                stmt.executeUpdate();
               

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        }
        
        
    }
    
    public void addUserPorPc(String nome, String sobreNome,String pc, String funcao) throws SQLException{
        String sql = "call sp_adComputadorPorUsuario(?,?,?,?);";
         try (Connection conn = ConnectBd.obterConexao()) {
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERACOES EM CASOS DE ERROS
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, pc);
                stmt.setString(2, nome);
                stmt.setString(3, sobreNome);
                stmt.setString(4, funcao);
               
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");

                conn.commit();

            } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, e);
                throw e;
            }

        }
    }
    
}
