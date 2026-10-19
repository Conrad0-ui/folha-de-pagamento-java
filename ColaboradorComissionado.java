public class ColaboradorComissionado extends Colaborador {

    private double valorVendas;
    private double percentualComissao;

    public ColaboradorComissionado(int matricula, String nome, double valorVendas, double percentualComissao) {
        super(matricula, nome);
        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public double calcularComissao() {
        return valorVendas * percentualComissao / 100;
    }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase() + calcularComissao();
    }

    @Override
    public String getTipo() {
        return "Comissionado";
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.printf("Comissao: R$ %.2f (vendas R$ %.2f x %.1f%%)%n",
                calcularComissao(), valorVendas, percentualComissao);
        System.out.printf("Salario Final: R$ %.2f%n", calcularSalarioFinal());
    }
}
