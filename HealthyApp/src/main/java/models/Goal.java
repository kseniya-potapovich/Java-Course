package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goal {
    private Long id;
    private Long userId;
    private String type;
    private String description;
    private Timestamp dateStart;
    private Timestamp dateFinish;
}
