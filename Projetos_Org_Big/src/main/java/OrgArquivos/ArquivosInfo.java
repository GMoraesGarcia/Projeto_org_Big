/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrgArquivos;

import Computador.DadosPc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Ti
 */
public class ArquivosInfo {
    
    private ArrayList<ArquivoDados> arrayArq;
    
    public ArquivosInfo(String file) {
        arrayArq = new ArrayList<>();
        
        try {
            BufferedReader r = new BufferedReader(new FileReader(file));
            if (r != null) {
                String linha = r.readLine();
                int q = Integer.parseInt(linha);
                String v[] = new String[q];
                for (int i = 0; i < q; i++) {
                    linha = r.readLine();
                    v = linha.split("#");

                   ArquivoDados dados = new ArquivoDados(Integer.parseInt(v[0]),v[1], v[2], v[3], v[4], LocalDate.parse(v[5]),Integer.parseInt(v[6]));
                    addDadposArquivo(dados);
                }
                r.close();
            }
        } catch (Exception e) {
            // System.exit(-1);
            System.out.println(e);

        }
    }
    
    public void addDadposArquivo(ArquivoDados dados) {
        arrayArq.add(dados);
        
    }
    
    public ArrayList<ArquivoDados>getInfoArquivos(){
        ArrayList<ArquivoDados> arraysPermi = new ArrayList<>();
        for(ArquivoDados dados: arrayArq)
            if(dados.getStatus() == 1)
                arraysPermi.add(dados);
        
        
        return arraysPermi;
    }
    
    public int getQtdDadosArqInfo (){
        int i = 0;
        for(ArquivoDados arq : arrayArq)
            i++;
        
    return i;
    }
    
    public void dump(String file) {
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter(file));
            w.write(String.valueOf(getQtdDadosArqInfo()));
            w.newLine();
            for (ArquivoDados a : arrayArq) {
                w.write(a.getNumCadastro() + "#");
                
                w.write(a.getNomeArq() + "#");
                
                w.write(a.getCaminhoOriginal() + "#");
                
                w.write(a.getCaminhoFinal() + "#");
                
                w.write(a.getDescrocao() + "#");
                
                w.write(a.getDataBackup()+"#");
                
                w.write(a.getStatus() + "");
                
                w.newLine();
                
            }
            w.flush();
            w.close();
            
        } catch (Exception e) {
            System.exit(-1);
            
        }
        
    }
    public ArquivoDados getFromNum(int num_agend){
     
      for(ArquivoDados dados: arrayArq)
          if(dados.getNumCadastro() == num_agend)
              return dados;
      
      
      return null;
    
    }
    
    public void deleteInfoArq(int num_agend){
        for(ArquivoDados dados: getInfoArquivos()){
            if(num_agend == dados.getNumCadastro())
               dados.setStatus(0);
            
        }
        dump("Dados.txt");
        JOptionPane.showMessageDialog(null, "Dado Deletado");
            
    }
    
    public boolean alterInfos(int numCadastro,String alter,String campo){
         ArquivoDados res = getFromNum(numCadastro);
    
         System.out.println(res.toString());
         
         
         System.out.println(numCadastro +" " + alter +" " + campo );
         if(res.getNumCadastro() == numCadastro && campo == "Descrição"){
                  System.out.println(numCadastro +" " + alter +" " + campo );
             res.setDescrocao(alter); 
              dump("Dados.txt");
         
              return true;
         }
   
         else if(res.getNumCadastro() == numCadastro && campo == "Caminho original"){
             res.setCaminhoOriginal(alter);
              dump("Dados.txt");
              return true;
         }
         
         else if(res.getNumCadastro() == numCadastro && campo == "Caminho final"){
             res.setCaminhoFinal(alter);
              dump("Dados.txt");
              return true;
         }
         else if(res.getNumCadastro() == numCadastro && campo == "Nome arquivo"){
             res.setNomeArq(alter);
              dump("Dados.txt");
              return true;
         }
         
        
         
        return false;
         
 
    }
    
   
    
   
}
