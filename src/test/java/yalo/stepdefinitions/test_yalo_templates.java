package yalo.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import yalo.elements.accountupdate.AccountAction;
import yalo.elements.commonbuttons.ButtonsAction;
import yalo.elements.galen.GalenAction;
import yalo.elements.paymentupdate.PaymentAction;
import yalo.elements.personalfinance.PersonalAction;
import yalo.elements.tryitout.TryitAction;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import yalo.navigation.NavigateTo;
import yalo.elements.homepage.*;

import static yalo.matchers.TextMatcher.textOf;

public class test_yalo_templates {

    @Steps
    NavigateTo navigateTo;

    @Steps
    WelcomeAction welcomeAction;

    @Steps
    TryitAction tryitAction;

    @Steps
    AccountAction accountAction;

    @Steps
    ButtonsAction buttonsAction;

    @Steps
    PaymentAction paymentAction;

    @Steps
    PersonalAction personalAction;

    @Steps
    GalenAction galenAction;

    @Given("welcome home page")
    public void welcomeHomePage() {
        navigateTo.YaloHomePage();
    }

    @When("click button next")
    public void clickButtonNext() {
        welcomeAction.click_button_next();
    }

    @Then("assert try it out text in page")
    public void assertTryItOutTextInPage() {
        assertThat(welcomeAction.assert_text_step_one(), is("Try it out"));
    }

    @Given("a phone number and user name")
    public void aPhoneNumberAndUserName() {
    }

    @And("click button start now")
    public void clickButtonStartNow() {
        welcomeAction.click_button_start_now();
    }

    @When("enroll phone number")
    public void enrollPhoneNumber() {
        tryitAction.enroll_phone_number();
    }

    @Then("assert text in step two")
    public void assertStepTwo() {
        assertThat(tryitAction.assert_text_step_two(), is("Configure your first notification"));

    }

    @Given("enroll phone number for template")
    public void enrollPhoneNumberForTemplate() {
        navigateTo.YaloHomePage();
        welcomeAction.click_button_start_now();
        tryitAction.enroll_phone_number();
    }

    @When("fill account update template")
    public void fillAccountUpdateTemplate() throws InterruptedException {
        accountAction.account_template();
    }

    @Then("assert text template")
    public void assertTextTemplate() throws InterruptedException {
        assertThat(accountAction.assert_text_template(), is("Hey Felipe Alvarado. I'm messaging you from José Altamirano to let you know that I'll be using this chat to notify you about updates in your account 56134546."));
    }

    @And("assert text in step three")
    public void assertTextInStepThree() throws InterruptedException {
        accountAction.click_button_continue();
        assertThat(accountAction.assert_text_step_three(), is("Try out the REST endpoint"));
    }

    @And("click on Continue button")
    public void clickOnContinueButton() {
        buttonsAction.click_button_continue_step_three();
    }

    @And("click on GET EARLY ACCESS button")
    public void clickOnGETEARLYACCESSButton() {
        buttonsAction.click_button_get_early_access();
    }

    @And("assert tittle in Yalochat home page")
    public void assertTittleInYalochatHomePage() {
        WebDriver driver = getDriver();
        assertThat(driver.getTitle(), is("Yalo: Chatbots in WhatsApp and Facebook Messenger"));
    }

    @When("fill payment update payment template")
    public void fillPaymentUpdateTemplate() throws InterruptedException {
        paymentAction.payment_template();
    }

    @Then("assert text update payment template")
    public void assertTextUpdatePaymentTemplate() throws InterruptedException {
        assertThat(paymentAction.assert_text_template(), is("You received 1520 from Felipe Alvarado on José Altamirano Mobile."));
    }

    @When("fill personal finance update template")
    public void fillPersonalFinanceUpdateTemplate() throws InterruptedException {
        personalAction.personal_template();
    }

    @Then("assert text personal finance template")
    public void assertTextPersonalFinanceTemplate() throws InterruptedException {
        assertThat(personalAction.assert_text_template(), is("Hey Felipe Alvarado. A reminder from José Altamirano that your payment due date is 11/11/2019. Your balance is 1520."));

    }

    @Given("welcome galen home page")
    public void welcomeGalenHomePage() {
        navigateTo.YaloHomePage();
    }

    @When("click button login")
    public void clickButtonLogin() {
        galenAction.click_hp();
    }

    @Then("assert that is a login form")
    public void assertThatIsALoginForm() {
        assertThat(galenAction.login_form_text(), is("Login"));
    }

    @When("user set username and password")
    public void userSetUsernameAndPassword() {
        galenAction.login_page();

    }

    @Then("assert My Notes title")
    public void assertMyNotesTitle() {
        assertThat(galenAction.my_notes(), is("My Notes"));
    }

    @When("user set bad username and password")
    public void userSetBadUsernameAndPassword() {
        galenAction.login_page_incorrect();
    }

    @Then("assert message about incorrect information")
    public void assertMessageAboutIncorrectInformation() {
        assertThat(galenAction.error_message(), is("The username or password are incorrect"));
    }
}
