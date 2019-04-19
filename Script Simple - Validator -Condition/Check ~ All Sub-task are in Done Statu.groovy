//Check that All Sub-task are in Done Status
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;

if(issue.getIssueType().getName().equals("Epic")) {
    def stC = issue?.subTaskObjects;
    for(def st : stC) {
        if(!st.getStatus().getName().equals("Done")) {
        	return false;
        }
    }
    return true;
} else {return true;}