package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebElementMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon anasayfaya gidip arama kutusunu locate edelim

        driver.get("https://amazon.com");
        WebElement aramaKutusuElementi =driver.findElement(By.id("twotabsearchtextbox"));
        System.out.println(aramaKutusuElementi.isDisplayed()); // gorunuyor mu? true
        System.out.println(aramaKutusuElementi.isEnabled()); // etkilesme acik mi? true

        System.out.println(aramaKutusuElementi.getText()); // varsa, webelementin uzerindeki yaziyi getirir.

        aramaKutusuElementi.sendKeys("Nutella"); // arama kutusuna "Nutella" yazar.
        Thread.sleep(2000);
        aramaKutusuElementi.clear(); // arama kutusuna yazdigimiz seyi siler.

        System.out.println(aramaKutusuElementi.getSize()); // (618, 38) x ekseninde 618px, ye ekseninde 38px
        System.out.println(aramaKutusuElementi.getSize().height); // 38px

        System.out.println(aramaKutusuElementi.getTagName()); // input ==> tag ismini verdi
        System.out.println(aramaKutusuElementi.getAttribute("class")); // nav-input nav-progressive-attribute
        // arama cubugunun html elementindeki class attribute' unun degerini yazdirdi.

        System.out.println(aramaKutusuElementi.getLocation()); // (279, 11) pixel olarak konumu

        System.out.println(aramaKutusuElementi.getRect().getDimension()); // (618, 38)


        Thread.sleep(3000);
        driver.close();


    }
}
