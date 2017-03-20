#Author: Prashanth Veldandi <prashanth.veldandi@gqaustralia.edu.au>
#[PV 12.06.16]
## (Comments-)
#Sample Feature Definition Template
@FreeSkillsReview @GQSMOKE
Feature: GQ Web Freeskills Review Validation
  As QE I want to validate,User is able to sumbit the skills assessment
  
  
## (Comments-)Below Scenario will cover TS01 and TS03

  Scenario Outline: GQWeb_TS01 & TS_03 #User is able to submit the skills assessment throw the GQ Web(TS01,TS03)
    Given User Navigate to the "GQWeb" URL
    When User click the "START YOUR FREE SKILLS REVIEW"
    Then User Application should be navigated to the "Free Skills Review" Page
    When User click the "I WANT TO START NOW"
   Then User is able to see the "Step 1" from Page
    When User enter <Industry>,<Experiance>,<ExperinaceType> and <PostCode> in STEP1 Page
    And User click the "TO EXPERIENCE INFO"
    And User enter <Specificqual>,<Formalqual> and <Uploadresume> in STEP2 Page
    And User click the "To Eligibility Assessment"
    And User enter <Firstname>,<Lastname>,<Email>,<Mobile> and <Heardaboutus>  in STEP3 Page
    And User click the "SUBMIT MY INFORMATION"
    Then User Application should be navigated to the "One last question" Page
    When User is <Motivation> Free-ebook

    Examples: 
      | Industry                | Experiance | ExperinaceType | PostCode                  | Specificqual                              | Formalqual        | Uploadresume | Firstname   | Lastname   | Email                | Mobile    | Heardaboutus | Motivation |
      | Automotive              | 5-10       | Both           | 2765 Berkshire Park - NSW | Yes: Certificate II in Driling Operations | Yes:5+ Year       | Yes          | TestFirst3  | TestLast3  | Test.Test@Test.com   | 123456789 | Referral     | Yes        |
  #    | Engineering             | 1-3        | Australian     | 2650 Hillgrove - NSW      | Not Sure                                  | Yes:2-5 Years     | No           | TestFirst12 | TestLast34 | Test12.Test@Test.com | 123421234 | Online       | No         |
    #  | Business and Management | 3-5        | Overseas       | 1123 Sydney - NSW         | Yes: Diploma of Financial Planning        | Yes:Within 1 Year | Yes          | TestFirst   | TestLast   | Test.Test@Test.com   | 123456789 | TV           | Yes        |
