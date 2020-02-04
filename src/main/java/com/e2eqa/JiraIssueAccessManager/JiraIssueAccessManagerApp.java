package com.e2eqa.JiraIssueAccessManager;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JiraIssueAccessManagerApp {

	public static void main(String[] args) {
		JiraIssueAccessManagerApp app = new JiraIssueAccessManagerApp();
		app.invokeAllMethods();		
	}

	private void invokeAllMethods() {
		List<JiraIssue> jiras = getAllJiraIssues();
		
		getJirasSortedByPriority(jiras);
		
		getCostOfBugsFixed(jiras);
		
	}
	
	private void getJirasSortedByPriority(List<JiraIssue> jiras) {
		JiraIssueAccessManager jiraIssueAccessManager = new JiraIssueAccessManager();
		
		// get a list of jira issues sorted by priority
		List<JiraIssue> jirasSortedByPriority = jiraIssueAccessManager.getJirasSortedByPriority(jiras);
		System.out.println("stream : " + jirasSortedByPriority);
	}

	private void getCostOfBugsFixed(List<JiraIssue> jiras) {
		JiraIssueAccessManager jiraIssueAccessManager = new JiraIssueAccessManager();
		
		// get a list of jira issues sorted by priority
		List<JiraIssue> jirasWithClosedStatus = jiraIssueAccessManager.getJirasSortedByPriority(jiras);
		int totalCostOfBugFixing = jirasWithClosedStatus.parallelStream()
				.mapToInt(JiraIssue::getCostOfix).sum();
		System.out.println("Total Cost of bug fixing = $" + totalCostOfBugFixing);
	}
	
	private void stash(List<JiraIssue>jiras) {
		List<JiraIssue> openJiras = jiras.stream().filter(jira -> jira.getStatus().equals(Status.OPEN))
				.collect(Collectors.toList());

		openJiras.forEach(jira -> {
			jira.advancePriority();
		});

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

		List<JiraIssue> jirasSortedByPriority = jiras.stream()
				.filter(jira -> jira.getPriority().compareTo(Priority.LOW) > 0)
				// .sorted(comparing(JiraIssue::getPriority).reversed())
				.map(jira -> jira) // equivalent to not including this line
				.collect(Collectors.toList());
		System.out.println(jirasSortedByPriority);
		List<JiraIssue> jirasSortedByPriorityWithoutMapFunction = jiras.stream()
				.filter(jira -> jira.getPriority().compareTo(Priority.LOW) > 0)
				// .sorted(JiraIssue::getPriority).reversed()
				// .sorted(comparing(JiraIssue::getPriority).reversed())
				// .collect(toList());
				.collect(Collectors.toList());
		System.out.println(jirasSortedByPriorityWithoutMapFunction);
	}
	
	private List<JiraIssue> getAllJiraIssues() {
		JiraIssue[] jiraArray = new JiraIssue[] {
				new JiraIssue(Status.OPEN, Priority.LOW, "TA-100"),
				new JiraIssue(Status.CLOSED, Priority.HIGH, "TA-200", 100),
				new JiraIssue(Status.OPEN, Priority.LOW, "TA-300"),
				new JiraIssue(Status.OPEN, Priority.HIGH, "TA-400"),
				new JiraIssue(Status.CLOSED, Priority.MEDIUM, "TA-500", 1000),
				new JiraIssue(Status.CLOSED, Priority.HIGH, "TA-600", 400),
				new JiraIssue(Status.CLOSED, Priority.HIGH, "TA-700", 650)
		};
		return Arrays.asList(jiraArray);
	}
}
