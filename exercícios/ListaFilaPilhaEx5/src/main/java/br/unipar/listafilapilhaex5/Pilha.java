package br.unipar.listafilapilhaex5;

public class Pilha<String> {
    private String[] pilha;
    private int posicaoTopo;
    
    public Pilha(int tamanho){
        pilha = (String[]) new Object[tamanho];
        posicaoTopo = -1;
    }
    
    //adiciono elemento da pilha
    public void push(String elemento){
        pilha[++posicaoTopo] = elemento;
    }
    
    //remove elemento da 
    public String pop(){
        return pilha[posicaoTopo--];
    }
    
    //Retorna o elemento que está no topo
    public String top(){
        return pilha[posicaoTopo];
    }
    
    //Retorna true se está vazio
    public boolean isEmpty(){
        return posicaoTopo == -1;
    }
    
    //Retorna true se estiver cheio
    public boolean isFull(){
        return posicaoTopo == pilha.length-1;
    }

    public Produto getProduto(int posicao) {
        if (posicao < 0 || posicao > posicaoTopo) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (Produto) pilha[posicao];
    }

    public int size() {
        return posicaoTopo + 1;
    }
}