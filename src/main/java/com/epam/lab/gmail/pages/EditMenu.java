package com.epam.lab.gmail.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.lab.gmail.decorator.ElementDecorator;
import com.epam.lab.gmail.elements.Button;
import com.epam.lab.gmail.utils.DriverManager;

public class EditMenu {
    private static Logger logger = Logger.getLogger(NavigationMenu.class);

    @FindBy(xpath = "//div[@class='ar9 T-I-J3 J-J5-Ji']")
    private List<Button> deleteButtons;

    public EditMenu() {
	logger.debug("TopEditMenu constructor");
	PageFactory.initElements(new ElementDecorator(DriverManager.getInstance()), this);
    }

    public void clickDelete() {
	logger.debug("delete menthod");
	for (Button deleteButton : deleteButtons) {
	    if (deleteButton.isDisplayed()) {
		deleteButton.click();
	    }
	}
    }

}
