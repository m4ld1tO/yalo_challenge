package yalo.elements.personalfinance;

import org.openqa.selenium.By;

public class Personal {

    static By CHANGE_PAYMENT_TEMPLATE = By.id("template");

    static By USER_NAME    = By.name("user.name");
    static By CLIENT_NAME  = By.name("client.name");
    static By DATE         = By.name("date");
    static By AMOUNT       = By.name("amount");

    static By BUTTON_SENT_MESSAGE        = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[2]/div[1]/form/button");
    static By BUTTON_CONTINUE_STEP_THREE = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[2]/div[2]/div[2]/button[2]");

    static By MESSAGE_FORMED             = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[2]/div[2]/div[1]/div/div");
    static By MESSAGE_STEP_THREE         = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[2]/div[1]/h1");
}
