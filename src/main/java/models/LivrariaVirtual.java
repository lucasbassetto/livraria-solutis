package models;

import exception.EstoqueInsuficienteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivrariaVirtual {

    private Scanner sc = new Scanner(System.in);
    private static final int MAX_IMPRESSOS = 10;
    private static final int MAX_ELETRONICOS = 20;
    private static final int MAX_VENDAS = 50;

    private List<Impresso> impressos = new ArrayList<>();
    private List<Eletronico> eletronicos = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();

    private Integer numeroImpressos;
    private Integer numeroEletronico;
    private Integer numeroVenda;

    public void cadastrarLivro() {
        System.out.println("Escolha o tipo de livro a ser cadastrado:");
        System.out.println("1 - Impresso");
        System.out.println("2 - Eletrônico");
        System.out.println("3 - Ambos");
        System.out.print("Digite a opção: ");

        int tipo = sc.nextInt();
        sc.nextLine();

        if (tipo < 1 || tipo > 3) {
            System.out.println("Opção inválida.");
            return;
        }

        // Entrada dos detalhes do livro comum a ambos os tipos
        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Autores: ");
        String autores = sc.nextLine();

        System.out.print("Editora: ");
        String editora = sc.nextLine();

        System.out.print("Preço: ");
        float preco = sc.nextFloat();

        if (tipo == 1 || tipo == 3) {
            if(numeroImpressos < MAX_IMPRESSOS) {

                // Detalhes específicos para livro impresso
                System.out.print("Frete: ");
                float frete = sc.nextFloat();

                System.out.print("Estoque: ");
                int estoque = sc.nextInt();

                Impresso impresso = new Impresso(titulo, autores, editora, preco, frete, estoque);
                impressos.add(impresso);
                System.out.println("Livro impresso cadastrado com sucesso.");
            } else {
                System.out.println("Não há mais espaço para cadastrar livros impressos.");
            }

        }

        if (tipo == 2 || tipo == 3) {
            if(numeroEletronico < MAX_ELETRONICOS) {
                // Detalhes específicos para livro eletrônico
                System.out.print("Tamanho (KB): ");
                int tamanho = sc.nextInt();

                Eletronico eletronico = new Eletronico(titulo, autores, editora, preco, tamanho);
                eletronicos.add(eletronico);
                System.out.println("Livro eletrônico cadastrado com sucesso.");
            } else {
                System.out.println("Não há mais espaço para cadastrar livros eletrônicos.");
            }
        }
    }

    public void realizarVenda() throws EstoqueInsuficienteException {
        sc.nextLine(); // Consumir a nova linha após a opção do menu
        System.out.print("Nome do cliente: ");
        String cliente = sc.nextLine();

        System.out.print("Quantidade de livros a comprar: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        Venda novaVenda = new Venda(cliente);

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Escolha o tipo de livro:");
            System.out.println("1. Impresso");
            System.out.println("2. Eletrônico");
            System.out.print("Digite a opção: ");
            int tipoLivro = sc.nextInt();
            sc.nextLine();

            switch (tipoLivro) {
                case 1:
                    listarLivrosImpressos();
                    System.out.print("Escolha o índice do livro impresso: ");
                    int indiceImpresso = sc.nextInt();
                    sc.nextLine();
                    Impresso impressoEscolhido = impressos.get(indiceImpresso);
                    novaVenda.addLivro(impressoEscolhido);
                    impressoEscolhido.atualizarEstoque();
                    break;
                case 2:
                    listarLivrosEletronicos();
                    System.out.print("Escolha o índice do livro eletrônico: ");
                    int indiceEletronico = sc.nextInt();
                    sc.nextLine();
                    Eletronico eletronicoEscolhido = eletronicos.get(indiceEletronico);
                    novaVenda.addLivro(eletronicoEscolhido);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    return;
            }
        }

        vendas.add(novaVenda);
        System.out.println("Venda realizada com SUCESSO!");
    }

    public void listarLivrosEletronicos() {
        if (eletronicos.isEmpty()) {
            System.out.println("Nenhum livro eletrônico cadastrado.");
        } else {
            System.out.println("Livros Eletrônicos Cadastrados:");
            for (int i = 0; i < eletronicos.size(); i++) {
                Eletronico eletronico = eletronicos.get(i);
                System.out.println("Índice " + i + ":");
                System.out.println(eletronico.toString());
            }
        }
    }

    public void listarLivrosImpressos() {
        if (impressos.isEmpty()) {
            System.out.println("Nenhum livro impresso cadastrado.");
        } else {
            System.out.println("Livros Impressos cadastrados:");
            for (int i = 0; i < impressos.size(); i++) {
                Impresso impresso = impressos.get(i);
                System.out.println("Índice " + i + ":");
                System.out.println(impresso.toString());
            }
        }
    }

    public void listarLivros() {
        listarLivrosImpressos();
        listarLivrosEletronicos();
    }

    public void listarVendas() {
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda realizada.");
        } else {
            System.out.println("Vendas Realizadas:");
            for (Venda venda : vendas) {
                System.out.println("Número da Venda: " + Venda.getNumVendas());
                System.out.println("Cliente: " + venda.getCliente());
                System.out.println("Valor Total: R$" + venda.getValor());
            }
        }
    }
}
