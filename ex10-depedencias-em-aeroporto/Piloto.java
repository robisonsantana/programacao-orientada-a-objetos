public class Piloto extends Pessoa {
    private String licenca;
    private int horasVoo;
    private String especializacao;

    public Piloto(String nome, int idade, String documento, String licenca, int horasVoo, String especializacao) {
        super(nome, idade, documento);
        this.licenca = licenca;
        this.horasVoo = horasVoo;
        this.especializacao = especializacao;
    }

    public void pilotar() {
        System.out.println(super.getNome() + " está pilotando.");
    }

    public String getLicenca() {
        return licenca;
    }

    public void setLicenca(String licenca) {
        this.licenca = licenca;
    }

    public int getHorasVoo() {
        return horasVoo;
    }

    public void setHorasVoo(int horasVoo) {
        this.horasVoo = horasVoo;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
}
