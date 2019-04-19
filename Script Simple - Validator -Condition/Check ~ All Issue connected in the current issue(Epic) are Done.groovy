//check that all subtask and issueLink are in Done statu in the Issue Type Epic
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;

if(issue.getIssueType().getName().equals("Epic")) {
	def linkIssueC = ComponentAccessor.getIssueLinkManager()?.getOutwardLinks(issue.getId());
    for (def l : linkIssueC) {
        if(!l.getDestinationObject().getStatus().getName().equals("Done")) {
            return false;
        }
    }
    return true;
} else {return true;}