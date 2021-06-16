package dragons.dungeons.characterapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlayerNotFoundException extends Exception {

    public PlayerNotFoundException(Long id) {

        super("Person not found with ID " + id);
    }
}
