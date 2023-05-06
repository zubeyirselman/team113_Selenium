package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Locator {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://amazon.com/ sayfasina gidin
        driver.get("https://amazon.com");

        // 2- arama kutusuna "city bike" yazip aratin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER); // arama kutusuna yazip enter' a basar.

        // 3- goruntulenen sonuclarin sayisini yazdirin
        WebElement goruntulenenSonucSayisi = driver.findElement(By.className("sg-col-inner"));
        System.out.println(goruntulenenSonucSayisi.getText()); // 1-16 of 250 results for "city bike"

        // 4- listeden ilk urunun resmine tiklayin
        List<WebElement> ilkUrununResmi = driver.findElements(By.className("s-image"));
        ilkUrununResmi.get(0).click();


        Thread.sleep(4000);
        driver.close();
    }
}
