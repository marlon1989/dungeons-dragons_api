package dragons.dungeons.characterapi.dto.request;

import dragons.dungeons.characterapi.entity.Class;
import dragons.dungeons.characterapi.entity.Race;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String playerName;

    @Valid
    @NotEmpty
    private List<Class> classes;

    @NotEmpty
    @Size(min = 1, max = 3)
    private String level;

    @Valid
    @NotEmpty
    private List<Race> races;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String antecedent;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String alignment;

    @NotEmpty
    @Size(min = 1, max = 3)
    private String experience;
}
