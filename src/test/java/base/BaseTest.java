package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop;

    @BeforeMethod
    public void setup() throws IOException {

        prop = new Properties();

        FileInputStream fis =
                new FileInputStream("src/test/resources/config.properties");

        prop.load(fis);

        String browser = prop.getProperty("browser");

        if(browser.equalsIgnoreCase("chrome")) {

        	WebDriverManager.chromedriver().setup();

        	Map<String, Object> prefs = new HashMap<>();
        	prefs.put("credentials_enable_service", false);
        	prefs.put("profile.password_manager_enabled", false);

        	ChromeOptions options = new ChromeOptions();
        	options.setExperimentalOption("prefs", prefs);

        	options.addArguments("--disable-notifications");
        	options.addArguments("--disable-infobars");
        	options.addArguments("--disable-extensions");
        	options.addArguments("--incognito");

        	driver = new ChromeDriver(options);

        }

        else if(browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();

            driver = new EdgeDriver();

        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(prop.getProperty("url"));

    }

    @AfterMethod

    public void tearDown() {

        if(driver != null) {

            driver.quit();

        }

    }

}