import java.util.ArrayList;

public class Pedido {
    private int numeroPedido;
    private String dataHoraPedido;
    private double precoTotal;
    private int statusPedido;
    private ArrayList<PedidoItem> itensPedido; // Lista para armazenar os itens do pedido

    // Construtor
    public Pedido(int numeroPedido, String dataHoraPedido, double precoTotal, int statusPedido) {
        this.numeroPedido = numeroPedido;
        this.dataHoraPedido = dataHoraPedido;
        this.precoTotal = precoTotal;
        this.statusPedido = statusPedido;
        this.itensPedido = new ArrayList<>();
    }

    // Método para alterar o status do pedido
    public void alterarStatus(int novoStatus) {
        this.statusPedido = novoStatus;
    }

    // Método para consultar se um pedido tem o mesmo número
    public boolean consultarPedido(Pedido pedidoParaComparar) {
        return this.numeroPedido == pedidoParaComparar.numeroPedido;
    }

    // Método para inserir itens no pedido
    public void inserirItensPedido(PedidoItem itemPedido) {
        this.itensPedido.add(itemPedido);
    }

    // Método para excluir itens do pedido
    public void excluirItensPedido(PedidoItem itemPedido) {
        this.itensPedido.remove(itemPedido);
    }

    // Método para calcular o total a pagar
    public double calculaTotalPagar() {
        double total = 0.0;
        for (PedidoItem item : this.itensPedido) {
            total += item.getSubtotal();
        }
        return total;
    }

    // Adicione este método à classe Pedido
    public void atualizarEstoque(ArrayList<Evento> eventos) {
        for (PedidoItem item : this.itensPedido) {
            Evento evento = buscarEvento(item.getNomeEvento(), eventos);
            if (evento != null) {
                int qtdeAtualizada = evento.getQtdeIngresso() - item.getQtdeIngresso();
                evento.setQtdeIngresso(qtdeAtualizada);
            }
        }
        this.alterarStatus(2); // Atualiza o status do pedido para 2
    }

    // Adicione este método à classe Pedido
    public boolean validarItensPedido(ArrayList<Evento> eventos) {
        for (PedidoItem item : this.itensPedido) {
            if (!Evento.buscarEvento(item.getNomeEvento(), eventos)) {
                return false; // Retorna false se um evento não for encontrado
            }
        }
        return true; // Retorna true se todos os eventos foram encontrados
    }

    // Adicione este método à classe Pedido
    private Evento buscarEvento(String nomeEvento, ArrayList<Evento> eventos) {
        for (Evento evento : eventos) {
            if (evento.getNomeEvento().equals(nomeEvento)) {
                return evento;
            }
        }
        return null;
    }
}