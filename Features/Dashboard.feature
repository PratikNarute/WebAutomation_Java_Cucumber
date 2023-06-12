Feature: Dahboard

Background: Common Step for all scenarios
Given User should be on Login page of CRM "http://uatdreamcity.kolonizer.in/login"
When Enter username as "pratik@kolonizer.com" and password as "Pratik@123"
And Click on Login button
Then User should be navigate to Home Page "http://uatdreamcity.kolonizer.in/dashboard"
#
#@Analysis_Report
#Scenario: Verify successful redirecting on lead page scenarios
#When User click on refresh button
#And Click on Analysis Report text button
#Then Active lead count should be equal to total analysis report count
#And All status and stages should be visible with sequencial order
#And User should be redirect on those specific lead page by click on button and Check count of lead on page is same as showing on Dashboard
#
#@Analysis_Report
#Scenario Outline: Verify numbers of Count on Tele Caller Dashboard as per Status wise (Default threshold setting)
#When User click on refresh button
#And Click on Analysis Report text button
#When User change or convert the lead into perticular status "<Status>"
#Then Impact of changing status should be show on the Dashboard of analysis report "<Status>"
#Examples:
#|Status    |
#|Meet      |
#|Visit     |
#|Prebooked |


#@Analysis_Report
#Scenario Outline: Verify numbers of Count on Tele Caller Dashboard as per Stage wise (Default Threshold setting)
#When User click on refresh button
#And Click on Analysis Report text button
#Then All status and stages should be visible with sequencial order
#When User call first time as per current status
#Then First call considerd as New statge
#When User call 2-5 times to perticular lead
#Then This lead considered as Primary stage
#When User call 6-10 times to perticular lead 
#Then This lead considered as Secondary statge
#When User call more than 10 times to perticular lead 
#Then This lead considered as Tertiary statge
#When User change status of lead into perticular status at any stage "<Status>"
#Then This lead considered as new stage for perticular status "<Status>"
#When User convert lead into Booked status 
#Then This lead should not considerd in analysis report "<Prebooked>"
#Examples:
#|Status|
#|Meet  |

@Effort_Report
Scenario: Verify Active log scenarios as per stage and status wise 
Given User should be on dashboart of effort report
When User click count button 
Then Active log Pop-Up should be open
And Sum of Count for all active log should be equal to the count on buttons of effort report
When User click on Expand button 
Then Expand the remarks of all lead
#And Count of expanded remarks against lead should be equal to the count which is displayed next to the lead name
#And Remark should be display against particular call times
#
#@Effort_Report
#Scenario Outline: Verify position of count call scenarios against stage and status wise
#Given User should be on dashboart of effort report
#When User call first time as per current status 
#Then First call considerd as New statge "<Status>"
#When User call 2-5 times to perticular lead
#Then Those call considered as Primary stage "<Status>"
#When User call 6-10 times to perticular lead 
#Then Those call considered as Secondary statge "<Status>"
#When User call more than 10 times to perticular lead 
#Then Those call considered as Tertiary statge "<Status>"
#When User change status of lead into perticular status at any stage "<Status>"
#Then Those call considered as new stage for perticular status "<Status>"
#And Previous call records should not be erase against lead

Examples:
|Staus|
|Meet |


 

















