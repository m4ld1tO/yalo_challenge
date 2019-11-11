package yalo.elements.accountupdate;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class AccountAction  extends UIInteractionSteps {

    @Step("Fill account update template")
    public void account_template() throws InterruptedException {
        $(Account.USER_NAME).clear();
        $(Account.USER_NAME).type("Felipe Alvarado");
        $(Account.CLIENT_NAME).clear();
        $(Account.CLIENT_NAME).type("José Altamirano");
        $(Account.USER_ACCOUNT).clear();
        $(Account.USER_ACCOUNT).type("56134546");
        $(Account.BUTTON_SENT_MESSAGE).click();
        Thread.sleep(3000);
    }

    @Step("Click button continue")
    public void click_button_continue() throws InterruptedException {
        $(Account.BUTTON_CONTINUE_STEP_THREE).click();
        Thread.sleep(3000);
    }

    @Step("Assert text formed in template")
    public String assert_text_template() throws InterruptedException {
        Thread.sleep(3000);
        return $(Account.MESSAGE_FORMED).getText();
    }

    @Step("Assert text in step three")
    public String assert_text_step_three() {
        return $(Account.MESSAGE_STEP_THREE).getText();
    }
}
