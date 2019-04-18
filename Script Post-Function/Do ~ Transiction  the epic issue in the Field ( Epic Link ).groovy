import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;
import com.onresolve.scriptrunner.runner.util.UserMessageUtil;

def issueService = ComponentAccessor.getIssueService();
def currentUser = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser();

def epicLink = ComponentAccessor.getCustomFieldManager()?.getCustomFieldObject(/* 10000 va sostitutito Inserire il numero del ID del field Epic Link */10000 as Long);
Issue issueEpic = (Issue)issue?.getCustomFieldValue(epicLink);

if (issueEpic.status.name.equals(/* il nome dello stato in cui ha una transizione che raggiunge lo stato sucessivo */"To Do")) {
    def issueInputParameters = issueService.newIssueInputParameters();
    issueInputParameters.setRemainingEstimate(0L);
    def transitionValidationResult = issueService.validateTransition(issueEpic?.getAssignee(), issueEpic.id, /* 51 va sostitutito con ID della transizione che porta a quella richiesta */51 as Integer, issueInputParameters);
    if (transitionValidationResult.isValid()) {
    	issueService.transition(currentUser, transitionValidationResult);
    } else {
        def text = "Transition failed. ";
        transitionValidationResult?.errorCollection?.errorMessages?.each { text += "Error Message: $it\r\n" }
        transitionValidationResult?.errorCollection?.errors?.each { text += "Error: $it\r\n" }
        transitionValidationResult?.errorCollection?.reasons?.each { text += "Reason: $it\r\n" }
        log?.error(text)
    }
}