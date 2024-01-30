package fabric_method.developers;

import fabric_method.developers.IDeveloper;

public class PythonDeveloper implements IDeveloper {
    @Override
    public String commonStack() {
        return "Python, Django etc.";
    }

    @Override
    public String getLanguage() {
        return "Python";
    }

    @Override
    public int getSalary() {
        return 1000;
    }
}
