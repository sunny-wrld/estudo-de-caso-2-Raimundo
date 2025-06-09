package poo.gestaodeleilao;

import poo.gestaodecontas.Lote;

public class BDLotes {
    private ArrayList<Lote> lotes;
    private int numeroProxLote;
    public CadastroLotes() {
        this.lotes = new ArrayList<>();
        this.numeroProxLote = 1;
    }
    public void adicionaLote(String descricao, double valorMinimo) {
        this.lotes.add(new Lote(this.numeroProxLote, descricao, valorMinimo));
        this.numeroProxLote++;
    }
    public Lote buscaLote(int numero) {
        if ((numero >= 1) && (numero < this.numeroProxLote)) {
            for (Lote loteSelecionado : lotes) {
                if(loteSelecionado.getNumero() == numero) {
                    return loteSelecionado;
                }

            }
        }
        return null;
    }
    public ArrayList<Lote> getTodosOsLotes() {
        return (ArrayList<Lote>) this.lotes.clone();
    }
    public int quantidadeDeLotes() {
        return this.lotes.size();
    }
}