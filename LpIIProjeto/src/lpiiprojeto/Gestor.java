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
import java.time.LocalDate;
import java.util.Calendar;

public class Gestor extends Empregado {
    
    public Gestor(String nome, int codigo, int ano, int mes, int dia) {
        super(nome,codigo,ano,mes,dia);
    }

    
    @Override
    public double obterSalarioEspecifico(double salarioBase, double valorPorQuilometro, double PercentagemVendas) {
        double bonusGestorFixo = 15; //Bonus Especifico de Gestor (%)
        double bonusGestor = obterSalarioBase(salarioBase, valorPorQuilometro, PercentagemVendas)*((bonusGestorFixo/100)+1);
        return bonusGestor;
    }
    
    
    @Override
    public String toString(){
       String info = "\n"; 
       info += "\n Gestor: "+ super.toString();
       return info+"\n";
}
}
    


//        @Override
//    public double obterSalarioAno(double salarioBase, double valorPorQuilometro, double PercentagemVendas) {
//        //Falta if
//        int diasDeTrabalhoAno = -1;
        
//        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
//        int anoEntrada = dataEntrada.getYear();
//        int anosTrabalhados = anoAtual - anoEntrada;
        
//        double bonusAntiquidade = 0.005*anosTrabalhados;
//        double bonusAlimentacao = 4;
//        double bonusGestor = 15; //Bonus Especifico de Gestor (%)
        
//        for (int i = 0; i < listaDiasDeTrabalho.length; i++) {
//            if (listaDiasDeTrabalho == null) {
//                listaDiasDeTrabalho[i] = 0;
//            }
//            diasDeTrabalhoAno = diasDeTrabalhoAno + listaDiasDeTrabalho[i];
//        }
//       return (diasDeTrabalhoAno*(salarioBase + bonusAlimentacao) + bonusAntiquidade) * ((bonusGestor/100)+1); // + subsido ferias e natal //#Adicionar o bonus geral de gestor
       /* O gestor recebe um bonus  */
  



