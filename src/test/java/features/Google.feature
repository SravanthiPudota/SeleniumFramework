Feature: Google Search

Scenario Outline: Search for different keywords

  Given User is on Google page
  When User enters "<searchText>" in search box
  Then Results should be displayed

Examples:
  | searchText |
  | Selenium   |
  | Cucumber   |
  | framework   |
  