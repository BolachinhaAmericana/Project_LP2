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
public class Passageiro extends Veiculo {
    
    private String matricula;
    private int numeroMaximoPassageiros;

    public Passageiro(String nome, String cor, int numeroApolice, int diasNaEmpresa, double consumoMedio, String matricula, int numeroMaximoPassageiros) {
        super(nome, cor, numeroApolice, diasNaEmpresa, consumoMedio);
        if (matricula == null) {
            throw new IllegalArgumentException("Erro no Argumento");
        }
        this.matricula = matricula;
        this.numeroMaximoPassageiros = numeroMaximoPassageiros;
    }

    @Override
    public boolean adicionarViagem(double quilometrosPercorridos, int passageiros, double cargaTransportada) {
        if (passageiros >= numeroMaximoPassageiros) {
            return false;
        }
        this.totalDeViagens += 1;
        this.totalQuilometrosPercorridos += quilometrosPercorridos;
        double consumoMedioDaViagem = consumoMedio + passageiros * 0.2;
        this.totalDeConsumo += consumoMedioDaViagem * quilometrosPercorridos / 100; //por cada 100 Km
        return true;
    }
    
    
    @Override
    public String toString() {
        String info = "\n";
        info += "\n Mercadoria: " + super.toString();
        info += "\n Numero Maximo Passageiros: " + this.numeroMaximoPassageiros;
        info += "\n Matricula: " + matricula;
        return info + "\n";
    }

}
