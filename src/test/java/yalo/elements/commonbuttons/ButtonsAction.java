package yalo.elements.commonbuttons;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class ButtonsAction extends UIInteractionSteps {

    @Step("click button continue in step three")
    public void click_button_continue_step_three(){
        $(Buttons.BUTTON_CONTINUE_TO_STEP_FOUR).click();
    }

    @Step("click on button get early access")
    public void click_button_get_early_access(){
        $(Buttons.BUTTON_GET_EARLY_ACCESS).click();
    }
}
