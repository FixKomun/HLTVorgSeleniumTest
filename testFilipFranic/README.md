# HLTVSeleniumTest

## Selenium

Selenium is a free (open source) automated testing suite for web applications across different browsers and platforms.

### 	Selenium WebDriver 
  Selenium WebDriver is an API that allows us to write automated tests for web applications. The automated tests that use Selenium    WebDriver are run by using a web browser. In other words, Selenium WebDriver helps us to verify that our application is working as expected when it is used by a real user.

#### 	--Simple and concise
WebDriver is simple, it is designed as a concise and compact programming interface.

#### 	--Works in all major browsers
Through a simple setup, WebDriver can be used with all major browsers. Automate real user interactions in Firefox, Safari, Edge, Chrome, Internet Explorer and more! Selenium WebDriver refers to both the language bindings and the implementations of the individual browser controlling code. This is commonly referred to as just WebDriver.


## TestNG

TestNG is a testing framework inspired from JUnit and NUnit but introducing some new functionalities that make it more powerful and easier to use, such as:

- Annotations.
- Run your tests in arbitrarily big thread pools with various policies available (all methods in their own thread, one thread per test class, etc...).
- Test that your code is multithread safe.
- Flexible test configuration.
- Support for data-driven testing (with @DataProvider).
- Support for parameters.
- Powerful execution model (no more TestSuite).
- Supported by a variety of tools and plug-ins (Eclipse, IDEA, Maven, etc...).
- Embeds BeanShell for further flexibility.
- Default JDK functions for runtime and logging (no dependencies).
- Dependent methods for application server testing.

TestNG is designed to cover all categories of tests:  unit, functional, end-to-end, integration, etc...


## Page Object Model (POM)
Page Object Model is a design pattern to create Object Repository for web UI elements. Under this model, for each web page in the application, there should be corresponding page class. This Page class will find the WebElements of that web page and also contains Page methods which perform operations on those WebElements.

<img src="https://testerworldhome.files.wordpress.com/2019/06/page-object-model-design-pattern-1.jpg" alt="POM"/>

## Cross Browser Testing

Cross browser testing involves checking compatibility of your application across multiple web browsers and ensures that your web application works correctly across different web browsers.
It is also possible to run parallel executes on 2 or more browsers.

<img src="https://www.cyberrafting.com/blog/wp-content/uploads/2016/10/cross-browser-comptabile.jpg" alt="Cross browser testing"/>

## WebDriverManager
WebDriverManager gets the browser version and downloads relevant binaries/executables in an automated way; This helps us to avoid all the manual steps that we previously had to do, related to browser driver setup, in order to run our tests.


