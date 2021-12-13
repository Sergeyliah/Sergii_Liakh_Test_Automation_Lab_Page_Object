package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Utility;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.List;

public class AddToCartTests extends BaseTest{
    private static final String CURRENCY_RATE_URL = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
    private static final String CURRENCY_RATE_XML_PATH = "C:\\Users\\Sergey\\IdeaProjects\\Sergii_Liakh_Test_Automation_Lab_Page_Object\\src\\main\\properties\\currency_rate.xml";
    private static final String AMOUNT_OF_ITEMS = "amountOfItems";
    private static final String TOTAL_PRICE = "totalPrice";
    private static final long WAITING_TIME = 30;


    @Test
    public void tc_001() throws IOException, XPathExpressionException {
        getHomePage().clickMenuButton();
        getHomePage().clickToFindComputersButton();
        getHomePage().waitVisibilityOfElement(WAITING_TIME,getSearchResultsPage().getToFindLaptopButton());
        getSearchResultsPage().clickButtonToFindLaptop();
        getHomePage().waitVisibilityOfElement(WAITING_TIME, getSearchResultsPage().getSelectAsusButton());
        getSearchResultsPage().selectAsus();
        getHomePage().waitVisibilityOfElement(WAITING_TIME, getSearchResultsPage().getSortAscButton());
        getSearchResultsPage().sortAsc();
        try {
            List<WebElement> list = getProductPage().getBuyButtons();
            list.get(0).click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            List <WebElement> list = getProductPage().getBuyButtons();
            list.get(0).click();
        }
        getShoppingCartPage().clickCartButton();
        Assert.assertEquals(Integer.parseInt((String) Utility.fetchPropertyValueXML(AMOUNT_OF_ITEMS)), Integer.parseInt(getShoppingCartPage().getAmountOfItems().getText()));
        Utility.downloadUsingStream(CURRENCY_RATE_URL, CURRENCY_RATE_XML_PATH);
        double currencyRate = Utility.XMLParser(CURRENCY_RATE_XML_PATH);
        Assert.assertTrue(Integer.parseInt(getShoppingCartPage().getTotalPrice().getText())<Integer.parseInt((String) Utility.fetchPropertyValueXML(TOTAL_PRICE))*currencyRate);
    }
}
