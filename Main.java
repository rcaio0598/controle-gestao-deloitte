import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);


    // Método auxiliar para repetir strings (compatibilidade com Java < 11)
    private static String repetir(String texto, int vezes) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < vezes; i++) {
            resultado.append(texto);
        }
        return resultado.toString();
    }
    
    // Método auxiliar para ler números decimais (aceita vírgula ou ponto)
    private static double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            
            // Substitui vírgula por ponto
            entrada = entrada.replace(",", ".");
            
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("❌ Erro! Digite um número válido (ex: 1.75 ou 1,75)");
            }
        }
    }
    
    // Método auxiliar para ler números inteiros
    private static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("❌ Erro! Digite um número inteiro válido (ex: 5)");
            }
        }
    }
    
    // Método auxiliar para ler texto (não vazio)
    private static String lerTexto(String mensagem) {
        String texto;
        do {
            System.out.print(mensagem);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("❌ Erro! Este campo não pode estar vazio.");
            }
        } while (texto.isEmpty());
        return texto;
    }
    
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║     SISTEMA DE TESTE DE ENCAPSULAMENTO                ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");

        /* Usei encapsulamento, criei métodos para controlar o comportamento das classes
        e testei tudo em um main imprimindo no terminal. */

        // ========== CLASSE PESSOA ==========
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║  1️⃣  CADASTRO DA CLASSE PESSOA                       ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
        
        Pessoa pessoa = new Pessoa();
        
        pessoa.setNome(lerTexto("👤 Nome da pessoa: "));
        pessoa.setDataNascimento(lerTexto("📅 Data de nascimento (dd/MM/yyyy, ex: 15/03/1990): "));
        pessoa.setAltura(lerDouble("📏 Altura em metros (ex: 1.75 ou 1,75): "));
        
        System.out.println("\n✅ Dados cadastrados com sucesso!");
        System.out.println("\n" + repetir("─", 55));
        System.out.println("📋 DADOS DA PESSOA:");
        System.out.println(repetir("─", 55));
        pessoa.imprimirDados();
        System.out.println("🎂 Idade: " + pessoa.calcularIdade() + " anos");
        System.out.println(repetir("─", 55) + "\n");

        // ========== CLASSE JOGADOR FUTEBOL ==========
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║  2️⃣  CADASTRO DA CLASSE JOGADOR DE FUTEBOL            ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
        
        JogadorFutebol jogador = new JogadorFutebol();
        
        jogador.setNome(lerTexto("👤 Nome do jogador: "));
        System.out.println("⚽ Posições disponíveis: defesa | meio-campo | atacante");
        jogador.setPosicao(lerTexto("⚽ Posição do jogador: "));
        jogador.setDataNascimento(lerTexto("📅 Data de nascimento (dd/MM/yyyy, ex: 05/02/1992): "));
        jogador.setNacionalidade(lerTexto("🌍 Nacionalidade: "));
        jogador.setAltura(lerDouble("📏 Altura em metros (ex: 1.75 ou 1,75): "));
        jogador.setPeso(lerDouble("⚖️  Peso em kg (ex: 68.0 ou 68,0): "));
        
        System.out.println("\n✅ Dados cadastrados com sucesso!");
        System.out.println("\n" + repetir("─", 55));
        System.out.println("📋 DADOS DO JOGADOR:");
        System.out.println(repetir("─", 55));
        jogador.imprimirDados();
        System.out.println("🎂 Idade: " + jogador.calcularIdade() + " anos");
        int tempoAposentar = jogador.tempoParaAposentar();
        if (tempoAposentar > 0) {
            System.out.println("⏰ Tempo para aposentar: " + tempoAposentar + " anos");
        } else {
            System.out.println("✅ Já pode se aposentar!");
        }
        System.out.println(repetir("─", 55) + "\n");

        // ========== CLASSE ELEVADOR ==========
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║  3️⃣  CONFIGURAÇÃO DA CLASSE ELEVADOR                 ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
        
        Elevador elevador = new Elevador();
        
        int capacidade = lerInt("👥 Capacidade do elevador (número de pessoas): ");
        int totalAndares = lerInt("🏢 Total de andares (sem contar o térreo): ");
        
        elevador.inicializa(capacidade, totalAndares);
        
        System.out.println("\n✅ Elevador configurado com sucesso!");
        System.out.println("\n" + repetir("─", 55));
        System.out.println("📋 ESTADO INICIAL DO ELEVADOR:");
        System.out.println(repetir("─", 55));
        elevador.imprimirDados();
        System.out.println(repetir("─", 55));
        
        // ========== INTERAÇÃO COM ELEVADOR ==========
        System.out.println("\n╔═══════════════════════════════════════════════════════╗");
        System.out.println("║  4️⃣  INTERAÇÃO COM O ELEVADOR                        ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
        System.out.println("\n📝 COMANDOS DISPONÍVEIS:");
        System.out.println("   • entrar  → Adiciona uma pessoa ao elevador");
        System.out.println("   • sair    → Remove uma pessoa do elevador");
        System.out.println("   • subir   → Sobe um andar");
        System.out.println("   • descer  → Desce um andar");
        System.out.println("   • status  → Mostra o estado atual do elevador");
        System.out.println("   • fim     → Encerra o programa");
        System.out.println("\n" + repetir("─", 55) + "\n");
        
        String comando;
        do {
            System.out.print("🎮 Digite um comando: ");
            comando = scanner.nextLine().toLowerCase().trim();
            
            switch (comando) {
                case "entrar":
                    elevador.entra();
                    break;
                case "sair":
                    elevador.sai();
                    break;
                case "subir":
                    elevador.sobe();
                    break;
                case "descer":
                    elevador.desce();
                    break;
                case "status":
                    System.out.println("\n" + repetir("─", 55));
                    System.out.println("📋 ESTADO ATUAL DO ELEVADOR:");
                    System.out.println(repetir("─", 55));
                    elevador.imprimirDados();
                    System.out.println(repetir("─", 55));
                    break;
                case "fim":
                    System.out.println("\n👋 Encerrando programa...");
                    break;
                default:
                    System.out.println("❌ Comando inválido! Use: entrar, sair, subir, descer, status ou fim");
            }
            System.out.println();
        } while (!comando.equals("fim"));
        
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║           FIM DO PROGRAMA - OBRIGADO!                ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
        scanner.close();
    }
}