public class Caixa {
    private double saldo;

    public void venda(double valorProduto) {
        saldo += valorProduto;
        System.out.println("Venda realizada! \nValor atual no caixa: " + saldo);
    }
}