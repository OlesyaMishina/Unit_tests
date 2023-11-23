package seminars.first.hw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setExtractBareNamePropertyMethods;


public class ShopTest {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.setProducts(Arrays.asList(
                new Product(84, "Bread"),
                new Product(180, "Butter"),
                new Product(240, "Meat"),
                new Product(42, "Water")
        ));


//     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
        assertThat(shop.getProducts()).isNotEmpty().hasSize(4);
        ArrayList<String> bascket= new ArrayList<String>(Arrays.asList("Bread", "Butter", "Meat", "Water"));
        assertThat(shop.validListOfProduct(shop, bascket)).isTrue();


//     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
        assertThat(shop.getMostExpensiveProduct().getCost()).isEqualTo(240);

//     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
        Shop expectedShop = new Shop();
        expectedShop.setProducts(Arrays.asList(
               new Product(42, "Water"),
                new Product(84, "Bread"),
//                new Product(42, "Water"),
                new Product(180, "Butter"),
                new Product(240, "Meat")
        ));
        Shop sortedShop=new Shop();
        sortedShop = shop.getSortedListProducts();
        assertThat(shop.equals(expectedShop, sortedShop)).isTrue();
    }
}




