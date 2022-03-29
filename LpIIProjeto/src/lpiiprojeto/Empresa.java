/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpiiprojeto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Guilherme Silva 202000178 && Duarte Valente 202000053
 */
public class Empresa implements IconfigEmpresa {

    private ArrayList<Empregado> listaDeEmpregado = new ArrayList<Empregado>();
    private double salarioBase = IconfigEmpresa.salarioBase;
    private double valorPorQuilometro = IconfigEmpresa.valorPorQuilometro;
    private double percentagemDeVendas = IconfigEmpresa.percentagemDeVendas;
    private double subsidioNatal = IconfigEmpresa.subsidioNatal;
    private double subsidioFerias = IconfigEmpresa.subsidioFerias;
    private Veiculo[] frota = new Veiculo[IconfigEmpresa.NumeroDeVeiculosNaFrota];
    private String path = new String();

    //Não necessita construtor todos os valores implementados na interface de configuracao da empresa
    public void adicionarEmpregado(Empregado empregado) {
        //Falta if/ talvez usar verificarExistenciaEmpregado no menu
        listaDeEmpregado.add(empregado);
    }

    
    public Empregado obterEmpregadoPorCodigo(int codigo) {
        if (verificarExistenciaEmpregado(codigo)) {
            for (Empregado member : listaDeEmpregado) {
                if (member.getCodigo() == codigo) {
                    return member;
                }
            }
        }
        return null;
    }

    
    public boolean verificarExistenciaEmpregado(int codigo) {
        //Falta if
        for (Empregado member : listaDeEmpregado) {
            if (member.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    
    public int obterTotalEmpregadoPorCategoria(Class categoria) {
        //todas as classes são objetos de um tipo superior
        //O tipo Class é um objeto que representa a class "categoria" por exemplo
        //.getClass método da class Object que retorna uma class expecifica
        //Logo são comparados dois objetos
        //Perguntar ao stor stackoverflow nao falha :)
        int contador = 0;
        for (Empregado member : listaDeEmpregado) {
            if (member.getClass() == categoria) {
                contador++;
            }
        }
        return contador;
    }

    
    public ArrayList<Empregado> obterlistaEmpergados() {
        return listaDeEmpregado;
    }

    
    public ArrayList<Empregado> obterlistaEmpergadosPorCategoria(Class categoria) {
        ArrayList<Empregado> ListaPorCategoria = new ArrayList<Empregado>();
        for (Empregado member : listaDeEmpregado) {
            if (member.getClass() == categoria) {
                ListaPorCategoria.add(member);
            }
        }
        return ListaPorCategoria;
    }

    
    public double obterTotalSalário() {
        double total = 0;
        for (Empregado member : listaDeEmpregado) {
            total += member.obterSalarioAno(salarioBase, valorPorQuilometro, percentagemDeVendas);
        }
        return total;
    }

    
    public String obterMapaGastosEmpergados() {
        double SalariosPorAno = (obterTotalSalário() + subsidioFerias + subsidioNatal);
        double SalalriosPorSemestre = (obterTotalSalário() + subsidioNatal + subsidioFerias) / 2;
        double SalarioPorTrimestre = (obterTotalSalário() + subsidioNatal + subsidioFerias) / 3;
        String info = "Salarios Por Ano: " + SalariosPorAno + "€\n" + "Slarios Por Semestre: " + SalalriosPorSemestre + "€\n" + "Salarios Por Trimestre: " + SalarioPorTrimestre + "€\n";
        return info;
    }

    
    public void inserirListaEmpregado(ArrayList<Empregado> NovalistaDeEmpregado) {
        listaDeEmpregado.addAll(NovalistaDeEmpregado);
    }

    
    public boolean adicionarVeiculo(Veiculo veiculo) {
        for (int i = 0; i < frota.length; i++) {
            Veiculo v = frota[i];
            if (v == null) {
                //Perguntar ao professor
                frota[i] = veiculo;
                return true;
            }
        }
        return false;
    }

    
    public boolean estaVeiculoDisponivel(Veiculo veiculo) {
        for (int i = 0; i < frota.length; i++) {
            Veiculo v = frota[i];
            if (v != null) {
                if (v == veiculo) {
                    return veiculo.estaDisponivel();
                }
            }
        }
        return false;
    }

    
    public ArrayList<Veiculo> obterVeiculosDisponiveis() {
        ArrayList<Veiculo> resultado = new ArrayList<Veiculo>();
        for (int i = 0; i < frota.length; i++) {
            Veiculo v = frota[i];
            if (estaVeiculoDisponivel(v)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    
    public ArrayList<Veiculo> obterVeiculos() {
        ArrayList<Veiculo> listaDeVeiculos = new ArrayList<Veiculo>();
        for (int i = 0; i < frota.length; i++) {
            Veiculo v = frota[i];
            if (v != null) {
                listaDeVeiculos.add(v);
            }
        }
        return listaDeVeiculos;
    }

    
    public Veiculo obterVeiculoPorNumero(int numero) {
        if (verificarExistenciaVeiculo(numero)) {
            for (int i = 0; i < frota.length; i++) {
                Veiculo v = frota[i];
                if (estaVeiculoDisponivel(v)) {
                    if (v != null) {
                        if (v.getnumeroApolice() == numero) {
                            return v;
                        }
                    }
                }
            }
        }
        return null;
    }

    
    public boolean verificarExistenciaVeiculo(int numero) {
        for (int i = 0; i < frota.length; i++) {
            Veiculo v = frota[i];
            if (v != null) {
                if (v.getnumeroApolice() == numero) {
                    return true;
                }
            }
        }
        return false;
    }

    
    public boolean atribuirVeiculosEmpregados(Empregado empregado, Veiculo veiculo) {
        boolean sucesso = false;
        for (int i = 0; (i < frota.length) && !sucesso; i++) {
            Veiculo v = frota[i];
            if (v != null) {
                if (v == veiculo && estaVeiculoDisponivel(v)) {
                    v.empregado = empregado;
                    sucesso = true;
                }
            }
        }
        return sucesso;
    }

    
    public void guardarListaEmpergado() {
    }

    
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    
    public void setValorPorQuilometro(double valorPorQuilometro) {
        this.valorPorQuilometro = valorPorQuilometro;
    }

    
    public void setPercentagemDeVendas(double percentagemDeVendas) {
        this.percentagemDeVendas = percentagemDeVendas;
    }

    
    public void setSubsidioNatal(double subsidioNatal) {
        this.subsidioNatal = subsidioNatal;
    }

    
    public void setSubsidioFerias(double subsidioFerias) {
        this.subsidioFerias = subsidioFerias;
    }
    
    public void setPath(String path){
        this.path = path;
    }

    
    public double getSalarioBase() {
        return salarioBase;
    }

    
    public double getValorPorQuilometro() {
        return valorPorQuilometro;
    }

    
    public double getPercentagemDeVendas() {
        return percentagemDeVendas;
    }

    
    public double getSubsidioNatal() {
        return subsidioNatal;
    }

    
    public double getSubsidioFerias() {
        return subsidioFerias;
    }
    
    public String getPath(){
        return this.path;
    }
    
    public void CriarFicheiroTxt(){
        try{
            File txt = new File("Lista.txt");
            if(txt.createNewFile()){
                System.out.println("O Ficheiro"+txt.getName() +" foi Criado !!"); 
            }
        else{
                System.err.println("O Ficheiro ja existe!!");
                }
    }catch(IOException e){
            System.err.println("Erro ao Criar o Ficheiro");
            e.printStackTrace();
}
}
    
    public void GuardarFichiroTxt(){
        try{
            FileWriter escrever = new FileWriter("Lista.txt");
            File txt = new File("Lista.txt");
            escrever.write(this.listaDeEmpregado.toString());
            escrever.close();
            if(txt.createNewFile()){
                System.err.println("O Ficheiro Tem de ser criado antes de se poder guardar!!");
            }else{
                System.out.println("Guardou os dados com sucesso!");
            }
        }catch(IOException e){
            System.err.println("Erro a Guardar os Dados");
            e.printStackTrace();
        }
    }

}