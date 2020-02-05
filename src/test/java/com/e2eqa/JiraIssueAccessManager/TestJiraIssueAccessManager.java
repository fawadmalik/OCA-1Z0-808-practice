package com.e2eqa.JiraIssueAccessManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class TestJiraIssueAccessManager {

	@Test
	public void testGetJirasSortedByPriority() {
		List<JiraIssue> mixedIssues = getAllJiraIssues();
		Optional<Integer> highestPriorityOrdinal = mixedIssues.stream()
				.map(JiraIssue::getPriorityOrdinal).reduce(Integer::max);
		assertTrue(highestPriorityOrdinal.get().intValue() != mixedIssues.get(0).getPriority().ordinal());

		List<JiraIssue> SortedIssuesByPriorityDesc = 
				(new JiraIssueAccessManager()).getJirasSortedByPriority(mixedIssues);
		assertTrue(highestPriorityOrdinal.get().intValue() == SortedIssuesByPriorityDesc.get(0).getPriority().ordinal());		
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

