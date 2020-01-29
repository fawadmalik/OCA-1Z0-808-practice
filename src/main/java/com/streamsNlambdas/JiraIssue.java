package com.streamsNlambdas;

public class JiraIssue {
	private Status status;
	private Priority priority;
	private final String ID;

	public JiraIssue(Status status, Priority priority, String ID) {
		this.status = status;
		this.priority = priority;
		this.ID = ID;
	}

	public Status getStatus() {
		return status;
	}

	public Priority getPriority() {
		return priority;
	}

	public String getID() {
		return ID;
	}

	
	public void advancePriority() {
		int currentPriorityOrdinal = priority.ordinal();
		
		if(currentPriorityOrdinal < (Priority.values().length)) {
			priority = Priority.values()[++currentPriorityOrdinal];
		}
	}
	
	@Override
	public String toString() {
		return "Jira{" + "ID='" + ID + "\'" + ", status=" + status + ", priority=" + priority + "}";
	}
}
