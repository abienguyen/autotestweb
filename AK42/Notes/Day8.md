## Page Object Model (hide all locators on Tcs )- là Class trên từng trang 1, gồm có:
- User behavior on the page - là Method
- locators on the page - là thuộc tính (Properties)
bao gồm 3 lớp: Tcs (Product layer), Page classes, Selenium

## Framework gồm:
- testplan.xml : là config browser, url, test cases
- Base : baseTest, basePage
- Pages (đặt tên: **Page.java): lấy emlement
- Specs (đặt tên: **Test.java): gồm các test case
- Support: browser -> selenium owner method (cái dùng lại method), read file: csv,json, excel,..., call rest request(API)
- Report : /target 

## Cách estimate công việc:
- Read test case <> Rewrite TCs => specified details
- Perform tcs by manual 
- Implement automation script
- Run all tcs
## bằng cách đánh level TCs
- < 5 steps => small => est 1 test per working day (wd) => **smoke test**
- 5 < steps < 10 => medium => est 2 test per 3 wd
- > 10 steps => large => 2 wds
## Set KPI cho bản thân
- 1 - 3 - 3 => 1 sprint viết 3 tcs = 3 tháng 

```BT java
TC10: Page Object Model - Body Mass Index Page
Open browser
Navigate to https://www.calculator.net/bmi-calculator.html
Select metric unit tab
Fill calculator with age, gender, weight, height
Validate result is correct