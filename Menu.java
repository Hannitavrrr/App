package university.jala.institutional.App;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Menu {
    private List<Producto> productosFinales;
    private List<Producto> accesorios;
    private List<Servicio> serviciosMantenimiento;
    private List<Servicio> serviciosReparacion;
    private Historial historial;
    private Scanner scanner;

    public Menu() {
        productosFinales = new ArrayList<>();
        accesorios = new ArrayList<>();
        serviciosMantenimiento = new ArrayList<>();
        serviciosReparacion = new ArrayList<>();
        historial = new Historial();
        scanner = new Scanner(System.in);
        inicializarDatos();
    }

    private void inicializarDatos() {
        productosFinales.add(new ProductoFinal("Smartphone", 800.0, "PeraPhone 13"));
        productosFinales.add(new ProductoFinal("Smart Watch", 350.0, "PeraWatch Gen 3"));
        productosFinales.add(new ProductoFinal("TV Inteligente", 1000.0, "PeraTV 50 pulgadas"));
        productosFinales.add(new ProductoFinal("Tablet", 220.0, "PeraPad Gen 5"));

        accesorios.add(new Accesorio("Cargador", 25.0, "Pera Charger"));
        accesorios.add(new Accesorio("Audífonos", 50.0, "Pera Headphones"));

        serviciosMantenimiento.add(new Mantenimiento("Actualización", 20.0));
        serviciosMantenimiento.add(new Mantenimiento("Limpieza", 15.0));
        serviciosMantenimiento.add(new Mantenimiento("Formateo", 30.0));

        serviciosReparacion.add(new Reparacion("Reemplazo de partes", 100.0));
        serviciosReparacion.add(new Reparacion("Flasheo", 50.0));
        serviciosReparacion.add(new Reparacion("Actualización de hardware", 150.0));
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("Por favor, elija una opción:");
            System.out.println("1. Ver productos");
            System.out.println("2. Ver servicios");
            System.out.println("3. Ver historial del día");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    mostrarProductos();
                    break;
                case 2:
                    mostrarServicios();
                    break;
                case 3:
                    historial.mostrarAdquisicionesDelDia();
                    break;
                case 4:
                    System.out.println("Gracias por usar nuestra aplicación! Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
    }

    private void mostrarProductos() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Ver productos finales");
        System.out.println("2. Ver accesorios");
        System.out.println("3. Regresar");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1:
                mostrarProductosFinales();
                break;
            case 2:
                mostrarAccesorios();
                break;
            case 3:
                System.out.println("Volviendo al menú principal...");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void mostrarProductosFinales() {
        System.out.println("Productos finales disponibles:");
        for (int i = 0; i < productosFinales.size(); i++) {
            System.out.println((i + 1) + ". " + productosFinales.get(i).getNombre());
        }
        System.out.println("Seleccione un producto (0 para regresar):");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion > 0 && opcion <= productosFinales.size()) {
            Producto producto = productosFinales.get(opcion - 1);
            producto.mostrarDetalle();
            realizarAdquisicion(producto);
        }
    }

    private void mostrarAccesorios() {
        System.out.println("Accesorios disponibles:");
        for (int i = 0; i < accesorios.size(); i++) {
            System.out.println((i + 1) + ". " + accesorios.get(i).getNombre());
        }
        System.out.println("Seleccione un accesorio (0 para regresar):");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion > 0 && opcion <= accesorios.size()) {
            Producto producto = accesorios.get(opcion - 1);
            producto.mostrarDetalle();
            realizarAdquisicion(producto);
        }
    }

    private void mostrarServicios() {
        System.out.println("Seleccione una categoría de servicio:");
        System.out.println("1. Mantenimiento");
        System.out.println("2. Reparación");
        System.out.println("0. Regresar");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1:
                mostrarServiciosMantenimiento();
                break;
            case 2:
                mostrarServiciosReparacion();
                break;
            case 0:
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void mostrarServiciosMantenimiento() {
        System.out.println("Servicios de Mantenimiento disponibles:");
        for (int i = 0; i < serviciosMantenimiento.size(); i++) {
            System.out.println((i + 1) + ". " + serviciosMantenimiento.get(i).getNombre());
        }
        System.out.println("Seleccione un servicio (0 para regresar):");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion > 0 && opcion <= serviciosMantenimiento.size()) {
            Servicio servicio = serviciosMantenimiento.get(opcion - 1);
            servicio.mostrarDetalle();
            realizarAdquisicion(servicio);
        }
    }

    private void mostrarServiciosReparacion() {
        System.out.println("Servicios de Reparación disponibles:");
        for (int i = 0; i < serviciosReparacion.size(); i++) {
            System.out.println((i + 1) + ". " + serviciosReparacion.get(i).getNombre());
        }
        System.out.println("Seleccione un servicio (0 para regresar):");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion > 0 && opcion <= serviciosReparacion.size()) {
            Servicio servicio = serviciosReparacion.get(opcion - 1);
            servicio.mostrarDetalle();
            realizarAdquisicion(servicio);
        }
    }

    private void realizarAdquisicion(Object item) {
        System.out.println("Ingrese su nombre:");
        String nombreCliente = scanner.nextLine();
        System.out.println("Ingrese su teléfono:");
        String telefono = scanner.nextLine();
        System.out.println("Ingrese el modelo:");
        String modelo = scanner.nextLine();
        System.out.println("Ingrese observaciones:");
        String observaciones = scanner.nextLine();

        Comprar adquisicion = new Comprar(new Date(), nombreCliente, telefono, modelo, observaciones, item);
        historial.agregarAdquisicion(adquisicion);
        System.out.println("Compra hecha con éxito.");
    }
}
