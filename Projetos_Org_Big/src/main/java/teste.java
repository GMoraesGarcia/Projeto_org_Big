/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ti
 */
public class teste {
    public static void main(String[] args) {
        String nomeComputador = "glitter";
        
                String sql = "SELECT nome_computador,processador,placadevideo,ram,numeroanydesk,senhaanydesk FROM computador where nome_computador LIKE " + "%'"+nomeComputador+ "'%";
        System.out.println(sql);
    }
    
}
