/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Licencas;

import Computador.DadosPc;

/**
 *
 * @author Ti
 */
public class LicencaDados extends DadosPc {
    private String nome;
    
    private String tipo;
    
    private String acesso;
    
    public LicencaDados(String nome,String tipo,String acesso,String nomePc,String cpu, String gpu, int ram, int numeroanyDesk, String senhaAnyDesk){
        super(nomePc,cpu,gpu,ram,numeroanyDesk,senhaAnyDesk);
        this.nome = nome;
        this.tipo = tipo;  
        this.acesso = acesso;
    }
    
    public LicencaDados(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }
    
    

  
    
    
    
    
    
}
