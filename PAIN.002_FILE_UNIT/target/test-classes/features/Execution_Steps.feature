#Following Scenarios will be covered during script exceution 
# ***Pre-Requisites: All file should be present at their designated directory before commencing the scipt execution*** #
#======================================================================================================================#

# 1. Successfully Mandate Execution & validation of Mandate status and confirmation file generation(if any)
# 2. Successfully Payment Execution & validation of Payment status,Pain.008 generation & Paymnet Confirmation file generation(if any)
# 3. validation of proper Mapping between pain.008 and pain.002 files.
# 4. Successfully Pain.002 file Execution & validation of Payment status and Report file generation.
Feature: Execution of Pain.002 file
  @Mandate_Processing
  Scenario: Sucessfull Mandate File Processing
 	Given Manadate file is present for <UserID>,<Legacy>
 	When Process the Mandate file 
 	Then Verify Mandate Status
 	And Verify Mandate Confirmation file generation

  @Payment_Processing
  Scenario Outline: Sucessfull Payment File Processing
  Given Payment file is present for <UserID>,<Legacy>,<Bank>
 	When Process the Payment file
 	Then Verify Pain.008 file generation
 	And Verify Payment Status
 	And Verify Payment Confirmation file generation

  @Pain002_Processing 
  Scenario Outline: Sucessfull Pain.002 File Processing
  Given Pain002 file is present for <UserID>,<Legacy>,<Bank>
  And Verify Data Mapping between Pain002 & Pain008
 	When Process the Pain002 file
 	Then Verify Payment Status
 	And Verify Account Report file generation
  