package br.unipar.listafilapilhaex3;

import javax.swing.JOptionPane;

public class ListaFilaPilhaEx3 {

    /*
    3 - Desenvolva um algoritmo para controlar uma pilha de livros de uma biblioteca. Deverá conter um
    método para adicionar o livro a pilha,
    Um método para listar os livros da pilha, um método para retirar o livro da pilha, nesse último
    método deverá ser exibido qual livro está sendo removido. Crie um menu para exibir as opções.
    */
    
    public static void main(String[] args) {
        Pilha pilhaDeLivros = new Pilha(10);
        
        boolean opcaoInvalida = false;
        while (!opcaoInvalida) {
            
            //página de opções
            String[] opcoes = {"Adicionar Livro", "Listar Livros", "Remover Livro", "Sair"};
            int escolha = JOptionPane.showOptionDialog(
                null,
                "\nSelecione uma opção\n ",
                "Biblioteca Bacana",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            switch (escolha) {
                case 0:
                    adicionarLivro(pilhaDeLivros);
                    break;
                case 1:
                    listarLivros(pilhaDeLivros);
                    break;
                case 2:
                    removerLivro(pilhaDeLivros);
                    break;
                case 3:
                    opcaoInvalida = true;
                    break;
                default:
                    opcaoInvalida = true;
                    break;
            }
        }
    }

    private static boolean adicionarLivro(Pilha pilha) {
        
        if(!pilha.isFull()){
        
            String titulo = JOptionPane.showInputDialog(null, 
                    "\nDigite o título do livro:\n ", 
                    "Adicionar Livro", 
                    -1);
            if (titulo != null && !titulo.trim().isEmpty()) {
                Livro livro = new Livro(titulo);
                pilha.push(livro);

                JOptionPane.showConfirmDialog(null, 
                        "\nLivro "+ titulo+ " foi adicionado à pilha\n ", 
                        "Adicionar Livro", 
                        -1, 
                        -1);
                return true;
                
            }else{
                JOptionPane.showConfirmDialog(null, 
                        "\nOperação cancelada!!\nNenhum livro foi adicionado à pilha\n ", 
                        "Adicionar Livro", 
                        -1, 
                        0);
            }
        }else{
            JOptionPane.showConfirmDialog(null, 
                    "\nA Pilha está cheia!\n ", 
                    "Adicionar Livro", 
                    -1, 
                    0);
        }
        return false;
        
    }

    private static void listarLivros(Pilha pilha) {
        if (!pilha.isEmpty()) {
            String dadosPilha = "\nLista de Livros:\n ";
            for (int i = pilha.size() - 1; i >= 0; i--) {
                dadosPilha += "\n" + pilha.getLivro(i);
            }
            dadosPilha += "\n ";
            JOptionPane.showConfirmDialog(null,
                    dadosPilha,
                    "Listar Livros",
                    -1,
                    -1);
        }else {
            JOptionPane.showConfirmDialog(null,
                    "A pilha está vazia",
                    "Listar Livros",
                    -1,
                    2);
        }
    }

    private static void removerLivro(Pilha pilha) {
        if (pilha.isEmpty()) {
            JOptionPane.showConfirmDialog(null, 
                        "A pilha está vazia!", 
                        "Lista de Livros", 
                        -1, 
                        2);
            return;
        }
        Livro livroRemovido = pilha.pop();
        JOptionPane.showConfirmDialog(null, 
                        "Livro removido: "+ livroRemovido.toString(), 
                        "Remover Livro", 
                        -1, 
                        2);
    }
}