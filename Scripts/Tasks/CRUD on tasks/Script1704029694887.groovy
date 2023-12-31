import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable

//Create a task
response1 = WS.sendRequest(findTestObject('Tasks/Create a task'))

WS.verifyResponseStatusCode(response1, 201)

WS.verifyElementPropertyValue(response1, 'data.name', 'create task')

taskGid = WS.getElementPropertyValue(response1, 'data.gid')

GlobalVariable.taskGid = taskGid

//Get a task
response2=WS.sendRequest(findTestObject('Tasks/Get a task', [('gid') : GlobalVariable.taskGid]))

WS.verifyResponseStatusCode(response2, 200)

WS.verifyElementPropertyValue(response2, 'data.gid', taskGid)

WS.verifyElementPropertyValue(response2, 'data.name', 'create task')

//Update a task
response3=WS.sendRequest(findTestObject('Tasks/Update a task', [('gid') : GlobalVariable.taskGid]))

WS.verifyResponseStatusCode(response3, 200)

WS.verifyElementPropertyValue(response3, 'data.gid', taskGid)

WS.verifyElementPropertyValue(response3, 'data.name', 'update task')

//Delete a task
response4=WS.sendRequest(findTestObject('Tasks/Delete a task', [('gid') : GlobalVariable.taskGid]))

WS.verifyResponseStatusCode(response4, 200)

