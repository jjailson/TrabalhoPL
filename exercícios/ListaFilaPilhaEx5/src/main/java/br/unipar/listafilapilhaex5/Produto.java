package br.unipar.listafilapilhaex5;

class Produto {
    private int codProduto;
    private String descricao;
    private String dataEntrada;
    private String ufOrigem;
    private String ufDestino;

    public Produto(int codProduto, String descricao, String dataEntrada, String ufOrigem, String ufDestino) {
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
        this.ufOrigem = ufOrigem;
        this.ufDestino = ufDestino;
    }

    @Override
    public String toString() {
        return "Produto:" +
                "\nCódigo: "+ codProduto+ " Descricao: "+ descricao+ " Data de Entrada: "+ dataEntrada+
                "\nUF Origem: "+ ufOrigem+ " UF Destino: "+ ufDestino+ "\n";
    }
}