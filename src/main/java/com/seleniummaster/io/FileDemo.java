package com.seleniummaster.io;

public class FileDemo {
    public static void main(String[] args) {
    FileUtility fileUtility = new FileUtility();
    String myContent = "  This test combines\n" +
            "logical reasoning questions with a\n" +
            "question about algorithms and another\n" +
            "about SQL. It allows you to evaluate\n" +
            "both the current programming skills of\n" +
            "the candidate, as well as their\n" +
            "potential, given their capacity for\n" +
            "logical reasoning. Since this\n" +
            "programming test uses pseudo-code it\n" +
            "does not have a bias related to the\n" +
            "knowledge of a specific language.";
    fileUtility.writeToFile("doc", "myFile", ".txt", myContent);
}
}

