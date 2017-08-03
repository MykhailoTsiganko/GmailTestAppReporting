package com.epam.lab.gmail.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.lab.gmail.utils.DriverManager;

public class GmailMainPage {
	private static Logger logger = Logger.getLogger(GmailMainPage.class);
	private EditMenu topEditMenu;
	private NavigationMenu navigationMenu;

	@FindBy(css = "tr.zA")
	private List<WebElement> messagesBox;

	public GmailMainPage() {
		logger.debug("GmailMainPage");

		PageFactory.initElements(DriverManager.getInstance(), this);
		navigationMenu = new NavigationMenu();
		topEditMenu = new EditMenu();
	}

	public NavigationMenu navigationMenu() {
		return navigationMenu;
	}

	public EditMenu topEditMenu() {
		return topEditMenu;
	}

	public List<MessageWidget> getMessagesWidgets() {
		logger.debug("getMessagesModels");
		List<MessageWidget> messageModelList = new ArrayList<>(messagesBox.size());
		for (WebElement element : messagesBox) {
			messageModelList.add(new MessageWidget(element));
		}
		return messageModelList;
	}

}
