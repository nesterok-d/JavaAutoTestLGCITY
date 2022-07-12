package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Home extends BasePage {

    public Home(WebDriver driver) {
        super(driver);
    }

    private final By userLocator = By.id("header-title-user-location"); //город
    private final By smallMenu = By.cssSelector("div.header__top div.wrapper div.header__right-nav ul li a"); //меню: магазины, оплата, доставка, возврат.
    private final By women = By.cssSelector("div.header__nav-button[data-gender= 'women']");//фильтр:женщинам
    private final By men = By.cssSelector("div.header__nav-button[data-gender= 'men']"); //фильтр мужчинам
    private final By menu = By.cssSelector("nav.header__nav-list div.header__nav-list-item");//список категорий меню
    private final By catalogSection = By.id("menu-340");
    private final By product = By.cssSelector("div.swiper-slide-active[data-index='0']");
    private final By buttonCart = By.id("btn-add-to-cart");
    private final By cart = By.cssSelector("a.js-header-basket[data-popup='popup--basket']");
    private final By nameProduct = By.cssSelector("span.card__info-desc");
    private final By nameProductInCart = By.cssSelector("p.basket__item-desc");

    public List<String> findFirst(){
        String [] actual = new String[9];
        int i =0;
        for (WebElement element:driver.findElements(menu)) {
            if(i<9){
                actual[i] = element.getText();
                i++;
            }
        }
        return (List<String>) Arrays.asList(actual);
    }

    public List<String> findSmallMenu(){
        String [] actual = new String[4];
        int i =0;
        for (WebElement element:driver.findElements(smallMenu)) {
            if(i<4){
                actual[i] = element.getText();
                i++;
            }
        }
        return (List<String>) Arrays.asList(actual);
    }




    //переход в карзину
    public Home toCart(){
        driver.findElement(cart).click();
        //String nameTextInCart = driver.findElement(nameProductInCart).getText();
        return this;
    }

}

