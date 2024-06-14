package org.hugo;

import org.hugo.services.NormaliserService;

public class Main {
    public static void main(String[] args) {

        String jt = "Java engineer";
        NormaliserService n = new NormaliserService();
        String normalisedTitle = n.normalise(jt);
        System.out.printf("The job title normalised for %s is %s%n",jt, normalisedTitle);

        jt = "C# engineer";
        normalisedTitle = n.normalise(jt);
        System.out.printf("The job title normalised for %s is %s%n",jt, normalisedTitle);

        jt = "Accountant";
        normalisedTitle = n.normalise(jt);
        System.out.printf("The job title normalised for %s is %s%n",jt, normalisedTitle);

        jt = "Chief Accountant";
        normalisedTitle = n.normalise(jt);
        System.out.printf("The job title normalised for %s is %s%n",jt, normalisedTitle);

        jt = "Quantity Surveyor";
        normalisedTitle = n.normalise(jt);
        System.out.printf("The job title normalised for %s is %s%n",jt, normalisedTitle);
    }
}