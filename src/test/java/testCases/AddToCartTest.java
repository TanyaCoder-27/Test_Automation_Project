
//try in future to use dynamic data for login and product selection as well, instead of static data. This will make the tests more robust and less prone to failure due to data changes. For example, you can create a utility class to generate random product names or use a data provider to supply different sets of login credentials and products to test with.

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class AddToCartTest extends BaseClass {

    @Test
    public void verifyAddToCart() {

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        //lp.setEmail("b69bc@gmail.com");  // use a registered email 
        //lp.setPassword("Test@123");
        lp.setEmail(USER_EMAIL);
        lp.setPassword(USER_PASSWORD);

        lp.clickLogin();

        ProductPage pp = new ProductPage(driver);
        pp.clickDesktops();
        pp.clickMac();
        pp.clickIMac();
        pp.addToCart();

        int beforeCount = pp.getCartItemCount();

        pp.addToCart();

        int afterCount = pp.getCartItemCount();

        Assert.assertEquals(afterCount, beforeCount+1);


        System.out.println("Product Added to Cart Successfully");
    }
}



/* FAILED TEST ERROR MESSAGE DUE TO USING NOT REGISTERED EMAIL:
FAILED: testCases.AddToCartTest.verifyAddToCart
org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//button[@onclick="cart.add('43');"]"}
  (Session info: chrome=145.0.7632.75)
For documentation on this error, please visit: https://www.selenium.dev/documentation/webdriver/troubleshooting/errors#no-such-element-exception
Build info: version: '4.18.1', revision: 'b1d3319b48'
System info: os.name: 'Windows 11', os.arch: 'amd64', os.version: '10.0', java.version: '22.0.2'
Driver info: org.openqa.selenium.chrome.ChromeDriver
Command: [fe3a21ae4736562fd3cabdc79fd3f7ca, findElement {using=xpath, value=//button[@onclick="cart.add('43');"]}]
Capabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 145.0.7632.75, chrome: {chromedriverVersion: 145.0.7632.76 (ee36f024f43a..., userDataDir: C:\Users\tanya\AppData\Loca...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:58641}, goog:processID: 12488, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: windows, proxy: Proxy(), se:cdp: ws://localhost:58641/devtoo..., se:cdpVersion: 145.0.7632.75, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}
Session ID: fe3a21ae4736562fd3cabdc79fd3f7ca
	at java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:62)
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:502)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:486)
	at org.openqa.selenium.remote.ErrorCodec.decode(ErrorCodec.java:167)
	at org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:138)
	at org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:50)
	at org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:190)
	at org.openqa.selenium.remote.service.DriverCommandExecutor.invokeExecute(DriverCommandExecutor.java:216)
	at org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:174)
	at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:519)
	at org.openqa.selenium.remote.ElementLocation$ElementFinder$2.findElement(ElementLocation.java:165)
	at org.openqa.selenium.remote.ElementLocation.findElement(ElementLocation.java:59)
	at org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:356)
	at org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:350)
	at org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:68)
	at org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)
	at jdk.proxy2/jdk.proxy2.$Proxy12.click(Unknown Source)
	at pageObjects.ProductPage.addToCart(ProductPage.java:38)
	at testCases.AddToCartTest.verifyAddToCart(AddToCartTest.java:31)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.testng.internal.invokers.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:139)
	at org.testng.internal.invokers.TestInvoker.invokeMethod(TestInvoker.java:664)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethod(TestInvoker.java:228)
	at org.testng.internal.invokers.MethodRunner.runInSequence(MethodRunner.java:63)
	at org.testng.internal.invokers.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:961)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethods(TestInvoker.java:201)
	at org.testng.internal.invokers.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:148)
	at org.testng.internal.invokers.TestMethodWorker.run(TestMethodWorker.java:128)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
	at org.testng.TestRunner.privateRun(TestRunner.java:819)
	at org.testng.TestRunner.run(TestRunner.java:619)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:443)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:437)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:397)
	at org.testng.SuiteRunner.run(SuiteRunner.java:336)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:95)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1301)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1228)
	at org.testng.TestNG.runSuites(TestNG.java:1134)
	at org.testng.TestNG.run(TestNG.java:1101)
	at org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:115)
	at org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:293)
	at org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:91)


===============================================
    Default test
    Tests run: 1, Failures: 1, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 1, Passes: 0, Failures: 1, Skips: 0
===============================================


--> Error shows:

StaleElementReferenceException
Element: //a[text()='Desktops']


This means:

Page loaded

Selenium located element

Page refreshed / DOM updated

Element reference became invalid

You tried to click old reference

That’s what “stale” means.

After login:

Page reloads

DOM updates

Then you try to use a PageFactory element that was initialized earlier

PageFactory sometimes holds old reference.

*/

/*
 Product Added to Cart Successfully
PASSED: testCases.AddToCartTest.verifyAddToCart

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================
*/
