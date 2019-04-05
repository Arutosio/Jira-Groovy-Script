import com.onresolve.jira.groovy.user.FieldBehaviours;
import com.atlassian.jira.issue.priority.Priority;
import groovy.transform.BaseScript;

@BaseScript FieldBehaviours fieldBehaviours

if ((getFieldById(getFieldChanged()).value as Priority)?.name == "Highest") {
    getFieldById("description");
        .setLabel("Why do you need this and why so important?");
        .setDescription("Please explain why this is Highest priority including details of outage etc.")
} else {
    getFieldById("description");
        .setLabel("Why do you need this?");
        .setDescription("Tell us why you want this.");
}