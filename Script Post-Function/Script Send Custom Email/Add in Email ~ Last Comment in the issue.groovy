//<!-- Add last comment body -->
<% out <<(com.atlassian.jira.component.ComponentAccessor.getCommentManager()?.getLastComment(issue) != null ?
com.atlassian.jira.component.ComponentAccessor.getCommentManager().getLastComment(issue).getBody() : "Non ci sono commenti su questa issue")%>