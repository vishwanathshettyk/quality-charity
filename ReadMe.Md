# TIGER Project API Automation 


## Usage (WIP)

### How to run API Tests

-  Open any Test Runner class, replace with appropriate tags and run.

## Dependencies

- Rest-Assured (API Testing)
- Cucumber
- Cucumber-Pico-Container
- SLF4j
- Lombok
- JUnit
- TestNG

\* Defined with test scope in the pom file.


### Why Cucumber Pico-container?

Cucumber-pico-container is the best choice for dependency injection because it blends well with the Cucumber implementation.
For more details about dependencies injector
http://www.thinkcode.se/blog/2017/04/01/sharing-state-between-steps-in-cucumberjvm-using-picocontainer


## Overview

Tiger API test framework is a BDD framework which has the following layers

1. Feature: Its written using gherkin languages , Plain english statements describes the test cases
2. Step definition: These are pure Java classes which implements steps written in Feature file.
3. Data POJO: These java classes which is used to deserialize the YAML file (Request Data) to Java Objects
4. YAML : These are test data files (request) which are created to achieve the different scenarios.
5. Utilities: Some helper Java classes and Enums to make framework more reusable.

## Project structure (WIP)

```
+ ing-auto-test
| -- src
|    + -- main/java/au/com/ing/lendfast/servicabiltiy
|    |    |    | -- ...
|    |    + -- lendfastAdpater
|    |    |    + -- stepDefinitation
|    |    |    + -- utils
|    |    |    + -- contstants
|    |    + -- serviceabiltiyCalculator
|    |    |    + -- stepDefinitation
|    |    |    + -- utils
|    |    |    + -- contstants
|    + -- main/resourcees/features/
|    |    |    + -- lendfastAdapter.feature
|    |    |    + -- serviceabilityhomeloan.feature
|    + -- test/java/au/ing/
|    |    + -- servicability
|    |    |    + -- commonData
|    |    |    |    + -- serviceabilityBaseRequest.yml
|    |    |    + -- resiMortage
|    |    |    |    + -- serviceabilityRM.yml
|    |    |    |    + -- liability.yml
|    |    |    |    + -- personApplicant.yml
|    |    |    + -- comercialLoan
|    |    |    |    + -- serviceabilityCL.yml


```

## Guideline

The following guideline is composed by several items from _Effective Java_ book.
This framework has been implemented trying to be compliance with every points:


#### Cucumber Feature:
- Use Cucumber Scenario Outline whenever is required.
- Add @ServiceabilityCalculator tags at feature level for all features
- Use proper tags  and MTM ID for each scenario.
- Feature file name should be all lower case.
- Steps should be grammatically correct and readable.
```gherkin
    Given serviceability request is loaded
    |serviceabilityRequestDetails|testDataPath|
    |SERVICEABILITYREQUEST       |data/serviceabilityRequest.yml|  
    When request submitted to resi mortgage api
    Then response from api is 200
    And response has assessmentRate and monthlyRepayment amount
```
#### Step Definition Class:

- Prefer dependency injection to hard-wiring resources.
- Keep Step definition class final
- Use log.Info or log.Debug whenever it is required.
- Add try and catch block for Arithmetic operations
- Declare global variable if that can be used in all member functions of class

#### General JAVA Standards:
- Adhere to SOLID principles
- Check possible NPE and Handle it properly.
- Minimize mutability.
- Favor static member classes over nonstatic.
- Don't use raw types.
- Eliminate unchecked warnings.
- Use enums instead of int constants.
- Prefer lambdas to anonymous classes.
- Prefer for-each loops to traditional for loops.
- Use checked exceptions for recoverable conditions and runtime exceptions.


#### Step 1 - Feature file creation

The first step is creating the feature file. It is stored for convenience in
`src/main/resources/features`.The feature file content could be like this:

```gherkin
Feature: test gadget endpoint of batman component

    Background:
        Given the "batman" component
        When the component is up and running
		
    @HeroTag
    Scenario Outline: check info endpoint
        Given "<quanity>" of "<gadget>"
        Then return "<returned>" gadget(s) 
		
    Examples:
        | quantity | gadget    | returned  |
        | 3        | batrang   | 3         |
        | 2        | batmobile | 1         |
```

The `Feature` keyword marks the test case title. 

- `Background` specifies a list of step that will we executed before every scenario.
- `Given` step loads the data or creates the json data required for sending the request to relevant APIs
- `When` steps is used in our steps to submit the request to target API.
- `Then` steps is used for assertion

Our test case is described and define using the `Scenario Outline` keyword (for more
details about the difference between `Scenario` and `Scenario Outline` read the
Cucumber documentation).`Scenario Outline` should be used only when one test cases can be tested with different test data example
if you want to test the behavior of the target application when different data are sent for one or many json nodes (attributes).

#### Step 2 - Steps implementation

The easier way to start with a rough implementation is running Cuccumber, and so Thor.
Because we need to run only our test case we launch Thor specifying the option `--tags @HeroTag`.
We are going to get an output similar to the this one:

```java
You can implement missing steps with the snippets below:

Given("{string} of {string}", (String string, String string2) -> {
    // Write code here that turns the phrase above into concrete actions
    throw new cucumber.api.PendingException();
});

Then("return {string} gadget\\(s)", (String string) -> {
    // Write code here that turns the phrase above into concrete actions
    throw new cucumber.api.PendingException();
});
```

Now you have to create a Java class where put the implementation suggested by Cucumber. The
only contrain is that class package is a subpackage of `au.ing.lendfast`

```java
package au.ing.lendfast.lendfastAdapter.stepDefinitation;

public class LendFastAdapterStepDefinition  {
    
    final ServiceAbility serviceAbility;
    
    //Dependency Injection using Cucumber Pico Container
    public LendFastAdapterStepDefinition(ServiceAbility serviceAbility)
    {
        this.serviceAbility = serviceAbility;
    }
    
    // add your test here
}
```

#### Step 3 - Utilities

We have utilities classes created for both Lendfast Adapter and Serviceability calculator. These classes are used for creating 
some helper methods which can be called in Step definition class. We can reuse these methods across all step definition classes