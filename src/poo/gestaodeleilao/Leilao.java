package poo.gestaodeleilao;

import poo.gestaodecontas.Lote;
import poo.gestaodecontas.Pessoa;

public class Leilao {
    private BDLotes lotes;
    private Interface terminal;
    private boolean ativo;
    public Leilao() {
        this.lotes = new BDLotes();
        this.terminal = new Interface(this);
    }
    public boolean isAtivo() {
        return this.ativo;
    }
    public void setAtivo(boolean encerrado) {
        this.ativo = encerrado;
    }
    public void adicionaLote(String descricao) {
        this.lotes.adicionaLote(descricao);
    }
    public Lote removeLote(int numero) {
        return this.lotes.removeLote(numero);
    }
    public int quantidadeDeLotes() {
        return this.lotes.quantidadeDeLotes();
    }
    public Lote getLote(int numero) {
        return this.lotes.buscaLote(numero);
    }
    public String ofertaLance(int numeroLote, String nomePessoa, double valor) {
        Lote lote = this.getLote(numeroLote);
        if(lote == null) {
            return "Lote Inexistente";
        }
        if(lote.lancePara(new Pessoa(nomePessoa), valor)) {
            return "Lance bem sucedido";
        }
        return "Lote no: " + lote.getNumero() + "("
                + lote.getDescricao() + ")"

                + "Atualmente tem um lance de: "
                + lote.getMaiorLance().getValor();
    }
    public String obtemTodosOsLotes() {
        ArrayList<Lote> lotes = this.lotes.getTodosOsLotes();
        StringBuilder todosOsLotes = new StringBuilder();
        for (Lote lote : lotes) {
            todosOsLotes.append(lote.toString())
                    .append("\n");
        }
        return todosOsLotes.toString();
    }
}
