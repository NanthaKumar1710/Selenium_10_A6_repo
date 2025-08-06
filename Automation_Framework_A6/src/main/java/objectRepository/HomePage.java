package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(partialLinkText = "BOOKS")
	private WebElement booksLink;
	
	@FindBy(partialLinkText = "COMPUTERS")
	private WebElement computerLink;
	
	@FindBy(partialLinkText = "ELECTRONICS")
	private WebElement electronicsLink;
	
	@FindBy(linkText = "Log out")
	private WebElement logoutlink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getBooksLink() {
		return booksLink;
	}

	public WebElement getComputerLink() {
		return computerLink;
	}

	public WebElement getElectronicsLink() {
		return electronicsLink;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
	
	
	
	


}
