package com.bbc.test.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import com.bbc.test.pageobjects.HomePage;

public class HomePageSteps {

	private HomePage homePage;

	public HomePageSteps() {
		this.homePage = new HomePage();
	}

	@Given("The user opened the home page of BBC Website")
	public void the_user_opened_the_home_page_of_BBC_Website() {
		homePage.openBBCHomePage();
		homePage.checkCookiesConsentDisplay();
		Assert.assertEquals(homePage.getTitle(), "BBC - Home");

	}

	@Given("The user agreed to cookies consent")
	public void the_user_agreed_to_cookies_consent() {
		homePage.clickCookiesConsentAccept();
		Assert.assertEquals(homePage.getTitle(), "BBC - Home");
	}

	@When("The user opens news headlines")
	public void the_user_opens_news_headlines() {
		homePage.clickNewsHeadlines();

	}

	@Then("The top headlines are displayed")
	public void the_top_headlines_are_displayed() {
		Assert.assertTrue(homePage.checkNewsPageDisplay());
	}

}
