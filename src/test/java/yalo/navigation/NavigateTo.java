package yalo.navigation;

import net.thucydides.core.annotations.Step;

public class NavigateTo {

    YaloHomePage yaloHomePage;

    @Step("Open the Yalo Dashboard")
    public void YaloHomePage() {
        yaloHomePage.open();
    }
}
