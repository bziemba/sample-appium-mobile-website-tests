Feature: Scrolling through banners

  Scenario: Can scroll to third banner
    Given User launches travelex website
    And User dismisses cookies message
    When User scrolls to banner
    Then User can swipe to third banner