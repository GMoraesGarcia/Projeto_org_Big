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
        String sql = "insert into usuarios (nome, data_cadastr) values (?,sysdate());";
          try (Connection conn = ConnectBd.obterConexao()) {
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERACOES EM CASOS DE ERROS
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, user.getNome());
               
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        }
        
        
    }
    
}
