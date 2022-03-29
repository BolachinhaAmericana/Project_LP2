/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpiiprojeto;

import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author Guilherme Silva 202000178 && Duarte Valente 202000053
 */
/* 

Nesta classe vamos ter de somar o total de vendas para podermos tirar uma 
taxa, a maneira mais facil seria fazer so 1 produto constante tipo
1 venda = 10 paus
assim para olhar o numero de vendas conseguiamos ver o dinheiro que ele tinha 
feito e podiamos taxar uma % mais facilmente
 */
public class Comercial extends Empregado {

    private int numeroVendas; //1

    public Comercial(String nome, int codigo, int ano, int mes, int dia, int numeroVendas) {
        super(nome, codigo, ano, mes, dia);
        //falta tratamento de erro basico
        this.numeroVendas = numeroVendas;
    }

    public void setNumeroVendas(int numeroVendas) { //2
        //Falta if
        this.numeroVendas = numeroVendas;
    }

    public int getNumeroVendas() { //3
        //Falta if
        return this.numeroVendas;
    }

    @Override
    public double obterSalarioEspecifico(double salarioBase, double valorPorQuilometro, double PercentagemVendas) {
        double bonusComerial = numeroVendas * PercentagemVendas;
        return bonusComerial;
    }

    @Override
    public String toString() {
        String info = "\n";
        info += "\n Comercial: " + super.toString();
        info += "Numero de Vendas: " + numeroVendas;
        return info + "\n";
    }

}

//    public double obterSalarioAno(double salarioBase, double valorPorQuilometro, double PercentagemVendas) {
//        //Falta if
//        int diasDeTrabalhoAno = -1;
//
//        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
//        int anoEntrada = dataEntrada.getYear();
//        int anosTrabalhados = anoAtual - anoEntrada;
//        double bonusAntiquidade = 0.005 * anosTrabalhados;
//        double bonusAlimentacao = 4;
//        double bonusComerial = numeroVendas * PercentagemVendas;
//        for (int i = 0; i < listaDiasDeTrabalho.length; i++) {
//            if (listaDiasDeTrabalho == null) {
//                listaDiasDeTrabalho[i] = 0;
//            }
//            diasDeTrabalhoAno = diasDeTrabalhoAno + listaDiasDeTrabalho[i];
//        }
//        return (diasDeTrabalhoAno * (salarioBase + bonusAlimentacao) + bonusAntiquidade)+ bonusComerial; // + subsido ferias e natal //
//    }

