import java.util.*;

// -------------------- Enum de modelos --------------------
enum ModeloVehiculo {
    AUTO("Auto", 180, 50_000_000, "Aire acondicionado + GPS"),
    BICICLETA("Bicicleta", 25, 500_000, "Timbre + Canasta"),
    MOTO("Moto", 120, 8_000_000, "Casco incluido"),

    LANCHA("Lancha", 80, 30_000_000, "Chalecos salvavidas"),
    VELERO("Velero", 60, 40_000_000, "Vela reforzada"),
    JETSKI("Jet Ski", 100, 25_000_000, "Equipo de seguridad"),

    AVION("Avión", 900, 500_000_000, "Cabina avanzada + Piloto automático"),
    AVIONETA("Avioneta", 250, 150_000_000, "Instrumentos básicos de vuelo"),
    HELICOPTERO("Helicóptero", 300, 200_000_000, "Sistema de navegación aérea");

    private final String nombre;
    private final int velocidadMax;
    private final int precio;
    private final String equipamiento;

    ModeloVehiculo(String nombre, int velocidadMax, int precio, String equipamiento) {
        this.nombre = nombre;
        this.velocidadMax = velocidadMax;
        this.precio = precio;
        this.equipamiento = equipamiento;
    }

    public String getNombre() { return nombre; }
    public int getVelocidadMax() { return velocidadMax; }
    public int getPrecio() { return precio; }
    public String getEquipamiento() { return equipamiento; }
}

// -------------------- Clase Vehiculo --------------------
class Vehiculo {
    private final String categoria;
    private final ModeloVehiculo modelo;

    public Vehiculo(String categoria, ModeloVehiculo modelo) {
        this.categoria = categoria;
        this.modelo = modelo;
    }

    public int getPrecio() {
        return modelo.getPrecio();
    }

    public String getDescripcion(int numero) {
        return """
                Vehículo %d:
                Tipo: %s
                Categoría: %s
                Velocidad máxima: %d km/h
                Precio: $%,d
                Equipamiento: %s

                """.formatted(
                numero,
                modelo.getNombre(),
                categoria,
                modelo.getVelocidadMax(),
                modelo.getPrecio(),
                modelo.getEquipamiento()
        );
    }
}

// -------------------- Abstract Factory --------------------
abstract class VehiculoFactory {
    protected final Map<String, ModeloVehiculo> modelos = new HashMap<>();

    public Vehiculo crearVehiculo(String categoria, String opcion) {
        ModeloVehiculo modelo = modelos.get(opcion);
        return modelo != null ? new Vehiculo(categoria, modelo) : null;
    }

    public void mostrarOpciones() {
        modelos.forEach((key, value) -> System.out.println(key + ". " + value.getNombre()));
    }
}

class VehiculoTierraFactory extends VehiculoFactory {
    public VehiculoTierraFactory() {
        modelos.put("1", ModeloVehiculo.AUTO);
        modelos.put("2", ModeloVehiculo.BICICLETA);
        modelos.put("3", ModeloVehiculo.MOTO);
    }
}

class VehiculoAcuaticoFactory extends VehiculoFactory {
    public VehiculoAcuaticoFactory() {
        modelos.put("1", ModeloVehiculo.LANCHA);
        modelos.put("2", ModeloVehiculo.VELERO);
        modelos.put("3", ModeloVehiculo.JETSKI);
    }
}

class VehiculoAereoFactory extends VehiculoFactory {
    public VehiculoAereoFactory() {
        modelos.put("1", ModeloVehiculo.AVION);
        modelos.put("2", ModeloVehiculo.AVIONETA);
        modelos.put("3", ModeloVehiculo.HELICOPTERO);
    }
}

// -------------------- Clase Principal --------------------
public class ReinoVehiculos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vehiculo> vehiculos = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            System.out.println("Seleccione el tipo de vehículo:");
            System.out.println("1. Tierra");
            System.out.println("2. Acuático");
            System.out.println("3. Aéreo");
            String tipo = sc.nextLine();

            VehiculoFactory factory = switch (tipo) {
                case "1" -> new VehiculoTierraFactory();
                case "2" -> new VehiculoAcuaticoFactory();
                case "3" -> new VehiculoAereoFactory();
                default -> null;
            };

            if (factory != null) {
                System.out.println("Seleccione la categoría del vehículo:");
                System.out.println("1. Económico");
                System.out.println("2. Lujo");
                System.out.println("3. Usado");
                String categoria = sc.nextLine();

                System.out.println("Seleccione el modelo de vehículo:");
                factory.mostrarOpciones();

                String opcion = sc.nextLine();
                Vehiculo vehiculo = factory.crearVehiculo(categoria, opcion);

                if (vehiculo != null) {
                    vehiculos.add(vehiculo);
                    System.out.println("✅ Vehículo agregado con éxito!");
                } else {
                    System.out.println("❌ Opción no válida.");
                }
            }

            System.out.print("\n¿Desea agregar otro vehículo? (si/no): ");
            continuar = sc.nextLine().equalsIgnoreCase("si");
        }

        // --- Mostrar resumen ---
        System.out.println("\n---- RESUMEN DE COMPRA ---\n");
        int i = 1;
        int subtotal = 0;
        for (Vehiculo v : vehiculos) {
            System.out.println(v.getDescripcion(i++));
            subtotal += v.getPrecio();
        }

        int descuento = 0; // Aquí podrías aplicar una lógica de descuentos
        int total = subtotal - descuento;

        System.out.println("Subtotal: $" + String.format("%,d", subtotal));
        System.out.println("Descuento aplicado: $" + String.format("%,d", descuento));
        System.out.println("Total a pagar: $" + String.format("%,d", total));
        System.out.println("\n----------------");
        System.out.println("¡Gracias por su compra en el Reino de los Vehículos!");
    }
}
