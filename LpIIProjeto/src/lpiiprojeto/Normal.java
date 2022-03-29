/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpiiprojeto;

import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author Guilherme Silva 202000178 && Duarte Valente 202000053
 */
public class Normal extends Empregado {
        public Normal(String nome, int codigo, int ano, int mes, int dia) {
            super(nome,codigo,ano,mes,dia);
    }

    @Override //Não é nessesário efetura nenhuma opração pois o salário do Normal não têm bonus
    public double obterSalarioEspecifico(double salarioBase, double valorPorQuilometro, double PercentagemVendas) {
        return 0;
    }


}
