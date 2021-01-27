/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Computador;

import Computador.*;
import ConexaoBanco.ConnectBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Licencas.*;

/**
 *
 * @author Ti
 */
public class computadorDao {

    public void addComputador(DadosPc pc) throws SQLException {

        String sql = "insert into computador(nome_computador,processador,placadevideo,ram,numeroanydesk,senhaanydesk) values(?,?,?,?,?,?)";

        try (Connection conn = ConnectBd.obterConexao()) {
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERACOES EM CASOS DE ERROS
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, pc.getNomePc());
                stmt.setString(2, pc.getCpu());
                stmt.setString(3, pc.getGpu());
                stmt.setInt(4, pc.getRam());
                stmt.setInt(5, pc.getNumeroAnyDesk());
                stmt.setString(6, pc.getSenhaAnyDesk());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");

                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        }
    }
    
    public ArrayList<LicencaDados> find() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from  tbInfoPcLicenca ";
        ArrayList<LicencaDados> computador = new ArrayList<LicencaDados>();

        try {

            conn = ConnectBd.obterConexao(); // abre e fecha a conexão
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                LicencaDados pc = new LicencaDados();
                pc.setNomePc(rs.getString("nome_computador"));
                pc.setCpu(rs.getString("processador"));
                pc.setGpu(rs.getString("placaDeVideo"));
                pc.setRam(rs.getInt("ram"));
                pc.setNumeroAnyDesk(rs.getInt("numeroAnyDesk"));
                pc.setSenhaAnyDesk(rs.getString("senhaAnyDesk"));
                pc.setNome(rs.getString("nome"));
                pc.setAcesso(rs.getString("acesso"));
                
                computador.add(pc);

            }
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return computador;
    }

    public ArrayList<DadosPc> findComputer(String nomeComputador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT nome_computador,processador,placadevideo,ram,numeroanydesk,senhaanydesk FROM computador where nome_computador LIKE " + "'%" + nomeComputador + "%'";
        ArrayList<DadosPc> computador = new ArrayList<DadosPc>();

        try {

            conn = ConnectBd.obterConexao(); // abre e fecha a conexão
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                DadosPc pc = new DadosPc();
                pc.setNomePc(rs.getString("nome_computador"));
                pc.setCpu(rs.getString("processador"));
                pc.setGpu(rs.getString("placaDeVideo"));
                pc.setRam(rs.getInt("ram"));
                pc.setNumeroAnyDesk(rs.getInt("numeroAnyDesk"));
                pc.setSenhaAnyDesk(rs.getString("senhaAnyDesk"));
                computador.add(pc);

            }
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return computador;
    }

    public ArrayList<DadosPc> findComputerByCpu(String processador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT nome_computador,processador,placadevideo,ram,numeroanydesk,senhaanydesk FROM computador where Processador LIKE " + "'%" + processador + "%'";
        ArrayList<DadosPc> computador = new ArrayList<DadosPc>();

        try {

            conn = ConnectBd.obterConexao(); // abre e fecha a conexão
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                DadosPc pc = new DadosPc();
                pc.setNomePc(rs.getString("nome_computador"));
                pc.setCpu(rs.getString("processador"));
                pc.setGpu(rs.getString("placaDeVideo"));
                pc.setRam(rs.getInt("ram"));
                pc.setNumeroAnyDesk(rs.getInt("numeroAnyDesk"));
                pc.setSenhaAnyDesk(rs.getString("senhaAnyDesk"));
                computador.add(pc);

            }
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return computador;

    }

    public ArrayList<DadosPc> findComputerByGpu(String placaDeVideo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT nome_computador,processador,placadevideo,ram,numeroanydesk,senhaanydesk FROM computador where placadevideo LIKE " + "'%" + placaDeVideo + "%'";
        ArrayList<DadosPc> computador = new ArrayList<DadosPc>();

        try {

            conn = ConnectBd.obterConexao(); // abre e fecha a conexão
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                DadosPc pc = new DadosPc();
                pc.setNomePc(rs.getString("nome_computador"));
                pc.setCpu(rs.getString("processador"));
                pc.setGpu(rs.getString("placaDeVideo"));
                pc.setRam(rs.getInt("ram"));
                pc.setNumeroAnyDesk(rs.getInt("numeroAnyDesk"));
                pc.setSenhaAnyDesk(rs.getString("senhaAnyDesk"));
                computador.add(pc);

            }
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return computador;
    }

    public ArrayList<DadosPc> findComputerByRam(String ram) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT nome_computador,processador,placadevideo,ram,numeroanydesk,senhaanydesk FROM computador where ram LIKE " + "'%" + ram + "%'";
        ArrayList<DadosPc> computador = new ArrayList<DadosPc>();

        try {

            conn = ConnectBd.obterConexao(); // abre e fecha a conexão
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                DadosPc pc = new DadosPc();
                pc.setNomePc(rs.getString("nome_computador"));
                pc.setCpu(rs.getString("processador"));
                pc.setGpu(rs.getString("placaDeVideo"));
                pc.setRam(rs.getInt("ram"));
                pc.setNumeroAnyDesk(rs.getInt("numeroAnyDesk"));
                pc.setSenhaAnyDesk(rs.getString("senhaAnyDesk"));
                computador.add(pc);

            }
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return computador;
    }

    public ArrayList<DadosPc> findComputerByAnyDesk(String NumeroAnyDesk) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT nome_computador,processador,placadevideo,ram,numeroanydesk,senhaanydesk FROM computador where numeroanydesk LIKE " + "'%" + NumeroAnyDesk + "%'";
        ArrayList<DadosPc> computador = new ArrayList<DadosPc>();

        try {

            conn = ConnectBd.obterConexao(); // abre e fecha a conexão
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                DadosPc pc = new DadosPc();
                pc.setNomePc(rs.getString("nome_computador"));
                pc.setCpu(rs.getString("processador"));
                pc.setGpu(rs.getString("placaDeVideo"));
                pc.setRam(rs.getInt("ram"));
                pc.setNumeroAnyDesk(rs.getInt("numeroAnyDesk"));
                pc.setSenhaAnyDesk(rs.getString("senhaAnyDesk"));
                computador.add(pc);

            }
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return computador;
    }
    
     public ArrayList<DadosPc> findComputerByAnyCpuAndGpu(String cpu, String gpu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT nome_computador,processador,placadevideo,ram,numeroanydesk,senhaanydesk FROM computador where processador LIKE " + "'%" + cpu + "%' and placadevideo LIKE " + "'%" + gpu + "%'";
        ArrayList<DadosPc> computador = new ArrayList<DadosPc>();

        try {

            conn = ConnectBd.obterConexao(); // abre e fecha a conexão
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                DadosPc pc = new DadosPc();
                pc.setNomePc(rs.getString("nome_computador"));
                pc.setCpu(rs.getString("processador"));
                pc.setGpu(rs.getString("placaDeVideo"));
                pc.setRam(rs.getInt("ram"));
                pc.setNumeroAnyDesk(rs.getInt("numeroAnyDesk"));
                pc.setSenhaAnyDesk(rs.getString("senhaAnyDesk"));
                computador.add(pc);

            }
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return computador;
    }
     
     public void Update(DadosPc pc) throws SQLException {
        String sql = "UPDATE computador set processador = ?, placadevideo=?,ram=?,numeroanydesk=?,senhaanydesk=? where nome_computador = ?;";
        try (Connection conn = ConnectBd.obterConexao()) {
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERACOES EM CASOS DE ERROS
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, pc.getCpu());
                stmt.setString(2, pc.getGpu());
                stmt.setString(3, String.valueOf(pc.getRam()));
                stmt.setString(4, String.valueOf(pc.getNumeroAnyDesk()));
                stmt.setString(5, String.valueOf(pc.getSenhaAnyDesk()));
                stmt.setString(6, pc.getNomePc());
               

                stmt.executeUpdate();
               JOptionPane.showMessageDialog(null, "Alterado com sucesso");
                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        }
    }
    
    
}
