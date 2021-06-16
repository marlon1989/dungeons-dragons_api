package dragons.dungeons.characterapi.dto.request;

import dragons.dungeons.characterapi.enums.ClassType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassDTO {

    private long id;

    @Enumerated(EnumType.STRING)
    private ClassType type;

}
