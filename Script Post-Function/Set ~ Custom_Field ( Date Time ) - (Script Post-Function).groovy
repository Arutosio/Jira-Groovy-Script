import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;
import java.sql.Timestamp;

def cfDTP = ComponentAccessor.getCustomFieldManager()?.getCustomFieldObjectByName("Date Time Field");
issue.setCustomFieldValue(cfDTP, new Timestamp((new Date()).time));