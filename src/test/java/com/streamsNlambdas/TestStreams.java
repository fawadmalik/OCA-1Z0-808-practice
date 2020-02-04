package com.streamsNlambdas;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import com.e2eqa.JiraIssueAccessManager.JiraIssue;
import com.e2eqa.JiraIssueAccessManager.Priority;
import com.e2eqa.JiraIssueAccessManager.Status;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestStreams {
	@Test
	public void whenAdvancePriorityForEachJira_thenNoLowPriorityJira() {
		List<JiraIssue> jiras = getAllJiraIssues();
		jiras.stream().forEach(jira -> jira.advancePriority());
		assertThat(jiras, everyItem(hasProperty("priority", is(not(Priority.LOW)))));
	}

	private static List<JiraIssue> getAllJiraIssues() {
		JiraIssue[] jiraArray = new JiraIssue[] {
				new JiraIssue(Status.OPEN, Priority.LOW, "TA-100"),
				new JiraIssue(Status.CLOSED, Priority.HIGH, "TA-200"),
				new JiraIssue(Status.OPEN, Priority.LOW, "TA-300"),
				new JiraIssue(Status.OPEN, Priority.HIGH, "TA-400"),
				new JiraIssue(Status.CLOSED, Priority.MEDIUM, "TA-500"),
				new JiraIssue(Status.CLOSED, Priority.HIGH, "TA-600"),
				new JiraIssue(Status.CLOSED, Priority.HIGH, "TA-700")
		};
		return Arrays.asList(jiraArray);
	}
}
