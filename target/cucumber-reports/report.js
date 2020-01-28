$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test3.feature");
formatter.feature({
  "line": 1,
  "name": "POM and Cucumber Test",
  "description": "Description: The purpose of this feature file is to implment POM with Cucmber",
  "id": "pom-and-cucumber-test",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Customer place an order by purchasing an item from search",
  "description": "",
  "id": "pom-and-cucumber-test;customer-place-an-order-by-purchasing-an-item-from-search",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "user is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user search for \"dress\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "choose \"\u003ctestCaseID\u003e\" to buy the first item",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "moves to checkout from mini cart",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "enter \"\u003ctestCaseID\u003e\" personal details on checkout page",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "place the order",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "verify the order details",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "pom-and-cucumber-test;customer-place-an-order-by-purchasing-an-item-from-search;",
  "rows": [
    {
      "cells": [
        "testCaseID"
      ],
      "line": 14,
      "id": "pom-and-cucumber-test;customer-place-an-order-by-purchasing-an-item-from-search;;1"
    },
    {
      "cells": [
        "TestCase2"
      ],
      "line": 15,
      "id": "pom-and-cucumber-test;customer-place-an-order-by-purchasing-an-item-from-search;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 11793424500,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Customer place an order by purchasing an item from search",
  "description": "",
  "id": "pom-and-cucumber-test;customer-place-an-order-by-purchasing-an-item-from-search;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "user is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user search for \"dress\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "choose \"TestCase2\" to buy the first item",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "moves to checkout from mini cart",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "enter \"TestCase2\" personal details on checkout page",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "place the order",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "verify the order details",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageSteps.user_is_on_Home_Page()"
});
formatter.result({
  "duration": 10412863900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "dress",
      "offset": 17
    }
  ],
  "location": "HomePageSteps.user_search_for(String)"
});
formatter.result({
  "duration": 5656324100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TestCase2",
      "offset": 8
    }
  ],
  "location": "ProductPageSteps.choose_to_buy_the_first_item(String)"
});
formatter.result({
  "duration": 7444951600,
  "status": "passed"
});
formatter.match({
  "location": "CartPageSteps.moves_to_checkout_from_mini_cart()"
});
formatter.result({
  "duration": 3400939700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TestCase2",
      "offset": 7
    }
  ],
  "location": "CheckoutPageSteps.enter_personal_details_on_checkout_page(String)"
});
formatter.result({
  "duration": 1035384700,
  "status": "passed"
});
formatter.match({
  "location": "CheckoutPageSteps.place_the_order()"
});
formatter.result({
  "duration": 2189335500,
  "status": "passed"
});
formatter.match({
  "location": "ConfirmationPageSteps.verify_the_order_details()"
});
formatter.result({
  "duration": 41760000,
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat org.junit.Assert.assertTrue(Assert.java:52)\r\n\tat StepDefinition.ConfirmationPageSteps.verify_the_order_details(ConfirmationPageSteps.java:23)\r\n\tat ✽.Then verify the order details(test3.feature:11)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 7588636600,
  "status": "passed"
});
});