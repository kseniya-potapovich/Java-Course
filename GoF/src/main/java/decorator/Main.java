package decorator;

import decorator.skills.CodeReview;
import decorator.skills.JSPDeveloper;
import decorator.skills.TestDeveloper;

public class Main {
    public static void main(String[] args) {
        Developer developer = new JavaDeveloper();
        developer.develop();

        System.out.println("-----------------------");

        TestDeveloper testDeveloper = new TestDeveloper(developer);
        testDeveloper.develop();

        System.out.println("-----------------------");

        JSPDeveloper jspDeveloper = new JSPDeveloper(testDeveloper);
        jspDeveloper.develop();

        System.out.println("------------------------");

        CodeReview codeReview = new CodeReview(jspDeveloper);
        codeReview.develop();

        System.out.println("------------------------");

        JavaScriptDeveloper javaScriptDeveloper = new JavaScriptDeveloper();
        javaScriptDeveloper.develop();

        System.out.println("------------------------");

        CodeReview codeReview1 = new CodeReview(javaScriptDeveloper);
        codeReview1.develop();
    }
}
