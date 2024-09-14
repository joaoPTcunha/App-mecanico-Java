import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // arrays para armazenar objetos
        Trabalhador[] arrayTrabalhadores = new Trabalhador[100];
        Cliente[] arrayClientes = new Cliente[100];
        ArranjoVeiculo[] arrayArranjos = new ArranjoVeiculo[100];

        // menu
        int opcao;
        do {
            System.out.println("\n========================Selecione uma opção:========================\n");
            System.out.println("1. Registar novo trabalhador");
            System.out.println("2. Registar novo cliente");
            System.out.println("3. Registar novo arranjo");
            System.out.println("4. Modificar informacao de um trabalhador");
            System.out.println("5. Modificar informacao de um cliente");
            System.out.println("6. Listar todos os trabalhadores");
            System.out.println("7. Listar todos os clientes");
            System.out.println("8. Listar todos os arranjos");
            System.out.println("9. Listar um trabalhador (pelo id trabalhador)");
            System.out.println("10. Listar um cliente (pelo id cliente)");
            System.out.println("11. Listar todos os arranjos de um cliente (pelo id cliente)");
            System.out.println("12. Listar todos os arranjos de uma determinada data");
            System.out.println("13. Calcular o preço total de todos os arranjos");
            System.out.println("14. Calcular o preço total dos arranjos de um cliente em especifico");
            System.out.println("15. Apresentar a informação do arranjo com o preco mais baixo e do mais alto");
            System.out.println("16. Calcular imposto");
            System.out.println("0. Sair");
            System.out.println("=====================================================================\n");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    registarNovoTrabalhador(arrayTrabalhadores);
                    break;
                case 2:
                    registarNovoCliente(arrayClientes);
                    break;
                case 3:
                    registarNovoArranjo(arrayArranjos, arrayTrabalhadores, arrayClientes);
                    break;
                case 4:
                    modificarInfoTrabalhador(arrayTrabalhadores);
                    break;
                case 5:
                    modificarInfoCliente(arrayClientes);
                    break;
                case 6:
                    listarTodosTrabalhadores(arrayTrabalhadores);
                    break;
                case 7:
                    listarTodosClientes(arrayClientes);
                    break;
                case 8:
                    listarTodosArranjos(arrayArranjos);
                    break;
                case 9:
                    listarTrabalhadorPorId(arrayTrabalhadores);
                    break;
                case 10:
                    listarClientePorId(arrayClientes);
                    break;
                case 11:
                    listarArranjosPorIdCliente(arrayArranjos);
                    break;
                case 12:
                    listarArranjosPorData(arrayArranjos);
                    break;
                case 13:
                    calcularPrecoTotalArranjos(arrayArranjos);
                    break;
                case 14:
                    calcularPrecoTotalCliente(arrayArranjos);
                    break;
                case 15:
                    apresentarInfoPrecoExtremo(arrayArranjos);
                    break;
                case 16:
                    calcularImposto(arrayArranjos);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static Scanner scanner = new Scanner(System.in);

    // funções

    private static void registarNovoTrabalhador(Trabalhador[] arrayTrabalhadores) {
        System.out.println("---------------------------------------");
        System.out.println("Introduza o nome do trabalhador:");
        String nome = scanner.nextLine();
        System.out.println("Introduza a idade do trabalhador:");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduza o contato do trabalhador:");
        String contato = scanner.nextLine();
        System.out.println("Introduza o cargo do funcionario:");
        String cargo = scanner.nextLine();
        System.out.println("Insira o salario mensal do trbalhador");
        float salarioMensal = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("---------------------------------------");
        Trabalhador novoTrabalhador = new Trabalhador(nome, idade, contato, cargo, salarioMensal);
        for (int i = 0; i < arrayTrabalhadores.length; i++) {
            if (arrayTrabalhadores[i] == null) {
                arrayTrabalhadores[i] = novoTrabalhador;
                System.out.println("Trabalhador registado com sucesso!");
                break;
            }
        }
    }

    private static void registarNovoCliente(Cliente[] arrayClientes) {
        System.out.println("---------------------------------------");
        System.out.println("Introduza o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Introduza o contato do cliente:");
        String contato = scanner.nextLine();
        System.out.println("Introduza o NIF do cliente:");
        String nif = scanner.nextLine();
        System.out.println("---------------------------------------");

        Cliente novoCliente = new Cliente(nome, contato, nif);

        for (int i = 0; i < arrayClientes.length; i++) {
            if (arrayClientes[i] == null) {
                arrayClientes[i] = novoCliente;
                System.out.println("Cliente registado com sucesso!");
                break;
            }
        }
    }

    private static void registarNovoArranjo(ArranjoVeiculo[] arrayArranjos, Trabalhador[] arrayTrabalhadores,
            Cliente[] arrayClientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------------------------");
        System.out.println("Introduza a matrícula do veículo:");
        String matricula = scanner.nextLine();
        System.out.println("Introduza o tipo de veículo:");
        String tipoVeiculo = scanner.nextLine();
        System.out.println("Introduza o ID do trabalhador responsável pelo arranjo:");
        int idTrabalhador = scanner.nextInt();
        System.out.println("Introduza o ID do cliente para o qual será feito o arranjo:");
        int idCliente = scanner.nextInt();
        System.out.println("Introduza o custo total do arranjo:");
        float custoTotal = scanner.nextFloat();
        scanner.nextLine(); // erro de passar a frente na data de arranjo
        System.out.println("Introduza a data do arranjo (formato DD/MM/AAAA):");
        String dataArranjo = scanner.nextLine();
        System.out.println("Introduza observações adicionais:");
        String observacoes = scanner.nextLine();
        System.out.println("---------------------------------------");
        Trabalhador trabalhadorResponsavel = null;
        Cliente clienteArranjo = null;

        // procurar id de trabalhador
        for (Trabalhador trabalhador : arrayTrabalhadores) {
            if (trabalhador != null && trabalhador.getIdTrabalhador() == idTrabalhador) {
                trabalhadorResponsavel = trabalhador;
                break;
            }
        }

        // procurar id de cliente
        for (Cliente cliente : arrayClientes) {
            if (cliente != null && cliente.getIdCliente() == idCliente) {
                clienteArranjo = cliente;
                break;
            }
        }

        // verifica se existe algum trabalhador
        if (trabalhadorResponsavel == null || clienteArranjo == null) {
            System.out.println("Trabalhador ou cliente não encontrado com o ID fornecido.");
            return;
        }

        ArranjoVeiculo novoArranjo = new ArranjoVeiculo(matricula, tipoVeiculo, idTrabalhador, idCliente, custoTotal,
                dataArranjo, observacoes);

        for (int i = 0; i < arrayArranjos.length; i++) {
            if (arrayArranjos[i] == null) {
                arrayArranjos[i] = novoArranjo;
                System.out.println("Arranjo registado com sucesso!");
                break;
            }
        }
    }

    private static void modificarInfoTrabalhador(Trabalhador[] arrayTrabalhadores) {
        System.out.println("Introduza o ID do trabalhador que deseja modificar:");
        int idTrabalhador = scanner.nextInt();
        scanner.nextLine();

        Trabalhador trabalhadorParaModificar = null;
        // pesquisar o trabalhador pelo id
        for (Trabalhador trabalhador : arrayTrabalhadores) {
            if (trabalhador != null && trabalhador.getIdTrabalhador() == idTrabalhador) {
                trabalhadorParaModificar = trabalhador;
                break;
            }
        }

        if (trabalhadorParaModificar == null) {
            System.out.println("Trabalhador não encontrado com o ID fornecido.");
            return;
        }

        // mostrar informações atuais do trabalhador
        System.out.println("---------------------------------------");
        System.out.println("Informações atuais do trabalhador:");
        System.out.println("Nome: " + trabalhadorParaModificar.getNome());
        System.out.println("Idade: " + trabalhadorParaModificar.getIdade());
        System.out.println("Contato: " + trabalhadorParaModificar.getContacto());
        System.out.println("Cargo: " + trabalhadorParaModificar.getCargo());
        System.out.println("Salário Mensal: " + trabalhadorParaModificar.getSalarioMensal());
        System.out.println("---------------------------------------");

        // qual informaçâo trocar no trabalhador
        System.out.println("---------------------------------------");
        System.out.println("\nSelecione a informação que deseja modificar:");
        System.out.println("1. Nome");
        System.out.println("2. Idade");
        System.out.println("3. Contato");
        System.out.println("4. Cargo");
        System.out.println("5. Salário Mensal");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        System.out.println("---------------------------------------");

        switch (opcao) {
            case 1:
                System.out.println("Introduza o novo nome:");
                String novoNome = scanner.nextLine();
                trabalhadorParaModificar.setNome(novoNome);
                System.out.println("Nome modificado com sucesso!");
                break;
            case 2:
                System.out.println("Introduza a nova idade:");
                int novaIdade = scanner.nextInt();
                trabalhadorParaModificar.setIdade(novaIdade);
                System.out.println("Idade modificada com sucesso!");
                break;
            case 3:
                System.out.println("Introduza o novo contato:");
                String novoContato = scanner.nextLine();
                trabalhadorParaModificar.setContacto(novoContato);
                System.out.println("Contato modificado com sucesso!");
                break;
            case 4:
                System.out.println("Introduza o novo cargo:");
                String novoCargo = scanner.nextLine();
                trabalhadorParaModificar.setCargo(novoCargo);
                System.out.println("Cargo modificado com sucesso!");
                break;
            case 5:
                System.out.println("Introduza o novo salário mensal:");
                float novoSalarioMensal = scanner.nextFloat();
                trabalhadorParaModificar.setSalarioMensal(novoSalarioMensal);
                System.out.println("Salário mensal modificado com sucesso!");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void modificarInfoCliente(Cliente[] arrayClientes) {
        System.out.println("Introduza o ID do cliente que deseja modificar:");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente clienteParaModificar = null;

        // pesquisa pelo id do cliente
        for (Cliente cliente : arrayClientes) {
            if (cliente != null && cliente.getIdCliente() == idCliente) {
                clienteParaModificar = cliente;
                break;
            }
        }

        if (clienteParaModificar == null) {
            System.out.println("Cliente não encontrado com o ID fornecido.");
            return;
        }
        System.out.println("---------------------------------------");
        System.out.println("Informações atuais do cliente:");
        System.out.println("Nome: " + clienteParaModificar.getNome());
        System.out.println("Contato: " + clienteParaModificar.getContato());
        System.out.println("NIF: " + clienteParaModificar.getNIF());

        System.out.println("Selecione a informação que deseja modificar:");
        System.out.println("1. Nome");
        System.out.println("2. Contato");
        System.out.println("3. NIF");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        System.out.println("---------------------------------------");

        switch (opcao) {
            case 1:
                System.out.println("Introduza o novo nome:");
                String novoNome = scanner.nextLine();
                clienteParaModificar.setNome(novoNome);
                System.out.println("Nome modificado com sucesso!");
                break;
            case 2:
                System.out.println("Introduza o novo contato:");
                String novoContato = scanner.nextLine();
                clienteParaModificar.setContato(novoContato);
                System.out.println("Contato modificado com sucesso!");
                break;
            case 3:
                System.out.println("Introduza o novo NIF:");
                String novoNif = scanner.nextLine();
                clienteParaModificar.setNIF(novoNif);
                System.out.println("NIF modificado com sucesso!");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void listarTodosTrabalhadores(Trabalhador[] arrayTrabalhadores) {
        System.out.println("---------------------------------------");
        System.out.println("Lista de todos os trabalhadores:");

        for (Trabalhador trabalhador : arrayTrabalhadores) {
            if (trabalhador != null) {
                System.out.println("\n\nID do Trabalhador: " + trabalhador.getIdTrabalhador());
                System.out.println("Nome: " + trabalhador.getNome());
                System.out.println("Idade: " + trabalhador.getIdade());
                System.out.println("Contato: " + trabalhador.getContacto());
                System.out.println("Cargo: " + trabalhador.getCargo());
                System.out.println("Salário Mensal: " + trabalhador.getSalarioMensal());
                System.out.println("---------------------------------------");
            }
        }
    }

    private static void listarTodosClientes(Cliente[] arrayClientes) {
        System.out.println("---------------------------------------");
        System.out.println("Lista de todos os clientes:");

        for (Cliente cliente : arrayClientes) {
            if (cliente != null) {
                System.out.println("ID do Cliente: " + cliente.getIdCliente());
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Contato: " + cliente.getContato());
                System.out.println("NIF: " + cliente.getNIF());
                System.out.println("---------------------------------------");
            }
        }
    }

    private static void listarTodosArranjos(ArranjoVeiculo[] arrayArranjos) {
        System.out.println("---------------------------------------");
        System.out.println("Lista de todos os arranjos de veículos:");

        for (ArranjoVeiculo arranjo : arrayArranjos) {
            if (arranjo != null) {
                System.out.println("ID do Arranjo: " + arranjo.getIdArranjo());
                System.out.println("Matrícula do Veículo: " + arranjo.getMatricula());
                System.out.println("Tipo de Veículo: " + arranjo.getTipoVeiculo());
                System.out.println("ID do Trabalhador Responsável: " + arranjo.getIdTrabalhador());
                System.out.println("ID do Cliente: " + arranjo.getIdCliente());
                System.out.println("Custo Total: " + arranjo.getCustoTotal());
                System.out.println("Data do Arranjo: " + arranjo.getDataArranjo());
                System.out.println("Observações: " + arranjo.getObservacoes());
                System.out.println("---------------------------------------\n");
            }
        }
    }

    private static void listarTrabalhadorPorId(Trabalhador[] arrayTrabalhadores) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza o ID do trabalhador:");
        int idProcurado = scanner.nextInt();
        scanner.nextLine();

        for (Trabalhador trabalhador : arrayTrabalhadores) {
            if (trabalhador != null && trabalhador.getIdTrabalhador() == idProcurado) {
                System.out.println("---------------------------------------");
                System.out.println("Informações do trabalhador com ID " + idProcurado + ":");
                System.out.println("Nome: " + trabalhador.getNome());
                System.out.println("Idade: " + trabalhador.getIdade());
                System.out.println("Contato: " + trabalhador.getContacto());
                System.out.println("Cargo: " + trabalhador.getCargo());
                System.out.println("Salário Mensal: " + trabalhador.getSalarioMensal());
                System.out.println("---------------------------------------");
                return;
            }
        }
        System.out.println("Trabalhador com ID " + idProcurado + " nao encontrado.");

    }

    private static void listarClientePorId(Cliente[] arrayClientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza o ID do cliente:");

        boolean clienteEncontrado = false;
        if (scanner.hasNextInt()) {
            int idProcurado = scanner.nextInt();
            scanner.nextLine();

            for (Cliente cliente : arrayClientes) {
                if (cliente != null && cliente.getIdCliente() == idProcurado) {
                    System.out.println("---------------------------------------");
                    System.out.println("Informações do cliente com ID " + idProcurado + ":");
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Contato: " + cliente.getContato());
                    System.out.println("NIF: " + cliente.getNIF());
                    System.out.println("---------------------------------------");
                    clienteEncontrado = true;
                    break;
                }
            }
        } else {
            System.out.println("Entrada inválida. Por favor, insira um ID válido.");
        }

        if (!clienteEncontrado) {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void listarArranjosPorIdCliente(ArranjoVeiculo[] arrayArranjos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza o ID do cliente:");
        int idClienteProcurado = scanner.nextInt();

        boolean arranjosEncontrados = false;

        System.out.println("Lista de arranjos para o cliente com ID " + idClienteProcurado + ":");

        for (ArranjoVeiculo arranjo : arrayArranjos) {
            if (arranjo != null && arranjo.getIdCliente() == idClienteProcurado) {
                System.out.println("---------------------------------------");
                System.out.println("ID do Arranjo: " + arranjo.getIdArranjo());
                System.out.println("Matrícula do Veículo: " + arranjo.getMatricula());
                System.out.println("Tipo de Veículo: " + arranjo.getTipoVeiculo());
                System.out.println("Custo Total: " + arranjo.getCustoTotal());
                System.out.println("Data do Arranjo: " + arranjo.getDataArranjo());
                System.out.println("Observações: " + arranjo.getObservacoes());
                System.out.println("---------------------------------------");
                arranjosEncontrados = true;
            }
        }

        if (!arranjosEncontrados) {
            System.out.println("Não há arranjos associados ao cliente com ID " + idClienteProcurado + ".");
        }
    }

    private static void listarArranjosPorData(ArranjoVeiculo[] arrayArranjos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza a data do arranjo (formato DD/MM/AAAA):");
        String dataProcuradaStr = scanner.nextLine();

        boolean arranjosEncontrados = false;

        System.out.println("Lista de arranjos para a data " + dataProcuradaStr + ":");

        for (ArranjoVeiculo arranjo : arrayArranjos) {
            if (arranjo != null && arranjo.getDataArranjo().equals(dataProcuradaStr)) {
                System.out.println("---------------------------------------");
                System.out.println("ID do Arranjo: " + arranjo.getIdArranjo());
                System.out.println("Matrícula do Veículo: " + arranjo.getMatricula());
                System.out.println("Tipo de Veículo: " + arranjo.getTipoVeiculo());
                System.out.println("Custo Total: " + arranjo.getCustoTotal());
                System.out.println("Data do Arranjo: " + arranjo.getDataArranjo());
                System.out.println("Observações: " + arranjo.getObservacoes());
                System.out.println("---------------------------------------");
                arranjosEncontrados = true;
            }
        }

        if (!arranjosEncontrados) {
            System.out.println("Não existe arranjos para a data " + dataProcuradaStr + ".");
        }

    }

    private static void calcularPrecoTotalArranjos(ArranjoVeiculo[] arrayArranjos) {
        float precoTotal = 0;

        for (ArranjoVeiculo arranjo : arrayArranjos) {
            if (arranjo != null) {
                precoTotal += arranjo.getCustoTotal();
            }
        }

        System.out.println("Preço total de todos os arranjos de veículos: " + precoTotal);
    }

    private static void calcularPrecoTotalCliente(ArranjoVeiculo[] arrayArranjos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza o ID do cliente:");
        int idCliente = scanner.nextInt();

        float precoTotalCliente = 0;

        for (ArranjoVeiculo arranjo : arrayArranjos) {
            if (arranjo != null && arranjo.getIdCliente() == idCliente) {
                precoTotalCliente += arranjo.getCustoTotal();
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("Preço total dos arranjos de veículos do cliente " + idCliente + ": " + precoTotalCliente);
        System.out.println("---------------------------------------");
    }

    private static void apresentarInfoPrecoExtremo(ArranjoVeiculo[] arrayArranjos) {
        ArranjoVeiculo arranjoPrecoMaisBaixo = null;
        ArranjoVeiculo arranjoPrecoMaisAlto = null;

        for (ArranjoVeiculo arranjo : arrayArranjos) {
            if (arranjo != null) {
                if (arranjoPrecoMaisBaixo == null || arranjo.getCustoTotal() < arranjoPrecoMaisBaixo.getCustoTotal()) {
                    arranjoPrecoMaisBaixo = arranjo;
                }
                if (arranjoPrecoMaisAlto == null || arranjo.getCustoTotal() > arranjoPrecoMaisAlto.getCustoTotal()) {
                    arranjoPrecoMaisAlto = arranjo;
                }
            }
        }

        if (arranjoPrecoMaisBaixo != null) {
            System.out.println("---------------------------------------");
            System.out.println("Informações do arranjo com preço mais baixo:");
            System.out.println("ID do Arranjo: " + arranjoPrecoMaisBaixo.getIdArranjo());
            System.out.println("Matrícula do Veículo: " + arranjoPrecoMaisBaixo.getMatricula());
            System.out.println("Tipo de Veículo: " + arranjoPrecoMaisBaixo.getTipoVeiculo());
            System.out.println("Custo Total: " + arranjoPrecoMaisBaixo.getCustoTotal());
            System.out.println("Data do Arranjo: " + arranjoPrecoMaisBaixo.getDataArranjo());
            System.out.println("Observações: " + arranjoPrecoMaisBaixo.getObservacoes());
            System.out.println("---------------------------------------");
        } else {
            System.out.println("Não há arranjos registados.");
        }

        if (arranjoPrecoMaisAlto != null) {
            System.out.println("\n\n---------------------------------------");
            System.out.println("Informações do arranjo com preço mais alto:");
            System.out.println("ID do Arranjo: " + arranjoPrecoMaisAlto.getIdArranjo());
            System.out.println("Matrícula do Veículo: " + arranjoPrecoMaisAlto.getMatricula());
            System.out.println("Tipo de Veículo: " + arranjoPrecoMaisAlto.getTipoVeiculo());
            System.out.println("Custo Total: " + arranjoPrecoMaisAlto.getCustoTotal());
            System.out.println("Data do Arranjo: " + arranjoPrecoMaisAlto.getDataArranjo());
            System.out.println("Observações: " + arranjoPrecoMaisAlto.getObservacoes());
            System.out.println("---------------------------------------");
        } else {
            System.out.println("Nao ha arranjos registados.");
        }
    }

    private static float calcularImposto(ArranjoVeiculo[] arrayArranjos) {
        // impostos sobre a oficina pelos arranjos
        float imposto18 = 0; // 18%
        float imposto21 = 0; // 21%

        for (ArranjoVeiculo arranjo : arrayArranjos) {
            if (arranjo != null) {
                // verifica o custo e faz o calculo do imposto na base do total de custo
                float custoTotal = arranjo.getCustoTotal();
                if (custoTotal < 55) {
                    imposto18 += custoTotal * 0.18;
                } else {
                    imposto21 += custoTotal * 0.21;
                }
            }

        }
        System.out.println("---------------------------------------");
        System.out.println("Total de imposto (18%): " + imposto18);
        System.out.println("Total de imposto (21%): " + imposto21);
        System.out.println("---------------------------------------");

        return imposto18 + imposto21;
    }

}
