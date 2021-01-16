/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Licencas;


import ConexaoBanco.ConnectBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ti
 */
public class LicencaDAO {
    
    public void Addlicenca(LicencaDados dados) throws SQLException {

        String sql = "insert into licenca(nome,acesso) values(?,?);";

        try (Connection conn = ConnectBd.obterConexao()) {
            
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, dados.getNome());
                stmt.setString(3, dados.getAcesso());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        }
    }
    
       public void AddPcLicenca(LicencaDados dados) throws SQLException {

        String sql1 = "insert into licenca(nome,acesso) values(?,?);";
        String sql2 = "insert into computador(nome_computador,processador,placadevideo,ram,numeroanydesk,senhaanydesk) values(?,?,?,?,?,?)";


        try (Connection conn = ConnectBd.obterConexao()) {
            
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql1)) {
                stmt.setString(1, dados.getNome());
                stmt.setString(2, dados.getAcesso());
                stmt.executeUpdate();

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        }
        
        try (Connection conn = ConnectBd.obterConexao()) {
            
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql2)) {
                stmt.setString(1, dados.getNomePc());
                stmt.setString(2, dados.getCpu());
                stmt.setString(3, dados.getGpu());
                stmt.setInt(4, dados.getRam());
                stmt.setInt(5, dados.getNumeroAnyDesk());
                stmt.setString(6, dados.getSenhaAnyDesk());
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
