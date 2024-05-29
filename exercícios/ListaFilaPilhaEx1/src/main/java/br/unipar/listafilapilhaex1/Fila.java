package br.unipar.listafilapilhaex1;

public class Fila {
    private String [] filaDePacientes;
    private int frente;
    private int fim;
    private int qtdItens;

    public Fila(int tamanho) {
        filaDePacientes = new String[tamanho];
        frente = 0;
        fim = -1;
        qtdItens = 0;
    }
    
    public void enqueue(String elemento){
        if(fim == filaDePacientes.length -1){
            fim = -1;
        }
        filaDePacientes[++fim] = elemento;
        qtdItens++;
    }
    
    public String dequeue(){
        String elemento = filaDePacientes[frente++];
        if(frente == filaDePacientes.length){
            frente = 0;
        }
        
        qtdItens--;
        return elemento;
    }
    
    public boolean isEmpty(){
        return qtdItens == 0;
    }
    
    public boolean isFull(){
        return qtdItens == filaDePacientes.length;
    }
    
}
