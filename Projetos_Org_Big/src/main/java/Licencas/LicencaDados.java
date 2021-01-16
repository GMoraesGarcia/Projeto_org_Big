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
    
    
    private String acesso;
    
    public LicencaDados(String nome,String acesso,String nomePc,String cpu, String gpu, int ram, int numeroanyDesk, String senhaAnyDesk){
        super(nomePc,cpu,gpu,ram,numeroanyDesk,senhaAnyDesk);
        this.nome = nome;
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

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }
    
    

  public String getNomeLicenca(String acesso){
      if(acesso.length() == 19)
          return "Redshift";
      else if(acesso.length() == 11)
          return "Nuke";
      else if (acesso.length() == 17)
          return "Deltagen";
     else 
      return "-1";
      
  }
    
    
    
    
    
}
