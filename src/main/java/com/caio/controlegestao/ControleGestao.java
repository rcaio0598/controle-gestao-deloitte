package com.caio.controlegestao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControleGestao {

    private static List<Usuario> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   Sistema de Controle de Gestão      ║");
        System.out.println("║   Deloitte Bootcamp - Java            ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        int opcao;
        
        do {
            exibirMenu();
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    consultarUsuario();
                    break;
                case 3:
                    listarTodosUsuarios();
                    break;
                case 4:
                    atualizarUsuario();
                    break;
                case 5:
                    deletarUsuario();
                    break;
                case 0:
                    System.out.println("\n✓ Obrigado por usar o sistema! Até logo!");
                    break;
                default:
                    System.out.println("\n⚠ Opção inválida! Por favor, escolha uma opção do menu.");
            }
            
            if (opcao != 0) {
                pausar();
            }
            
        } while (opcao != 0);
        
        scanner.close();
    }

    private static void exibirMenu() {
        String linha = repetir("═", 40);
        System.out.println("\n" + linha);
        System.out.println("            MENU PRINCIPAL");
        System.out.println(linha);
        System.out.println("  1  →  Cadastrar novo usuário");
        System.out.println("  2  →  Consultar usuário por ID");
        System.out.println("  3  →  Listar todos os usuários");
        System.out.println("  4  →  Atualizar usuário");
        System.out.println("  5  →  Deletar usuário");
        System.out.println("  0  →  Sair do sistema");
        System.out.println(linha);
        System.out.print("  Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            return opcao;
        } catch (Exception e) {
            scanner.nextLine(); // Limpa o buffer em caso de erro
            return -1;
        }
    }

    private static void cadastrarUsuario() {
        String linha = repetir("─", 40);
        System.out.println("\n" + linha);
        System.out.println("  📝 CADASTRAR NOVO USUÁRIO");
        System.out.println(linha);
        
        System.out.print("  Digite o ID: ");
        int id = lerInteiro();
        
        if (id <= 0) {
            System.out.println("\n  ❌ Erro: ID deve ser um número positivo!");
            return;
        }
        
        // Verifica se já existe um usuário ativo com esse ID
        if (existeUsuarioAtivo(id)) {
            System.out.println("\n  ❌ Erro: Já existe um usuário ativo com o ID " + id + "!");
            return;
        }
        
        System.out.print("  Digite o nome: ");
        String nome = scanner.nextLine().trim();
        
        if (nome.isEmpty()) {
            System.out.println("\n  ❌ Erro: O nome não pode estar vazio!");
            return;
        }
        
        usuarios.add(new Usuario(id, nome));
        System.out.println("\n  ✓ Usuário cadastrado com sucesso!");
        System.out.println("    " + usuarios.get(usuarios.size() - 1));
    }

    private static void consultarUsuario() {
        String linha = repetir("─", 40);
        System.out.println("\n" + linha);
        System.out.println("  🔍 CONSULTAR USUÁRIO");
        System.out.println(linha);
        
        System.out.print("  Digite o ID para consultar: ");
        int id = lerInteiro();
        
        if (id <= 0) {
            System.out.println("\n  ❌ Erro: ID inválido!");
            return;
        }
        
        Usuario usuario = buscarUsuarioAtivo(id);
        
        if (usuario != null) {
            System.out.println("\n  ✓ Usuário encontrado:");
            System.out.println("    " + usuario);
        } else {
            System.out.println("\n  ❌ Usuário não encontrado ou inativo.");
        }
    }

    private static void listarTodosUsuarios() {
        String linha = repetir("─", 40);
        System.out.println("\n" + linha);
        System.out.println("  📋 LISTAR TODOS OS USUÁRIOS");
        System.out.println(linha);
        
        List<Usuario> usuariosAtivos = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.isAtivo()) {
                usuariosAtivos.add(usuario);
            }
        }
        
        if (usuariosAtivos.isEmpty()) {
            System.out.println("\n  ℹ Nenhum usuário cadastrado no sistema.");
        } else {
            System.out.println("\n  Total de usuários ativos: " + usuariosAtivos.size());
            String linhaLista = repetir("─", 38);
            System.out.println("\n  " + linhaLista);
            for (int i = 0; i < usuariosAtivos.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + usuariosAtivos.get(i));
            }
            System.out.println("  " + linhaLista);
        }
    }

    private static void atualizarUsuario() {
        String linha = repetir("─", 40);
        System.out.println("\n" + linha);
        System.out.println("  ✏️  ATUALIZAR USUÁRIO");
        System.out.println(linha);
        
        System.out.print("  Digite o ID do usuário a ser atualizado: ");
        int id = lerInteiro();
        
        if (id <= 0) {
            System.out.println("\n  ❌ Erro: ID inválido!");
            return;
        }
        
        Usuario usuario = buscarUsuarioAtivo(id);
        
        if (usuario == null) {
            System.out.println("\n  ❌ Usuário não encontrado ou inativo.");
            return;
        }
        
        System.out.println("\n  Usuário atual:");
        System.out.println("    " + usuario);
        
        System.out.print("\n  Digite o novo nome: ");
        String novoNome = scanner.nextLine().trim();
        
        if (novoNome.isEmpty()) {
            System.out.println("\n  ❌ Erro: O nome não pode estar vazio!");
            return;
        }
        
        String nomeAntigo = usuario.getNome();
        usuario.setNome(novoNome);
        
        System.out.println("\n  ✓ Usuário atualizado com sucesso!");
        System.out.println("    Nome anterior: " + nomeAntigo);
        System.out.println("    Nome atual: " + usuario.getNome());
    }

    private static void deletarUsuario() {
        String linha = repetir("─", 40);
        System.out.println("\n" + linha);
        System.out.println("  🗑️  DELETAR USUÁRIO");
        System.out.println(linha);
        
        System.out.print("  Digite o ID do usuário a ser deletado: ");
        int id = lerInteiro();
        
        if (id <= 0) {
            System.out.println("\n  ❌ Erro: ID inválido!");
            return;
        }
        
        Usuario usuario = buscarUsuarioAtivo(id);
        
        if (usuario == null) {
            System.out.println("\n  ❌ Usuário não encontrado ou já está inativo.");
            return;
        }
        
        System.out.println("\n  Usuário a ser deletado:");
        System.out.println("    " + usuario);
        
        System.out.print("\n  Tem certeza que deseja deletar? (s/n): ");
        String confirmacao = scanner.nextLine().trim().toLowerCase();
        
        if (confirmacao.equals("s") || confirmacao.equals("sim")) {
            usuario.desativar();
            System.out.println("\n  ✓ Usuário deletado com sucesso!");
        } else {
            System.out.println("\n  ℹ Operação cancelada.");
        }
    }

    // Métodos auxiliares
    private static Usuario buscarUsuarioAtivo(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id && usuario.isAtivo()) {
                return usuario;
            }
        }
        return null;
    }

    private static boolean existeUsuarioAtivo(int id) {
        return buscarUsuarioAtivo(id) != null;
    }

    private static int lerInteiro() {
        try {
            int valor = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            return valor;
        } catch (Exception e) {
            scanner.nextLine(); // Limpa o buffer em caso de erro
            return -1;
        }
    }

    private static void pausar() {
        System.out.print("\n  Pressione ENTER para continuar...");
        scanner.nextLine();
    }

    private static String repetir(String texto, int vezes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vezes; i++) {
            sb.append(texto);
        }
        return sb.toString();
    }
}
