package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import pages.ShoppingCartPage;
import utility.Utility;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void testsSetUp() throws IOException {
        if (Utility.fetchPropertyValue ("browser").toString().equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "./src/main/driver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (Utility.fetchPropertyValue("browser").toString().equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver", "./src/main/driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (Utility.fetchPropertyValue("browser").toString().equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", "./src/main/driver/internetexplorerdriver.exe");
            driver = new InternetExplorerDriver();
        }
        else {
            System.setProperty("webdriver.chrome.driver", "./src/main/driver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(Utility.fetchPropertyValue("applicationURL").toString());
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
    public WebDriver getDriver() {
        return driver;
    }
    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }
    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(getDriver());
    }
    public ShoppingCartPage getShoppingCartPage() {
        return new ShoppingCartPage(getDriver());
    }
    public ProductPage getProductPage() {
        return new ProductPage(getDriver());
    }

}
