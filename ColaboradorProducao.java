public class ColaboradorProducao extends Colaborador {

    private int quantidadePecas;
    private double valorPorPeca;

    public ColaboradorProducao(int matricula, String nome, int quantidadePecas, double valorPorPeca) {
        super(matricula, nome);
        this.quantidadePecas = quantidadePecas;
        this.valorPorPeca = valorPorPeca;
    }

    public int getQuantidadePecas() {
        return quantidadePecas;
    }

    public void setQuantidadePecas(int quantidadePecas) {
        this.quantidadePecas = quantidadePecas;
    }

    public double getValorPorPeca() {
        return valorPorPeca;
    }

    public void setValorPorPeca(double valorPorPeca) {
        this.valorPorPeca = valorPorPeca;
    }

    public double calcularProdutividade() {
        return quantidadePecas * valorPorPeca;
    }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase() + calcularProdutividade();
    }

    @Override
    public String getTipo() {
        return "Producao";
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.printf("Produtividade: R$ %.2f (%d pecas x R$ %.2f)%n",
                calcularProdutividade(), quantidadePecas, valorPorPeca);
        System.out.printf("Salario Final: R$ %.2f%n", calcularSalarioFinal());
    }
}
