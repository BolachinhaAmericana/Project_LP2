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
public interface InterfaceVeiculo {
    // Devolve true se viagem adicionado com succeso senão false
    public boolean adicionarViagem(double quilometrosPercorridos, int pessageiros, double cargaTransportada);
    // Devolve true se veiculo tem empregado associado (!= null) senão false
    public boolean estaDisponivel();
}
