package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".widget:nth-child(3) .portal-grid__cell:nth-child(1) .tile-cats__heading")
    private WebElement toFindLaptopButton;
    @FindBy(xpath = "//label[@for='ASUS']")
    private WebElement selectAsusButton;
    @FindBy(xpath = "//option[@value='2: expensive']")
    private WebElement sortAscButton;

    public void clickButtonToFindLaptop(){
        toFindLaptopButton.click();
    }
    public void selectAsus(){
        selectAsusButton.click();
    }
    public void sortAsc(){
        sortAscButton.click();
    }

    public WebElement getToFindLaptopButton() {
        return toFindLaptopButton;
    }

    public WebElement getSelectAsusButton() {
        return selectAsusButton;
    }

    public WebElement getSortAscButton() {
        return sortAscButton;
    }
}
