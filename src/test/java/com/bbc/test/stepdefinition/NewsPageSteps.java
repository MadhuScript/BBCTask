package com.bbc.test.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;

import com.bbc.test.pageobjects.HomePage;
import com.bbc.test.pageobjects.NewsPage;

public class NewsPageSteps {

	private NewsPage newsPage;

	public NewsPageSteps() {
		this.newsPage = new NewsPage();
	}

	@When("The user opens a comment enabled news article")
	public void the_user_opens_a_comment_enabled_news_article() {
		newsPage.clickFirstNewsWhereCommentIsEnabled();
		Assert.assertTrue(newsPage.checkCommentsButtonDisplay());

	}

	@Then("The user can check comments are displayed")
	public void the_user_can_check_comments_are_displayed() {
		newsPage.clickComments();
		Assert.assertTrue(newsPage.checkIfCommentsCanBeViewed());
		Assert.assertTrue(newsPage.checkIfSignINOrRegisterIsDisplayed());
	}
}
