public class Marketplace {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        Product<String> p1 = new Product<>(1, "Laptop", "Elektronik", 10000000);
        Product<String> p2 = new Product<>(2, "Baju", "Fashion", 150000);
        Product<String> p3 = new Product<>(3, "Kulkas", "Elektronik", 2500000);
        Product<String> p4 = new Product<>(4, "Celana", "Fashion", 170000);

        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);
        manager.addProduct(p4);

        System.out.println("\n== Daftar Produk ==");
        manager.displayAllProducts();

        System.out.println("\n== Semua Kategori ==");
        manager.displayAllCategories();

        System.out.println("\n== Cari Produk: Celana, Fashion ==");
        manager.searchProduct("Celana", "Fashion");

        System.out.println("\n== Hapus Produk ID 2 ==");
        manager.removeProductById(2);

        System.out.println("\n== Setelah Dihapus ==");
        manager.displayAllProducts();

        System.out.println("\n== Tambahkan Produk ke Antrian Proses ==");
        manager.processProduct(p1);
        manager.processProduct(p3);

        manager.showProcessedQueue();

        System.out.println("\n== Statistik Produk per Kategori ==");
        manager.showProductCountPerCategory();
    }
}