import com.onresolve.jira.groovy.user.FormField;
import com.atlassian.jira.component.ComponentAccessor;

def cfSGP = getFieldByName("Single Group Picker");
def cfSUP = getFieldByName("Single User Picker");

if(cfSGP?.getFormValue().toString().replaceAll(" ","").equals("")) { 
    cfSUP.setHidden(false); 
} else { cfSUP.setHidden(true); }