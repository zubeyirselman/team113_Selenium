package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        // sisteme webdriver' imizin ne olacagini ve bu driver' in hangi dosya yolunda oldugunu soyler
        WebDriver driver = new ChromeDriver();
        // bilgisayarimizdaki chrome browser' in otomasyonla calisacak bir kopyasini olusturur.
        // chrome disinda bir browser olusturmak istersek o browser' in driver' ini indirip,
        // System.setProperty("webdriver.safari.driver","safari driver' in dosya yolu");

        // olsuturdugumuz driver objesi bizim elimiz ve gozumuz gibidir.

        driver.get("https://amazon.com"); // istenen url' ye bizi goturur.
        // www yazmasak da calisir ama https yazmasak calismaz.

        System.out.println(driver.getTitle()); // bize title' i dondurur.
        // Amazon.com. Spend less. Smile more.

        System.out.println(driver.getCurrentUrl()); // gidilen url' yi dondurur.
        // https://www.amazon.com/

        System.out.println(driver.getPageSource());
        // gidilen web sayfasinin kaynak kodlarini dondurur.

        System.out.println(driver.getWindowHandle()); // A59DFA778E1095EF01F7A8BFF90233AE
        // acilan her bir pencereye verilen unique hash code degeridir.

        System.out.println(driver.getWindowHandles()); // [9FEB84648CE89896B93632BE73EECCB5]
        // eger driver calisirken birden fazla pencere veya tab olusturduysa
        // acilan tum windows/tab' larin unique hash code' larini bir set olarak dondurur.



        Thread.sleep(500); // milisaniye olarak yazdigimiz sayi suresince kodu bekletir.
        driver.close(); // acilan browser' i kapatir.


    }
}
