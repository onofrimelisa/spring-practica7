package com.bootcamp.spring.interfaces;

import com.bootcamp.spring.dto.CharacterDTO;

import java.util.List;

public interface ICharactersService {
    List<CharacterDTO> searchCharacterByNameLike(String name);
}
