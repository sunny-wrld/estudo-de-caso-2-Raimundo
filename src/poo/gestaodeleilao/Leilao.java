package poo.gestaodeleilao;

import poo.gestaodecontas.Lance;
import poo.gestaodecontas.Lote;
import poo.gestaodecontas.Pessoa;

import java.util.ArrayList;

public class Leilao {
    private BDLotes lotes;
    private Interface terminal;
    private boolean ativo;

    public Leilao() {
        this.lotes = new BDLotes();
        this.terminal = new Interface(this);
        this.ativo = true;
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
        if (lote == null) {
            return "Lote Inexistente";
        }
        if (lote.lancePara(new Pessoa(nomePessoa), valor)) {
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

    public class Leilao {
        private List<Lote> lotes;

        public Leilao(List<Lote> lotes) {
            this.lotes = lotes;
        }

        public String encerraLeilao() {
            StringBuilder resultado = new StringBuilder();
            ArrayList<Lote> todosLotes = this.lotes.getTodosOsLotes();
            for (Lote lote : todosLotes) {
                resultado.append("Lote número: ").append(lote.getNumero()).append("\n");
                resultado.append("Descrição: ").append(lote.getDescricao()).append("\n");
                Lance maiorLance = lote.getMaiorLance();
                if (maiorLance != null) {
                    resultado.append("Vendido para: ")
                            .append(maiorLance.getLicitante().getNome())
                            .append(" por R$ ")
                            .append(String.format("%.2f", maiorLance.getValor()))
                            .append("\n");
                } else {
                    resultado.append("Lote não foi vendido.\n");
                }
                resultado.append("\n");
            }
            return resultado.toString();
        }

        public String encerraLeilao() {
            StringBuilder resultado = new StringBuilder();
            ArrayList<Lote> todosLotes = this.lotes.getTodosOsLotes();
            for (Lote lote : todosLotes) {
                resultado.append("Lote número: ").append(lote.getNumero()).append("\n");
                resultado.append("Descrição: ").append(lote.getDescricao()).append("\n");
                Lance maiorLance = lote.getMaiorLance();
                if (maiorLance != null) {
                    resultado.append("Vendido para: ")
                            .append(maiorLance.getLicitante().getNome())
                            .append(" por R$ ")
                            .append(String.format("%.2f", maiorLance.getValor()))
                            .append("\n");
                } else {
                    resultado.append("Lote não foi vendido.\n");
                }
                resultado.append("\n");
            }
            return resultado.toString();
        }
    }