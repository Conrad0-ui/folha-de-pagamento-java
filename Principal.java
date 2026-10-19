import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Colaborador> colaboradores = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;

        do {
            mostrarMenu();
            opcao = lerInteiro("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    cadastrarPadrao();
                    break;
                case 2:
                    cadastrarComissionado();
                    break;
                case 3:
                    cadastrarProducao();
                    break;
                case 4:
                    gerarFolha();
                    break;
                case 5:
                    exibirResumo();
                    break;
                case 0:
                    System.out.println("Saindo do programa... ate mais!");
                    break;
                default:
                    System.out.println("Opcao invalida, tente de novo.");
            }
        } while (opcao != 0);

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println();
        System.out.println("===== FOLHA DE PAGAMENTO =====");
        System.out.println("1 - Cadastrar Colaborador Padrao");
        System.out.println("2 - Cadastrar Colaborador Comissionado");
        System.out.println("3 - Cadastrar Colaborador Producao");
        System.out.println("4 - Gerar Folha de Pagamento");
        System.out.println("5 - Exibir Resumo da Folha");
        System.out.println("0 - Sair do Programa");
    }

    static void cadastrarPadrao() {
        System.out.println("\n-- Cadastro de Colaborador Padrao --");
        int matricula = lerMatricula();
        String nome = lerNome();
        colaboradores.add(new ColaboradorPadrao(matricula, nome));
        System.out.println("Colaborador cadastrado com sucesso!");
    }

    static void cadastrarComissionado() {
        System.out.println("\n-- Cadastro de Colaborador Comissionado --");
        int matricula = lerMatricula();
        String nome = lerNome();
        double vendas = lerDoublePositivo("Valor total de vendas no mes: R$ ");
        double percentual = lerDoublePositivo("Percentual de comissao (%): ");
        colaboradores.add(new ColaboradorComissionado(matricula, nome, vendas, percentual));
        System.out.println("Colaborador cadastrado com sucesso!");
    }

    static void cadastrarProducao() {
        System.out.println("\n-- Cadastro de Colaborador de Producao --");
        int matricula = lerMatricula();
        String nome = lerNome();
        int pecas = lerInteiroPositivo("Quantidade de pecas produzidas: ");
        double valorPeca = lerDoublePositivo("Valor por peca: R$ ");
        colaboradores.add(new ColaboradorProducao(matricula, nome, pecas, valorPeca));
        System.out.println("Colaborador cadastrado com sucesso!");
    }

    static void gerarFolha() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado ainda.");
            return;
        }
        System.out.println("\n========== FOLHA DE PAGAMENTO ==========");
        for (Colaborador c : colaboradores) {
            c.exibirDados();
            System.out.println("----------------------------------------");
        }
    }

    static void exibirResumo() {
        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado ainda.");
            return;
        }
        double total = calcularTotalFolha();
        System.out.println("\n========== RESUMO DA FOLHA ==========");
        System.out.println("Quantidade de colaboradores: " + colaboradores.size());
        System.out.printf("Total da folha: R$ %.2f%n", total);
        System.out.printf("Media salarial: R$ %.2f%n", calcularMedia(total));
    }

    static double calcularTotalFolha() {
        double total = 0;
        for (Colaborador c : colaboradores) {
            total += c.calcularSalarioFinal();
        }
        return total;
    }

    static double calcularMedia(double total) {
        return total / colaboradores.size();
    }

    static int lerMatricula() {
        while (true) {
            int matricula = lerInteiroPositivo("Matricula: ");
            if (matricula == 0) {
                System.out.println("Matricula nao pode ser zero.");
            } else if (matriculaExiste(matricula)) {
                System.out.println("Ja existe colaborador com essa matricula.");
            } else {
                return matricula;
            }
        }
    }

    static boolean matriculaExiste(int matricula) {
        for (Colaborador c : colaboradores) {
            if (c.getMatricula() == matricula) {
                return true;
            }
        }
        return false;
    }

    static String lerNome() {
        String nome;
        do {
            System.out.print("Nome completo: ");
            nome = sc.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("O nome nao pode ficar vazio.");
            }
        } while (nome.isEmpty());
        return nome;
    }

    static int lerInteiro(String msg) {
        while (true) {
            System.out.print(msg);
            String linha = sc.nextLine().trim();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }

    static int lerInteiroPositivo(String msg) {
        int valor;
        do {
            valor = lerInteiro(msg);
            if (valor < 0) {
                System.out.println("Nao pode ser negativo.");
            }
        } while (valor < 0);
        return valor;
    }

    static double lerDoublePositivo(String msg) {
        while (true) {
            System.out.print(msg);
            String linha = sc.nextLine().trim().replace(",", ".");
            try {
                double valor = Double.parseDouble(linha);
                if (valor < 0) {
                    System.out.println("Nao pode ser negativo.");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido.");
            }
        }
    }
}
