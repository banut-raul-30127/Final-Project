package aut.utcluj.isp.ex4;

import java.util.Objects;

/**
 * @author stefan
 */
public class Product {
    private String productId;
    private Double price;

    public Product(String productId, Double price) {
        this.productId = productId;
        this.price = price;

    }

    public String getProductId() {
        return this.productId;
    }

    public Double getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return this.productId.equals(product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, price);
    }
}
