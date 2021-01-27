package Usuarios;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class UsuarioDados {

    private String nome;

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

    public String getNomeComputador() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        String hostname = addr.getHostName();

        return hostname;
    }

}
