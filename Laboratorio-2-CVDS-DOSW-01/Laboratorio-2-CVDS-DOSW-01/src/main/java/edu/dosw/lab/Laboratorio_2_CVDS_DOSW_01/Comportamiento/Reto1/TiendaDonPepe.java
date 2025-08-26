import java.util.*;
import java.util.stream.*;

// --------- Clase Producto (solo tenis) ---------
class Producto {
    private final String nombre;
    private final double precioUnitario;

    public Producto(String nombre, double precioUnitario) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() { 
        return nombre; 
    }
    
    public double getPrecioUnitario() { 
        return precioUnitario; 
    }
}

// --------- Carrito de compras ---------
class Carrito {
    private final Map<Producto, Integer> productos = new HashMap<>();
    private Descuento descuento;

    public void agregarProducto(Producto producto, int cantidad) {
        productos.put(producto, productos.getOrDefault(producto, 0) + cantidad);
        System.out.println(producto.getNombre() + " " + cantidad + " unidades agregado al carrito.");
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public void generarRecibo(String tipoCliente) {
        System.out.println("\n--- RECIBO DE COMPRA ---");
        System.out.println("Cliente: " + tipoCliente);

        double subtotal = productos.entrySet().stream()
            .mapToDouble(e -> e.getKey().getPrecioUnitario() * e.getValue())
            .sum();

        productos.forEach((p, c) -> 
            System.out.println("- " + p.getNombre() + " - $" + (p.getPrecioUnitario() * c))
        );

        double descuentoAplicado = descuento != null ? descuento.aplicarDescuento(subtotal) : 0;
        double total = subtotal - descuentoAplicado;

        System.out.println("\nSubtotal: $" + subtotal);
        System.out.println("Descuento aplicado: $" + descuentoAplicado);
        System.out.println("Total a pagar: $" + total);
        System.out.println("------------------------");
        System.out.println("¡Gracias por su compra!");
    }
}

// --------- Clase abstracta de Descuento ---------
abstract class Descuento {
    public abstract double aplicarDescuento(double monto);
}

// --------- Descuentos concretos ---------
class DescuentoNuevo extends Descuento {
    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.05;
    }
}

class DescuentoFrecuente extends Descuento {
    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.10;
    }
}

// --------- Main (interactivo) ---------
public class TiendaDonPepe {
    public static void main(String[] args) {
        System.out.println("Ejecutando reto 1 - Tienda Don Pepe");
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a la tienda Don Pepe de Tenis Deportivos!");

        // Lista de productos disponibles
        List<Producto> productosDisponibles = Arrays.asList(
            new Producto("Nike Air", 250000),
            new Producto("Adidas UltraBoost", 300000),
            new Producto("Puma RS-X", 200000),
            new Producto("Reebok Classic", 180000)
        );

        // Mostrar catálogo
        System.out.println("\n--- Productos disponibles ---");
        for (int i = 0; i < productosDisponibles.size(); i++) {
            Producto p = productosDisponibles.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " - $" + p.getPrecioUnitario());
        }

        Carrito carrito = new Carrito();

        // Preguntar tipo de cliente
        System.out.print("\n¿Eres cliente Nuevo o Frecuente? (escribe 'nuevo' o 'frecuente'): ");
        String tipoCliente = sc.nextLine().trim().toLowerCase();

        if (tipoCliente.equals("frecuente")) {
            carrito.setDescuento(new DescuentoFrecuente());
        } else {
            carrito.setDescuento(new DescuentoNuevo());
            tipoCliente = "nuevo"; // normalizar
        }

        // Proceso de compra
        String continuar;
        do {
            System.out.print("\nIngresa el número del producto que deseas comprar: ");
            int opcion = sc.nextInt();
            System.out.print("¿Cuántas unidades deseas?: ");
            int cantidad = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            if (opcion >= 1 && opcion <= productosDisponibles.size()) {
                carrito.agregarProducto(productosDisponibles.get(opcion - 1), cantidad);
            } else {
                System.out.println("⚠ Producto inválido.");
            }

            System.out.print("\n¿Quieres agregar otro producto? (s/n): ");
            continuar = sc.nextLine().trim().toLowerCase();
        } while (continuar.equals("s"));

        // Generar recibo final
        carrito.generarRecibo(tipoCliente.substring(0,1).toUpperCase() + tipoCliente.substring(1));

        sc.close();
    }
}
