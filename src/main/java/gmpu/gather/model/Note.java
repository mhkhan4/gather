package gmpu.gather.model;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("notes")
public class Note {
    @Id
    private Integer noteId;
    @NotNull
    private String topic;
    private String category;
    private String noteInDetails;
    @NotNull
    private Integer sourceId;
    @NotNull
    private Integer userId;
}
