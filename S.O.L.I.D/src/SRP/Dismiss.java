package SRP;

import static SRP.Utils.NORMAL;
import static SRP.Utils.staff;

public class Dismiss {
    public void dismiss(Worker worker){
        if (worker.getSkill() <= NORMAL){
            staff.remove(worker);
        }
    }
}
