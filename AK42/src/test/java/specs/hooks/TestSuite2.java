package specs.hooks;

import org.testng.annotations.*;

public class TestSuite2 {
    @BeforeSuite
    void beforeSuite(){
        System.out.println("before suite");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("before test");
    }

    @BeforeClass
    void beforeClass(){
        System.out.println("before class");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("before method");
    }
    @Test
    void tc01(){
        System.out.println("tc01");
    }

    void tc02(){
        System.out.println("tc02");
    }

    void tc03(){
        System.out.println("tc03");
    }

    void tc04(){
        System.out.println("tc04");
    }

    void tc05(){
        System.out.println("tc05");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("after method");
    }

    @AfterClass
    void afterClass(){
        System.out.println("after class");
    }

    @AfterTest
    void afterTest(){
        System.out.println("after test");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("after suite");
    }
}
