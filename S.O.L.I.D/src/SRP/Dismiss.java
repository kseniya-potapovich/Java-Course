package SRP;

import static SRP.Utils.staff;
import static java.awt.Frame.NORMAL;

public class Dismiss {
    public void dismiss(Worker worker){
        if (worker.getSkill() <= NORMAL){
            staff.remove(worker);
        }
    }
}
