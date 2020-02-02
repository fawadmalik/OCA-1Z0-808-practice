package com.streamsNlambdas;

import java.util.ArrayList;

import org.junit.Test;

public class TestStreams {
	@Test
	public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {
		ArrayList<JiraIssue> jiras = getAllJiraIssues();
		jiras.stream().forEach(jira -> jira.advancePriority());
		
//		org.hamcrest.MatcherAssert.assertThat(jiras, 
//				contains(hasProperty("priority", equals(Priority.BLOCKER.name())))
//				hasItem(allOf(hasProperty("priority", is(Priority.BLOCKER.name())))
//				);

	}

	private static ArrayList<JiraIssue> getAllJiraIssues() {
		ArrayList<JiraIssue> issues = new ArrayList<>();
		issues.add(new JiraIssue(Status.OPEN, Priority.LOW, "TA-100"));
		issues.add(new JiraIssue(Status.CLOSED, Priority.HIGH, "TA-200"));
		issues.add(new JiraIssue(Status.OPEN, Priority.LOW, "TA-300"));
		issues.add(new JiraIssue(Status.OPEN, Priority.HIGH, "TA-400"));
		issues.add(new JiraIssue(Status.CLOSED, Priority.MEDIUM, "TA-500"));
		issues.add(new JiraIssue(Status.CLOSED, Priority.HIGH, "TA-600"));
		issues.add(new JiraIssue(Status.CLOSED, Priority.HIGH, "TA-700"));

		return issues;
	}

}
