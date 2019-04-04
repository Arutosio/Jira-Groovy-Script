//<!-- Add Summary in the issue field. -->
<% out << (
	((com.atlassian.jira.issue.Issue)issue?.getCustomFieldValue(com.atlassian.jira.component.ComponentAccessor.getCustomFieldManager()?.getCustomFieldObjectByName("Single Issue Picker")))?.getSummary() != null ?
	((com.atlassian.jira.issue.Issue)issue?.getCustomFieldValue(com.atlassian.jira.component.ComponentAccessor.getCustomFieldManager()?.getCustomFieldObjectByName("Single Issue Picker")))?.getSummary() : "Errore: con Asset Summary" 
)%>