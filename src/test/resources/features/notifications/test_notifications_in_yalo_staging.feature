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