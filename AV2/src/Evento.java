import java.util.ArrayList;

public class Evento {
    private String nomeEvento;
    private String dataEvento;
    private double precoEvento;
    private String descEvento;
    private int qtdeIngresso;
    private String categoria;

    public Evento(String nomeEvento, String dataEvento, double precoEvento, String descEvento, int qtdeIngresso, String categoria) {
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.precoEvento = precoEvento;
        this.descEvento = descEvento;
        this.qtdeIngresso = qtdeIngresso;
        this.categoria = categoria;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public double getPrecoEvento() {
        return precoEvento;
    }

    public void setPrecoEvento(double precoEvento) {
        this.precoEvento = precoEvento;
    }

    public String getDescEvento() {
        return descEvento;
    }

    public void setDescEvento(String descEvento) {
        this.descEvento = descEvento;
    }

    public int getQtdeIngresso() {
        return qtdeIngresso;
    }

    public void setQtdeIngresso(int qtdeIngresso) {
        this.qtdeIngresso = qtdeIngresso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Adicione este método à classe Evento
    public static boolean buscarEvento(String nomeEvento, ArrayList<Evento> eventos) {
        for (Evento evento : eventos) {
            if (evento.getNomeEvento().equals(nomeEvento)) {
                return true;
            }
        }
        return false;
    }
}
