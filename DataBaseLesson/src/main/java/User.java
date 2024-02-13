import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data //POJO - plain old java object (модель, сущность)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String userPassword;
    private Timestamp created;
    private Timestamp changed;
    private int age;
}
