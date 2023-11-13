package gmpu.gather.model;

import gmpu.gather.constant.SourceType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("sources")
public class Source {
    @Id
    private Integer sourceId;
    private SourceType sourceType;
    private String title;
    private String author;
    private String url;
}
