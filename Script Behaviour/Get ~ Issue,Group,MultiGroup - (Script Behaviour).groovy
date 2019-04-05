import com.atlassian.jira.component.ComponentAccessor; //import necessaro
import com.atlassian.jira.issue.MutableIssue; //import necessaro
import com.atlassian.crowd.embedded.api.Group;//import necessaro

// il nome dei campi va cambiato con i propri
def cfSIP = getFieldByName("Single Issue Picker"); //otteniamo il Field che ha come nome "Single Issue Picker"
String x = cfSIP.getValue() as String; // prendiamo il valore presente sul campo "Single Issue Picker" e lo teniamo in memoria
boolean ce = false;
def currentUser = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser();
MutableIssue sIssue = ComponentAccessor.getIssueManager().getIssueObject(x); //con il valore che fa riferimento alla issue prendiamo la issue selezionata
def groupList = sIssue.getCustomFieldValue(ComponentAccessor.getCustomFieldManager().getCustomFieldObjectByName("Multi Group Picker"));
Collection<Group> group = (Collection) sIssue.getCustomFieldValue(ComponentAccessor.getCustomFieldManager().getCustomFieldObjectByName("Multi Group Picker"));
// che ci servira per ottenere l'assegnatario a quella particolare issue.
if(group != null && group.size() > 0) {
	for(int i = 0; group.size() > i; i++) {
		if(ComponentAccessor.getGroupManager().isUserInGroup(currentUser, group[i].getName())) { //se l'utente corrente e presente nel gruppo Ni
			ce=true;
		}
	}
	if(ce) {
		cfSIP.clearError();
		if(sIssue.getAssignee() == null ) { // s'� la issue non ha un assegnatario allora
			cfSIP.setError("La issue non � Assegnata");
		} // scrivimi sul field "Single User Picker" La issue non � Assegnata
		else {// altrimenti
			cfSIP.clearError();
		}
	} else {cfSIP.setError("Non fai parte dei gruppi");}
} else {cfSIP.setError("Errore: NON CI SONO GRUPPI IN QUESTO Asset")};