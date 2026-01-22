import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


    /* Na classe Pessoa, eu guardei nome, data de nascimento e altura,
    criei getters e setters e um método que calcula a idade usando a data atual.*/

public class Pessoa {
    private String nome;
    private String dataNascimento;
    private double altura; //“altura é um número com decimais e só pode ser acessada pela própria classe”.

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Altura: " + altura);
    }

    public int calcularIdade() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNasc = LocalDate.parse(dataNascimento, formato);

        LocalDate hoje = LocalDate.now();
        Period idade = Period.between(dataNasc, hoje);

        return idade.getYears();
    }
}
