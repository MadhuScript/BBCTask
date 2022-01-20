package com.bbc.test.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bbc.test.basepage.BasePage;

import java.util.List;
import java.util.stream.IntStream;

public class NewsPage extends BasePage {

	@FindBy(xpath = "//a[contains(@class,'comment')]")
	public List<WebElement> lnkFirstCommentOnPage;

	@FindBy(xpath = "//a[text()='Comments']")
	public WebElement lnkComments;

	@FindBy(xpath = "//div[@class='comments-total']/span")
	public WebElement txtTotalComments;

	@FindBy(xpath = "//ul[@class='comments-list']")
	public WebElement ulForComments;

	@FindBy(xpath = "//a[text()='Sign in']")
	public WebElement btnSignIn;

	@FindBy(xpath = "//a[text()='Register']")
	public WebElement btnRegister;

	@FindBy(xpath = "//iframe[@title='Comments']")
	public WebElement iframeComments;

	public NewsPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickFirstNewsWhereCommentIsEnabled() {
		wait.forLoading(10);
		this.lnkFirstCommentOnPage.get(0).click();
	}

	public boolean checkCommentsButtonDisplay() {
		wait.forElementToBeDisplayed(5, this.lnkComments, "Comments Link");
		if (this.lnkComments.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void clickComments() {
		this.lnkComments.click();
	}

	public boolean checkIfCommentsCanBeViewed() {
		driver.switchTo().frame(this.iframeComments);
		wait.forElementToBeDisplayed(15, this.txtTotalComments, "Total Comments");
		this.txtTotalComments.click();
		String totalComments = this.txtTotalComments.getText().split(" ")[0];
		if (Integer.parseInt(totalComments) > 0) {
			wait.forElementToBeDisplayed(5, this.ulForComments, "Comments Unordered List");
			if (this.ulForComments.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean checkIfSignINOrRegisterIsDisplayed() {
		wait.forElementToBeDisplayed(5, this.btnSignIn, "Sign In Button");
		wait.forElementToBeDisplayed(5, this.btnRegister, "Register Button");
		if (this.btnRegister.isDisplayed() && this.btnRegister.isEnabled() && this.btnSignIn.isDisplayed()
				&& this.btnSignIn.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}
}
