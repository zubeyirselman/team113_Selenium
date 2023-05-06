package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_cssSelector {
    public static void main(String[] args) throws InterruptedException {

        //1-  bir class olusturun
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2-  https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //3-  Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4-  Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5-  Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedBaslikIcerik = "Spend less";
        String actualBaslikIcerik = driver.getTitle();
        if (actualBaslikIcerik.contains(expectedBaslikIcerik)){
            System.out.println("Title Testi PASSED");
        }else {
            System.out.println("Title Testi FAILED");
        }

        //6-  Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[text()='Gift Cards']")).click();

        //7-  Birthday butonuna basin
        driver.findElement(By.xpath("//img[@alt='Birthday']")).click();
        // //img[@alt='Birthday']

        //8-  Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//div[@class='a-section a-spacing-mini a-spacing-top-micro acs-product-block__product-image'])[1]")).click();

        //9-  Gift card details’den 25 $’i  secin
        driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]")).click();

        //10-Urun ucretinin 25$ oldugunu test edin
        WebElement ucretElementi = driver.findElement(By.cssSelector("span[class='a-color-price a-text-bold']"));
        String expectedDeger = "25$";
        String actualDeger = ucretElementi.getText();
        if (expectedDeger.equals(actualDeger)){
            System.out.println("Hediye Kart Ucret Testi PASSED");
        }else {
            System.out.println("Hediye Kart Ucret Testi FAILED");
            System.out.println("Beklenen Deger: 25$, Gerceklesen Deger: " + actualDeger);
        }

        //11-Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();

    }
}
