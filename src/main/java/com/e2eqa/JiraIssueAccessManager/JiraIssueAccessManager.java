package com.e2eqa.JiraIssueAccessManager;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JiraIssueAccessManager {

	public List<JiraIssue> getJirasSortedByPriority(List<JiraIssue> jiras) {
		List<JiraIssue> jirasSortedByPriority = jiras.stream()
				.sorted(Comparator.comparingInt(JiraIssue::getPriorityOrdinal).reversed())
				.collect(Collectors.toList());
		
		return jirasSortedByPriority;
	}
}
