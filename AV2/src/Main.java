import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Criando uma lista de eventos
        ArrayList<Evento> eventos = new ArrayList<>();

        // Inserindo 5 eventos distintos
        eventos.add(new Evento("Evento1", "2023-12-01", 50.0, "Descrição do Evento 1", 100, "Categoria A"));
        eventos.add(new Evento("Evento2", "2023-12-02", 40.0, "Descrição do Evento 2", 150, "Categoria B"));
        eventos.add(new Evento("Evento3", "2023-12-03", 60.0, "Descrição do Evento 3", 120, "Categoria C"));
        eventos.add(new Evento("Evento4", "2023-12-04", 45.0, "Descrição do Evento 4", 80, "Categoria A"));
        eventos.add(new Evento("Evento5", "2023-12-05", 55.0, "Descrição do Evento 5", 200, "Categoria B"));

        // Criando uma lista de pedidos
        ArrayList<Pedido> pedidos = new ArrayList<>();

        // Criando dois pedidos
        Pedido pedido1 = new Pedido(1, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 0.0, 1);
        Pedido pedido2 = new Pedido(2, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 0.0, 1);

        // Criando itens para o Pedido 1
        PedidoItem item1Pedido1 = new PedidoItem("Evento1", 2, 50.0);
        PedidoItem item2Pedido1 = new PedidoItem("Evento2", 1, 40.0);
        PedidoItem item3Pedido1 = new PedidoItem("Evento3", 3, 60.0);

        // Adicionando itens ao Pedido 1
        pedido1.inserirItensPedido(item1Pedido1);
        pedido1.inserirItensPedido(item2Pedido1);
        pedido1.inserirItensPedido(item3Pedido1);

        // Validando se os eventos existem antes de adicionar ao pedido
        if (pedido1.validarItensPedido(eventos)) {
            // Atualizando o estoque e status do pedido
            pedido1.atualizarEstoque(eventos);
        } else {
            System.out.println("Erro: Um ou mais eventos não existem.");
        }

        // Criando itens para o Pedido 2
        PedidoItem item1Pedido2 = new PedidoItem("Evento4", 2, 45.0);
        PedidoItem item2Pedido2 = new PedidoItem("Evento5", 1, 55.0);

        // Adicionando itens ao Pedido 2
        pedido2.inserirItensPedido(item1Pedido2);
        pedido2.inserirItensPedido(item2Pedido2);

        // Validando se os eventos existem antes de adicionar ao pedido
        if (pedido2.validarItensPedido(eventos)) {
            // Atualizando o estoque e status do pedido
            pedido2.atualizarEstoque(eventos);
        } else {
            System.out.println("Erro: Um ou mais eventos não existem.");
        }

        // Calculando o total a pagar para cada pedido
        double totalPagarPedido1 = pedido1.calculaTotalPagar();
        double totalPagarPedido2 = pedido2.calculaTotalPagar();

        // Exibindo os resultados
        System.out.println("Pedido 1 - Total a Pagar: R$ " + totalPagarPedido1);
        System.out.println("Pedido 2 - Total a Pagar: R$ " + totalPagarPedido2);
    }
}
