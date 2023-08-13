package models;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private List<Livro> livros = new ArrayList<>();
    private static int numVendas = 0;
    private int numero = numVendas;
    private String cliente;
    private float valor;

    public Venda(String cliente) {
        this.cliente = cliente;
        this.valor = 0;
        numVendas++;
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
        valor += livro.getPreco();
    }

    public void listarLivros() {
        System.out.println("Livros:");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public float valorTotal() {
        float total = 0;
        for (Livro livro : livros) {
            total += livro.getPreco();
        }
        return total;
    }

    public float getValor() {
        return valor;
    }

    public String getCliente() {
        return cliente;
    }

    public static int getNumVendas() {
        return numVendas;
    }


    @Override
    public String toString() {
        return "------------- Vendas -------------\n" +
                "    Número: " + numero + "\n" +
                "    Cliente: '" + cliente + "'\n" +
                "    Valor : " + valor + "\n";
    }
}