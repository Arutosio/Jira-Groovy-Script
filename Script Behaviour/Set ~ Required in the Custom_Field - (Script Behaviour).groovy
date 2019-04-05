import com.onresolve.jira.groovy.user.FormField;
import com.atlassian.jira.component.ComponentAccessor;

def cfS = getFieldById("summary");
def cfSUP = getFieldByName("Single User Picker");

if(cfS?.getFormValue()?.toString().indexOf("required") >= 0) { 
    cfSUP.setRequired(true); 
} else { cfSUP.setRequired(false); }