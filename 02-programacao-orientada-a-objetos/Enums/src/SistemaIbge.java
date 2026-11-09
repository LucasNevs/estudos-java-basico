
// qualquer classe do sistema poderá obter os objetos de EstadoBrasileiro

void main() {
    //imprimindo os estados existentes no enum
    for (EstadoBrasileiro uf : EstadoBrasileiro.values()) {
        IO.println(uf.getSigla() + "-" + uf.getNomeMaiusculo());
    }

    //selecionando um estado a partir das opções disponíveis
    EstadoBrasileiro ufSelecionado = EstadoBrasileiro.PIAUI;

    IO.println("O estado selecionado foi: " + ufSelecionado.getNome());
}
