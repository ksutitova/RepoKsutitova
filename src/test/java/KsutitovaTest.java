import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class KsutitovaTest {

    /**
     * TC_11_01
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на пункт меню Guide
     * 3.  Подтвердить, что вы перешли на страницу со ссылкой
     * https://openweathermap.org/guide и что title этой страницы
     * // OpenWeatherMap API guide - OpenWeatherMap
     **/

    @Test
    public void testH2TextOpenWeatherMapInGuideLink() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/ksenianehotina/Chromedriver/chromedriver3");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResultTitle = "OpenWeatherMap API guide - OpenWeatherMap";
        String expectedResultUrl = "https://openweathermap.org/guide";

        driver.get(url);

        WebElement menuGuide = driver.findElement(
                By.xpath("//div[@id='desktop-menu']/ul/li/a[@href='/guide']")
        );
//      driver.get(menuGuide.getAttribute("href"));

        Thread.sleep(5000);
        menuGuide.click();

        String urlGuede = driver.getCurrentUrl();
        String title = driver.getTitle();

        Assert.assertEquals(urlGuede, expectedResultUrl);
        Assert.assertEquals(title, expectedResultTitle);

        driver.quit();
    }

    /**
     * TC_11_02
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на единицы измерения Imperial: °F, mph
     * 3.  Подтвердить, что температура для города показана в Фарингейтах
     **/

    @Test
    public void testConfirmTemperatureFaringate() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/ksenianehotina/Chromedriver/chromedriver3");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "F";

        driver.get(url);

        WebElement imperialF = driver.findElement(
                By.xpath("//div[text()='Imperial: °F, mph']")
        );
        Thread.sleep(5000);
        imperialF.click();

        WebElement faringate = driver.findElement(
                By.xpath("//div[@class = 'current-temp']/span")
        );

        Thread.sleep(5000);
        String actualResult = faringate.getText();

        Assert.assertTrue(actualResult.contains("F"));

        driver.quit();
    }

    /**
     * TC_11_04
     * 1.  Открыть базовую ссылку
     * 2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”
     **/

    @Test
    public void testSubMenu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/ksenianehotina/Chromedriver/chromedriver3");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "FAQ How to start Ask a question ";

        driver.get(url);

        driver.manage().window().maximize();
        WebElement support = driver.findElement(By.xpath(" //div[@id='support-dropdown']"));

        Thread.sleep(5000);
        support.click();

        List<WebElement> allSupportMenu = driver.findElements(
                By.xpath("//ul[@class='dropdown-menu dropdown-visible']/li/a")
        );
        String actualResult = "";
        for (WebElement supportMenu : allSupportMenu) {
            actualResult += supportMenu.getText() + " ";
        }

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
    
}