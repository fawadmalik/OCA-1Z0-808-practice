package com.e2eqa.JiraIssueAccessManager;

public class JiraIssue {
	private Status status;
	private Priority priority;
	private final String ID;
	private int priorityOrdinal;
	private int costOfFix;

	public JiraIssue(Status status, Priority priority, String ID) {
		this.status = status;
		this.priority = priority;
		this.ID = ID;
		priorityOrdinal=priority.ordinal();
	}
	public JiraIssue(Status status, Priority priority, String ID, int costOfFix) {
		this.status = status;
		this.priority = priority;
		this.ID = ID;
		priorityOrdinal=priority.ordinal();
		this.costOfFix = costOfFix;
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
	
	public int getPriorityOrdinal() {
		return priorityOrdinal;
	}

	public int getCostOfix() {
		return costOfFix;
	}

	
	public void advancePriority() {
		int currentPriorityOrdinal = priority.ordinal();
		
		if(currentPriorityOrdinal < (Priority.values().length)) {
			priority = Priority.values()[++currentPriorityOrdinal];
			priorityOrdinal = priority.ordinal();
		}
	}
	
	@Override
	public String toString() {
		return "Jira{" + "ID='" + ID + "\'" + ", status=" + status + ", priority=" + priority + ", costOfFix=" + costOfFix + "}";
	}
}
