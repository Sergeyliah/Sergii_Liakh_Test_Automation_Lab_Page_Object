package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@id='fat-menu']")
    private WebElement menuButton;
    @FindBy(xpath = "//ul[@class='menu-categories ng-star-inserted']/li[1]")
    private WebElement toFindComputersButton;

    public void clickMenuButton(){
        menuButton.click();
    }
    public void clickToFindComputersButton(){
        toFindComputersButton.click();
    }

    public WebElement getMenuButton() {
        return menuButton;
    }

    public WebElement getToFindComputersButton() {
        return toFindComputersButton;
    }
}
