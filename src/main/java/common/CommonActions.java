package common;
//данный пакет опясывает запуск браузера

//импорт встроенных библиотек и классов

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static common.Config.PLATFORM;
import static constants.Constants.TimeoutVariable.IMPLICIT_WAIT;

//описание запуска браузера
public class CommonActions {
    public static WebDriver createDriver(){
        WebDriver driver = null;
        switch(PLATFORM){
            case "win_chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            //default:
                //Assert.fail("Incorrect platform" + PLATFORM);
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

} //обновление проекта
