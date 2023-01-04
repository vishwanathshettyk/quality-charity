# AmazonAssingment - UI Automation with Selenium - Java Cucumber BDD framework



## Usage (WIP)

```
mvn clean test 
```

Some arguments are optional as `plugin` and `tags`:

```
mvn clean test -Dcucumber.options="--tags @tagName"
mvn clean test -Dcucumber.options="--plugin rerun:target/rerun.txt"

```

## Dependencies

- Selenium
- Cucumber
- Cucumber-Spring
- SLF4j
- Spring
- Lombok
- JUnit

\* Defined with test scope in the pom file.


### Why Cucumber Spring?

Cucumber-Spring is the best choice for dependency
injection because it blends well with the Cucumber implementation and can also use the profile
to differentiate the test data based on the test environment.

For more details about dependencies injector
https://www.baeldung.com/cucumber-spring-integration
## Project structure (WIP)

```
+ Amazon
| -- src
|    + -- test/java/com/amzon/
|    |    + -- pages
|    |    |    | -- ...
|    |    + -- steps/
|    |    |    | -- ...
|    |    + -- springconfig/
|    |    |    | -- ...
|    |    + -- utils/
|    |    |    | -- ...
|    | -- test/resource
|    |    + -- config.json
|    |    + -- *.feature
```
- `.../pages` package contains all classes which has page objects.<br />
- `.../steps` package contains the application's entry point.<br />
- `.../springconfig` package contains the classes used for injecting objects into Cucumber steps implementation.<br />
- `.../utils` package contains all utilities classes (e.g. Query, SQLBuilder, ObjectPool, Table, etc...).<br />
- `.../features` package contains all feature files.<br />


## Guideline

The following guideline is composed by several items from _Effective Java_ book.
This framework has been implemented trying to be compliance with every points:

- Prefer dependency injection to hardwiring resources.
- Minimize mutability.
- Favor static member classes over nonstatic.
- Don't use raw types.
- Eliminate unchecked warnings.
- Use enums instead of int costants.
- Prefer lambdas to anonymous classes.
- Prefer for-each loops to traditional for loops.
- Use checked exceptions for recoverable conditions and runtime exceptions.


#### Step 1 - Feature file creation

The first step is creating the feature file. It is stored for convenience in
`src/test/resources/features` but it is hosted in `tests` directory
of the component repository as well. The feature file content could be like this:

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

The `Feature` keyword marks the test case title. The `Background` specifies
a list of step that will we executed before every scenario. `Thor` framework
provide a ready-implementation for background steps:

- `Given the "<var>" compontent` this step sets the component with  `<var>`
  name as current target of the test in order to retrieve component informations in
  other steps.
- `When the component is up and running` check up if the component set as
  target of the test is up and running.

Our test case is described and define using the `Scenario Outline` keyword (for more
details about the difference between `Scenario` and `Scenario Outline` read the
Cucumber documentation). The sentence after `Scenario Outline` is the test case
description. For testing the `gadget` endpoint we have defined two steps. In the first one,
we are going to set a gadget request providing its name and its quantity. In the second step
we are going to check the result: the number of gadget expected (e.g we suppose batman owns
3 batrang but when he needs two batmobile only one is returned). In this two steps we define
three variable, `quantity`, `gadget` and `result` that will be evaluated during the
execution phase. Finally we have to define the dataset used for evaluating the variables.
For doing this we use the keyword `Examples` followed by a little rough table where the
first row is the header.

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
only contrain is that class package is a subpackage of `com.ing.cucumber` but it's
suggested to use something like `com.ing.cucumber.setpdefs.rest.superhero`.

```java
package com.amazon.steps;
import com.amazon.pages.HomePage;

public class HomeSteps implements En {

    @Autowired
    HomePage homepage;
    
    // add your test here
}
```

#### Step 4 - Page Implementation

Every Step classes will have its own page class which interacts with Browser using WebDriver.

```java
package com.amazon.pages;

public class HomeSteps  {
	
    @Autowired
    ApplicationSetup applicationSetup;
    
    // add your test here
}
```
`
