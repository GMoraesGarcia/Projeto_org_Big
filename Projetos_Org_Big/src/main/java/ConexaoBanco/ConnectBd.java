/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ti
 */
public class ConnectBd {
     public static Connection obterConexao() throws SQLException {
        // 1) Declarar o driver JDBC de acordo com o Banco de dados usado
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
        
        // 2) Abrir a conexão
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.15.254:3306/dbBig?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC",
                "Gabriel", // Usuário de conexão no BD
                "Pontanegra123"); // Senha
        return conn ;
    }
}
