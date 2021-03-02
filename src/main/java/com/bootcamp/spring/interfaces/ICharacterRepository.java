package com.bootcamp.spring.interfaces;

import com.bootcamp.spring.dto.CharacterDTO;

import java.util.List;

public interface ICharacterRepository {
    List<CharacterDTO> loadDatabase();
    List<CharacterDTO> searchCharacterByNameLike(String name);
}
