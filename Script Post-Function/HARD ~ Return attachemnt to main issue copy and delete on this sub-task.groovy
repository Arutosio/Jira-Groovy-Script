//script by Henning Tietgens : For the last transaction of the sub-task you could use
import com.atlassian.jira.component.ComponentAccessor

final SUBTASK_ISSUETYPE_NAME = "Sub-task"

if (issue.issueType.name == SUBTASK_ISSUETYPE_NAME) {
    def attachmentManager = ComponentAccessor.attachmentManager
    issue.attachments.each{att ->
        attachmentManager.copyAttachment(att, att.authorObject, issue.parentObject.key)
        attachmentManager.deleteAttachment(att)
    }
} 