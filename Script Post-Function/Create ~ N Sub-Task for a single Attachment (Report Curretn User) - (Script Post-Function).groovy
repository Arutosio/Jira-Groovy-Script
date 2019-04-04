///Script per la creazione di Sub-Task in base agli allegati presenti
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.config.SubTaskManager;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.AttachmentManager
import com.atlassian.jira.issue.attachment.Attachment;
import com.atlassian.jira.issue.IssueFactory;
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.issue.MutableIssue;

if (issue.getIssueType().getName() != "Sub-task" && issue.issueType.name == "Incident") { // only calculate this for non-subtask issues
	if (ComponentAccessor.getAttachmentManager() .getAttachments(issue).size() >= 1) { //se c'è almeno un allegato
		for(int i = 0; i < ComponentAccessor.attachmentManager.getAttachments(issue).size(); i++) { //rifa la creazione in base al numero di allegati
			///__________________________________________________________________________________________________________________________________________________
			Issue parentIssue = issue  //si associa la issue a parentIssue(penso per comodita)
			def att = parentIssue.getAttachments()[i]; //si prende l'attchmenmt i e si asegna a att
			def currentUser = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser();  //si crea l'associazione al current user
			IssueFactory issueFactory = ComponentAccessor.getIssueFactory();
			String subTaskId = ComponentAccessor.getConstantsManager().getAllIssueTypeObjects().find { it.getName() == "Sub-task" }.id //si prende il tipo di issue che ci serve per la creazione

			AttachmentManager attachmentManager = ComponentAccessor.getAttachmentManager() //serve questo componente per i metodi di gestione degli attachment
			IssueManager issueManager = ComponentAccessor.getIssueManager();
			SubTaskManager subTaskManager = ComponentAccessor.getSubTaskManager();

			MutableIssue newSubTask = issueFactory.getIssue(); // si instanaza un nuovo oggetto issue modificabbile
			newSubTask.setSummary("Sub-Task Attachment: " + (i+1)); //imposta la summery
			newSubTask.setDescription("Sub-Task with an Attachment"); // imposta la descrizione
			newSubTask.setParentObject(parentIssue);  //???anora poco chiara???
			newSubTask.setReporterId(currentUser.username);  //imposta il reporter (.username prende il il suo username come Stringa)
			newSubTask.setProjectObject(parentIssue.getProjectObject());	//prende le impostazioni del progetto
			newSubTask.setIssueTypeId(subTaskId); // imposta il tipo di issue
		
			issueManager.createIssueObject(currentUser, newSubTask);	//Fase di creazione 1
			subTaskManager.createSubTaskIssueLink(parentIssue, newSubTask, currentUser);	//Fase di creazione 2

			attachmentManager.copyAttachment(att, currentUser, newSubTask.getKey().toString())	//questa riga copia e incolla l'attachment nella issue appena creata(newSubTask)
			/// _____________________________________________________________________________________________________________________________________________________
		}
	}
}