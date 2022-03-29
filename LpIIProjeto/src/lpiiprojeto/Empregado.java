/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpiiprojeto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
/**
 *
 * @author Guilherme Silva 202000178 && Duarte Valente 202000053
 */

public abstract class Empregado {
    private String nome;
    private int codigo;
    private LocalDate dataEntrada;
    private int[] listaDiasDeTrabalho = new int[12];
    
    
   public Empregado(String nome, int codigo, int ano, int mes, int dia) {
       if(nome == null || mes < 0 || mes > 12 || dia < 0 || dia > 31 || ano > 2022 || ano < 1940){
           throw new IllegalArgumentException("Erro no Argumento");
        }
        this.nome = nome;
        this.codigo = codigo;
        dataEntrada = LocalDate.of(ano, mes, dia);      
    }

   public abstract double obterSalarioEspecifico(double salarioBase, double valorPorQuilometro, double PercentagemVendas);
   
   public double obterSalarioBase(double salarioBase, double valorPorQuilometro, double PercentagemVendas){
        int diasDeTrabalhoAno = -1;
   
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        int anoEntrada = dataEntrada.getYear();
        int anosTrabalhados = anoAtual - anoEntrada;
        
        double bonusAntiquidade = 0.005*anosTrabalhados;
        double bonusAlimentacao = 4;
        
        for (int i = 0; i < listaDiasDeTrabalho.length; i++) {
            if (listaDiasDeTrabalho == null) {
                listaDiasDeTrabalho[i] = 0;
            }
            diasDeTrabalhoAno = diasDeTrabalhoAno + listaDiasDeTrabalho[i];
        }
       return (diasDeTrabalhoAno*(salarioBase + bonusAlimentacao) + bonusAntiquidade); // + subsido ferias e natal
    }
   
   
    public double obterSalarioAno(double salarioBase, double valorPorQuilometro, double PercentagemVendas){ 
        double x = obterSalarioBase(salarioBase, valorPorQuilometro, PercentagemVendas);
        double y = obterSalarioEspecifico(salarioBase, valorPorQuilometro, PercentagemVendas);
        return x + y;
    }
    
    
    public boolean adicionarDiasDeTrabalho(int mes, int diasDeTrabalho){
        if(diasDeTrabalho > 20){  //(5*4)
            return false;//tratar o false no menu
        }
        mes--;
        listaDiasDeTrabalho[mes] = diasDeTrabalho;
        return true; 
    }
        
     public String getNome(){
        return nome;
    }
     
    public int getCodigo(){
        return codigo;
    }
    
    @Override
   public String toString() {
        String info ="\n";
        info = info +" Nome: "+ nome+"\n";
        info = info +" Codigo: "+ codigo+"\n";
        info = info +" Data de Entrada: "+ dataEntrada+"\n";
        info = info +" Dias De Trabalho Dividido em Anos: "+ Arrays.toString(listaDiasDeTrabalho)+"\n";
        return info+"\n";          
    }
}
