import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;

def currentUser = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser();
def cfSUP = ComponentAccessor.getCustomFieldManager()?.getCustomFieldObjectByName("Single User Picker");
issue.setCustomFieldValue(cfSUP,currentUser);