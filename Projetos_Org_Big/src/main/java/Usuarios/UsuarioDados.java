package Usuarios;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class UsuarioDados {

    private String nome;
    
    private String sobreNome;
    
    private String funcao;

    public UsuarioDados(String nome, String funcao) {
        this.nome = nome;

    }

    public UsuarioDados() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    

    public String getNomeComputador() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        String hostname = addr.getHostName();

        return hostname;
    }

}
