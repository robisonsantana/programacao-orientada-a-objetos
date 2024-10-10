public class Main {
    public static void main(String[] args) {
        Funcionario func = new Funcionario("João");
        Produto prod = new Produto("Notebook", 2500.0);

        Caixa caixa = new Caixa(5000.0, func, prod);

        caixa.venda();

        Caixa caixa2 = new Caixa();
        caixa2.setFuncionario(new Funcionario("Maria"));
        caixa2.setProduto(new Produto("Smartphone", 1500.0));
        caixa2.venda();
    }
}