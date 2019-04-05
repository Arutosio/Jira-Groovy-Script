import com.atlassian.jira.component.ComponentAccessor; //import necessaro

def cfVN = getFieldByName("String Field");

if(cfVN?.getFormValue().toString().replaceAll(" ","").equals("")) {
	cfVN.setError("The field is empty �");
} else { cfVN.clearError(); }