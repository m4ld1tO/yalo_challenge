package yalo.elements.tryitout;

import org.openqa.selenium.By;
import java.util.*;

public class Tryit {
    static By NAME           = By.id("name");
    static By PHONE          = By.id("phone");

    static By ENROLL_BUTTON  = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/section/div[1]/form/button");
    static By CONFIRM_BUTTON = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/section/div[1]/form/div[3]/div");
    static By CONTINUE_BUTTON= By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/section/div[2]/div[2]/button[2]");

    static By TEXT_STEP_TWO  = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[2]/div[1]/h1");
}
