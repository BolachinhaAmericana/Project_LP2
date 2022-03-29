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
public class Bicicletas extends Veiculo {

    private double autonomia;
    private boolean miniAtrelado;
    private int totalDeCarregamentos = 0;

    public Bicicletas(String nome, String cor, int numeroApolice, int diasNaEmpresa, double consumoMedio, double autonomia, int miniAtrelado) {
        super(nome, cor, numeroApolice, diasNaEmpresa, consumoMedio);
        if (0 < miniAtrelado || miniAtrelado > 1) {
            throw new IllegalArgumentException("Erro no Argumento");
        }

        this.autonomia = autonomia;
        if(miniAtrelado == 1){
            this.miniAtrelado = true;
        }
        else if(miniAtrelado == 0){
            this.miniAtrelado = false;
        }
        
    }
   
    @Override
    public boolean adicionarViagem(double quilometrosPercorridos, int pessageiros, double cargaTransportada) {
        totalDeViagens += 1;
        this.totalQuilometrosPercorridos += quilometrosPercorridos;
        totalDeConsumo = consumoMedio * quilometrosPercorridos;//por km  
        totalDeCarregamentos = (int) (totalDeConsumo / autonomia); //Quantos vezes teve de carregar durante a viagem
        return true;
    }

    
    @Override
    public String toString() {
        String info = "\n";
        info += "\n Bicicleta: " + super.toString();
        info += "\n Autonomia da Bateria: " + autonomia + " Km";
        info += "\n Teve de carregar durante as viagems : " + totalDeCarregamentos + " vezes";
        info += "\n Tem um mini atrelado?: " + miniAtrelado;
        return info + "\n";
    }
}
