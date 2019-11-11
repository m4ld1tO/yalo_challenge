package yalo.elements.homepage;

import org.openqa.selenium.By;

public class Welcome {
    static By BUTTON_START_NOW = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div[3]/button[1]");
    static By BUTTON_NEXT      = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div[3]/button[2]");

    static By H1_TEXT_STEP_ONE = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/section/div[1]/h1");
}
