package com.streamsNlambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestStreams {
	@Test
	public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {
		String poetry = "mary had a little lamb";
		assertThat(poetry, allOf(
				containsString("mary"),
				containsString("lamb"),
				startsWith("mary")
				));
		assertThat(poetry, anyOf(
				containsString("mary"),
				containsString("sally"),
				startsWith("jerry"),
				endsWith("lamb")
				));
		Animal[] animalsArray = new Animal[] {
			    new Animal(AnimalType.SHEEP, "Black Sheep", 3), 
			    new Animal(AnimalType.DOG, "Tramp", 1), 
			    new Animal(AnimalType.DOG, "Lady", 1)
		};
		List<Animal> animals = Arrays.asList(animalsArray);
		
	    assertThat(animals, contains(
	    	      hasProperty("type", equalTo(AnimalType.SHEEP))
//	    	      hasProperty("type", equalTo(AnimalType.DOG)),
//	    	      hasProperty("type", equalTo(AnimalType.CAT))
	    	    ));
		List<JiraIssue> jiras = getAllJiraIssues();
		jiras.stream().forEach(jira -> jira.advancePriority());
	    assertThat(jiras, contains(
	    	      hasProperty("priority", equalTo(Priority.BLOCKER))
//	    	      hasProperty("priority", equalTo(Priority.HIGH)),
//	    	      hasProperty("priority", equalTo(Priority.MEDIUM))
	    	      ));

		// (JiraIssue, Matcher<Iterable<? extends Object>>)
//		jiras.stream().forEach(jira ->
//		assertThat(jira, contains(
//				hasProperty("batch", equalTo(1))
//				))
//		);
		
//				contains(hasProperty("priority", equals(Priority.BLOCKER.name())))
//				hasItem(allOf(hasProperty("priority", is(Priority.BLOCKER.name())))
//				);


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
		
//		ArrayList<JiraIssue> issues = new ArrayList<>();
//		issues.add(new JiraIssue(Status.OPEN, Priority.LOW, "TA-100"));
//		issues.add(new JiraIssue(Status.CLOSED, Priority.HIGH, "TA-200"));
//		issues.add(new JiraIssue(Status.OPEN, Priority.LOW, "TA-300"));
//		issues.add(new JiraIssue(Status.OPEN, Priority.HIGH, "TA-400"));
//		issues.add(new JiraIssue(Status.CLOSED, Priority.MEDIUM, "TA-500"));
//		issues.add(new JiraIssue(Status.CLOSED, Priority.HIGH, "TA-600"));
//		issues.add(new JiraIssue(Status.CLOSED, Priority.HIGH, "TA-700"));

//		return issues;
	}
}
