package aut.utcluj.isp.ex4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stefan
 */
public class UserCart implements ICartDetails {
    private List<Product> cardProducts;
    private double totalPrice;

    public UserCart() {
        this.cardProducts = new ArrayList<>();
        totalPrice = 0;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public List<Product> getCardProducts() {
        return this.cardProducts;
    }

    /**
     * Add new product to user cart
     *
     * @param product  - product to be added
     * @param quantity - number of products of the same type to be added
     */
    public void addProductToCart(final Product product, int quantity) {
        for (char i = 0; i < quantity; i++) {
            this.cardProducts.add(product);
        }
        this.totalPrice += quantity * product.getPrice();
    }

    /**
     * Remove one product with product id from cart
     * If the product with desired id not found in the card, an {@link ProductNotFoundException} exception will be thrown
     *
     * @param productId - unique product id
     */
    public void removeProductFromCart(final String productId) throws ProductNotFoundException {
        Product product = new Product(productId, 0.0);
        if (!this.cardProducts.contains(product)) throw new ProductNotFoundException();
        else {
            product = this.cardProducts.get(this.cardProducts.indexOf(product));
            this.totalPrice -= product.getPrice();
            this.cardProducts.remove(product);
        }
    }

    /**
     * Reset user cart
     * Reset products and total price to default values
     */
    public void resetCart() {
        this.cardProducts.clear();
        totalPrice = 0;
    }

    @Override
    public String getCartDetails() {
        List<Product> distinctProducts = new ArrayList<>();
        for (Product product : this.cardProducts) {
            if (!distinctProducts.contains(product)) distinctProducts.add(product);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Product distinctProduct : distinctProducts) {
            int quantity = 0;
            for (Product product : cardProducts) {
                if (distinctProduct.equals(product)) quantity++;
            }
            stringBuilder.append("Product id: ");
            stringBuilder.append(distinctProduct.getProductId());
            stringBuilder.append(", Items: ");
            stringBuilder.append(quantity);
            stringBuilder.append("\n");
            quantity = 0;
        }
        stringBuilder.append("Total price: ");
        stringBuilder.append(totalPrice);
        return stringBuilder.toString();
    }
}
