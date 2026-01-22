import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


    /* Na classe Jogador, além dos dados pessoais, eu implementei uma regra de negócio para aposentadoria,
    onde a idade de saída muda conforme a posição do jogador.*/

public class JogadorFutebol {
    public String nome;
    public String posicao;
    public String dataNascimento;
    public String nacionalidade;
    public double altura;
    public double peso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Posição: " + posicao);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Nacionalidade: " + nacionalidade);
        System.out.println("Altura: " + altura);
        System.out.println("Peso: " + peso);
    }

    public int calcularIdade() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNasc = LocalDate.parse(dataNascimento, formato);

        LocalDate hoje = LocalDate.now();
        Period idade = Period.between(dataNasc, hoje);

        return idade.getYears();
    }

    public int tempoParaAposentar() {
        int idade = calcularIdade();
        int idadeAposentadoria;

        if (posicao.equalsIgnoreCase("defesa")) {
            idadeAposentadoria = 40;
        } else if (posicao.equalsIgnoreCase("meio-campo")) {
            idadeAposentadoria = 38;
        } else {
            idadeAposentadoria = 35;
        }

        return idadeAposentadoria - idade;
    }
}
