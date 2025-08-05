import java.util.ArrayList;

public class Venta {

    // Venta

    private Cliente cliente;
    private ArrayList<Producto> lineasDeVenta;
    private String fecha;

    // Constructor

    public Venta(Cliente cliente, String fecha) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.lineasDeVenta = new ArrayList<>();
    }

    // Función

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

    // Getter

    public Cliente getCliente() {
        return cliente;
    }

    // Sobrescritura

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
