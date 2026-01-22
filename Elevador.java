public class Elevador {


   /* Já na classe Elevador, eu controlei o estado do elevador, como andar atual e quantidade de pessoas, e criei métodos
   que impedem ações inválidas, como subir além do último andar ou exceder a capacidade. */

    private int andarAtual;
    private int totalAndares;
    private int capacidade;
    private int pessoasPresentes;

    public void inicializa(int capacidade, int totalAndares) {
        this.capacidade = capacidade;
        this.totalAndares = totalAndares;
        this.andarAtual = 0;
        this.pessoasPresentes = 0;
    }

    public void entra() {
        if (pessoasPresentes < capacidade) {
            pessoasPresentes++;
        } else {
            System.out.println("Elevador cheio!");
        }
    }

    public void sai() {
        if (pessoasPresentes > 0) {
            pessoasPresentes--;
        } else {
            System.out.println("Elevador vazio!");
        }
    }

    public void sobe() {
        if (andarAtual < totalAndares - 1) {
            andarAtual++;
        } else {
            System.out.println("Já está no último andar!");
        }
    }

    public void desce() {
        if (andarAtual > 0) {
            andarAtual--;
        } else {
            System.out.println("Já está no térreo!");
        }
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public int getTotalAndares() {
        return totalAndares;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getPessoasPresentes() {
        return pessoasPresentes;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public void setTotalAndares(int totalAndares) {
        this.totalAndares = totalAndares;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setPessoasPresentes(int pessoasPresentes) {
        this.pessoasPresentes = pessoasPresentes;
    }

    public void imprimirDados() {
        System.out.println("=== Estado do Elevador ===");
        System.out.println("Andar atual: " + andarAtual);
        System.out.println("Total de andares: " + totalAndares);
        System.out.println("Capacidade: " + capacidade + " pessoas");
        System.out.println("Pessoas presentes: " + pessoasPresentes);
        System.out.println("==========================");
    }
}
