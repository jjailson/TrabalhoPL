package br.unipar.listafilapilhaex3;

public class Pilha {
    private Livro[] pilha;
    private int posicaoTopo;

    public Pilha(int tamanho) {
        pilha = new Livro[tamanho];
        posicaoTopo = -1;
    }

    public void push(Livro livro) {
        pilha[++posicaoTopo] = livro;
    }

    public Livro pop() {
        return pilha[posicaoTopo--];
    }

    public Livro top() {
        return pilha[posicaoTopo];
    }

    public boolean isEmpty() {
        return posicaoTopo == -1;
    }

    public boolean isFull() {
        return posicaoTopo == pilha.length - 1;
    }
    
    public int size() {
        return posicaoTopo + 1;
    }
    
    public Livro getLivro(int posicao) {
        return pilha[posicao];
    }
}