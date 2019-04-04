import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;

def customFieldIssue = ComponentAccessor.getCustomFieldManager().getCustomFieldObjectByName("Single Issue Picker"); //Get Object Field
def sIssue = (Issue)issue.getCustomFieldValue(customFieldIssue); // get Value in the field and Cast CustomField Value to Issue

issue.setAssignee(sIssue.getAssignee()); //Set Assignee in the current issue

def sip = ComponentAccessor.getCustomFieldManager().getCustomFieldObjectByName("Single User Picker"); //Get Object Field
issue.setCustomFieldValue(sip, sIssue.getAssignee()); // Set field "sip" with a User 


def assu = ComponentAccessor.getCustomFieldManager().getCustomFieldObjectByName("Field Text");
issue.setCustomFieldValue(assu, sIssue.getSummary()); // Set field "assu" with the name of sIssue summary
