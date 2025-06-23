package poo.gestaodeleilao;

import poo.gestaodecontas.Lote;
import java.util.ArrayList;

public class BDLotes {
    private ArrayList<Lote> lotes = new ArrayList<>();
    private int proximoNumero = 1;

    public void adicionaLote(String descricao, double valorMinimo) {
        lotes.add(new Lote(proximoNumero++, descricao, valorMinimo));
    }

    public Lote removeLote(int idLote) {
        for (Lote lote : lotes) {
            if (lote.getNumero() == idLote) {
                lotes.remove(lote);
                return lote;
            }
        }
        return null;
    }

    public int quantidadeDeLotes() {
        return lotes.size();
    }

    public Lote buscaLote(int numero) {
        for (Lote lote : lotes) {
            if (lote.getNumero() == numero) {
                return lote;
            }
        }
        return null;
    }

    public ArrayList<Lote> getTodosOsLotes() {
        return new ArrayList<>(lotes);
    }
}