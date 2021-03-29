package com.github.almoskvin.teasers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SolutionParseLsOutput {

    /**
     * example:
     * <pre>
     * """
     *   root r-x delete-this.xls
     *   root r-- bug-report.pdf
     *   root r-- doc.xls
     *   root r-- podcast.flac
     *  alice r-- system.xls
     *   root --x invoices.pdf
     *  admin rwx SETUP.PY
     * """
     * </pre>
     * A list of files - representation of a linux terminal outcome:
     * <p>
     * - first column is User - length 6, case-sensitive, right-aligned
     * - second column is Permissions - length 3, consists of 'rwx' or a hyphen - just as in a real terminal
     * - third line is Filename - length max 255, ends with extension (. and three letters), case-sensitive
     *
     * @param S files
     * @return the shortest filename of readable (not writable) file, created by 'root' and having an extension of
     * doc, xls, or pdf.
     */
    public String solution(String S) {

        List<String> lines = Arrays.asList(S.split("\n"));
        List<Integer> resultList = new ArrayList<>();
        lines.forEach(line -> {
            String user = line.substring(0, 6);
            String perm = line.substring(7, 10);
            String name = line.substring(11);
            String fileExt = name.trim().substring(name.length() - 4);
            if (user.trim().equals("root") &&
                    (perm.charAt(0) == 'r' && perm.charAt(1) != 'w') &&
                    (fileExt.equals(".doc") || fileExt.equals(".xls") || fileExt.equals(".pdf"))) {
                resultList.add(name.trim().length());
            }
        });
        if (resultList.size() > 0) {
            return resultList.stream()
                    .min(Integer::compareTo)
                    .map(String::valueOf)
                    .orElse("");
        }
        return "NO FILES";
    }
}
