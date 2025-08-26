import java.util.*;
import java.util.stream.Collectors;

// -------------------- Entidad Ingrediente --------------------
class Ingredient {
    private final String name;
    private final double price;

    public Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name;
    }
}

// -------------------- Producto Complejo: Hamburguesa --------------------
class Burger {
    private final List<Ingredient> ingredients;

    public Burger(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getTotalPrice() {
        return ingredients.stream().mapToDouble(Ingredient::getPrice).sum();
    }

    public String getIngredientsList() {
        return ingredients.stream()
                .map(Ingredient::getName)
                .collect(Collectors.joining(", "));
    }

    public void showBurger() {
        System.out.println("\n--- HAMBURGUESA PERSONALIZADA ---");
        System.out.println("Ingredientes seleccionados: " + getIngredientsList());
        System.out.println("Precio total: $" + String.format("%.0f", getTotalPrice()));
        System.out.println("------------------------------");
        System.out.println("¡Disfrute su hamburguesa!");
    }
}

// -------------------- Builder --------------------
class BurgerBuilder {
    private final List<Ingredient> ingredients = new ArrayList<>();

    public BurgerBuilder addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        return this;
    }

    public Burger build() {
        return new Burger(ingredients);
    }
}

// -------------------- Menú --------------------
class Menu {
    private final Map<Integer, Ingredient> options = new HashMap<>();

    public Menu() {
        options.put(1, new Ingredient("Pan", 3000));
        options.put(2, new Ingredient("Carne", 10000));
        options.put(3, new Ingredient("Queso", 5000));
        options.put(4, new Ingredient("Lechuga", 2000));
        options.put(5, new Ingredient("Tomate", 2000));
        options.put(6, new Ingredient("Salsa especial", 3000));
    }

    public void showMenu() {
        System.out.println("Ejecutando reto 2 - Chef Burger");
        System.out.println("Seleccione ingredientes para su hamburguesa:");
        options.forEach((num, ing) ->
                System.out.println(num + ". " + ing.getName() + " ($" + String.format("%.0f", ing.getPrice()) + ")"));
        System.out.println("7. Agregar un nuevo ingrediente");
    }

    public Ingredient getIngredient(int option) {
        return options.get(option);
    }

    public void addCustomIngredient(String name, double price) {
        int newKey = options.size() + 1;
        options.put(newKey, new Ingredient(name, price));
    }
}

// -------------------- Cliente (Main) --------------------
public class ChefBurgerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        BurgerBuilder builder = new BurgerBuilder();

        menu.showMenu();
        System.out.print("Ingrese los números separados por coma: ");
        String input = sc.nextLine();
        String[] choices = input.split(",");

        for (String choice : choices) {
            int option = Integer.parseInt(choice.trim());

            if (option == 7) {
                System.out.print("Ingrese el nombre del nuevo ingrediente: ");
                String name = sc.nextLine();
                System.out.print("Ingrese el precio del ingrediente: ");
                double price = sc.nextDouble();
                sc.nextLine(); // limpiar buffer

                Ingredient custom = new Ingredient(name, price);
                builder.addIngredient(custom);
            } else {
                Ingredient ing = menu.getIngredient(option);
                if (ing != null) builder.addIngredient(ing);
            }
        }

        Burger burger = builder.build();
        burger.showBurger();
    }
}
