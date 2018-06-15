import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test implements Runnable {

    private String url;

    public Test(String url) {
        this.url = url;
    }

    public void run() {
        try {
            System.setProperty("webdriver.chrome.driver", "C:/Users/Ilya/Documents/chromedriver_win32/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            //options.setHeadless(true);
            options.addArguments("user-data-dir=C:/Users/Ilya/AppData/Local/Google/Chrome/User Data");
            WebDriver driver = new ChromeDriver(options);
            driver.get(url);
            WebDriverWait wait = new WebDriverWait(driver, 20);

            boolean entered = false;

            while (!entered) {
                try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
                if (driver.getPageSource().contains("WE ARE LAUNCHING PROXIES FOR TODAYS RELEASE!")) {
                } else if(driver.getPageSource().contains("Adidas Instant Delivery")) {
                    System.out.println("SUCCESS! Check pages");
                    //options.setHeadless(false);
                    driver.quit();
                    WebDriver checkout = new ChromeDriver(options);
                    checkout.get(url);
                    entered = true;
                } else {
                    System.out.println("Error");
                }
            }

        } catch (Exception e) {
            System.out.println("Error; please restart");
        }
    }
}
