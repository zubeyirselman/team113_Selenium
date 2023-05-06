package day03_locators;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_AutomationExercise {
    public static void main(String[] args) throws InterruptedException {

        // 1- bir test class' i olusturun
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- https:// www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        // 3- sayfada 147 adet link bulundugunu test edin
        List<WebElement> sayfadakiLinkElementleri = driver.findElements(By.tagName("a")); // linkler html'de a ile ifade edildigi icin a arattik
        int expectedLinkSayisi = 147;
        int actualLinkSayisi = sayfadakiLinkElementleri.size();

        if (expectedLinkSayisi==actualLinkSayisi){
            System.out.println("Link Sayisi Testi PASSED");
        }else {
            System.out.println("Link Sayisi Testi FAILED");
        }

        // 4- products linkine tiklayin
        WebElement productsLinkElementi = driver.findElement(By.partialLinkText("Products"));
        productsLinkElementi.click();

        // 5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferYazisi = driver.findElement(By.id("sale_image"));
        if (specialOfferYazisi.isDisplayed()){
            System.out.println("Special Offer Testi PASSED");
        }else {
            System.out.println("Special Offer Testi FAILED");
        }


        Thread.sleep(2000);
        // 6- sayfayi kapatin
        driver.close();
    }
}
