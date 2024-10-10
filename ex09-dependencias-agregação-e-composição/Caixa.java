public class Caixa {
    private double saldo;
    private Funcionario funcionario;
    private Produto produto;

    public Caixa(double saldo, Funcionario funcionario, Produto produto) {
        this.saldo = saldo;
        this.funcionario = funcionario;
        this.produto = produto;
    }

    public Caixa() {
        this.saldo = 0.0;
        this.funcionario = null;
        this.produto = null;
    }

    public void venda() {
        if (produto != null) {
            saldo += produto.getPreco();
            System.out.println("Venda realizada: " + produto.getNome() + ". Novo saldo: " + saldo);
        } else {
            System.out.println("Nenhum produto foi associado ao caixa.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
