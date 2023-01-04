Feature: test

  Background: Open amazon website in Mobile browser
    Given open amazon website in mobile browser

    @android
  Scenario: Search product in Aam
      When enter a text "mobile" in search box
      Then mobile phones are displayed