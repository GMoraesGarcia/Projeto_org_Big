/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrgArquivos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Ti
 */
public class ArquivoDados {
    private int numCadastro;
    
    private String nomeArq;

    private String caminhoOriginal;
    
    private String caminhoFinal;
    
    private String descricao;

    private LocalDate dataBackup;
    
    private int status;
    
    public ArquivoDados(int numCadastro, String nomeArq, String caminhoOriginal, String caminhoFinal, String descricao, LocalDate dataBackup, int status) {
        this.numCadastro = numCadastro;
        this.nomeArq = nomeArq;
        this.caminhoOriginal = caminhoOriginal;
        this.caminhoFinal = caminhoFinal;
        this.descricao = descricao;
        this.dataBackup = dataBackup;
        this.status = status;
    }

    public ArquivoDados() {
    }

    
    
    
    public String getNomeArq() { 
        return nomeArq;
    }

    public void setNomeArq(String nomeArq) {
        this.nomeArq = nomeArq;
    }

    public String getCaminhoOriginal() {
        return caminhoOriginal;
    }

    public void setCaminhoOriginal(String caminhoOriginal) {
        this.caminhoOriginal = caminhoOriginal;
    }

    public String getCaminhoFinal() {
        return caminhoFinal;
    }

    public void setCaminhoFinal(String caminhoFinal) {
        this.caminhoFinal = caminhoFinal;
    }

    public String getDescrocao() {
        return descricao;
    }

    public void setDescrocao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataBackup() {
        return dataBackup;
    }

    public void setDataBackup(LocalDate dataBackup) {
        this.dataBackup = dataBackup;
    }

    public int getNumCadastro() {
        return numCadastro;
    }

    public void setNumCadastro(int numCadastro) {
        this.numCadastro = numCadastro;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    
   

    /*public String dataFormatada (LocalDate data){
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       
       return String.valueOf(data.format(formatter));*/

    @Override
    public String toString() {
        return "ArquivoDados{" + "numCadastro=" + numCadastro + ", nomeArq=" + nomeArq + ", caminhoOriginal=" + caminhoOriginal + ", caminhoFinal=" + caminhoFinal + ", descricao=" + descricao + ", dataBackup=" + dataBackup + '}';
    }

   }
    
    
    
    
    
    
    
    
