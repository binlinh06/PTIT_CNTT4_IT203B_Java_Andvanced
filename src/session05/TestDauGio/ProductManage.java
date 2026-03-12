package session05.TestDauGio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class ProductManage {
    private List<Product> products = new ArrayList<Product>();

    public void addProduct(Product product) throws InvalidProductException {
        boolean exists = products.stream()
                .anyMatch(p -> p.getId() == product.getId());
        if (exists) {
            throw new InvalidProductException("ID đã tồn tại");
        }
        products.add(product);
    }

    public void displayProducts() {
        for (Product p : products) {
            System.out.printf("ID:%-5d Name:%-15s Price:%-10.2f Quantty:%-10d Category:%-15s\n",
                    p.getId(),
                    p.getName(),
                    p.getPrice(),
                    p.getQuantity(),
                    p.getCategory());
        }
    }

    public void updateQuantity(int id, int newQuantity) throws InvalidProductException {

        Optional<Product> result = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (result.isPresent()) {
            result.get().setQuantity(newQuantity);
        } else {
            throw new InvalidProductException("Không tìm thấy sản phẩm!");
        }
    }

    public void deleteOutOfStock() {
        products.removeIf(p -> p.getQuantity() == 0);
    }
}
