package tests.womenouterwear;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.Arrays;
import java.util.List;

public class WomenOuterwearTest extends BaseTest {

    @Test
    public void sortList() throws InterruptedException { //получение и проверка списка категорий первого уровня
        basePage.open("https://lgcity.ru/outerwear/women/");
        Thread.sleep(2000);
        String [] expectedSortType = {"По новинкам ↓", "По новинкам ↑", "По возрастанию цены ↓ ", "По убыванию цены ↑", "По популярности ↓", "По популярности ↑"};
        String [] expectedSortTitle ={"Женская верхняя одежда, новая коллекция", "Женская верхняя одежда, основная коллекция", "Женская верхняя одежда, недорого", "Женская верхняя одежда, премиум", "Женская верхняя одежда, смелое", "Женская верхняя одежда, популярное"};
        int nom = 6;
        for (int n=0; n<nom; n++){
            outerWearWomen.sortListOfProduct(expectedSortType[n],expectedSortTitle[n]);

        }

    }




}
