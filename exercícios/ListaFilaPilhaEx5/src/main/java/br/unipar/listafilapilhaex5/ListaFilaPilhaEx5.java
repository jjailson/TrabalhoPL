package br.unipar.listafilapilhaex5;

import javax.swing.JOptionPane;

public class ListaFilaPilhaEx5 {

    public static void main(String[] args) {
        // Criar um array de 5 pilhas
        Pilha<Produto>[] pilhas = new Pilha[5];
        for (int i = 0; i < pilhas.length; i++) {
            pilhas[i] = new Pilha<>(3); // Definir o tamanho da pilha como 3 para este exemplo
        }

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
                    adicionarProduto(pilhas);
                    break;
                case 1:
                    despacharProduto(pilhas);
                    break;
                case 2:
                    verPilha(pilhas);
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

    public static void adicionarProduto(Pilha<Produto>[] pilhas) {
        int indicePilha = selecionarPilha("Adicionar Produto", pilhas.length);
        if (indicePilha == -1) {
            return; // Se o usuário cancelar a operação, retorna sem fazer nada
        }

        Pilha<Produto> pilhaSelecionada = pilhas[indicePilha];
        if (!pilhaSelecionada.isFull()) {
            try {
                int codProduto = Integer.parseInt(JOptionPane.showInputDialog(
                        null, "Informe o código do produto:",
                        "Adicionar Produto", -1));

                String descricao;
                do {
                    descricao = JOptionPane.showInputDialog(
                            null, "Informe a descrição do produto:",
                            "Adicionar Produto", -1);
                    if (descricao == null) {
                        return; // Se o usuário cancelar a operação, retorna sem fazer nada
                    }
                } while (descricao.trim().isEmpty());

                String ufOrigem;
                do {
                    ufOrigem = JOptionPane.showInputDialog(
                            null, "Informe a UF de origem:",
                            "Adicionar Produto", -1);
                    if (ufOrigem == null) {
                        return; // Se o usuário cancelar a operação, retorna sem fazer nada
                    }
                } while (ufOrigem.trim().isEmpty());

                String ufDestino;
                do {
                    ufDestino = JOptionPane.showInputDialog(
                            null, "Informe a UF de destino:",
                            "Adicionar Produto", -1);
                    if (ufDestino == null) {
                        return; // Se o usuário cancelar a operação, retorna sem fazer nada
                    }
                } while (ufDestino.trim().isEmpty());

                String dataEntrada;
                do {
                    dataEntrada = JOptionPane.showInputDialog(
                            null, "Informe a data de entrada (dd/MM/yyyy):",
                            "Adicionar Produto", -1);
                    if (dataEntrada == null) {
                        return; // Se o usuário cancelar a operação, retorna sem fazer nada
                    }
                } while (dataEntrada.trim().isEmpty());

                Produto produto = new Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
                pilhaSelecionada.push(produto);

                JOptionPane.showConfirmDialog(null,
                        "Produto adicionado à pilha.",
                        "Adicionar Produto",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showConfirmDialog(null,
                        "Código do produto deve ser um número inteiro.",
                        "Adicionar Produto",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "A pilha está cheia.");
        }
    }

    public static void despacharProduto(Pilha<Produto>[] pilhas) {
        int indicePilha = selecionarPilha("Despachar Produto", pilhas.length);
        if (indicePilha == -1) {
            return; // Se o usuário cancelar a operação, retorna sem fazer nada
        }

        Pilha<Produto> pilhaSelecionada = pilhas[indicePilha];
        if (!pilhaSelecionada.isEmpty()) {
            Produto produto = pilhaSelecionada.pop();
            JOptionPane.showConfirmDialog(null,
                    "Produto despachado: " + produto,
                    "Despachar Produto",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showConfirmDialog(null,
                    "A pilha está vazia.",
                    "Despachar Produto",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void verPilha(Pilha<Produto>[] pilhas) {
        int indicePilha = selecionarPilha("Ver Pilha", pilhas.length);
        if (indicePilha == -1) {
            return; // Se o usuário cancelar a operação, retorna sem fazer nada
        }

        Pilha<Produto> pilhaSelecionada = pilhas[indicePilha];
        if (!pilhaSelecionada.isEmpty()) {
            String dadosPilha = "\nLista de Produtos na Pilha " + (indicePilha + 1) + ":\n ";
            for (int i = pilhaSelecionada.size() - 1; i >= 0; i--) {
                dadosPilha += pilhaSelecionada.getProduto(i) + "\n";
            }
            JOptionPane.showConfirmDialog(null,
                    dadosPilha,
                    "Listar Produtos",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showConfirmDialog(null,
                    "A pilha está vazia",
                    "Listar Produtos",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static int selecionarPilha(String titulo, int numPilhas) {
        if (numPilhas == 0) {
            JOptionPane.showMessageDialog(null, "Não há pilhas disponíveis.");
            return -1;
        }

        String[] opcoes = new String[numPilhas];
        for (int i = 0; i < numPilhas; i++) {
            opcoes[i] = "Pilha " + (i + 1);
        }

        int escolha = JOptionPane.showOptionDialog(
                null,
                "Selecione a pilha:",
                titulo,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        return escolha;
    }
}