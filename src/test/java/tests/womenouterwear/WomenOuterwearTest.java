package tests.womenouterwear;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.Arrays;
import java.util.List;

public class WomenOuterwearTest extends BaseTest {

    @Test
    public void sortList() throws InterruptedException { //полуение и проверка списка категорий первогу уровня
        basePage.open("https://lgcity.ru/outerwear/women/");
        outerWearWomen.sortListOfProduct();
    }




}
