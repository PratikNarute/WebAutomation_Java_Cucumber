Feature: Leads

Background: Common Step for all scenarios
Given User should be on Login page of CRM "http://devdreamcity.kolonizer.in/login"
When Enter username as "stock@kolonizer.com" and password as "Stock@123"
And Click on Login button
Then User should be navigate to Home Page "http://devdreamcity.kolonizer.in/dashboard"

#Scenario Outline: Create lead scenarios
#Given User should be on add lead page
#When Create lead by Filling all necessary required information "<Contactibility>" and "<Mode of Interest>" and "<Category>" and "<Status>"
#Then Lead should be created 
#And This lead considered in particular section according to the whether is it active or deactive lead
#
#Examples:
#|Contactibility | Mode of Interest| Category | Status|    
#|Conversation   | Interested      | Hot      | Call  |
#|Conversation   | Interested      | Warm     | Call  |
#|Conversation   | Interested      | Cold     | Call  |
#|Conversation   | Not Interested  |          | Call  |
#|Not Matched    |                 |          | Call  |
#|Not Connected  |                 |          | Call  |



#Scenario: Edit lead scenarios (contactibility is conversion and mode is interested)
#Given User should be on edit lead page 
#
#When Check all contactability field scenarios
#Then Contactability field should be disable
#And Contactability is conversion coming by defualt
#And Mode of interested checkbox should be  selected by default
#And Category drop-down will displayed (Mandatory) and category coming by default whichever is select at time of add lead
#And Next follow up date field coming as Mandatory
#
#When Deselect the checkbox of interested field
#Then Hide Category drop-down
#And Next follow up field coming as Non-Mandatory
#
#When Check all status field scenarios
#Then Status should be come as same by default, whichever is select at the time of add lead
#And Lead status option should be disabled, if status selected as call at the time of add lead
#
#When User change status to Meet
#Then Mode of interest field  become selected by default
#And Expected visit date field will open
#And Meet status option should be disabled, if status selected as Visit at the time of add lead
#
#When User change status to Visit
#Then Mode of interest field  become selected by default
#And Proceed to pre-booking and pre-booking button is open
#
#When Check remark field
#Then Remark field should be enable to take user input
#And It is non mandatory field
#
#When Check company data section
#Then Field of (Project, Select user to assign lead and Lead source) should be display under company data section
#And All field should be enabled
#And Project and select user to assign lead should be come as mandatory
#And Data is coming as same whichever is select at the time of add lead
#
#When Check lead personal data section
#Then Field of (Name, Phone, Alternative no, Select profession, Select living mode, Current address, Pin code, Area, city, District, State, Contry) should be displyed under leads personal data section
#And All field should be enabled
#And Name and Phone no fields should be mandatory
#And Phone no field should be disable
#And Address and relevent address fields should be come as mandatory, when enter address
#And Data of fields (District, City, State and Contry) should be come automatically, when enter pin code and select area
#And Data of fields (Area, District, City, State and Contry) should be erase automatically, when delete pincode 
#And Address data is coming as same whichever is select at the time of add lead
#
#When Check lead requirement section
#Then This section will displayed, when contactibility is conversion
#And Field of (Area of interest, Required Plot size, Budget) should be displayed and enabled under lead requirement section
#And Lead requirement data is coming as same whichever is select at the time of add lead



Scenario Outline: Edit Prebooked or Booked lead scenarios
Given User should be on edit prebooked or booked lead page "<Status>"
When Check disable or not editable fields
Then Contactibility field should be disabled
And Status field should be disabled
And Mobile no field should be disabled

When Check mode of interested field 
Then Checkbox of interest should be come as selected by default
When User deselect the checkbox of interested
Then Open property details pop up and show disclaimer message (Property already prebook or book, firstly release all properties)
And After release all properties, then user will able to convert into not interested lead
And Category field hide
And Next followup date field come as non mandatory

When Check category field dropdown
Then  Category drop-down will displayed (Mandatory) and category coming by default whichever is select at time of add lead

When Check select status field
Then It should be disabled

When Check next followup date field
Then It come as mandatory by default

When Check remark field
Then Remark field should be enable to take user input
And It is non mandatory field

When Check company data section
Then Field of (Project, Select user to assign lead and Lead source) should be display under company data section
And All field should be enabled
And Project and select user to assign lead should be come as mandatory
And Data is coming as same whichever is select at the time of add lead

When Check lead personal data section
Then Field of (Name, Phone, Alternative no, Select profession, Select living mode, Current address, Pin code, Area, city, District, State, Contry) should be displyed and enabled under leads personal data section
And Name and Phone no fields should be mandatory
And Phone no field should be disable
And Address and relevent address fields should be come as mandatory, when enter address
And Data of fields (District, City, State and Contry) should be come automatically, when enter pin code and select area
And Data of fields (Area, District, City, State and Contry) should be erase automatically, when delete pincode 
And Address data is coming as same whichever is select at the time of add lead

#When Check lead requirement section
#Then This section will displayed, when contactibility is conversion
#And Field of (Area of interest, Required Plot size, Budget) should be displayed and enabled under lead requirement section
#And Lead requirement data is coming as same whichever is select at the time of add lead

Examples:
|Status|
#|Prebook|
|Booked|





