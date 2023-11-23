package seminars.first.hw;

import java.util.*;

import static java.util.Comparator.*;

public class Shop {
    private List<Product> products;
    public Shop() {
        products = new ArrayList<>();
    }

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public Shop getSortedListProducts() {
        if (products.isEmpty()) return null;

        List<Product> sortedList = new ArrayList<>(products);
        sortedList.sort(comparingInt(Product::getCost));
        Shop shop = new Shop();
        for (int i = 0; i < sortedList.size(); i++) {
            shop.addProduct(sortedList.get(i));
        }
        return shop;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        Product mostExpensiveProduct = new Product(0, "");
        if (products.isEmpty())
            mostExpensiveProduct = null;

        else {
            for (Product product : products) {
                if (product.getCost() > mostExpensiveProduct.getCost()) {
                    mostExpensiveProduct = product;
                }
            }
        }
        return mostExpensiveProduct;
    }

    public boolean equals(Shop shop, Shop sortedShop) {
        boolean flag = true;

        for (int i = 0; i < sortedShop.getProducts().size(); i++) {
            if ((shop.getProducts().get(i).getCost() != sortedShop.getProducts().get(i).getCost())
                    & !(shop.getProducts().get(i).getTitle().equals(sortedShop.getProducts().get(i).getTitle()))) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean validListOfProduct(Shop shop, ArrayList<String> bascket) {
        boolean flag = true;
        ArrayList<String> shopbascket= new ArrayList<String>();
        for (int i = 0; i < shop.getProducts().size(); i++) {
            if (!shopbascket.contains(shop.getProducts().get(i).getTitle())) {
                shopbascket.add(shop.getProducts().get(i).getTitle());
                Collections.sort(shopbascket);
            }
        }
        if(!(bascket.size()==shopbascket.size()))
            flag=false;
        else {
           for (int i = 0; i < bascket.size(); i++) {
                if(!(bascket.get(i) == shopbascket.get(i))) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

//    public static void main(String[] args) {
//        Shop shop = new Shop();
//        shop.setProducts(Arrays.asList(
//                new Product(84, "Bread"),
//                new Product(180, "Butter"),
//                new Product(240, "Meat"),
//                new Product(42, "Water")
//        ));
//        ArrayList<String> bascket= new ArrayList<String>(Arrays.asList("Bread", "Butter", "Meat", "Water"));
//        System.out.println(shop.getProducts());
//        Product expensiveProduct = shop.getMostExpensiveProduct();
//        System.out.println(expensiveProduct);
//        System.out.println(shop.getSortedListProducts().getProducts());
//        shop.validListOfProduct(shop, bascket);
//
//    }
}