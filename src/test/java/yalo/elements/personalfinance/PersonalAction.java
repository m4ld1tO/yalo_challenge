package yalo.elements.personalfinance;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class PersonalAction extends UIInteractionSteps {

    @Step("Fill account update template")
    public void personal_template() throws InterruptedException {
        $(Personal.CHANGE_PAYMENT_TEMPLATE).click();
        $(Personal.CHANGE_PAYMENT_TEMPLATE).selectByVisibleText("Personal Finance Update");
        Thread.sleep(3000);
        $(Personal.USER_NAME).clear();
        $(Personal.USER_NAME).type("Felipe Alvarado");
        $(Personal.CLIENT_NAME).clear();
        $(Personal.CLIENT_NAME).type("José Altamirano");
        $(Personal.DATE).clear();
        $(Personal.DATE).type("11/11/2019");
        $(Personal.AMOUNT).clear();
        $(Personal.AMOUNT).type("1520");
        $(Personal.BUTTON_SENT_MESSAGE).click();
        Thread.sleep(3000);
    }

    @Step("Click button continue")
    public void click_button_continue() throws InterruptedException {
        $(Personal.BUTTON_CONTINUE_STEP_THREE).click();
        Thread.sleep(3000);
    }

    @Step("Assert text formed in template")
    public String assert_text_template() throws InterruptedException {
        Thread.sleep(3000);
        return $(Personal.MESSAGE_FORMED).getText();
    }

    @Step("Assert text in step three")
    public String assert_text_step_three() {
        return $(Personal.MESSAGE_STEP_THREE).getText();
    }
}
