package dragons.dungeons.characterapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RaceType {

    HUMAN("Human"),
    ELF("Elf"),
    DWARF("Dwarf"),
    ORC("Orc");

    private final String description;
}