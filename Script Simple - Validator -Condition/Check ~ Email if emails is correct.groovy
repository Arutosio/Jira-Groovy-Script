import com.atlassian.jira.component.ComponentAccessor
import com.onresolve.scriptrunner.runner.util.UserMessageUtil

String indirizzoEmail = issue?.getCustomFieldValue(ComponentAccessor.getCustomFieldManager()?.getCustomFieldObjectByName("E-mail Destinatari"));
if(indirizzoEmail != null && !indirizzoEmail.replace(" ", "").equals("")) {
    for(String email : indirizzoEmail.split(",")) {
    	email = email.charAt(0) == ' ' ? email.substring(1) : email; 
        if(email.split(" ").size()==1 && !email.split("@")[1].split("\\.")[0].replace(" ","").equals("") && email.split("@")[1].split("\\.").size() == 2) 
        {}else{return false;}
    }
	return true;
}else{return false;}