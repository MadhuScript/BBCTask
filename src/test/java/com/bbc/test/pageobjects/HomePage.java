package com.bbc.test.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bbc.test.basepage.BasePage;

public class HomePage extends BasePage {

	public static final String HOME_PAGE_URL = "https://www.bbc.co.uk/";

	@FindBy(xpath = "//button[text()='Yes, I agree']")
	public WebElement btnCookiesConsent;

	@FindBy(xpath = "//a[text()='News headlines']")
	public WebElement lnkNewsHeadlines;

	@FindBy(xpath = "//span[text()='BBC News']")
	public WebElement txtBBCNews;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void openBBCHomePage() {
		driver.get(HOME_PAGE_URL);
		wait.forLoading(5);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void checkCookiesConsentDisplay() {
		wait.forElementToBeDisplayed(5, this.btnCookiesConsent, "Cookies Consent Agree Button");
	}

	public void clickCookiesConsentAccept() {
		this.btnCookiesConsent.click();
	}

	public void clickNewsHeadlines() {
		this.lnkNewsHeadlines.click();
	}

	public boolean checkNewsPageDisplay() {
		wait.forElementToBeDisplayed(5, this.txtBBCNews, "BBC News Span");
		if (this.txtBBCNews.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}


}
