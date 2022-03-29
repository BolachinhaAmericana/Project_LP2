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
public class Motorista extends Empregado {
    private double quilometrosPercorridos; //1

    
    public Motorista(String nome, int codigo, int ano, int mes, int dia, int quilometrosPercorridos) {
        super(nome,codigo,ano,mes,dia);
        
        this.quilometrosPercorridos = quilometrosPercorridos;  
    }
    
    
    public void setQuilometrosPercorridos(double quilometrosPercorridos){ //2
        this.quilometrosPercorridos = quilometrosPercorridos;
    }
    
    
    public double getQuilometrosPercorridos(){ //3
        return this.quilometrosPercorridos;
    }

    @Override
    public double obterSalarioEspecifico(double salarioBase, double valorPorQuilometro, double PercentagemVendas) {
        double bonusMotorista = quilometrosPercorridos * valorPorQuilometro;
        return bonusMotorista;
    }
    
    @Override
    public String toString(){
       String info = "\n"; 
       info += "\n Motorista: "+ super.toString();
       info += "Quilometros Percorridos: "+quilometrosPercorridos;
       return info+"\n";
}
}
    
//    @Override
//    public double obterSalarioAno(double salarioBase, double valorPorQuilometro, double PercentagemVendas) {
//        int diasDeTrabalhoAno = -1;

//        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
//        int anoEntrada = dataEntrada.getYear();
//        int anosTrabalhados = anoAtual - anoEntrada;

//        double bonusAntiquidade = 0.005 * anosTrabalhados;
//        double bonusAlimentacao = 4;
        
//        double bonusMotorista = quilometrosPercorridos * valorPorQuilometro;

//        for (int i = 0; i < listaDiasDeTrabalho.length; i++) {
//            if (listaDiasDeTrabalho == null) {
//                listaDiasDeTrabalho[i] = 0;
//            }
//            diasDeTrabalhoAno = diasDeTrabalhoAno + listaDiasDeTrabalho[i];
//        }
//        return (diasDeTrabalhoAno * (salarioBase + bonusAlimentacao) + bonusAntiquidade)+ bonusMotorista; // + subsido ferias e natal //
//    }

