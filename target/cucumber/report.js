$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("FeatureFiles/GQWEB/FreeSkillsReview.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Prashanth Veldandi \u003cprashanth.veldandi@gqaustralia.edu.au\u003e"
    },
    {
      "line": 2,
      "value": "#[PV 12.06.16]"
    },
    {
      "line": 3,
      "value": "## (Comments-)"
    },
    {
      "line": 4,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 6,
  "name": "GQ Web Freeskills Review Validation",
  "description": "As QE I want to validate,User is able to sumbit the skills assessment",
  "id": "gq-web-freeskills-review-validation",
  "keyword": "Feature",
  "tags": [
    {
      "line": 5,
      "name": "@FreeSkillsReview"
    },
    {
      "line": 5,
      "name": "@GQSMOKE"
    }
  ]
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 10,
      "value": "## (Comments-)Below Scenario will cover TS01 and TS03"
    }
  ],
  "line": 12,
  "name": "GQWeb_TS01 \u0026 TS_03 #User is able to submit the skills assessment throw the GQ Web(TS01,TS03)",
  "description": "",
  "id": "gq-web-freeskills-review-validation;gqweb-ts01-\u0026-ts-03-#user-is-able-to-submit-the-skills-assessment-throw-the-gq-web(ts01,ts03)",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 13,
  "name": "User Navigate to the \"GQWeb\" URL",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "User click the \"START YOUR FREE SKILLS REVIEW\"",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "User Application should be navigated to the \"Free Skills Review\" Page",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "User click the \"I WANT TO START NOW\"",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "User is able to see the \"Step 1\" from Page",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "User enter \u003cIndustry\u003e,\u003cExperiance\u003e,\u003cExperinaceType\u003e and \u003cPostCode\u003e in STEP1 Page",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "User click the \"TO EXPERIENCE INFO\"",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "User enter \u003cSpecificqual\u003e,\u003cFormalqual\u003e and \u003cUploadresume\u003e in STEP2 Page",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "User click the \"To Eligibility Assessment\"",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "User enter \u003cFirstname\u003e,\u003cLastname\u003e,\u003cEmail\u003e,\u003cMobile\u003e and \u003cHeardaboutus\u003e  in STEP3 Page",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "User click the \"SUBMIT MY INFORMATION\"",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "User Application should be navigated to the \"One last question\" Page",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "User is \u003cMotivation\u003e Free-ebook",
  "keyword": "When "
});
formatter.examples({
  "line": 27,
  "name": "",
  "description": "",
  "id": "gq-web-freeskills-review-validation;gqweb-ts01-\u0026-ts-03-#user-is-able-to-submit-the-skills-assessment-throw-the-gq-web(ts01,ts03);",
  "rows": [
    {
      "cells": [
        "Industry",
        "Experiance",
        "ExperinaceType",
        "PostCode",
        "Specificqual",
        "Formalqual",
        "Uploadresume",
        "Firstname",
        "Lastname",
        "Email",
        "Mobile",
        "Heardaboutus",
        "Motivation"
      ],
      "line": 28,
      "id": "gq-web-freeskills-review-validation;gqweb-ts01-\u0026-ts-03-#user-is-able-to-submit-the-skills-assessment-throw-the-gq-web(ts01,ts03);;1"
    },
    {
      "cells": [
        "Automotive",
        "5-10",
        "Both",
        "2765 Berkshire Park - NSW",
        "Yes: Certificate II in Driling Operations",
        "Yes:5+ Year",
        "Yes",
        "TestFirst3",
        "TestLast3",
        "Test.Test@Test.com",
        "123456789",
        "Referral",
        "Yes"
      ],
      "line": 29,
      "id": "gq-web-freeskills-review-validation;gqweb-ts01-\u0026-ts-03-#user-is-able-to-submit-the-skills-assessment-throw-the-gq-web(ts01,ts03);;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5554078604,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "GQWeb_TS01 \u0026 TS_03 #User is able to submit the skills assessment throw the GQ Web(TS01,TS03)",
  "description": "",
  "id": "gq-web-freeskills-review-validation;gqweb-ts01-\u0026-ts-03-#user-is-able-to-submit-the-skills-assessment-throw-the-gq-web(ts01,ts03);;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@GQSMOKE"
    },
    {
      "line": 5,
      "name": "@FreeSkillsReview"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "User Navigate to the \"GQWeb\" URL",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "User click the \"START YOUR FREE SKILLS REVIEW\"",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "User Application should be navigated to the \"Free Skills Review\" Page",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "User click the \"I WANT TO START NOW\"",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "User is able to see the \"Step 1\" from Page",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "User enter Automotive,5-10,Both and 2765 Berkshire Park - NSW in STEP1 Page",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "User click the \"TO EXPERIENCE INFO\"",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "User enter Yes: Certificate II in Driling Operations,Yes:5+ Year and Yes in STEP2 Page",
  "matchedColumns": [
    4,
    5,
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "User click the \"To Eligibility Assessment\"",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "User enter TestFirst3,TestLast3,Test.Test@Test.com,123456789 and Referral  in STEP3 Page",
  "matchedColumns": [
    7,
    8,
    9,
    10,
    11
  ],
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "User click the \"SUBMIT MY INFORMATION\"",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "User Application should be navigated to the \"One last question\" Page",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "User is Yes Free-ebook",
  "matchedColumns": [
    12
  ],
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "GQWeb",
      "offset": 22
    }
  ],
  "location": "CommonStepDefinations.user_Navigate_to_the_URL(String)"
});
