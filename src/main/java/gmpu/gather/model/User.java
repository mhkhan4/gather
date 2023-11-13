package gmpu.gather.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("users")
public class User {
    @Id
    private Integer userId;
    private String userName;
    private String password;
}
