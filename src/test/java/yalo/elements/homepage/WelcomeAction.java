package yalo.elements.homepage;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class WelcomeAction extends UIInteractionSteps {

    @Step("Click button start now")
    public void click_button_start_now() {
        $(Welcome.BUTTON_START_NOW).click();
    }

    @Step("Click button next 4 times")
    public void click_button_next() {
        for (int i = 0; i < 4; i++) {
            $(Welcome.BUTTON_NEXT).click();
        }
    }

    @Step("Assert text")
    public String assert_text_step_one() {
        String text = $(Welcome.H1_TEXT_STEP_ONE).getText();
        return text;
    }
}
