import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable


//Creating a new project
response1 = WS.sendRequest(findTestObject('Projects/Create a project'))

WS.verifyResponseStatusCode(response1, 201)

WS.verifyElementPropertyValue(response1, 'data.name', 'Creating project')

projectGid = WS.getElementPropertyValue(response1, 'data.gid')

GlobalVariable.projectGid = projectGid

//fetching a project
response2 = WS.sendRequest(findTestObject('Projects/Get a project', [('gid') : GlobalVariable.projectGid]))

WS.verifyResponseStatusCode(response2, 200)

WS.verifyElementPropertyValue(response2, 'data.gid', projectGid)

WS.verifyElementPropertyValue(response2, 'data.name', 'Creating project')

//Updating a project
response3 = WS.sendRequest(findTestObject('Projects/Update a project', [('gid') : GlobalVariable.projectGid]))

WS.verifyResponseStatusCode(response3, 200)

WS.verifyElementPropertyValue(response3, 'data.gid', projectGid)

WS.verifyElementPropertyValue(response3, 'data.name', 'Updating project')

//Deleting a project
response4 = WS.sendRequest(findTestObject('Projects/Delete a project', [('gid') : GlobalVariable.projectGid]))

WS.verifyResponseStatusCode(response4, 200)

