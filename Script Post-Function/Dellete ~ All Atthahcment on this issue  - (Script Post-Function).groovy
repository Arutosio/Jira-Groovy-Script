import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.AttachmentManager
 
AttachmentManager attachmentManager = ComponentAccessor.attachmentManager

def attachments = attachmentManager.getAttachments(issue)
attachments.each {attachment ->;
    attachmentManager.deleteAttachment(attachment)
}