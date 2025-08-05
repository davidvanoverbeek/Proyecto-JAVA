import java.util.ArrayList;

public class Venta {

    private Cliente cliente;
    private ArrayList<Producto> lineasDeVenta;
    private String fecha;

    public Venta(Cliente cliente, String fecha) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.lineasDeVenta = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        lineasDeVenta.add(producto);
    }

    public double calcuclarTotal() {
        double total = 0;
        for (Producto producto : lineasDeVenta) {
            total += producto.getPrecio();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Venta {" +
                "cliente: " + cliente.getNombre() +
                ", fecha: " + fecha + '\'' +
                ", total: " + calcuclarTotal() +
                ", producto: " + lineasDeVenta +
                '}';
    }
}
