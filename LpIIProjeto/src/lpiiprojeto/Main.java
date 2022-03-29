/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpiiprojeto;

/**
 *
 * @author Guilherme
 */
public class Main {

     public static void mainTest(String[] args){
        Empresa empresa = new Empresa();
        Empregado empregado;
        Empregado empregado_2;
        try{
            empregado =  new Comercial(null, 1, 2, 3, 4, 5);
            empregado_2 = new Comercial("Zezinho", 1, 2, 3, 4, 5);
        }
        catch(Exception e){
            System.out.println("Erro do tipo (ta MT BOM): " + e.getMessage());
            return;
        }
        
        empresa.adicionarEmpregado(empregado);
        empresa.adicionarEmpregado(empregado_2);
        System.out.println(empresa.obterTotalEmpregadoPorCategoria(Comercial.class));
        
        Veiculo v = new Mercadoria("MMA", "Vermelho", 22, 2, 3,"ss",7);
        empresa.atribuirVeiculosEmpregados(empregado, v); 
    }
     
       public static void mainMenu(String[] args) {
         Empresa empresa = new Empresa();
         Empregado empregado =  new Comercial("Fernando", 11, 2020, 3, 4, 5);
         Empregado empregado_2 = new Comercial("Zezinho", 22, 2020, 3, 4, 5);
         Empregado empregado_3 = new Gestor("Maria", 33, 1965, 3, 4);
         Empregado empregado_4 = new Normal("Sofia", 1, 1999, 3, 4);
         Empregado empregado_5 = new Motorista("joana", 1, 2022, 3, 4, 5);
         empresa.adicionarEmpregado(empregado);
         empresa.adicionarEmpregado( empregado_2);
         empresa.adicionarEmpregado(empregado_3);
         empresa.adicionarEmpregado(empregado_4);
         empresa.adicionarEmpregado(empregado_5);
         empregado.adicionarDiasDeTrabalho(1, 12);
         empregado.adicionarDiasDeTrabalho(2, 20);
         Veiculo veiculo =  new Bicicletas("Bmx", "Azul", 1, 2, 20, 23, 0);
         Veiculo veiculo2 =  new Mercadoria("SmartDuo", "Vermelho", 22, 2, 3,"ss",1);
         Veiculo veiculo3 =  new Mercadoria("SmartUni", "Vermelho", 22, 2, 3,"MM-A",1);
         Veiculo veiculo4 =  new Passageiro("Bus escolar", "Verde", 1, 44, 3, "aa",5);
         Veiculo veiculo5 =  new Passageiro("Carrinha", "Verde", 7, 55, 3, "bb",3);
         Veiculo veiculo6 =  new Mercadoria("Neke", "AZUL", 67, 66, 46,"qweqw",1000);
         empresa.adicionarVeiculo(veiculo);
         empresa.adicionarVeiculo(veiculo2);
         empresa.adicionarVeiculo(veiculo3);
         empresa.adicionarVeiculo(veiculo4);
         empresa.adicionarVeiculo(veiculo5);
         empresa.adicionarVeiculo(veiculo6);
         
         
         Menu menu = new Menu(empresa);
         
         menu.executar();
    }
    
    public static void main(String[] args) {
         //mainTest(args);
         mainMenu(args);
    }
    
    
}
