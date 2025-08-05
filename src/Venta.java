import java.util.ArrayList;

public class Venta {

    private Cliente cliente;
    private ArrayList<Producto> lineasDeVenta;

    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.lineasDeVenta = new ArrayList<>();
    }
}
