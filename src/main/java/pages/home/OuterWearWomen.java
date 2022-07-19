package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.List;
import java.util.Objects;


public class OuterWearWomen extends BasePage{
    public OuterWearWomen(WebDriver driver) {super(driver);}

    private final By sortButtun = By.cssSelector("input.select__container-text");
    private final By sort = By.cssSelector("li.js-catalog-sort-btn");
    private final By sortNewIncr = By.cssSelector("li.js-catalog-sort-btn[data-sort='new-desc'] a");
    private final By sortNewDecr = By.cssSelector("li.js-catalog-sort-btn[data-sort='new-asc'] a");
    private final By sortPriceIncr = By.cssSelector("li.js-catalog-sort-btn[data-sort='price-desc'] a");
    private final By sortPriceDecr = By.cssSelector("li.js-catalog-sort-btn[data-sort='price-asc'] a");
    private final By sortPopularIncr = By.cssSelector("li.js-catalog-sort-btn[data-sort='popular-desc'] a");
    private final By sortPopularDecr = By.cssSelector("li.js-catalog-sort-btn[data-sort='popular-asc'] a");
    private final By catalogTitle = By.cssSelector("h1.catalog__title");

    public void sortListOfProduct() throws InterruptedException {
        By[] listSort = new By[]{sortNewIncr, sortNewDecr, sortPriceIncr,sortPriceDecr,sortPopularIncr,sortPopularDecr};
        String [] expectedSortType = {"По новинкам ↓", "По новинкам ↑", "По возрастанию цены ↓ ", "По убыванию цены ↑", "По популярности ↓", "По популярности ↑"};
        String [] expectedSortTitle ={"Женская верхняя одежда, новая коллекция", "Женская верхняя одежда, основная коллекция", "Женская верхняя одежда, недорого",
                "Женская верхняя одежда, премиум", "Женская верхняя одежда, смелое", "Женская верхняя одежда, популярное"};
        for (int i = 0; i< 6; i++){
            driver.findElement(sortButtun).click();
            Thread.sleep(2000);
            String actualSortType = driver.findElement(listSort[i]).getText();
            if (actualSortType.contains(expectedSortType[i])){
                driver.findElement(listSort[i]).click();
                Thread.sleep(2000);
                String actualSortTitle = driver.findElement(catalogTitle).getText();
                assert Objects.equals(actualSortTitle, expectedSortTitle[i]);
                Thread.sleep(2000);
            }else{
                System.out.println("нет категории " + expectedSortType[i]);
                break;
            }

        }
    }



}
