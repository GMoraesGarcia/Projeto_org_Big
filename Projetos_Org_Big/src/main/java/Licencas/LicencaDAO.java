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

        String sql1 = "insert into licenca(nome,acesso,data_cadastro) values(?,?,sysdate());";
        String sql2 = "insert into computador(nome_computador,processador,placadevideo,ram,numeroanydesk,senhaanydesk) values(?,?,?,?,?,?)";
        String sql3 = "call sp_addLicencaPorComputador(?)";

        //Realiza o cadastro da licença
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

        //Realiza o cadastro do computador
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

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        }
        try (Connection conn = ConnectBd.obterConexao()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql3)) {
                stmt.setString(1, dados.getNomePc());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");
                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        }

    }
    
    public void addLicenca (String pc, String chave) throws SQLException {
        String sql = "call sp_addLicencaPorComputador(?,?)";
       
        
     try (Connection conn = ConnectBd.obterConexao()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, pc);
                stmt.setString(2, chave);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Licença adicionada a máquina "+ pc+" com sucesso!!");
                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        }
    }
    
    public void addLi(LicencaDados dados) throws SQLException{
       String sql1 = "insert into licenca(nome,acesso,data_cadastro) values(?,?,sysdate());";
       String nomeLicenca = dados.getNomeLicenca(dados.getAcesso()) ;
       
        try (Connection conn = ConnectBd.obterConexao()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql1)) {
                stmt.setString(1, nomeLicenca);
                stmt.setString(2, dados.getAcesso());
                stmt.executeUpdate();

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        }
    }
    
    public void alter_PcLicenca(String nomePc, String codAcesso) throws SQLException{
        String sql = "update licencaPorComputador set id_pc = (select id_pc from computador where nome_computador = ? ) where id_licenca = (select id from licenca where acesso = ?)";
          try (Connection conn = ConnectBd.obterConexao()) {

            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nomePc);
                stmt.setString(2, codAcesso);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Troca realizada com ");
                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        }
    
    }

}
