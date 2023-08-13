import exception.EstoqueInsuficienteException;
import models.LivrariaVirtual;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EstoqueInsuficienteException {

        Scanner sc = new Scanner(System.in);

        LivrariaVirtual livraria = new LivrariaVirtual();
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Realizar uma venda");
            System.out.println("3. Listar livros");
            System.out.println("4. Listar vendas");
            System.out.println("5. Sair do programa");
            System.out.print("Escolha uma opção: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    livraria.cadastrarLivro();
                    break;
                case 2:
                    livraria.realizarVenda();
                    break;
                case 3:
                    livraria.listarLivros();
                    break;
                case 4:
                    livraria.listarVendas();
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!.");
            }
        } while (option != 5);
    }
}