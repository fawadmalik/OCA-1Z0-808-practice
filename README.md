# OCA-1Z0-808-practice
![Java CI](https://github.com/fawadmalik/OCA-1Z0-808-practice/workflows/Java%20CI/badge.svg)
### Practice code mainly for newer java constructs like streams and lambdas.

#### I am using Jira Issue lists to process with streams and lambdas.
#### How to run the code from commandline with maven:

```
mvn exec:java -Dexec.mainClass="com.e2eqa.JiraIssueAccessManager.JiraIssueAccessManagerApp"

Console output of a sample run:

WeRUs@DESKTOP-OO638E0 MINGW64 /c/dev/eclipse-workspace/OCA-1Z0-808-practice (master)
$ mvn exec:java -Dexec.mainClass="com.e2eqa.JiraIssueAccessManager.JiraIssueAccessManagerApp"
[INFO] Scanning for projects...
[INFO]
[INFO] -----------< com.oca-1Z0-808.practice:OCA-1Z0-808-practice >------------
[INFO] Building OCA-1Z0-808-practice 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ OCA-1Z0-808-practice ---
stream : [Jira{ID='TA-200', status=CLOSED, priority=HIGH}, Jira{ID='TA-400', status=OPEN, priority=HIGH}, Jira{ID='TA-600', status=CLOSED, priority=HIGH}, Jira{ID='TA-700', status=CLOSED, priority=HIGH}, Jira{ID='TA-500', status=CLOSED, priority=MEDIUM}, Jira{ID='TA-100', status=OPEN, priority=LOW}, Jira{ID='TA-300', status=OPEN, priority=LOW}]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.393 s
[INFO] Finished at: 2020-02-03T21:11:21-08:00
[INFO] ------------------------------------------------------------------------

WeRUs@DESKTOP-OO638E0 MINGW64 /c/dev/eclipse-workspace/OCA-1Z0-808-practice (master)

```
