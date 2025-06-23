package poo.gestaodeleilao;

public class TesteLeilao {
    public static void main(String[] args) {
        Leilao leilao = new Leilao();

        leilao.adicionaLote("Quadro de Van Gogh", 1000.0);
        leilao.adicionaLote("Escultura de Bronze", 2000.0);
        leilao.adicionaLote("Relógio Antigo", 1500.0);

        System.out.println("Todos os lotes:");
        System.out.println(leilao.obtemTodosOsLotes());

        leilao.removeLote(2);
        System.out.println("Após remover o lote 2:");
        System.out.println(leilao.obtemTodosOsLotes());

        System.out.println(leilao.ofertaLance(1, "Maria", 5000.0));
        System.out.println(leilao.ofertaLance(3, "João", 2000.0));
        System.out.println(leilao.ofertaLance(1, "Carlos", 6000.0));
        System.out.println("Encerrando leilão:");
        System.out.println(leilao.encerraLeilao());

        System.out.println("Lotes não vendidos:");
        for (var lote : leilao.getNaoVendidos()) {
            System.out.println(lote);
        }
    }
}