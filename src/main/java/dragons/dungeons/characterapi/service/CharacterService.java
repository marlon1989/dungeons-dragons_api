package dragons.dungeons.characterapi.service;

import dragons.dungeons.characterapi.dto.request.PlayerDTO;
import dragons.dungeons.characterapi.dto.response.MessageResponseDTO;
import dragons.dungeons.characterapi.entity.Player;
import dragons.dungeons.characterapi.exception.PlayerNotFoundException;
import dragons.dungeons.characterapi.mapper.PlayerMapper;
import dragons.dungeons.characterapi.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CharacterService {

    private PlayerRepository playerRepository;

    private final PlayerMapper playerMapper = PlayerMapper.INSTANCE;

    public MessageResponseDTO createPlayer(PlayerDTO playerDTO) {

        Player playerToSave = playerMapper.toModel(playerDTO);

        Player savedPlayer = playerRepository.save(playerToSave);

        return createMessageResponse(savedPlayer.getId(), "Created player with ID ");

    }

    public List<PlayerDTO> listAll() {

        List<Player> allPlayer = playerRepository.findAll();

        return allPlayer.stream()
                .map(playerMapper::toDTO)
                .collect((Collectors.toList()));
    }

    public PlayerDTO findById(Long id) throws PlayerNotFoundException {
        Player person = verifyIfExists(id);

        return playerMapper.toDTO(person);
    }

    public MessageResponseDTO updateById(Long id, PlayerDTO playerDTO) throws PlayerNotFoundException {

        verifyIfExists(id);

        Player playerToUpdate = playerMapper.toModel(playerDTO);

        Player updatedPlayer = playerRepository.save(playerToUpdate);

        return createMessageResponse(updatedPlayer.getId(), "Update person with ID ");

    }

    public void delete(Long id) throws PlayerNotFoundException {

        verifyIfExists(id);

        playerRepository.deleteById(id);

    }

    private Player verifyIfExists(Long id) throws PlayerNotFoundException {

        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {

        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();

    }
}
