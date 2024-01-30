package SRP;

import static SRP.Utils.NORMAL;
import static SRP.Utils.staff;

public class Employ {
    public void employ(Worker worker){
        if (worker.getSkill() >= NORMAL){
            staff.add(worker);
        }
    }
}
