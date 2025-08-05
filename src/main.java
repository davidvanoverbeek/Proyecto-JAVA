import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Producto> catalogo = new ArrayList<>();
    static ArrayList<Venta> ventas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Menú principal

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de clientes");
            System.out.println("2. Gestión de productos");
            System.out.println("3. Realizar venta");
            System.out.println("4. Mostrar ventas");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> menuClientes();
                case 2 -> menuProductos();
                case 3 -> realizarVenta();
                case 4 -> mostrarVentas();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        }while (opcion != 5);
    }

    // Menú para clientes

    public static void menuClientes() {
        int option;
        do {
            System.out.println("\n-- Gestión de Clientes --");
            System.out.println("1. Alta");
            System.out.println("2. Baja");
            System.out.println("3. Modificación");
            System.out.println("4. Buscar por DNI");
            System.out.println("5. Listado");
            System.out.println("6. Ordenar por nombre");
            System.out.println("7. Volver");
            System.out.print("Elige una opción: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("DNI: ");
                    String dni = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    clientes.add(new Cliente(nombre, dni, tel, email));
                    System.out.println("Cliente añadido.");
                }
                case 2 -> {
                    System.out.print("DNI del cliente que quiere eliminar: ");
                    String dni = scanner.nextLine();
                    clientes.removeIf(c -> c.getDni().equalsIgnoreCase(dni));
                    System.out.println("Cliente eliminado.");
                }
                case 3 -> {
                    System.out.print("DNI del cliente que quiere modificar: ");
                    String dni = scanner.nextLine();

                    for (Cliente cliente : clientes) {
                        if (cliente.getDni().equalsIgnoreCase(dni)) {
                            System.out.print("Nuevo nombre: ");
                            cliente.setNombre(scanner.nextLine());
                            System.out.print("Nuevo teléfono: ");
                            cliente.setTelefono(scanner.nextLine());
                            System.out.print("Nuevo email: ");
                            cliente.setEmail(scanner.nextLine());
                            System.out.println("Cliente modificado.");
                            break;
                        }
                    }
                }
                case 4 -> {
                    System.out.print("DNI que quiere buscar: ");
                    String dni = scanner.nextLine();
                    for (Cliente cliente : clientes) {
                        if (cliente.getDni().equalsIgnoreCase(dni)) {
                            System.out.println(cliente);
                            break;
                        }
                    }
                }
                case 5 -> clientes.forEach(System.out::println);
                case 6 -> clientes.stream()
                        .sorted((a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre()))
                        .forEach(System.out::println);
            }
        }while (option != 7);
    }

    // Menu para productos

    public static void menuProductos() {
        int option;
        do {
            System.out.println("\n-- Gestión de Productos --");
            System.out.println("1. Alta");
            System.out.println("2. Listado del catálogo");
            System.out.println("3. Ordenar por precio");
            System.out.println("4. Buscar por articulo");
            System.out.println("5. Volver");
            System.out.print("Elige una opción: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> {
                    System.out.print("Articulo: ");
                    String articulo = scanner.nextLine();
                    System.out.print("Tamaño: ");
                    String tamaño = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(scanner.nextLine());
                    System.out.print("Stock disponible: ");
                    int stock = Integer.parseInt(scanner.nextLine());
                    catalogo.add(new Producto(articulo, tamaño, precio, stock));
                    System.out.println("Producto añadido al catálogo.");
                }
                case 2 -> catalogo.forEach(System.out::println);
                case 3-> catalogo.stream()
                        .sorted((a, b) -> Double.compare(a.getPrecio(), b.getPrecio()))
                        .forEach(System.out::println);
                case 4 -> {
                    System.out.print("Articulo que quiere buscar: ");
                    String articulo = scanner.nextLine();
                    catalogo.stream()
                            .filter(producto -> producto.getArticulo().equalsIgnoreCase(articulo))
                            .forEach(System.out::println);
                }
            }
        } while (option != 5);
    }

    //Proceso de venta

    public static void realizarVenta() {
        System.out.print("DNI del cliente: ");
        String dni = scanner.nextLine();

        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                cliente = c;
                break;
            }
        }
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Fecha de la venta: ");
        String fecha = scanner.nextLine();
        Venta venta = new Venta(cliente, fecha);

        String seguir;
        do {
            System.out.println("Catálogo de productos:");

            for (int i = 0; i < catalogo.size(); i++) {
                System.out.println(i + ". " + catalogo.get(i));
            }
            System.out.print("Selecciona número del producto: ");

            int i = Integer.parseInt(scanner.nextLine());
            if (catalogo.get(i).getStock() > 0) {
                venta.agregarProducto(catalogo.get(i));
                catalogo.get(i).setStock(catalogo.get(i).getStock() - 1);
                System.out.println("Stock restante: " + catalogo.get(i).getStock());
            } else {
                System.out.println("No hay stock disponible de ese producto.");
            }

            if (i >= 0 && i < catalogo.size()) {
                venta.agregarProducto(catalogo.get(i));
                System.out.println("Producto añadido.");
            }
            System.out.print("¿Añadir otro producto? (SI/NO): ");

            seguir = scanner.nextLine().toUpperCase();
        } while (seguir.equalsIgnoreCase("si"));

        ventas.add(venta);
        System.out.println("Venta realizada correctamente.");

    }

    // Proceso de mostrar información

    public static void mostrarVentas() {
        int option;
        do {
            System.out.println("\n-- Mostrar Ventas --");
            System.out.println("1. Todas las ventas");
            System.out.println("2. Ventas por cliente");
            System.out.println("3. Total gastado por cliente");
            System.out.println("4. Volver");

            System.out.print("Elige una opción: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> ventas.forEach(System.out::println);
                case 2 -> {
                    System.out.print("DNI del cliente: ");
                    String dni = scanner.nextLine();
                    for (Venta v : ventas) {
                        if (v.getCliente().getDni().equalsIgnoreCase(dni)) {
                            System.out.println(v);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("DNI del cliente: ");
                    String dni = scanner.nextLine();
                    double totalGastado = 0;
                    for (Venta v : ventas) {
                        if (v.getCliente().getDni().equalsIgnoreCase(dni)) {
                            totalGastado += v.calcularTotal();
                        }
                    }
                    System.out.println("Total gastado por el cliente: " + totalGastado + " €");
                }
            }
        } while (option != 4);
    }
}
