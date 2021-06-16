package dragons.dungeons.characterapi.repository;

import dragons.dungeons.characterapi.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
