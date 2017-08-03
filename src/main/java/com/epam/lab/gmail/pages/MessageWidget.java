package com.epam.lab.gmail.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.lab.gmail.decorator.ElementDecorator;
import com.epam.lab.gmail.elements.Label;
import com.epam.lab.gmail.utils.DriverManager;

public class MessageWidget {
	private static Logger logger = Logger.getLogger(NavigationMenu.class);

	public static final String NOT_IMPORTANT_MESSAGE_CLASS = "pH-A7 a9q";
	public static final String IMPORTANT_MESSAGE_ELEM = ".//*[@class='pH a9q']";

	private WebElement currentContext;

	@FindBy(xpath = ".//*[@class='pG']/div[2]")
	private WebElement importanceMarker;

	@FindBy(xpath = ".//td[@class='oZ-x3 xY']")
	private WebElement checkBox;

	@FindBy(xpath = ".//div[@class='yW']/span")
	private Label sender;

	@FindBy(xpath = ".//span[@class='bog']")
	private Label topic;

	@FindBy(xpath = ".//td[@class='xW xY ']/span")
	private Label date;

	public MessageWidget(WebElement elem) {
		logger.debug("MessageWidget constructor");
		PageFactory.initElements(new ElementDecorator(elem), this);
		this.currentContext = elem;
	}

	public boolean isNotImportant() {
		logger.debug("isNotImportant method");
		return importanceMarker.getAttribute("class").equals(NOT_IMPORTANT_MESSAGE_CLASS);
	}

	public void clickOnImportantMarker() {
		logger.debug("clickOnImportantMarker method");
		new Actions(DriverManager.getInstance()).click(importanceMarker).build().perform();
		new WebDriverWait(DriverManager.getInstance(), 10).until(
				ExpectedConditions.presenceOfNestedElementLocatedBy(currentContext, By.xpath(IMPORTANT_MESSAGE_ELEM)));
	}

	public void clickOnMarker() {
		logger.debug("clickOnMarker method");
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getInstance();
		js.executeScript("arguments[0].click();", checkBox);
	}

	public String getDate() {
		logger.debug("getDate method");

		return date.getAttribute("aria-label");
	}

	public String getSender() {
		logger.debug("getSender method");
		return sender.getContex();
	}

	public String getTopic() {
		logger.debug("getTopic method");
		return topic.getContex();
	}

}
