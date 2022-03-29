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
public class Mercadoria extends Veiculo {

    private String matricula;
    private double cargaMaxima;

    public Mercadoria(String nome, String cor, int numeroApolice, int diasNaEmpresa, double consumoMedio, String matricula, double cargaMaxima) {
        super(nome, cor, numeroApolice, diasNaEmpresa, consumoMedio);
        if (matricula == null) {
            throw new IllegalArgumentException("Erro no Argumento");
        }
        this.cargaMaxima = cargaMaxima;
        this.matricula = matricula;

    }

    @Override
    public boolean adicionarViagem(double quilometrosPercorridos, int pessageiros, double cargaTransportada) {
        if (cargaTransportada >= cargaMaxima) {
            return false;
        }
        this.totalDeViagens += 1;
        totalQuilometrosPercorridos += quilometrosPercorridos;
        double consumoMedioDaViagem = consumoMedio + (cargaTransportada / 40) * 0.1;
        this.totalDeConsumo += consumoMedioDaViagem * quilometrosPercorridos / 100;
        return true;
    }

    @Override
    public String toString() {
        String info = "\n";
        info += "\n Mercadoria: " + super.toString();
        info += "\n Carga Maxima: " + this.cargaMaxima;
        info += "\n Matricula: " + matricula;
        return info + "\n";
    }


}
