package day05_relativeLocators_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_GoogleNutella {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        Thread.sleep(2000);

        //2- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedIcerik = "Google";
        String actualTittle = driver.getTitle();

        if (actualTittle.contains(expectedIcerik)){
            System.out.println("Title Testi PASSED");
        }else {
            System.out.println("Title Testi FAILED");
        }

        //3- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubugu = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        aramaCubugu.sendKeys("Nutella");
        Thread.sleep(2000);
        aramaCubugu.submit();

        //4- Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucYazisi.getText());

        Thread.sleep(2000);

        //5- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucYazisiStr = sonucYazisi.getText();
        String[] sonucYazisiArr = sonucYazisiStr.split(" ");
        String sonucSayisiStr = sonucYazisiArr[1].replaceAll("\\D", "");
        int sonucSayisi = Integer.parseInt(sonucSayisiStr);

        if (sonucSayisi>10000000){
            System.out.println("Sonuc Sayisi Testi PASSED");
        }else {
            System.out.println("Sonuc Sayisi Testi FAILED");
        }


        //6- Sayfayi kapatin
        driver.close();

    }
}
