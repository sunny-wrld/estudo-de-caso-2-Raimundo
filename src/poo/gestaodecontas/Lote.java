package poo.gestaodecontas;

public class Lote {
    private int numero;
    private String descricao;
    private double valorMinimo;
    private Lance maiorLance;

    public Lote(int numero, String descricao, double valorMinimo) {
        this.numero = numero;
        this.descricao = descricao;
        this.valorMinimo = valorMinimo;
        this.maiorLance = null;
    }

    public int getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorMinimo() {
        return valorMinimo;
    }

    public Lance getMaiorLance() {
        return maiorLance;
    }

    public boolean lancePara(Pessoa pessoa, double valor) {
        if (valor >= valorMinimo && (maiorLance == null || valor > maiorLance.getValor())) {
            maiorLance = new Lance(pessoa, valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Lote " + numero + ": " + descricao + " (mínimo: R$" + valorMinimo + ")";
    }
}