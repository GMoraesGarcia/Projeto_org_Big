/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

/**
 *
 * @author Ti
 */
public class LoginDados {
    private String nomeUsuario;
    
    private String senha;
    
    private String tipo;

    public LoginDados(String nomeUsuario, String senha, String tipo) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.tipo = tipo;
    }

    public LoginDados() {
    }

    
    
    
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    
    
    
}
