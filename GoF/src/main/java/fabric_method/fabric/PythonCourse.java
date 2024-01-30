package fabric_method.fabric;

import fabric_method.developers.IDeveloper;
import fabric_method.developers.PythonDeveloper;

public class PythonCourse implements ICourse {
    @Override
    public IDeveloper getDeveloper() {
        return new PythonDeveloper();
    }
}
