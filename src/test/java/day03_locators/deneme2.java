package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class deneme2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1- bulurumm.com' a gidin
        driver.get("https://bulurumm.com");

        //2- kategorilerin oldugu bolumdeki elementleri locate edin
        List<WebElement> kategorilerElementi = driver.findElements(By.xpath("(//div[@class='container'])[2]"));

        //3- kategori bolumunde 9 element oldugunu test edin
        int expectedSize = 9;
        int actualSize = kategorilerElementi.size();
        if (kategorilerElementi.size()==expectedSize){
            System.out.println("Kategori Element Testi PASSED");
        }else {
            System.out.println("Kategori Element Testi FAILED");
        }

        //4- sayfayi kapatin
        driver.close();
    }
}
