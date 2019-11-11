package yalo.elements.paymentupdate;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class PaymentAction extends UIInteractionSteps {

    @Step("Fill account update template")
    public void payment_template() throws InterruptedException {
        $(Payment.CHANGE_PAYMENT_TEMPLATE).click();
        $(Payment.CHANGE_PAYMENT_TEMPLATE).selectByVisibleText("Payment Update");
        Thread.sleep(3000);
        $(Payment.AMOUNT).clear();
        $(Payment.AMOUNT).type("1520");
        $(Payment.USER_NAME).clear();
        $(Payment.USER_NAME).type("Felipe Alvarado");
        $(Payment.CLIENT_NAME).clear();
        $(Payment.CLIENT_NAME).type("José Altamirano");
        $(Payment.BUTTON_SENT_MESSAGE).click();
        Thread.sleep(3000);
    }

    @Step("Click button continue")
    public void click_button_continue() throws InterruptedException {
        $(Payment.BUTTON_CONTINUE_STEP_THREE).click();
        Thread.sleep(3000);
    }

    @Step("Assert text formed in template")
    public String assert_text_template() throws InterruptedException {
        Thread.sleep(3000);
        return $(Payment.MESSAGE_FORMED).getText();
    }

    @Step("Assert text in step three")
    public String assert_text_step_three() {
        return $(Payment.MESSAGE_STEP_THREE).getText();
    }
}
