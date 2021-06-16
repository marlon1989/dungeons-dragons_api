package dragons.dungeons.characterapi.mapper;

import dragons.dungeons.characterapi.dto.request.PlayerDTO;
import dragons.dungeons.characterapi.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    Player toModel(PlayerDTO playerDTO);

    PlayerDTO toDTO(Player player);
}
