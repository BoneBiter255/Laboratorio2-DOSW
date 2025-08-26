import java.util.*;
import java.util.stream.Collectors;

// Interfaz estrategia
interface ConversionStrategy {
    double convert(double amount);
}

// Estrategias concretas
class EURToUSD implements ConversionStrategy {
    public double convert(double amount) {
        return amount * 1.1; // Ejemplo de tasa
    }
}

class EURToJPY implements ConversionStrategy {
    public double convert(double amount) {
        return amount * 165; // Ejemplo de tasa
    }
}

class COPToUSD implements ConversionStrategy {
    public double convert(double amount) {
        return amount / 4000; // Ejemplo de tasa
    }
}

class COPToEUR implements ConversionStrategy {
    public double convert(double amount) {
        return amount / 4400; // Ejemplo de tasa
    }
}

// Servicio que maneja las conversiones
class ConversionService {
    private final Map<String, ConversionStrategy> strategies = new HashMap<>();

    public ConversionService() {
        strategies.put("EUR-USD", new EURToUSD());
        strategies.put("EUR-JPY", new EURToJPY());
        strategies.put("COP-USD", new COPToUSD());
        strategies.put("COP-EUR", new COPToEUR());
        // Aquí se pueden agregar más estrategias fácilmente
    }

    public Optional<Double> convert(String from, String to, double amount) {
        String key = from + "-" + to;
        if (strategies.containsKey(key)) {
            return Optional.of(strategies.get(key).convert(amount));
        }
        return Optional.empty();
    }
}

// Entidad que representa una transacción
class Transaction {
    double amount;
    String fromCurrency;
    List<String> toCurrencies;

    public Transaction(double amount, String fromCurrency, List<String> toCurrencies) {
        this.amount = amount;
        this.fromCurrency = fromCurrency;
        this.toCurrencies = toCurrencies;
    }
}

// Clase principal
public class CasaDeCambio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConversionService service = new ConversionService();

        System.out.print("Ingrese número de transacciones: ");
        int numTransactions = Integer.parseInt(sc.nextLine());

        List<Transaction> transactions = new ArrayList<>();
        for (int i = 1; i <= numTransactions; i++) {
            System.out.println("---- Transacción " + i + " ----");
            System.out.print("Ingrese monto: ");
            double amount = Double.parseDouble(sc.nextLine());

            System.out.print("Ingrese moneda de origen (USD, EUR, JPY, COP): ");
            String from = sc.nextLine().toUpperCase();

            System.out.print("Ingrese monedas destino (separadas por coma, ej: USD,JPY): ");
            List<String> to = Arrays.stream(sc.nextLine().split(","))
                                    .map(String::trim)
                                    .map(String::toUpperCase)
                                    .collect(Collectors.toList());

            transactions.add(new Transaction(amount, from, to));
        }

        Map<String, Double> totals = new HashMap<>();

        int tIndex = 1;
        for (Transaction t : transactions) {
            System.out.println("\nTransacción " + tIndex++ + ": " + t.amount + " " + t.fromCurrency);
            for (String toCurrency : t.toCurrencies) {
                service.convert(t.fromCurrency, toCurrency, t.amount).ifPresentOrElse(
                    converted -> {
                        System.out.printf("Convertido a %s: %.3f %s\n", toCurrency, converted, toCurrency);
                        totals.merge(toCurrency, converted, Double::sum);
                    },
                    () -> System.out.println("No se encontró tasa de conversión para " + t.fromCurrency + " a " + toCurrency)
                );
            }
        }

        System.out.println("\n---- Totales por moneda ----");
        totals.forEach((currency, total) ->
            System.out.printf("%s: %.3f %s\n", currency, total, currency)
        );

        sc.close();
    }
}
