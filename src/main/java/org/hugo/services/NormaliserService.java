package org.hugo.services;

import org.apache.commons.text.similarity.JaroWinklerSimilarity;

import java.util.Collections;
import java.util.Map;

public class NormaliserService {

    private final static String ARCHITECT_KEYWORD = "architect";
    private final static String SOFTWARE_KEYWORD = "software";
    private final static String ENGINEER_KEYWORD = "engineer";
    private final static String DEVELOPER_KEYWORD = "developer";
    private final static String ACCOUNTANT_KEYWORD = "accountant";
    private final static String SURVEYOR_KEYWORD = "surveyor";
    private final static String QUANTITY_SURVEYOR_KEYWORD = "quantity surveyor";

    private final static Map<String, String> NORMALISED_JOB_TITLE = Map.of(
            ARCHITECT_KEYWORD, "Architect",
            SOFTWARE_KEYWORD, "Software engineer",
            ENGINEER_KEYWORD, "Software engineer",
            DEVELOPER_KEYWORD, "Software engineer",
            ACCOUNTANT_KEYWORD, "Accountant",
            SURVEYOR_KEYWORD, "Quantity surveyor",
            QUANTITY_SURVEYOR_KEYWORD, "Quantity surveyor"
    );

    public String normalise( final String jobTitle ) {
        String jobTitleLowerCase = jobTitle.toLowerCase();
        JaroWinklerSimilarity jaroWinklerSimilarity = new JaroWinklerSimilarity();

        Map<String, Double> scores = Map.of(
                ARCHITECT_KEYWORD, jaroWinklerSimilarity.apply(jobTitleLowerCase, ARCHITECT_KEYWORD),
                ENGINEER_KEYWORD, jaroWinklerSimilarity.apply(jobTitleLowerCase, ENGINEER_KEYWORD),
                SOFTWARE_KEYWORD, jaroWinklerSimilarity.apply(jobTitleLowerCase, SOFTWARE_KEYWORD),
                DEVELOPER_KEYWORD, jaroWinklerSimilarity.apply(jobTitleLowerCase, DEVELOPER_KEYWORD),
                ACCOUNTANT_KEYWORD, jaroWinklerSimilarity.apply(jobTitleLowerCase, ACCOUNTANT_KEYWORD),
                SURVEYOR_KEYWORD, jaroWinklerSimilarity.apply(jobTitleLowerCase, SURVEYOR_KEYWORD),
                QUANTITY_SURVEYOR_KEYWORD, jaroWinklerSimilarity.apply(jobTitleLowerCase, QUANTITY_SURVEYOR_KEYWORD)
        );

        String highestScoreKeyword = Collections.max(scores.entrySet(), Map.Entry.comparingByValue()).getKey();

        return NORMALISED_JOB_TITLE.get(highestScoreKeyword);
    }
}
