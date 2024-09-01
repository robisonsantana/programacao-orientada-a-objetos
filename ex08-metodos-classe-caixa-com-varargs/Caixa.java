public class Caixa {
    private double saldo;

    public void venda(double... valorProduto) {
        for(double produtos : valorProduto) {
            saldo += produtos;
        }
        System.out.println("Venda realizada! \nValor atual no caixa: " + saldo);
    }
}
