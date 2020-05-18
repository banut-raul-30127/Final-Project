package aut.utcluj.isp.ex2;

/**
 * @author stefan
 */

public class OnlineShop extends Shop {
    private String webAddress;
    private Shop shop;


    public OnlineShop(String name, String city, String webAddress) {
        super();
        Shop shop = new Shop(name, city);
        this.shop = shop;
        this.webAddress = webAddress;
    }

    public String getWebAddress() {
        return webAddress;
    }

    @Override
    public String toString() {
        return shop.toString() +  " Web address: " + webAddress;
    }
}
