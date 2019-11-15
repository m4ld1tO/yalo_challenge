package yalo.elements.galen;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class GalenAction extends UIInteractionSteps {

    @Step("Click login Home Page")
    public void click_hp(){
        $(GalenElm.LOGINBTNHP).click();
    }

    @Step("Fill Login page")
    public void login_page() {
        $(GalenElm.USERNAME).clear();
        $(GalenElm.USERNAME).type("testuser@example.com");
        $(GalenElm.PASSWORD).clear();
        $(GalenElm.PASSWORD).type("test123");
        $(GalenElm.LOGINBTN).click();
    }

    @Step("Fill incorrect info Login page")
    public void login_page_incorrect() {
        $(GalenElm.USERNAME).clear();
        $(GalenElm.USERNAME).type("testuser");
        $(GalenElm.PASSWORD).clear();
        $(GalenElm.PASSWORD).type("test12333");
        $(GalenElm.LOGINBTN).click();
    }

    @Step("assert login form")
    public String login_form_text(){
        return $(GalenElm.LOGINFORM).getText();
    }

    @Step("assert My Notes")
    public String my_notes(){
        return $(GalenElm.HEADMYNOTES).getText();
    }

    @Step("assert on error message")
    public String error_message() {
        return $(GalenElm.INCORRECTMSG).getText();
    }

}
