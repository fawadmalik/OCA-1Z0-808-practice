package com.e2eqa.JiraIssueAccessManager;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestJiraIssueAccessManager {

	private static JiraIssueAccessManager jiraIssueAccessManager;
	private static List<JiraIssue> allIssues;
	
	@BeforeClass
	public static void setUp() {
		jiraIssueAccessManager = new JiraIssueAccessManager();
		allIssues = getAllJiraIssues();
	}
	
	@Test
	public void testGetJirasSortedByPriority() {
		Optional<Integer> highestPriorityOrdinal = allIssues.stream()
				.map(JiraIssue::getPriorityOrdinal).reduce(Integer::max);
		assertTrue(highestPriorityOrdinal.get().intValue() != allIssues.get(0).getPriority().ordinal());

		List<JiraIssue> SortedIssuesByPriorityDesc = 
				jiraIssueAccessManager.getJirasSortedByPriority(allIssues);
		assertTrue(highestPriorityOrdinal.get().intValue() == SortedIssuesByPriorityDesc.get(0).getPriority().ordinal());		
	}
	
	@Test
	public void testGetJirasWithClosedStatus() {
		assertTrue(false);		
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

