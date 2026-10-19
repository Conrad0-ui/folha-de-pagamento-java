public class ColaboradorPadrao extends Colaborador {

    public ColaboradorPadrao(int matricula, String nome) {
        super(matricula, nome);
    }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase();
    }

    @Override
    public String getTipo() {
        return "Padrao";
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Beneficio adicional: nenhum");
        System.out.printf("Salario Final: R$ %.2f%n", calcularSalarioFinal());
    }
}
