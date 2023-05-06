package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_findElements {
    public static void main(String[] args) throws InterruptedException {


        // 1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Category bolumundeki elementleri locate edin
        List<WebElement> categoryElementsList = driver.findElements(By.className("panel-title"));

        //4- Category bolumunde 3 element oldugunu test edin
        int expectedSize = 3; // BEKLENEN DEGER
        int actualSize = categoryElementsList.size(); // GERCEKLESEN DEGER

        if (expectedSize==actualSize){
            System.out.println("Category Element Testi: PASSED");
        }else {
            System.out.println("Category Element Testi: FAILED");
        }

        //5- Category isimlerini yazdirin
        /*  System.out.println(categoryElementsList);
            Normalde bir List direk yazdirilabilir ancak,
            findElements ile bulunan elementler webelement oldugundan direk yazdirilamaz

            bir for-each loop kullanilarak listenin elementleri yazdirilabilir.
         */

        for (WebElement eachElement:categoryElementsList
             ) {
            System.out.println(eachElement.getText() + " ");
        }

        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
