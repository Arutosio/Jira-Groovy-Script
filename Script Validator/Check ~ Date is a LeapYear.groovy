import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;
import java.sql.Timestamp;

def cfDTP = ComponentAccessor.getCustomFieldManager()?.getCustomFieldObjectByName("Date Time Field");
def date = (Timestamp)issue.getCustomFieldValue(cfDTP);
int year = date.format("yyyy").toInteger()
GregorianCalendar c = (GregorianCalendar)GregorianCalendar.getInstance();
return c.isLeapYear(year);