
package Usuarios;


public class UsuarioDados {
    private String nome;
    
    private String telefone;
    
    private String email;
    
    private String funcao;

    public UsuarioDados(String nome, String telefone, String email, String funcao) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.funcao = funcao;
    }

    public UsuarioDados() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
  
}
