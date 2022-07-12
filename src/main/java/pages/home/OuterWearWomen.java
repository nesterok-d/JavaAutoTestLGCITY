package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.List;
import java.util.Objects;


public class OuterWearWomen extends BasePage{
    public OuterWearWomen(WebDriver driver) {super(driver);}

    private final By sortButtun = By.cssSelector("div.select__container--city");
    private final By sort = By.cssSelector("li.js-catalog-sort-btn");
    private final By sortNewIncr = By.cssSelector("li.js-catalog-sort-btn[data-sort='new-desc']");
    private final By sortNewDecr = By.cssSelector("li.js-catalog-sort-btn[data-sort='new-asc']");
    private final By sortPriceIncr = By.cssSelector("li.js-catalog-sort-btn[data-sort='price-desc']");
    private final By sortPriceDecr = By.cssSelector("li.js-catalog-sort-btn[data-sort='price-asc']");
    private final By sortPopularIncr = By.cssSelector("li.js-catalog-sort-btn[data-sort='popular-desc']");
    private final By sortPopularDecr = By.cssSelector("li.js-catalog-sort-btn[data-sort='popular-asc']");
    private final By catalogTitle = By.cssSelector("h1.catalog__title");

    public void sortListOfProduct(String expectedSortType, String expectedSortTitle) throws InterruptedException {
        By[] listSort = new By[]{sortNewIncr, sortNewDecr, sortPriceIncr,sortPriceDecr,sortPopularIncr,sortPopularDecr};
        int i = 0;
        driver.findElement(sortButtun).click();
        Thread.sleep(2000);
        for (By sortType : listSort){
            String actualSortType = driver.findElement(sortType).getText();
            if (actualSortType.equals(expectedSortType)){
                driver.findElement(sortType).click();
                Thread.sleep(2000);
                String actualSortTitle = driver.findElement(catalogTitle).getText();
                assert Objects.equals(actualSortTitle, expectedSortTitle);
                i++;
                Thread.sleep(2000);
            }else{
                break;
            }

        }
        if (i!=1){System.out.println("нет категории " + expectedSortType);}
    }



}
