# Tổng hợp lại cách làm Web Elements

- [] Text box
- [] Button
- [] Label
- [] Checkbox 
- [] Dropdown
- [] Hyperlink
- [] Table (*) `Java Stream: Filter/Map/Sort/Max/Min`
- [] Js Alert
- [] Frame

## Inspect Element: Approaches: runable > specified meaning or UI text > shortest 
Brainstorming question(
  - TagName
  - Attributes
  - Text
)
-[] By.id
-[] By.name
-[] By.className
-[] By.linkText
-[] By.cssSelector
-[] By.xpath

## Interactions

## Dùng findElement()
- [] Click
- [] SendKeys
- [] GetText
--------------
## Dùng Actions
- [] Hover
- [] DragAndDrop
- [] Right Click <> Context Click
- [] KeyUp/KeyDown

## Dùng Capture Screenshot
- combine with testNG to capture screenshot when test fails

## Waits - per page 
- [] Implicit Wait 
- [] Explicit Wait `WebDriverWait(driver,maximun_time_out)`, `Thread.sleep(10000)`

# TestNG
## java
    @Before()
    - Class: open Browser
        
    @Test()
        - Selenium as Actions
        - Asserts as Validation
        
    @After();
    - Method: capture screen when fail
    - Class: close browser

## Test Plan as XML file
-```xml
  <suite name = "UI">
        <test name ="login">
            <classes>
                <class name="Login"/>
            </classes>
        </test>
  </suite>
```