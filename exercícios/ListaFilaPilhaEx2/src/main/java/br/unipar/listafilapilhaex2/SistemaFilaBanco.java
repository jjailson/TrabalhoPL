package br.unipar.listafilapilhaex2;

import javax.swing.JOptionPane;

public class SistemaFilaBanco {
    private Fila filaPrioritaria;
    private Fila filaNormal;
    private int prioridadeCounter;

    public SistemaFilaBanco() {
        
        filaPrioritaria = new Fila(100); // tamanho arbitrário
        filaNormal = new Fila(100); // tamanho arbitrário
        prioridadeCounter = 0;
    }

    public void adicionarCliente() {
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        int anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento do cliente:"));
        int senha = Integer.parseInt(JOptionPane.showInputDialog("Digite a senha do cliente:"));
        Cliente cliente = new Cliente(senha, nome, anoNascimento);
        
        if (2024 - anoNascimento > 65) {
            filaPrioritaria.enqueue(cliente);
            JOptionPane.showMessageDialog(null, "Cliente adicionado à fila prioritária.");
        } else {
            filaNormal.enqueue(cliente);
            JOptionPane.showMessageDialog(null, "Cliente adicionado à fila normal.");
        }
    }

    public void chamarCliente() {
        if (prioridadeCounter < 2 && !filaPrioritaria.isEmpty()) {
            Cliente cliente = filaPrioritaria.dequeue();
            prioridadeCounter++;
            JOptionPane.showMessageDialog(null, "Chamando cliente prioritário: "
            + cliente.getNome() + " (Senha: " + cliente.getSenha() + ")");
            
        } else if (!filaNormal.isEmpty()) {
            Cliente cliente = filaNormal.dequeue();
            prioridadeCounter = 0;
            JOptionPane.showMessageDialog(null, "Chamando cliente normal: " 
            + cliente.getNome() + " (Senha: " + cliente.getSenha() + ")");
            
        } else if (!filaPrioritaria.isEmpty()) {
            Cliente cliente = filaPrioritaria.dequeue();
            JOptionPane.showMessageDialog(null, "Chamando cliente prioritário: "
            + cliente.getNome() + " (Senha: " + cliente.getSenha() + ")");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum cliente na fila.");
        }
    }
}