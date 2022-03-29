/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpiiprojeto;
import java.util.ArrayList;
/**
 *
 * @author Guilherme
 */
public class Menu {

    private InputReader reader;
    private Empresa empresa;

    public Menu(Empresa empresa) {
        reader = new InputReader();
        this.empresa = empresa;
    }

    public void executar() {
        int opcao;
        do {
            opcao = menuPrincipal();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    menuEmpresa();
                    break;
                case 2:
                    menuEmpregado();
                    break;
                case 3:
                    menuVeiculo();
                    break;
                case 4:
                    menuTxt();
            }

        } while (opcao != 0);

        System.out.println("O Programa terminou :)");
        supresa();
    }

    public int menuPrincipal() {
        System.out.println("****** Menu Principal *****");
        System.out.println("1.Configurar Empresa:");
        System.out.println("2.Empregado:");
        System.out.println("3.Veiculo:");
        System.out.println("4.Guardar Dados");
        System.out.println("0.Sair:");
        int opcao = reader.getIntegerNumber("Digite a sua escolha: ");
        if (opcao < 0 || opcao > 4) {
            System.out.println("Opcão Ilegal");
        }
        return opcao;
    }

    public void menuEmpresa() {
        System.out.println("****** Menu Principal \\ Empresa  *****");
        System.out.println("1.Alterar salário base:");
        System.out.println("2.Obter salario base atual:");
        System.out.println("3.Alterar Subsidio de Ferias:");
        System.out.println("4.Obter Subsidio de Ferias:");
        System.out.println("5.Alterar Subsidio de Natal:");
        System.out.println("6.Obter Subsidio de Natal:");
        System.out.println("7.Alterar Percentagem De Vendas do Comercial:");
        System.out.println("8.Obter Percentagem De Vendas do Comercial:");
        System.out.println("9.Alterar Valor Por Quilometro do Motorista:");
        System.out.println("10.Obter Valor Por Quilometro do Motorista:");
        System.out.println("0.Voltar ao Menu Principal:");

        int opcao = reader.getIntegerNumber("Digite a sua escolha: ");
        if (opcao < 0 || opcao > 10) {
            System.out.println("Opcão Ilegal");
            return;
        }

        switch (opcao) {
            case 1:
                opcao = reader.getIntegerNumber("Digite o novo valor: ");
                empresa.setSalarioBase(opcao);
                break;
            case 2:
                System.out.println(empresa.getSalarioBase());
                break;
            case 3:
                opcao = reader.getIntegerNumber("Digite o novo valor: ");
                empresa.setSubsidioFerias(opcao);
                break;
            case 4:
                System.out.println(empresa.getSubsidioFerias());
                break;
            case 5:
                opcao = reader.getIntegerNumber("Digite o novo valor: ");
                empresa.setSubsidioNatal(opcao);
                break;
            case 6:
                System.out.println(empresa.getSubsidioNatal());
                break;
            case 7:
                opcao = reader.getIntegerNumber("Digite o novo valor: ");
                empresa.setPercentagemDeVendas(opcao);
                break;
            case 8:
                System.out.println(empresa.getPercentagemDeVendas());
                break;
            case 9:
                opcao = reader.getIntegerNumber("Digite o novo valor: ");
                empresa.setValorPorQuilometro(opcao);
                break;
            case 10:
                System.out.println(empresa.getValorPorQuilometro());
                break;
        }
    }

    public void menuVeiculo() {
        System.out.println("****** Menu Principal \\ Veiculo *****");
        System.out.println("1.Adicionar Veiculo:");
        System.out.println("2.Obter Lista de Veiculos Disponiveis:");
        System.out.println("3.Atribuir Veiculos a Empregados:");
        System.out.println("4.Obter todos os Veiculos:");
        System.out.println("5.Adicionar Viagem:");
        System.out.println("0.Voltar ao Menu Principal:");
        int opcao = reader.getIntegerNumber("Digite a sua escolha: ");

        if (opcao < 0 || opcao > 5) {
            System.out.println("Opcão Ilegal");
            return;
        }

        switch (opcao) {
            case 1:
                adicionarVeiculo();
                break;
            case 2:
                System.out.println(empresa.obterVeiculosDisponiveis());
                break;
            case 3:
                atribuirVeiculosEmpregados();
                break;
            case 4:
                System.out.println(empresa.obterVeiculos());
                break;
            case 5:
                adicionarViagem();
                break;

        }
    }

    public void adicionarViagem() {
        int opcaoVeiculo = reader.getIntegerNumber("Digite o Numero da Apolice do Veiculo: ");
        Veiculo veiculo = empresa.obterVeiculoPorNumero(opcaoVeiculo);
        if (veiculo == null) {
            System.out.println("Numero inválido");
            return;
        }

        Class tipoDeVeiculo = veiculo.getClass();
        int passageiros = -1;
        double cargaTrasportada = -1;
        double quilometrosPercorridos;

        if (tipoDeVeiculo == Mercadoria.class) {
            quilometrosPercorridos = reader.getRealNumber("Digite o Numero de quilometroPercorridos: ");
            cargaTrasportada = reader.getRealNumber("Digite a carga Trasportada em Kg: ");
        } else if (tipoDeVeiculo == Passageiro.class) {
            quilometrosPercorridos = reader.getRealNumber("Digite o Numero de quilometroPercorridos: ");
            passageiros = reader.getIntegerNumber("Digite o número de Passageiros: ");
        } else if (tipoDeVeiculo == Bicicletas.class) {
            quilometrosPercorridos = reader.getRealNumber("Digite o Numero de quilometroPercorridos: ");
        } else {
            throw new IllegalArgumentException("Erro - Tipo de Veiculo Inválido");
        }

        boolean sucesso = veiculo.adicionarViagem(quilometrosPercorridos, passageiros, cargaTrasportada);
        if (sucesso) {
            System.out.println("Viagem Adicionada com sucesso");
        } else {
            System.out.println("A viagem não foi Adicionada com sucesso");
        }
    }

    
    public void atribuirVeiculosEmpregados() {
        int opcao;
        
        opcao = reader.getIntegerNumber("Digite o Código do Empregado: ");
        Empregado empregado = empresa.obterEmpregadoPorCodigo(opcao);
        if (empregado == null) {
            System.out.println("Código Empregado inválido");
            return;
        }

        opcao = reader.getIntegerNumber("Digite o Numero da Apolice do Veiculo: ");
        Veiculo veiculo = empresa.obterVeiculoPorNumero(opcao);
        if (veiculo == null) {
            System.out.println("Numero da Apolice do Veiculo inválido");
            return;
        }

        boolean sucesso = empresa.atribuirVeiculosEmpregados(empregado, veiculo);
        if (sucesso) {
            System.out.println("Atribuido Veiculo a Empregado com Sucesso");
        } else {
            System.out.println("Atribuido Veiculo a Empregado com Insucesso");
        }        
    }

     public void adicionarVeiculo() {
        Veiculo veiculo;
        veiculo = obterVeiculoEscolhido();
        if (veiculo == null){
            return;
        } 
        int numero = veiculo.getnumeroApolice();
        boolean sucesso = empresa.verificarExistenciaVeiculo(numero);
        
        if(sucesso){
            System.out.println("O veiculo que deseja adicionar está presente no sistema");
        }
        else{
           empresa.adicionarVeiculo(veiculo);
        }
    }
    
    
    public Veiculo obterVeiculoEscolhido() {
        Veiculo veiculo = null;
        System.out.println("1.Mercadorias");
        System.out.println("2.Passageiros");
        System.out.println("3.Bicicletas");
        System.out.println("4.Obter Informação Total de Todos os Veiculos");
        System.out.println("0.Voltar ao Menu Principal:");

        int opcao = reader.getIntegerNumber("Digite a sua escolha: ");
        if (opcao < 0 || opcao > 4) {
            System.out.println("Opcão Ilegal");
        }

        switch (opcao) {
            case 1:
               veiculo = adicionarVeiculosMercadorias();
                break;
            case 2:
               veiculo = escolherVeiculoPassageiros();
                break;
            case 3:
               veiculo = escolherVeiculoBicicleta();
                break;
        }
        return veiculo;
    }

    public Veiculo adicionarVeiculosMercadorias() {
        String nome = reader.getText("Digite o nome: ");
        String cor = reader.getText("Digite a cor: ");
        int numeroApolice = reader.getIntegerNumber("Digite o Numero Da Apolice: ");
        int diasNaEmpresa = reader.getIntegerNumber("Digite os dias na Empresa: ");
        double consumoMedio = reader.getRealNumber("Digite o consumo Medio: ");
        String matricula = reader.getText("Digite a Matricula: ");
        double cargaMaxima = reader.getRealNumber("Digite a carga Máxima: ");
        try {
            Veiculo veiculo = new Mercadoria(nome, cor, numeroApolice, diasNaEmpresa, consumoMedio, matricula, cargaMaxima);
            return veiculo;
        } catch (Exception e) {
            System.err.println("Erro do tipo: " + e.getMessage());
            System.out.println(" ");
        }
        return null;
    }

    public Veiculo escolherVeiculoPassageiros() {
        String nome = reader.getText("Digite o nome: ");
        String cor = reader.getText("Digite a cor: ");
        int numeroApolice = reader.getIntegerNumber("Digite o Numero Da Apolice: ");
        int diasNaEmpresa = reader.getIntegerNumber("Digite os dias na Empresa: ");
        double consumoMedio = reader.getRealNumber("Digite o consumo Medio: ");
        String matricula = reader.getText("Digite a Matricula: ");
        int numeroTotalPassageiros = reader.getIntegerNumber("Digite o máximo de passageiros: ");
        try {
            Veiculo veiculo = new Passageiro(nome, cor, numeroApolice, diasNaEmpresa, consumoMedio, matricula,numeroTotalPassageiros);
            return veiculo;
        } catch (Exception e) {
            System.err.println("Erro do tipo: " + e.getMessage());
            System.out.println(" ");
        }
        return null;
    }

    public Veiculo escolherVeiculoBicicleta() {
        String nome = reader.getText("Digite o nome: ");
        String cor = reader.getText("Digite a cor: ");
        int numeroApolice = reader.getIntegerNumber("Digite o Numero Da Apolice: ");
        int diasNaEmpresa = reader.getIntegerNumber("Digite os dias na Empresa: ");
        double consumoMedio = reader.getRealNumber("Digite o consumo Medio: ");
        double autonomia = reader.getRealNumber("Digite a Matricula: ");
        int miniAtrelado = reader.getIntegerNumber("Tem mini atrelado ? \n Digite 0 ou 1:  ");
        try {
            Veiculo veiculo = new Bicicletas(nome, cor, numeroApolice, diasNaEmpresa, consumoMedio, autonomia, miniAtrelado);
            return veiculo;
        } catch (Exception e) {
            System.err.println("Erro do tipo: " + e.getMessage());
            System.out.println(" ");
        }
        return null;
    }

    //Menu Empregado a baixo
    public void menuEmpregado() {
        System.out.println("****** Menu Principal \\ Empregado *****");
        System.out.println("1.Adicionar Empregado:");
        System.out.println("2.Verificar  Existencia de Empregado por código:");
        System.out.println("3.Obter Empregados Por Código:");
        System.out.println("4.Obter número de Empregados por categoria:");
        System.out.println("5.Obter lista de Empergados:");
        System.out.println("6.Obter lista de Empergados: por categoria:");
        System.out.println("7.Obter Total de Salários:");
        System.out.println("8.Obter Mapa de Gastos dos Empergados:");
        System.out.println("9.Adicionar Lista De Empregados ao Sistema");
        System.out.println("0.Voltar ao Menu Principal:");

        int opcao = reader.getIntegerNumber("Digite a sua escolha: ");
        if (opcao < 0 || opcao > 9) {
            System.out.println("Opcão Ilegal");
            return;
        }
        
        switch (opcao) {
            case 1:
                adicionarEmpregado();
                break;
            case 2:
                verificarExistenciaEmpregado();
                break;
            case 3:
                obterEmpregadoPorCodigo();
                break;
            case 4:
                obterTotalEmpregadoPorCategoria();
                break;
            case 5:
                System.out.println(empresa.obterlistaEmpergados());
                break;
            case 6:
                obterEmpregadoListaPorCategoria();
                break;
            case 7:
                System.out.println(empresa.obterTotalSalário() + "€");
                break;
            case 8:
                System.out.println(empresa.obterMapaGastosEmpergados());
                break;
            case 9:
                inserirListaEmpregado();
                break;

        }
    }
    
    public void inserirListaEmpregado() {
        ArrayList<Empregado> novalistaDeEmpregado = new ArrayList<Empregado>();
        Empregado empregado;
        int contador = 0;
        int empregadosAdicionar = reader.getIntegerNumber("Quantos Empregados Desejas Adicionar? ");
        while (contador < empregadosAdicionar) {
            empregado = obterEmpregadoEscolhido();
            novalistaDeEmpregado.add(empregado);
            contador++;
        }
        empresa.inserirListaEmpregado(novalistaDeEmpregado);
    }

    public void obterEmpregadoListaPorCategoria() {
        System.out.println("1.Normal:");
        System.out.println("2.Gestor:");
        System.out.println("3.Motorista");
        System.out.println("4.Comercial:");
        System.out.println("0.Voltar ao Menu Principal:");

        int opcao = reader.getIntegerNumber("Digite a sua escolha: ");
        if (opcao < 0 || opcao > 4) {
            System.out.println("Opcão Ilegal");
            return;
        }

        switch (opcao) {
            case 1:
                System.out.println(empresa.obterlistaEmpergadosPorCategoria(Normal.class));
                break;
            case 2:
                System.out.println(empresa.obterlistaEmpergadosPorCategoria(Gestor.class));
                break;
            case 3:
                System.out.println(empresa.obterlistaEmpergadosPorCategoria(Motorista.class));
                break;
            case 4:
                System.out.println(empresa.obterlistaEmpergadosPorCategoria(Comercial.class));
                break;
        }
    }

    public void obterTotalEmpregadoPorCategoria() {
        System.out.println("1.Normal:");
        System.out.println("2.Gestor:");
        System.out.println("3.Motorista");
        System.out.println("4.Comercial:");
        System.out.println("0.Voltar ao Menu Principal:");

        int opcao = reader.getIntegerNumber("Digite a sua escolha: ");
        if (opcao < 0 || opcao > 4) {
            System.out.println("Opcão Ilegal");
            return;
        }

        switch (opcao) {
            case 1:
                System.out.println(empresa.obterTotalEmpregadoPorCategoria(Normal.class));
                break;
            case 2:
                System.out.println(empresa.obterTotalEmpregadoPorCategoria(Gestor.class));
                break;
            case 3:
                System.out.println(empresa.obterTotalEmpregadoPorCategoria(Motorista.class));
                break;
            case 4:
                System.out.println(+empresa.obterTotalEmpregadoPorCategoria(Comercial.class));
                break;
        }

    }

    public void obterEmpregadoPorCodigo() {
        int opcao = reader.getIntegerNumber("Digite o codigo do Empregado que deseja obter: ");
        System.out.println(empresa.obterEmpregadoPorCodigo(opcao));
    }

    public void verificarExistenciaEmpregado() {
        int opcao = reader.getIntegerNumber("Digite o codigo do Empregado que deseja verificar: ");
        boolean sucesso = empresa.verificarExistenciaEmpregado(opcao);
        if(sucesso) {
            System.out.println("O empregado está presente no sistema");
        }
        else{
            System.out.println("O empregado não está presente no sistema");
        }
    }

    public void adicionarEmpregado() {
        Empregado empregado;
        empregado = obterEmpregadoEscolhido();
        if (empregado == null){
            return;
        } 
        int codigo = empregado.getCodigo();
        boolean sucesso = empresa.verificarExistenciaEmpregado(codigo);
        
        if(sucesso){
            System.out.println("O empregado que deseja adicionar está presente no sistema");
        }
        else{
           empresa.adicionarEmpregado(empregado); 
        }
    }

    public Empregado obterEmpregadoEscolhido() {
        Empregado empregado = null;
        System.out.println("1.Normal:");
        System.out.println("2.Gestor:");
        System.out.println("3.Motorista");
        System.out.println("4.Comercial:");
        System.out.println("0.Voltar ao Menu Principal:");

        int opcao = reader.getIntegerNumber("Digite a sua escolha: ");
        if (opcao < 0 || opcao > 4) {
            System.out.println("Opcão Ilegal");
            return null;
        }

        switch (opcao) {
            case 1:
                empregado = obterEmpregadoNormal();
                break;
            case 2:
                empregado = obterEmpregadoGestor();
                break;
            case 3:
                empregado = obterEmpregadoMotorista();
                break;
            case 4:
                empregado = obterEmpregadoComercial();
                break;
        }
        return empregado;
    }

    public Empregado obterEmpregadoNormal() {
        String nome = reader.getText("Digite o nome: ");
        int codigo = reader.getIntegerNumber("Digite o codigo: ");
        int ano = reader.getIntegerNumber("Digite o ano: ");
        int mes = reader.getIntegerNumber("Digite o mes: ");
        int dia = reader.getIntegerNumber("Digite o dia: ");
        try {
            Empregado empregado = new Normal(nome, codigo, ano, mes, dia);
            adicionarDiasDeTrabalho(empregado);
            return empregado;
        } catch (Exception e) {
            System.err.println("Erro do tipo: " + e.getMessage());
            System.out.println(" ");
        }
        return null;
    }

    public Empregado obterEmpregadoGestor() {
        String nome = reader.getText("Digite o nome: ");
        int codigo = reader.getIntegerNumber("Digite o codigo: ");
        int ano = reader.getIntegerNumber("Digite o ano: ");
        int mes = reader.getIntegerNumber("Digite o mes: ");
        int dia = reader.getIntegerNumber("Digite o dia: ");
        try {
            Empregado empregado = new Gestor(nome, codigo, ano, mes, dia);
            adicionarDiasDeTrabalho(empregado);
            return empregado;
        } catch (Exception e) {
            System.err.println("Erro do tipo: " + e.getMessage());
            System.out.println(" ");
        }
        return null;
    }

    public Empregado obterEmpregadoMotorista() {
        String nome = reader.getText("Digite o nome: ");
        int codigo = reader.getIntegerNumber("Digite o codigo: ");
        int ano = reader.getIntegerNumber("Digite o ano: ");
        int mes = reader.getIntegerNumber("Digite o mes: ");
        int dia = reader.getIntegerNumber("Digite o dia: ");
        int quilometrosPercorridos = reader.getIntegerNumber("Digite os quilometros Percorridos: ");
        try {
            Empregado empregado = new Motorista(nome, codigo, ano, mes, dia, quilometrosPercorridos);
            adicionarDiasDeTrabalho(empregado);
            return empregado;
        } catch (Exception e) {
            System.err.println("Erro do tipo: " + e.getMessage());
            System.out.println(" ");
        }
        return null;
    }

    public Empregado obterEmpregadoComercial() {
        String nome = reader.getText("Digite o nome: ");
        int codigo = reader.getIntegerNumber("Digite o codigo: ");
        int ano = reader.getIntegerNumber("Digite o ano: ");
        int mes = reader.getIntegerNumber("Digite o mes: ");
        int dia = reader.getIntegerNumber("Digite o dia: ");
        int numeroVendas = reader.getIntegerNumber("Digite os numero de vendas: ");
        try {
            Empregado empregado = new Comercial(nome, codigo, ano, mes, dia, numeroVendas);
            adicionarDiasDeTrabalho(empregado);
            return empregado;
        } catch (Exception e) {
            System.err.println("Erro do tipo: " + e.getMessage());
            System.out.println(" ");
        }
        return null;
    }

    public void adicionarDiasDeTrabalho(Empregado empregado) {
        int mesesDeTrabalho = reader.getIntegerNumber("Quantos meses o empregado trabalhou? ");
        int contador = 0;
        while (contador < mesesDeTrabalho) {
            int mes = reader.getIntegerNumber("Digite o mes de trabalho a adicionar: ");
            if (mes > 12) {
                System.out.println("Mes Inválido (>12)");
                return;
            }
            int dia = reader.getIntegerNumber("Digite o numero de dias nesse mes: ");
            if (empregado.adicionarDiasDeTrabalho(mes, dia) == false) {
                System.out.println("Dias de Trabalho Inválidos(>20)");
            }
            contador++;
        }
    }
    
   public void supresa(){
        System.out.println("");
        System.out.println("´´´´´´´´´´´´´´´´´´´´´7¶¶¶¶¶¶¶¶¶¶¶¶¶¶$7´´´´´´´´´´´´´´´´´´´´´");
        System.out.println("´´´´´´´´´´´´´´´´´¶¶¶¶¶ø´´´´´´´´´´´´´¢¶¶¶¶¶7´´´´´´´´´´´´´´´´");
        System.out.println("´´´´´´´´´´´´´´7¶¶¶´´´´´´´´´´´´´´´´´´´´´´´¶¶¶ø´´´´´´´´´´´´´´");
        System.out.println("´´´´´´´´´´´´´¶¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´¢¶¶´´´´´´´´´´´´´");
        System.out.println("´´´´´´´´´´´´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´´´´´´´´´´´´");
        System.out.println("´´´´´´´´´´´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´´´´´´´´´´´");
        System.out.println("´´´´´´´´´´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´´´´´´´´´´");
        System.out.println("´´´´´´´´´´¶¶´1¶1´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´¶¶´´´´´´´´´´");
        System.out.println("´´´´´´´´´´¶o´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´´¶´´´´´´´´´´");
        System.out.println("´´´´´´´´´´¶o´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´´¶´´´´´´´´´´");
        System.out.println("´´´´´´´´´´¶¶´´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶ø´7¶´´´´´´´´´´");
        System.out.println("´´´´´´´´´´¢¶´´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´´¶¶´´´´´´´´´´");
        System.out.println("´´´´´´´´´´´¶¶´o¶´´´1¢ø¶¶¶¶1´´´´´´¶¶¶¶ø¢1´´´¶¶´¶¶´´´´´´´´´´´");
        System.out.println("´´´´´´´´´´´´¶¶o¶´$¶¶¶¶¶¶¶¶¶´´´´´¶¶¶¶¶¶¶¶¶¶´¶¶ø¶7´´´´´´´´´´´");
        System.out.println("´´´´´´´´´´´´´¶¶¶´¶¶¶¶¶¶¶¶¶¶´´´´´¶¶¶¶¶¶¶¶¶¶´¶¶¶´´´´´´´´´´´´´");
        System.out.println("´´´´¶¶ø´´´´´´´¶ø´´¶¶¶¶¶¶¶¶´´´´´´´¶¶¶¶¶¶¶¶o´´¶7´´´´´´ø¶¶$´´´");
        System.out.println("´´´¶¶7¶¶´´´´´1¶´´´ø¶¶¶¶¶¶´´´7´7´´´o¶¶¶¶¶¶´´´¶¶´´´´´¶¶1¢¶7´´");
        System.out.println("´´7¶´´´¶¶´´´´1¶´´´´´oøø´´´´¶¶7¶¶´´´´oøo´´´´´¶$´´´´¶¶´´´¶$´´");
        System.out.println("´o¶¶´´´´¶¶¶¶´´¶¶´´´´´´´´´´¶¶¶´¶¶¶´´´´´´´´´´$¶´´¶¶¶¶´´´´¶¶ø´");
        System.out.println("¶¶´´´´´´´´´¶¶¶¶¶¶¶o´´´´´´´¶¶¶´¶¶¶´´´´´´´7¶¶¶¶¶¶¶1´´´´´´´´¶¶");
        System.out.println("¶¶¶¶¶¶¶¶1´´´´´o¶¶¶¶¶¶¶´´´´¶¶¶´¶¶¶´´´´$¶¶¶¶¶¶o´´´´´´¶¶¶¶¶¶¶¶");
        System.out.println("´´oøø1´¶¶¶¶¶´´´´´´¶1¶ø¶´´´´''´´´´´´´´´¶¶¶´¶o´´´´´¶¶¶¶¶1´øøø");
        System.out.println("´´´´´´´´´´7¶¶¶¶ø´´¶ø¶´¶¶´´´´´´´´´´´ø¶´¶1¶´´o¶¶¶¶o´´´´´´´´´´");
        System.out.println("´´´´´´´´´´´´´´ø¶¶¶¶¶´¶´´¶$¶¶¶¶¶¶¶¶¶´ø1´¶¶¶¶¶$´´´´´´´´´´´´´´");
        System.out.println("´´´´´´´´´´´´´´´´´´¶¶´¶´$¶´¶ø´¶´¶ø7¶oø¶´¶¶´´´´´´´´´´´´´´´´´´");
        System.out.println("´´´´´´´´´´´´´´´´¶¶¶¶´ø¶´¶´¶¶´¶´¶ø´¶´¶¶´¶¶¶¶o´´´´´´´´´´´´´´´");
        System.out.println("´´´´´´´´´´´´o¶¶¶¶´1¶´´´o¶¶¶¶ø¶o¶¶¶¶ø´´´¶ø´$¶¶¶¶´´´´´´´´´´´´");
        System.out.println("´´´´¶¶¶¶¶¶¶¶¶o´´´´´¶¶´´´´´´´´´´´´´´´´´¶¶´´´´´´¶¶¶¶¶¶¶¶¶´´´´");
        System.out.println("´´´¶¶´´´´´´´´´´´¶¶¶¶¶¶¶´´´´´´´´´´´´´¶¶¶ø¶¶¶o´´´´´´´´´´¶¶´´´");
        System.out.println("´´´´¶¶¶´´´´´1¶¶¶¶´´´´´¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶´´´´´¶¶¶¶ø´´´´´¶¶¶´´´´");
        System.out.println("´´´´´´¶¶´´´¶¶¢´´´´´´´´´´´7$¶¶¶¶¶¶7´´´´´´´´´´´7¶¶´´´¶¶´´´´´´");
        System.out.println("´´´´´´¢¶´´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´´¶¶´´´´´´");
        System.out.println("´´´´´´´¶¶¶ø´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¢¶¶¶´´´´´´´");
        System.out.println("");
    }
   
   public void menuTxt(){
        System.out.println("****** Menu Principal / Menu TXT *****");
        System.out.println("1.Criar Ficheiro TXT");
        System.out.println("2.Guardar Ficheiro TXT");
        System.out.println("0.Sair:");
        int opcao = reader.getIntegerNumber("Digite a sua escolha: ");
        if (opcao < 0 || opcao > 2) {
            System.out.println("Opcão Ilegal");
            return;
        }
        
        switch(opcao){
            case 1:
                empresa.CriarFicheiroTxt();
                break;
            case 2:
                empresa.GuardarFichiroTxt();
                break;
        }
   }
}
