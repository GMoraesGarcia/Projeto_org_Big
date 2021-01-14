


package Computador;



public  class DadosPc {
    protected String nomePc;
    
    protected String cpu;
    
    protected String gpu;
    
    protected int ram;
    
    protected int numeroAnyDesk;
    
    protected String senhaAnyDesk;

    public DadosPc(String nomePc, String cpu, String gpu, int ram, int numeroAnyDesk, String senhaAnyDesk) {
        this.nomePc = nomePc;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.numeroAnyDesk = numeroAnyDesk;
        this.senhaAnyDesk = senhaAnyDesk;
    }
    
    public DadosPc(){
    }
    
    

    public String getNomePc() {
        return nomePc;
    }
   

    public void setNomePc(String nomePc) {
        this.nomePc = nomePc;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }
    
    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getNumeroAnyDesk() {
        return numeroAnyDesk;
    }

    public void setNumeroAnyDesk(int numeroAnyDesk) {
        this.numeroAnyDesk = numeroAnyDesk;
    }

    public String getSenhaAnyDesk() {
        return senhaAnyDesk;
    }

    public void setSenhaAnyDesk(String senhaAnyDesk) {
        this.senhaAnyDesk = senhaAnyDesk;
    }
    
    
    
}
