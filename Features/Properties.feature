Feature: Properties unit details

Background: Common Steps for All Scenarios
Given User should be on Login page of CRM "http://devdreamcity.kolonizer.in/login"
When Enter username as "pratik@kolonizer.com" and password as "Pratik@123"
And Click on Login button
Then User should be navigate to Home Page "http://devdreamcity.kolonizer.in/dashboard"

Scenario Outline: Verify Succesfull changes of all selected Properties price
When User Click on Propertis icon
And Click on Property Unit Details menu option
Then User landing on Veiw Properties page "http://devdreamcity.kolonizer.in/master/property"

When User select checkbox for all properties 
Then Checkbox for all properties should be selected

When User Select type "<Types of Change Rate>" as a change rate
And Enter price "<price>"
And Click on update button
Then Price of all properties should be change by "<price>"

Examples:
|price|Types of Change Rate|
|100  |Direct Amount       |
|1    |RatePerSqFt         |
|10   |RateInPercent       |


