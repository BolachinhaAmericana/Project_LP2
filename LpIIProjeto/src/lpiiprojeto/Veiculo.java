/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpiiprojeto;
/**
 *
 * @author Guilherme Silva 202000178 && Duarte Valente 202000053
 */
//Ver se da para usar super() com interface de configuracao ja que come o construtor 
public abstract class Veiculo implements InterfaceVeiculo {
    private String nome;
    private String cor;
    private int numeroApolice;
    private int diasNaEmpresa;
    protected double consumoMedio;
    protected double totalQuilometrosPercorridos = 0.0; //acumula em cada viagem
    protected double totalDeConsumo = 0.0; //acumula em cada viagem
    protected double totalDeViagens = 0.0;    
    Empregado empregado = null;

    
    public Veiculo(String nome, String cor, int numeroApolice, int diasNaEmpresa, double consumoMedio) {
        if(nome == null || numeroApolice < 0 || diasNaEmpresa < 0 || consumoMedio < 0){
           throw new IllegalArgumentException("Erro no Argumento");
        }
        this.nome = nome;
        this.cor = cor;
        this.numeroApolice = numeroApolice;
        this.diasNaEmpresa = diasNaEmpresa;
        this.consumoMedio = consumoMedio;
    }

  
    @Override
    public boolean estaDisponivel(){
       return empregado == null; //se for verdadeiro esta disponivel
    }
   
    
    @Override
    public abstract boolean adicionarViagem(double quilometrosPercorridos, int pessageiros, double cargaTransportada);
    
    

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setcor(String cor) {
        this.cor = cor;
    }
    
    public void setnumeroApolice(int numeroApolice) {
        this.numeroApolice = numeroApolice;
    }
    
    public void setDiasNaEmpresa(int diasNaEmpresa) {
        this.diasNaEmpresa = diasNaEmpresa;
    }

    public void setTotalQuilometrosPercorridos(double totalQuilometrosPercorridos) {
        this.totalQuilometrosPercorridos = totalQuilometrosPercorridos;
    }

    public void setConsumoMedio(double ConsumoMedio) {
        this.consumoMedio = ConsumoMedio;
    }

    public void setTotalDeViagens(double totalDeViagens) {
        this.totalDeViagens = totalDeViagens;
    }

    public void setTotalDeConsumo(double totalDeConsumo) {
        this.totalDeConsumo = totalDeConsumo;
    }
    
    public String getNome() {
        return nome;
    }

    public String getcor() {
        return cor;
    }
    
    public int getnumeroApolice() {
        return numeroApolice;
    }    
    
    public int getDiasNaEmpresa(){
        return diasNaEmpresa;
    }

    public double getTotalQuilometrosPercorridos() {
        return totalQuilometrosPercorridos;
    }
   
    public double getConsumoMedio() {
        return consumoMedio;
    }
 
    public double getTotalDeViagens() {
        return totalDeViagens;
    }

    public double getTotalDeConsumo() {
        return totalDeConsumo;
    }
      
    
    @Override
    public String toString() {
        String info = "\n";
        info = info + " Nome: " + nome+"\n";
        info = info + " Cor: " + cor+"\n";
        info = info + " Numero da Apolice: " + numeroApolice+"\n";
        info = info + " Dias Na Empresa: " + diasNaEmpresa+"\n";
        info = info + " Total de Viagens: " +totalDeViagens+"\n";
        info = info + " Total de Quilometros Percorridos: " +totalQuilometrosPercorridos+"\n";
        info = info + " Total de Consumo: " +totalDeConsumo+"\n";
        if(empregado == null){
            return info+"\n";
        }
        info = info + " Empregado: " +empregado.getNome()+"\n";
        return info;      
    }
    
}
