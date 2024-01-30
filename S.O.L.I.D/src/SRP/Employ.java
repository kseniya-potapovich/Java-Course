package SRP;

import static SRP.Utils.staff;
import static java.awt.Frame.NORMAL;

public class Employ {
    public void employ(Worker worker){
        if (worker.getSkill() >= NORMAL){
            staff.add(worker);
        }
    }
}
