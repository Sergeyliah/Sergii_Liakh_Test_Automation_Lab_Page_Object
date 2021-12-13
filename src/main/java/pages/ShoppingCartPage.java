package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//rz-cart[@class='header-actions__component']")
    private WebElement cartButton;
    @FindBy(xpath = "//span[@class='counter counter--green ng-star-inserted']")
    private WebElement amountOfItems;
    @FindBy(css = ".cart-receipt__sum-price > span:nth-child(1)")
    private WebElement totalPrice;

    public void clickCartButton(){
        cartButton.click();
    }

    public WebElement getAmountOfItems() {
        return amountOfItems;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }
}
