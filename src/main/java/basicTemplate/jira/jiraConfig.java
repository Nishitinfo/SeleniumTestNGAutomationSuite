package basicTemplate.jira;

import basicTemplate.configs.loadProps;

public class jiraConfig {
    public static final String BASE_URL = loadProps.getProperty("Jira_BASE_URL");
    public static final String EMAIL = loadProps.getProperty("Jira_Email").trim();
    public static final String TOKEN = loadProps.getProperty("Jira_API_Token").trim();
    public static final String PROJECT_KEY = loadProps.getProperty("Jira_PROJECT_KEY");
}

