package br.unipar.listafilapilhaex4;

import javax.swing.JOptionPane;

public class ListaFilaPilhaEx4 {

    /*
    4 - Uma empresa de transportes precisa controlar o fluxo de produtos no seu depósito. Para auxiliar
    na organização,
    as caixas são empilhadas no máximo 10 caixas. Quando vão despachar o produto, a empilhadeira
    sempre retira e adiciona caixas
    em cima da pilha. Eles necessitam que seja exibido no painel quais produtos estão aguardando o
    despache em ordem, e no momento de retirada da caixa, qual produto está sendo despachado.
    Obs: no painel sempre depois de cada ação, mostra a posição atual da pilha, ou seja, quais
    produtos estão na pilha.
    Produto
    - codProduto
    - descricao
    - dataEntrada
    - ufOrigem
    - ufDestino
    */
    
    public static void main(String[] args) {
        Pilha<Produto> pilha = new Pilha<>(10);

        boolean fechar = false;
        while (!fechar) {
            String[] opcoes = {"Adicionar Produto", "Despachar Produto", "Ver Pilha", "Sair"};
            int escolha = JOptionPane.showOptionDialog(
                    null, 
                    "\nEscolha uma ação\n ", 
                    "Controle de Depósito",
                    -1, 
                    -1, 
                    null, 
                    opcoes,
                    opcoes[0]);

            switch (escolha) {
                case 0:
                    adicionarProduto(pilha);
                    break;
                case 1:
                    despacharProduto(pilha);
                    break;
                case 2: // Ver Pilha
                    listarProdutos(pilha);
                    break;
                case 3:
                    fechar = true;
                    break;
                default:
                    fechar = true;
                    break;
            }
        }
    }
    public static void adicionarProduto(Pilha<Produto> pilha){
        if (!pilha.isFull()) {
            try {
                int codProduto = Integer.parseInt(JOptionPane.showInputDialog(
                null, "Informe o código do produto:", 
                "Adicionar Produto",-1));
                
                String descricao = JOptionPane.showInputDialog(
                null, "Informe a descrição do produto:", 
                "Adicionar Produto", -1);
                
                String ufOrigem = JOptionPane.showInputDialog(
                null, "Informe a UF de origem:",
                "Adicionar Produto", -1);
                
                String ufDestino = JOptionPane.showInputDialog(
                null, "Informe a UF de destino:",
                "Adicionar Produto", -1);
                
                String dataEntrada = JOptionPane.showInputDialog(
                null, "Informe a data de entrada (dd/MM/yyyy):",
                "Adicionar Produto", -1);

                if (codProduto == 0 || descricao.trim().isEmpty() || ufOrigem.trim().isEmpty() || ufDestino.trim().isEmpty() || dataEntrada.trim().isEmpty()) {
                    throw new IllegalArgumentException("Nenhum campo pode estar em branco.");
                }
                
                Produto produto = new Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
                pilha.push(produto);
                
                JOptionPane.showConfirmDialog(null, 
                    "Produto adicionado à pilha.", 
                    "Adicionar Produto", 
                    -1, 
                    -1);
            } catch (NumberFormatException ex) {
                JOptionPane.showConfirmDialog(null, 
                    "Código do produto deve ser um número inteiro.", 
                    "Adicionar Produto", 
                    -1, 
                    -1);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showConfirmDialog(null, 
                    ex.getMessage(), 
                    "Adicionar Produto", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "A pilha está cheia.");
        }
    }
    
    public static void despacharProduto(Pilha<Produto> pilha) {
        if (!pilha.isEmpty()) {
            Produto produto = pilha.pop();
            JOptionPane.showConfirmDialog(null, 
                "Produto despachado: " + produto, 
                "Despachar Produto", 
                -1, 
                -1);
        } else {
            JOptionPane.showConfirmDialog(null, 
                "A pilha está vazia.", 
                "Despachar Produto", 
                -1, 
                -1);
        }
    }
    
    private static void listarProdutos(Pilha<Produto> pilha) {
        if (!pilha.isEmpty()) {
            String dadosPilha = "\nLista de Produtos:\n ";
            for (int i = pilha.size() - 1; i >= 0; i--) {
                dadosPilha += "\n" + pilha.getProduto(i);
            }
            dadosPilha += "\n ";
            JOptionPane.showConfirmDialog(null, 
                dadosPilha, 
                "Listar Produtos", 
                -1, 
                -1);
        }else {
            JOptionPane.showConfirmDialog(null, 
                "A pilha está vazia", 
                "Listar Produtos", 
                -1, 
                -1);
        }
    }
}