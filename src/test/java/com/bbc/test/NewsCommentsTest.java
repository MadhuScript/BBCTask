package com.bbc.test;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/Features/BBC/" }, strict = false, plugin = { "pretty",
		"json:target/cucumber_json_reports/home-page.json", "html:target/home-page-html" }, glue = { "com.bbc.test.stepdefinition" })
public class NewsCommentsTest {
}
