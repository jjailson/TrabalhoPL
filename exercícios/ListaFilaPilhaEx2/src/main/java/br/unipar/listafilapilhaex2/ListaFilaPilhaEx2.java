package br.unipar.listafilapilhaex2;

import javax.swing.JOptionPane;

public class ListaFilaPilhaEx2 {

    /*
    2 - Um banco necessita de uma sistema para controlar a fila de pagamentos no caixa.
    Para o atendimento é obedecido a lei de prioridade, onde a cada 2 clientes prioritários,
    um cliente normal é atendido. Desenvolva um algoritmo para controlar a fila de
    atendimento, para isso deverá ser criado 2 filas, uma de atendimento prioritário e outra
    de atendimento normal. Na fila será cadastrado os seguintes dados do cliente:
    Cliente
    - int senha;
    - String nome;
    - int anoNascimento;
    Deverá ser determinado pela a idade qual fila será inserido o cliente, acima de 65 anos
    fila prioritária, os demais na fila normal. Crie um menu com uma opção para adicionar o
    cliente, e outra para chamar o cliente. Lembre-se deverá seguir a regra de ao ser
    atendido 2 clientes prioritários será atendido um cliente normal.
    */
    
    public static void main(String[] args) {
        SistemaFilaBanco sistema = new SistemaFilaBanco();
        
        boolean opcaoInvalida = false;
        while (!opcaoInvalida) {
            
            //página de opções
            String[] opcoes = {"Adicionar Cliente", "Chamar Cliente", "Sair"};
            int escolha = JOptionPane.showOptionDialog(
                    null, 
                    "Selecione uma opção", 
                    "Sistema de Fila do Banco", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.INFORMATION_MESSAGE, 
                    null, 
                    opcoes,
                    opcoes[0]);
            
            switch (escolha) {
                case 0:
                    sistema.adicionarCliente();
                    break;
                case 1:
                    sistema.chamarCliente();
                    break;
                case 2:
                    opcaoInvalida = true;
                    break;
                default:
                    opcaoInvalida = true;
                    break;
            }
        }
    }
}