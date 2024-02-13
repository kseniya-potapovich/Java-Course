import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data //POJO - plain old java object (модель, сущность)
public class User {
    private Long id;
    private String username;
    private String userPassword;
    private Timestamp created;
    private Timestamp changed;
    private int age;
}
