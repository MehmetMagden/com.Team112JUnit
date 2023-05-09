package day11_cookies_tables;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void test01(){

        //Create a new class : cookiesAutomation
        //1- Go to Amazon homepage
        //2- list all cookies
        //3- Test that the number of cookies on the page is greater than 5
        //4- Test the value of the cookie with the name i18n-prefs is USD
        //5- Create a cookie with the name "my favorite cookie" and the value "chocolate" and add it to the page
        //6- test that the cookie you added is added to the page
        //7- Delete the cookie whose name is skin and test it is deleted
        //8- delete all cookies and test if they are deleted

        //1- Go to Amazon homepage
        driver.get("https://www.amazon.com");

        //2- list all cookies
        Set<Cookie> cookiesSet = driver.manage().getCookies(); // like a list, our set stores all cookies


        int index = 1; // to count number of cookies, we added a little cosmetic

        for (Cookie eachCookie: cookiesSet
             ) {

            System.out.println(index+"- "+eachCookie);
            index++;

        }

        //3- Test that the number of cookies on the page is greater than 5

        int expectedNumberCookies = 5;
        int actualNumberCookies = cookiesSet.size();

        Assert.assertTrue(actualNumberCookies>expectedNumberCookies);

        //4- Test the value of the cookie with the name i18n-prefs is USD
        // cookiesSet  this is the set where I stored all cookies

        String expectedCookieValue = "USD";
        String actualCookieValue = "";


        for (Cookie eachCookie :cookiesSet
             ) {
            if (eachCookie.getName().equals("i18n-prefs")){
                actualCookieValue = eachCookie.getValue();
            }
        }

        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        //5- Create a cookie with the name "my favorite cookie" and the value "chocolate" and add it to the page

        Cookie myCookie = new Cookie("my favorite cookie","chocolate"); // created the cookie
        driver.manage().addCookie(myCookie); // will add the cookie to website

        //6- test that the cookie you added is added to the page
        Set<Cookie> amazonCookies = driver.manage().getCookies();

        int index2 = 1;
        for (Cookie eachCookie: amazonCookies
             ) {
            System.out.println(index2+"- "+eachCookie);
            index2++;
        }

//        int expectedCookieNumber = 9;
//        int actualCookieNumber = amazonCookies.size();
//
//        Assert.assertEquals(expectedCookieNumber,actualCookieNumber);

        boolean haveCookie = false;
        for (Cookie eachCookie: amazonCookies
        ) {
          if (eachCookie.getName().equals("my favorite cookie")){
              haveCookie = true; // if look can find my favorite cookie this boolean will be true so assertion will pass
          }

        }

        Assert.assertTrue(haveCookie); // if haveCookie is true it will pass

        //7- Delete the cookie whose name is skin and test it is deleted

        driver.manage().deleteCookieNamed("skin");

        amazonCookies = driver.manage().getCookies();

        //boolean skinCookie = true; // by default we should not be able to find any cookie named skin because we have deleted it
        int skinNumber = 0; // to count cookies
        for (Cookie eachCookie: amazonCookies
             ) {

            if (eachCookie.getName().equals("skin")){
                //skinCookie = false;// if in the loop we can find a cookie named skin, test will fail
                skinNumber++;// if look finds any cookie with the name skin, number will increase
            }
        }

        //Assert.assertTrue(skinCookie);
        Assert.assertTrue(skinNumber==0);// if the numbers is 0, it means in the loop we could not find any
                                                // cookie named skin, so test will pass


        //8- delete all cookies and test if they are deleted

        driver.manage().deleteAllCookies();

        amazonCookies = driver.manage().getCookies();

        Assert.assertEquals(0,amazonCookies.size());







    }

}
