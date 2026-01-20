import java.util.Scanner;

public class ControleGestao {

    // Variáveis principais do sistema
    static int id = 0;
    static String nome = "";
    static boolean ativo = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Menu usando FOR (conforme exigido)
        for (int i = 0; i < 10; i++) {

            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            if (opcao == 1) {
                cadastrarUsuario(scanner);
            } else if (opcao == 2) {
                consultarUsuario();
            } else if (opcao == 3) {
                atualizarUsuario(scanner);
            } else if (opcao == 4) {
                deletarUsuario();
            } else if (opcao == 0) {
                System.out.println("Saindo do sistema...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n==============================");
        System.out.println(" Sistema de Controle de Gestão");
        System.out.println(" Deloitte Bootcamp - Java");
        System.out.println("==============================");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Consultar usuário");
        System.out.println("3 - Atualizar usuário");
        System.out.println("4 - Deletar usuário");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarUsuario(Scanner scanner) {
        if (!ativo) {
            System.out.print("Digite o ID: ");
            id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite o nome: ");
            nome = scanner.nextLine();

            ativo = true;
            System.out.println("Usuário cadastrado com sucesso!");
        } else {
            System.out.println("Já existe um usuário cadastrado.");
        }
    }

    private static void consultarUsuario() {
        if (ativo) {
            System.out.println("ID: " + id);
            System.out.println("Nome: " + nome);
            System.out.println("Status: ATIVO");
        } else {
            System.out.println("Nenhum usuário cadastrado no sistema.");
        }
    }

    private static void atualizarUsuario(Scanner scanner) {
        if (ativo) {
            System.out.print("Digite o novo nome: ");
            nome = scanner.nextLine();
            System.out.println("Usuário atualizado com sucesso!");
        } else {
            System.out.println("Não existe usuário para atualizar.");
        }
    }

    private static void deletarUsuario() {
        if (ativo) {
            ativo = false;
            id = 0;
            nome = "";
            System.out.println("Usuário deletado com sucesso.");
        } else {
            System.out.println("Não existe usuário para deletar.");
        }
    }
}
