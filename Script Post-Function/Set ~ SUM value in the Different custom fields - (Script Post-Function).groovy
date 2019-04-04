import com.atlassian.jira.component.ComponentAccessor;

double res = 0;
def customField = ComponentAccessor.getCustomFieldManager().getCustomFieldObjectByName("customfield 1");
res += Double.parseDouble(issue.getCustomFieldValue(customField).toString());
customField = ComponentAccessor.getCustomFieldManager().getCustomFieldObjectByName("customfield 2");
res += Double.parseDouble(issue.getCustomFieldValue(customField).toString());
customField = ComponentAccessor.getCustomFieldManager().getCustomFieldObjectByName("customfield 3");
issue.setCustomFieldValue(customField, res);