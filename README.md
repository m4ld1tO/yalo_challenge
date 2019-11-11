# Yalo WhatsApp Notifications Automation Test

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured. 

Serenity strongly encourages good test automation design, and supports several design patterns, including classic Page Objects, the newer Lean Page Objects/ Action Classes approach, and the more sophisticated and flexible Screenplay pattern.

The latest version of Serenity supports both Cucumber 2.4 and the more recent Cucumber 4.x. Cucumber 4 is not backward compatible with Cucumber 2.

## Get the code

Git:

    git clone https://github.com/m4ld1tO/yalo_challenge.git
    cd yalo_challenge

## The starter project

### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
  + test
    + java                          Test runners and supporting code
    + resources
      + features                    Feature files
      + webdriver                   Bundled webdriver binaries
        + linux
        + mac
        + windows
          chromedriver.exe          OS-specific Webdriver binaries
          geckodriver.exe

```

### Cucumber dependency
Serenity seamlessly supports both Cucumber 2.x and Cucumber 4. However, this flexibility requires a little tweaking in the build dependencies. 

If you are using Maven, you need to do the following:
- exclude the default `cucumber-core` dependency from your `serenity-core` dependency
- Replace your `serenity-cucumber` dependency with the `serenity-cucumber4` dependency
- Add dependencies on the Cucumber 4.x version of `cucumber-java` and `cucumber-junit` into your project

An example of the correctly configured dependencies is shown below:
```xml
<dependency>
    <groupId>net.serenity-bdd</groupId>
    <artifactId>serenity-core</artifactId>
    <version>2.0.38</version>
    <scope>test</scope>
    <exclusions>
        <exclusion>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-core</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>net.serenity-bdd</groupId>
    <artifactId>serenity-cucumber4</artifactId>
    <version>1.0.4</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>4.2.0</version>
</dependency>
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>4.2.0</version>
</dependency>
```

If you are using Gradle, you need to ensure that the 4.x version of `cucumber-core` is used using the _resolutionStrategy_ element, and also add the Cucumber 4.x version of `cucumber-java` and `cucumber-junit` dependencies as mentioned above:
```Gradle
configurations.all {
    resolutionStrategy {
        force "io.cucumber:cucumber-core:4.2.0"
    }
}

dependencies {
    testCompile "net.serenity-bdd:serenity-core:2.0.38",
                "net.serenity-bdd:serenity-cucumber4:1.0.4",
                "io.cucumber:cucumber-core:4.2.0",
                "io.cucumber:cucumber-junit:4.2.0"
}
```

## The Cucumber scenario with test cases

```Gherkin
Feature: Test yalobot templates on the web staging

  Scenario: Test home page with button next
    Given welcome home page
    When click button next
    Then assert try it out text in page

  Scenario: Test home page with button start now
    Given welcome home page
    When click button start now
    Then assert try it out text in page

  Scenario: Enroll phone number
    Given welcome home page
    And click button start now
    When enroll phone number
    Then assert text in step two

  Scenario: Fill and test Account Update Template
    Given enroll phone number for template
    When fill account update template
    Then assert text template
    And assert text in step three

  Scenario: Fill and test Account Update Template Complete Flow
    Given enroll phone number for template
    When fill account update template
    Then assert text template
    And assert text in step three
    And click on Continue button
    And click on GET EARLY ACCESS button
    And assert tittle in Yalochat home page

  Scenario: Fill and test Payment Update Template Complete Flow
    Given enroll phone number for template
    When fill payment update payment template
    Then assert text update payment template
    And assert text in step three
    And click on Continue button
    And click on GET EARLY ACCESS button
    And assert tittle in Yalochat home page

  Scenario: Fill and test Personal Finance Update Template Complete Flow
    Given enroll phone number for template
    When fill personal finance update template
    Then assert text personal finance template
    And assert text in step three
    And click on Continue button
    And click on GET EARLY ACCESS button
    And assert tittle in Yalochat home page
```

This scenarios let us to validate the functionality of Yalo services. 

The glue code for some scenarios uses both regular expressions and cucumber expressions. The glue code looks this this:

```java
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
```

## Executing the tests

Prerequisites

- Maven Installed and configured
- JDK 1.8

To run the project, you can either just run the `CucumberTestSuite` test runner class, or run either `mvn verify` or `gradle test` from the command line.

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```json
$ mvn clean verify -Ddriver=firefox
```
Or 
```json
$ gradle clean test -Pdriver=firefox
```

The test results will be recorded in the `target/site/serenity/index.html` file.

## Simplified WebDriver configuration and other Serenity extras
The sample projects both use some Serenity features which make configuring the tests easier. In particular, Serenity uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.  
### Webdriver configuration
The WebDriver configuration is managed entirely from this file, as illustrated below:
```java
webdriver {
    driver = chrome
}
headless.mode = false

chrome.switches="""--start-maximized;--test-type;--no-sandbox;--ignore-certificate-errors;
                   --disable-popup-blocking;--disable-default-apps;--disable-extensions-file-access-check;
                   --incognito;--disable-infobars,--disable-gpu"""

```

The project also bundles some of the WebDriver binaries that you need to run Selenium tests in the `src/test/resources/webdriver` directories. These binaries are configured in the `drivers` section of the `serenity.conf` config file:
```json
drivers {
  windows {
    webdriver.chrome.driver = "src/test/resources/webdriver/windows/chromedriver.exe"
    webdriver.gecko.driver = "src/test/resources/webdriver/windows/geckodriver.exe"
  }
  mac {
    webdriver.chrome.driver = "src/test/resources/webdriver/mac/chromedriver"
    webdriver.gecko.driver = "src/test/resources/webdriver/mac/geckodriver"
  }
  linux {
    webdriver.chrome.driver = "src/test/resources/webdriver/linux/chromedriver"
    webdriver.gecko.driver = "src/test/resources/webdriver/linux/geckodriver"
  }
}
```
This configuration means that development machines and build servers do not need to have a particular version of the WebDriver drivers installed for the tests to run correctly.

## Video for execution


See [**this youtube video**](https://www.youtube.com/watch?v=1YevFx32OtA) for more details about this feature running with Serenity BDD.

## Evidence of WhatsApp Images with the messages received

![Image enroll phone](https://i.ibb.co/fdxNn1s/Screenshot-20191111-1.jpg)

![Image enroll phone](https://i.ibb.co/YjxYST0/Screenshot-20191111-2.jpg)

![Image enroll phone](https://i.ibb.co/mtB9YMf/Screenshot-20191111-3.jpg)

![Image enroll phone](https://i.ibb.co/r2rjkJc/Screenshot-20191111-4.jpg)

![Image enroll phone](https://i.ibb.co/JmzVQkN/Screenshot-20191111-5.jpg)

