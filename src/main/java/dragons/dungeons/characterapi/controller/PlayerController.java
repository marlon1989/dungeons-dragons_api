package dragons.dungeons.characterapi.controller;

import dragons.dungeons.characterapi.dto.request.PlayerDTO;
import dragons.dungeons.characterapi.dto.response.MessageResponseDTO;
import dragons.dungeons.characterapi.exception.PlayerNotFoundException;
import dragons.dungeons.characterapi.service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/character")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PlayerController {

    private CharacterService characterService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPlayer(@RequestBody @Valid PlayerDTO playerDTO) {

        return characterService.createPlayer(playerDTO);
    }

    @GetMapping
    public List<PlayerDTO> listAll() {

        return characterService.listAll();
    }

    @GetMapping("/{id}")
    public PlayerDTO findById(@PathVariable Long id) throws PlayerNotFoundException {
        return characterService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PlayerDTO playerDTO) throws PlayerNotFoundException {

        return characterService.updateById(id, playerDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PlayerNotFoundException {

        characterService.delete(id);
    }
}