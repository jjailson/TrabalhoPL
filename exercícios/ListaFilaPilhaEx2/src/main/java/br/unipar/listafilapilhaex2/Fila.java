package br.unipar.listafilapilhaex2;

public class Fila {
    private Cliente[] filaDePacientes;
    private int frente;
    private int fim;
    private int qtdItens;

    public Fila(int tamanho) {
        filaDePacientes = new Cliente[tamanho];
        frente = 0;
        fim = -1;
        qtdItens = 0;
    }

    public void enqueue(Cliente elemento) {
        if (fim == filaDePacientes.length - 1) {
            fim = -1;
        }
        filaDePacientes[++fim] = elemento;
        qtdItens++;
    }

    public Cliente dequeue() {
        Cliente elemento = filaDePacientes[frente++];
        if (frente == filaDePacientes.length) {
            frente = 0;
        }
        qtdItens--;
        return elemento;
    }

    public boolean isEmpty() {
        return qtdItens == 0;
    }

    public boolean isFull() {
        return qtdItens == filaDePacientes.length;
    }
}