///Script per la creazione di Sub-Task in base agli allegati presenti con aggiunta di un singolo allegato.
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.config.SubTaskManager;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.AttachmentManager
import com.atlassian.jira.issue.attachment.Attachment;
import com.atlassian.jira.issue.IssueFactory;
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.issue.MutableIssue;

if (issue.getIssueType().getName() != "Sub-task") {
	if (ComponentAccessor.getAttachmentManager() .getAttachments(issue).size() >= 1) {
    		for(int i = 0; i < ComponentAccessor.attachmentManager.getAttachments(issue).size(); i++) {
			//__________________________________________________________________________________________________________________________________________________
			Issue parentIssue = issue  
			def att = parentIssue.getAttachments()[i];
			def currentUser = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser();
			IssueFactory issueFactory = ComponentAccessor.getIssueFactory();
			String subTaskId = ComponentAccessor.getConstantsManager().getAllIssueTypeObjects().find { it.getName() == "Sub-task" }.id

			IssueManager issueManager = ComponentAccessor.getIssueManager();
			SubTaskManager subTaskManager = ComponentAccessor.getSubTaskManager();
			AttachmentManager attachmentManager = ComponentAccessor.getAttachmentManager()
			//__FASE Build
			MutableIssue newSubTask = issueFactory.getIssue();
			newSubTask.setSummary("Sub-Task Attachment: " + (i+1)); 
			newSubTask.setDescription("Sub-Task with an Attachment"); 
			newSubTask.setParentObject(parentIssue);
			newSubTask.setReporterId(currentUser.username); 
			newSubTask.setProjectObject(parentIssue.getProjectObject());
			newSubTask.setIssueTypeId(subTaskId);
			//__FASE Creation
			issueManager.createIssueObject(currentUser, newSubTask);
			subTaskManager.createSubTaskIssueLink(parentIssue, newSubTask, currentUser);
			//__FASE Add attachment
			attachmentManager.copyAttachment(att, currentUser, newSubTask.getKey().toString())
			//__________________________________________________________________________________________________________________________________________________
		}
	}
}