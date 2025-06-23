package poo.gestaodeleilao;

import java.util.Scanner;

public class Interface {
    private Leilao leilao;
    private Scanner scanner;

    public Interface(Leilao leilao) {
        this.leilao = leilao;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            System.out.println("Sistema de Leilão");
            System.out.println("1. Adicionar lote");
            System.out.println("2. Exibir todos os lotes");
            System.out.println("3. Ofertar lance");
            System.out.println("4. Encerrar leilão");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    adicionarLote();
                    break;
                case 2:
                    exibirLotes();
                    break;
                case 3:
                    ofertarLance();
                    break;
                case 4:
                    encerrarLeilao();
                    break;
                case 0:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void adicionarLote() {
        System.out.print("Descrição do lote: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor mínimo: ");
        double valorMinimo = scanner.nextDouble();
        scanner.nextLine();
        leilao.adicionaLote(descricao, valorMinimo);
        System.out.println("Lote adicionado com sucesso!");
    }

    private void exibirLotes() {
        System.out.println("Lotes cadastrados:");
        System.out.println(leilao.obtemTodosOsLotes());
    }

    private void ofertarLance() {
        System.out.print("Número do lote: ");
        int numeroLote = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome do participante: ");
        String nome = scanner.nextLine();
        System.out.print("Valor do lance: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        String resultado = leilao.ofertaLance(numeroLote, nome, valor);
        System.out.println(resultado);
    }

    private void encerrarLeilao() {
        System.out.println("Resultado do leilão:");
        System.out.println(leilao.encerraLeilao());
        leilao.setAtivo(false);
    }
}