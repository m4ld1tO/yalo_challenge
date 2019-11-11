package yalo.elements.tryitout;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class TryitAction extends UIInteractionSteps {

    @Step("Enroll the phone number")
    public void enroll_phone_number() {
        $(Tryit.NAME).clear();
        $(Tryit.NAME).type("Felipe Alvarado");

        $(Tryit.PHONE).clear();
        $(Tryit.PHONE).type("5545037836");

        $(Tryit.ENROLL_BUTTON).click();
        $(Tryit.CONFIRM_BUTTON).click();
        $(Tryit.CONTINUE_BUTTON).click();
    }

    @Step("Assert text")
    public String assert_text_step_two() {
        return $(Tryit.TEXT_STEP_TWO).getText();
    }
}
