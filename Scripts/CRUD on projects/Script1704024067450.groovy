import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Creating a new project
'Creating a new project'
response1 = WS.sendRequest(findTestObject('Projects/Create a project'))

WS.verifyResponseStatusCode(response1, 201)

WS.verifyElementPropertyValue(response1, 'data.name', 'Creating project')

projectGid = WS.getElementPropertyValue(response1, 'data.gid')

GlobalVariable.projectGid = projectGid

//fetching a project
'Fetching a project'
response2 = WS.sendRequest(findTestObject('Projects/Get a project', [('gid') : GlobalVariable.projectGid]))

WS.verifyResponseStatusCode(response2, 200)

WS.verifyElementPropertyValue(response2, 'data.gid', projectGid)

WS.verifyElementPropertyValue(response2, 'data.name', 'Creating project')

//Updating a project
'Updating a project'
response3 = WS.sendRequest(findTestObject('Projects/Update a project', [('gid') : GlobalVariable.projectGid]))

WS.verifyResponseStatusCode(response3, 200)

WS.verifyElementPropertyValue(response3, 'data.gid', projectGid)

WS.verifyElementPropertyValue(response3, 'data.name', 'Updating project')

//Deleting a project
'Deleting a project'
response4 = WS.sendRequest(findTestObject('Projects/Delete a project', [('gid') : GlobalVariable.projectGid]))

WS.verifyResponseStatusCode(response4, 200)

