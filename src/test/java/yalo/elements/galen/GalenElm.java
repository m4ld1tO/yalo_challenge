package yalo.elements.galen;

import org.openqa.selenium.By;

public class GalenElm {
    static By USERNAME = By.name("login.username");
    static By PASSWORD = By.name("login.password");

    static By LOGINBTN = By.xpath("//*[@id=\"login-page\"]/p[3]/button[1]");
    static By CANCELBTN = By.xpath("//*[@id=\"login-page\"]/p[3]/button[2]");

    static By HEADMYNOTES = By.xpath("//*[@id=\"my-notes-page\"]/h2");
    static By HEADHP = By.xpath("//*[@id=\"welcome-page\"]/h1");

    static By LOGINBTNHP = By.xpath("//*[@id=\"welcome-page\"]/p[3]/button");

    static By LOGINFORM = By.xpath("//*[@id=\"login-page\"]/h2");
    static By INCORRECTMSG = By.id("login-error-message");
}
