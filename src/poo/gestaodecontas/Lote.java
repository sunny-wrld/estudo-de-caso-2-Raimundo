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
    }
    public int getNumero() {
        return this.numero;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public Lance getMaiorLance() {
        return this.maiorLance;
    }
    public boolean lancePara(Pessoa licitante, double valor) {
        if (valor >= this.valorMinimo &&
                (this.maiorLance == null || (this.maiorLance.getValor() < valor))) {
            this.maiorLance = new Lance(licitante, valor);
            return true;
        } else {
            return false;
        }
    }
    public String toString() {
        StringBuilder lote = new StringBuilder();
        lote.append("Lote numero: ")
                .append(this.numero)
                .append("\n")
                .append(this.descricao);
        Lance melhorLance = this.getMaiorLance();
        if (melhorLance != null) {
            lote.append(" Lance: " + melhorLance.getValor());
        } else {
            lote.append(" (Nenhum Lance)");
        }
        lote.append("\n");
        return lote.toString();
    }
}