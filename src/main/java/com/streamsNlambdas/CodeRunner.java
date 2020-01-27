package com.streamsNlambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CodeRunner {

	public static void main(String[] args) {
		ArrayList<JiraIssue> jiras = getAllJiraIssues();

		List<JiraIssue> openJiras = jiras.stream().filter(jira -> jira.getStatus().equals(Status.OPEN))
				.collect(Collectors.toList());

		openJiras.forEach(System.out::println);

		boolean seriousJiras = jiras.stream().allMatch(jira -> jira.getPriority().compareTo(Priority.LOW) > 0);
		System.out.println(seriousJiras);
		// Group
		Map<Priority, List<JiraIssue>> groupByPriority = jiras.stream()
				.collect(Collectors.groupingBy(JiraIssue::getPriority));

		groupByPriority.forEach((priority, allJiras) -> {
			System.out.println(priority);
			allJiras.forEach(System.out::println);
			System.out.println();
		});
	}

	private static ArrayList<JiraIssue> getAllJiraIssues() {
		ArrayList<JiraIssue> issues = new ArrayList<>();
		issues.add(new JiraIssue(Status.OPEN, Priority.LOW, "TA-100"));
		issues.add(new JiraIssue(Status.CLOSED, Priority.HIGH, "TA-200"));
		issues.add(new JiraIssue(Status.OPEN, Priority.LOW, "TA-300"));
		issues.add(new JiraIssue(Status.OPEN, Priority.HIGH, "TA-400"));
		issues.add(new JiraIssue(Status.CLOSED, Priority.MEDIUM, "TA-500"));
		issues.add(new JiraIssue(Status.CLOSED, Priority.BLOCKER, "TA-600"));
		issues.add(new JiraIssue(Status.CLOSED, Priority.HIGH, "TA-700"));

		return issues;
	}
}

class JiraIssue {
	private final Status status;
	private final Priority priority;
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

	@Override
	public String toString() {
		return "Jira{" + "ID='" + ID + "\'" + ", status=" + status + ", priority=" + priority + "}";
	}
}
