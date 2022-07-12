package tests.menu;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.List;


public class MenuTest extends BaseTest {
    @Test
    public void findFirstMenu() { //полуение и проверка списка категорий первогу уровня
        int err = 0;
        basePage.open("https://lgcity.ru/");
        String [] expected = {"Верхняя одежда", "Одежда", "Нижнее белье", "Обувь", "Аксессуары", "Бренды", "Новинки", "Акции и новости", "Sale"};
        List<String> actualList = homePage.findFirst();
        for (String value : expected) {
            if (actualList.contains(value)){
                break;
            }else{
                err++;
                System.out.println("Раздел " + value + " не найден");
            }
        }
        assert err == 0;
    }

    @Test
    public void findSmallMenu() { //получение и проверка списка разделов малого меню
        basePage.open("https://lgcity.ru/");
        String [] expected = {"Магазины", "оплат", "доставка", "возврат"};
        List<String> actualList = homePage.findSmallMenu();
        for (String value : expected) {
            if (actualList.contains(value)){
                break;
            }else{
                System.out.println("Раздел " + value + " не найден");
            }
        }
    }
}
