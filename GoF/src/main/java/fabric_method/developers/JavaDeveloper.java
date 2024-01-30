package fabric_method.developers;

public class JavaDeveloper implements IDeveloper{
    @Override
    public String commonStack() {
        return "Java, Spring, SQL, Hibernate etc.";
    }

    @Override
    public String getLanguage() {
        return "Java";
    }

    @Override
    public int getSalary() {
        return 3000;
    }
}
