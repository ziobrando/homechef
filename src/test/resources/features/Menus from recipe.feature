Feature: Creating menus from existing recipe

  Scenario: adding a single dish to the menu
    Given recipe Canederli is displayed on screen
    When I add the recipe to my menu
    Then a menu us created with the items for recipe Canederli for 2 persons
