package com.github.almoskvin.teasers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph {

    /**
     * Change format of a phone number on-the-go from XXX-XX-XXXX to XXX/XX/XXXX
     *
     * @param paragraph string input containing a phone number in the format of XXX-XX-XXXX
     * @return the same input where the phone number format has been changed to XXX/XX/XXXX
     */
    public static String changeFormat(String paragraph) {
        System.out.println("Paragraph: " + paragraph);
        Pattern pattern = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
        Matcher matcher = pattern.matcher(paragraph);
        if (matcher.find()) {
            String number = matcher.group(0);
            System.out.println("Number found: " + number);
            return matcher.replaceAll(number.replace('-', '/'));
        }
        System.out.println("No number found in the paragraph " + paragraph);
        return "";
    }
}
