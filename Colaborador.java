public class Colaborador {

    public static final double SALARIO_BASE = 2000.00;

    private int matricula;
    private String nome;
    private double salarioBase;

    public Colaborador(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.salarioBase = SALARIO_BASE;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double calcularSalarioFinal() {
        return salarioBase;
    }

    public String getTipo() {
        return "Colaborador";
    }

    public void exibirDados() {
        System.out.println("Matricula: " + matricula);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + getTipo());
        System.out.printf("Salario Base: R$ %.2f%n", salarioBase);
    }
}
