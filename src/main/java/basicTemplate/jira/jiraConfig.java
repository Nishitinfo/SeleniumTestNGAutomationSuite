package basicTemplate.jira;

import basicTemplate.configs.loadProps;

public class jiraConfig {
    public static final String BASE_URL = loadProps.getProperty("Jira_BASE_URL");
    public static final String EMAIL = loadProps.getProperty("Jira_Email");
    public static final String API_TOKEN = loadProps.getProperty("Jira_API_Token");
    public static final String PROJECT_KEY = loadProps.getProperty("Jira_PROJECT_KEY");
}

