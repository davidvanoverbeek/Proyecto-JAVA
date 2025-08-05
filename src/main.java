import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Producto> joyas = new ArrayList<>();
    static ArrayList<Venta> ventas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de clientes");
            System.out.println("2. Gestión de pájaros");
            System.out.println("3. Realizar venta");
            System.out.println("4. Mostrar venta");
            System.out.println("5. Salir");
            System.out.println("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> gestionarClientes(scanner);
                case 2 -> gestionarProducto(scanner);
                case 3 -> realizarVenta(scanner);
                case 4 -> mostrarVentas();
                case 5 -> System.out.println("Saliendo del sistema");
                default -> System.out.println("Opcion no valida");
            }

        }while (opcion != 5);
    }

    static  void gestionarClientes(Scanner scanner) {
        System.out.println("\n-- Gestión de clientes --");
        System.out.println("1. Alta");
        System.out.println("2. Baja");
        System.out.println("3. Modificación");
        System.out.println("4. Listado");
        System.out.println("Elige opcion: ");
        int opc = scanner.nextInt(); scanner.nextLine();

        switch (opc) {
            case 1 -> {
                System.out.println("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.println("DNI: ");
                String dni = scanner.nextLine();
                System.out.println("Telefono: ");
                String telefono = scanner.nextLine();
                System.out.println("Email: ");
                String email = scanner.nextLine();
                clientes.add(new Cliente(nombre, dni, telefono, email));
            }
            case 2 -> {
                listarClientes();
                System.out.println("Posición que desea eliminar: ");
                int pos = scanner.nextInt();
                if (pos >= 0 && pos < clientes.size()) clientes.remove(pos);
            }
            case 3 -> {
                listarClientes();
                System.out.println("Posición que desea modificar: ");
                int pos = scanner.nextInt();
                if (pos >= 0 && pos < clientes.size()) {
                    Cliente clien = clientes.get(pos);
                    System.out.println("Nuevo nombre: ");
                    clien.setNombre(scanner.nextLine());
                }
            }
            case 4 -> listarClientes();
        }
    }

    static void gestionarProducto(Scanner scanner) {
        System.out.println("\n-- Gestión de productos --");
        System.out.println("1. Alta");
        System.out.println("2. Listado");
        System.out.println("Elige opcion: ");
        int posi = scanner.nextInt(); scanner.nextLine();

        if (posi == 1) {
            System.out.println("Joyas: ");
            String articulo = scanner.nextLine();
            System.out.println("Tamaño: ");
            String tamaño = scanner.nextLine();
            System.out.println("Precio: ");
            double precio = scanner.nextDouble();
            joyas.add(new Producto(articulo, tamaño, precio));
        } else if (posi == 2) {
            listarJoyas();
        }
    }

    static void realizarVenta(Scanner scanner) {
        if (clientes.isEmpty() || joyas.isEmpty()) {
            System.out.println("Primero debes registar clientes y joyas");
            return;
        }
        System.out.println("Selecciona cliente: ");
        listarClientes();
        int posCliente = scanner.nextInt(); scanner.nextLine();
        if (posCliente < 0 || posCliente >= clientes.size()) return;

        Cliente clienteSeleccionado = clientes.get(posCliente);
        Venta venta = new Venta(clienteSeleccionado);

        boolean seguir = true;
        while (seguir) {
            System.out.println("Selecciona joya para añadir: ");
            listarJoyas();
            int posJoya = scanner.nextInt(); scanner.nextLine();
            if (posJoya >= 0  && posJoya < joyas.size()) {
                venta.añadirJoya(joyas.get(posJoya));
            }
            System.out.println("Añadir otro? (si/no): ");
            seguir = scanner.hasNextLine().equalsIgnoreCase("si");
        }
        ventas.add(venta);
        System.out.println("Venta registrada.");
    }

    static void mostrarVentas() {
        System.out.println("\n-- Ventas registradas --");
        for (Venta v : ventas) {
            v.mostrarInfo();
            System.out.println();
        }
    }

    static void listarClientes() {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + ". " + clientes.get(i).getNombre());
        }
    }

    static void listarJoyas() {
        for (int i = 0; i < joyas.size(); i++) {
            System.out.println(i + ". " + joyas.get(i).getArticulo());
        }
    }
}
