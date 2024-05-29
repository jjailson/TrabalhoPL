package br.unipar.listafilapilhaex1;

import javax.swing.JOptionPane;

public class ListaFilaPilhaEx1 {

    /*
    1 - Uma clínica precisa de um sistema para organizar a fila de pacientes, para cada dia 
    é disponibilizado 20 senhas para consulta. Eles necessitam de um sistema onde é 
    informado o nome do paciente em ordem de chegada e uma opção para chamar o 
    próximo paciente. Desenvolva um algoritmo de Fila, contendo um menu com as 
    opções: 1 - Adicionar paciente, 2 - Chamar próximo paciente. A opção 1 deverá exibir 
    um campo para informar o nome do paciente assim que ele chega no consultório, e a 
    opção 2, ao selecionar deverá exibir o nome do próximo paciente na fila
    */
    
    public static void main(String[] args) {
        int tamanhoFila = 20;//tamanho da fila desejado
        Fila fila = new Fila(tamanhoFila);//Cria a fila limitada ao tamanho desejado
        int contadorPacientes = 0;//contador de pacientes para limitar o numero de senhas por dia
        
        boolean opcaoInvalida = false;
        while (!opcaoInvalida) {
            
            //página de opções
            String[] opcoes = {"Adicionar Paciente", "Chamar Paciente", "Sair"};
            int escolha = JOptionPane.showOptionDialog(
                null,
                "\nBem Vindo ao Sistema de senhas\n\nSelecione uma opção:\n ",
                "Clínica Bacana",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            switch (escolha) {
                case 0:
                    if(contadorPacientes < tamanhoFila){
                        boolean pacienteAdicionado = adicionarPaciente(fila);
                        if(pacienteAdicionado){
                            contadorPacientes++;
                        }
                    }else{
                        JOptionPane.showConfirmDialog(null, 
                        "Limite diário de senhas atingido", 
                        "Clínica Bacana", 
                        -1, 
                        0);
                    }    
                    break;
                case 1:
                    chamarPaciente(fila);
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
    
    public static boolean adicionarPaciente(Fila fila){
        if(!fila.isFull()){
        
            String nomePaciente = JOptionPane.showInputDialog(null, 
                    "\nDigite o nome do paciente\n ", 
                    "Clínica Bacana", 
                    -1);
            if (nomePaciente != null && !nomePaciente.trim().isEmpty()) {
                fila.enqueue(nomePaciente);

                JOptionPane.showConfirmDialog(null, 
                        "\nPaciente "+ nomePaciente+ " foi adicionado à fila de espera\n ", 
                        "Clínica Bacana", 
                        -1, 
                        -1);
                return true;
                
            }else{
                JOptionPane.showConfirmDialog(null, 
                        "\nOperação cancelada. Nenhum paciente foi adicionado à fila.\n ", 
                        "Clínica Bacana", 
                        -1, 
                        0);
            }
        }else{
            JOptionPane.showConfirmDialog(null, 
                    "\nFila está cheia\n ", 
                    "Clínica Bacana", 
                    -1, 
                    -1);
        }
        return false;
    }
    
    public static void chamarPaciente(Fila fila){
        
        if(!fila.isEmpty()){  
            JOptionPane.showConfirmDialog(null, 
                    "\nPaciente "+ fila.dequeue()+ " é o proximo da fila\n ", 
                    "Clínica Bacana", 
                    -1, 
                    -1);
        }else{
            JOptionPane.showConfirmDialog(null, 
                    "\nA Fila está vazia\n ", 
                    "Clínica Bacana", 
                    -1, 
                    -1);
        }
    }
}
