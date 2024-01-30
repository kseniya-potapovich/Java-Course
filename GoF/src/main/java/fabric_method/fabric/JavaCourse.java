package fabric_method.fabric;

import fabric_method.developers.IDeveloper;
import fabric_method.developers.JavaDeveloper;

public class JavaCourse implements ICourse {
    @Override
    public IDeveloper getDeveloper() {
        return new JavaDeveloper();
    }
}
