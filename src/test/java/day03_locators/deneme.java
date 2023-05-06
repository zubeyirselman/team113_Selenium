package day03_locators;

import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class deneme {
    public static void main(String[] args) throws InterruptedException {


        //1- bulurumm.com' a gidin
        //2- kategorilerin oldugu bolumdeki elementleri locate edin
        //3- kategori bolumunde 9 element oldugunu test edin
        //4- sayfayi kapatin
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- bulurumm.com' git
        driver.get("https://bulurumm.com");

        //2- kategorilerin oldugu bolumdeki elementleri locate edin
        List<WebElement> categoryElements = driver.findElements(By.className("header-menu-list"));

        // 3- kategori bolumunde 9 element oldugunu test edin
        int expectedSize = 9;
        int actualSize = categoryElements.size();

        if (expectedSize==actualSize){
            System.out.println("Kategori Element Testi PASSED");
        }else {
            System.out.println("Kategori Element Testi FAILED");
        }


        Thread.sleep(5000);

        //4- sayfayi kapatin
        driver.close();

    }
}
