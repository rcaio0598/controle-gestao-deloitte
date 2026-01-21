import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControleGestao {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>(); // LISTA DE USUÁRIOS
        int opcao;

        while (true) {

            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                // CADASTRAR
                System.out.print("Digite o ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Digite o nome: ");
                String nome = scanner.nextLine();

                // VALIDAÇÃO: ID repetido
                boolean existe = false;
                for (Usuario u : usuarios) {
                    if (u.getId() == id && u.isAtivo()) {
                        existe = true;
                        break;
                    }
                }

                if (existe) {
                    System.out.println("Erro: já existe um usuário com esse ID.");
                } else if (nome.isBlank()) {
                    System.out.println("Erro: nome não pode ser vazio.");
                } else {
                    usuarios.add(new Usuario(id, nome));
                    System.out.println("Usuário cadastrado com sucesso!");
                }

            } else if (opcao == 2) {
                // CONSULTAR
                System.out.print("Digite o ID para consultar: ");
                int idConsulta = scanner.nextInt();
                scanner.nextLine();

                boolean encontrado = false;

                for (Usuario u : usuarios) {
                    if (u.getId() == idConsulta && u.isAtivo()) {
                        System.out.println("ID: " + u.getId());
                        System.out.println("Nome: " + u.getNome());
                        System.out.println("Status: ATIVO");
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Usuário não encontrado.");
                }

            } else if (opcao == 3) {
                // ATUALIZAR
                System.out.print("Digite o ID para atualizar: ");
                int idAtualizar = scanner.nextInt();
                scanner.nextLine();

                boolean encontrado = false;

                for (Usuario u : usuarios) {
                    if (u.getId() == idAtualizar && u.isAtivo()) {
                        System.out.print("Digite o novo nome: ");
                        String novoNome = scanner.nextLine();

                        if (novoNome.isBlank()) {
                            System.out.println("Erro: nome não pode ser vazio.");
                        } else {
                            u.setNome(novoNome);
                            System.out.println("Usuário atualizado com sucesso!");
                        }

                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Usuário não encontrado.");
                }

            } else if (opcao == 4) {
                // DELETAR
                System.out.print("Digite o ID para deletar: ");
                int idDeletar = scanner.nextInt();
                scanner.nextLine();

                boolean encontrado = false;

                for (Usuario u : usuarios) {
                    if (u.getId() == idDeletar && u.isAtivo()) {
                        u.desativar();
                        System.out.println("Usuário deletado com sucesso.");
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Usuário não encontrado.");
                }

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
}
