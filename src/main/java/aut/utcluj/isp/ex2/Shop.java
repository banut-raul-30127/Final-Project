package aut.utcluj.isp.ex2;

import java.util.Objects;

/**
 * @author stefan
 */
public class Shop {
    private String name;
    private String city;


    public Shop(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Shop() {
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        if (Objects.equals(name, shop.name) && Objects.equals(city, shop.city)) {
            shop.toString();
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }

    @Override
    public String toString() {
        return "Shop: " + name + " City: " + city;
    }


}
