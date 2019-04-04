//<!-- Add Summary -->
<% out << (issue?.getReporter().getDisplayName() != null ? issue.getReporter()?.getDisplayName() : "Errore: Nome Reporter non disponibile")%>