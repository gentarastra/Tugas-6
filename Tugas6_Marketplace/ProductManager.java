import java.util.*;

public class ProductManager {
    private List<Product<?>> products = new ArrayList<>();
    private Set<String> categories = new HashSet<>();
    private Queue<Product<?>> processedQueue = new LinkedList<>();

    public void addProduct(Product<?> product) {
        products.add(product);
        categories.add(product.getCategory().toString());
    }

    public void removeProductById(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    public void searchProduct(String name, String category) {
        boolean found = false;
        for (Product<?> p : products) {
            if (p.getName().equalsIgnoreCase(name) &&
                p.getCategory().toString().equalsIgnoreCase(category)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("Produk tidak ditemukan.");
    }

    public void displayAllProducts() {
        List<Product<?>> sorted = new ArrayList<>(products);
        sorted.sort((a, b) -> a.getCategory().toString().compareTo(b.getCategory().toString()));
        for (Product<?> p : sorted) {
            System.out.println(p);
        }
    }

    public void displayAllCategories() {
        System.out.println("Kategori Unik:");
        for (String c : categories) {
            System.out.println("- " + c);
        }
    }

    public void processProduct(Product<?> product) {
        processedQueue.add(product);
    }

    public void showProcessedQueue() {
        System.out.println("Produk yang telah diproses:");
        for (Product<?> p : processedQueue) {
            System.out.println(p);
        }
    }

    public void showProductCountPerCategory() {
        Map<String, Integer> countMap = new HashMap<>();
        for (Product<?> p : products) {
            String key = p.getCategory().toString();
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }
        System.out.println("Jumlah Produk per Kategori:");
        countMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}