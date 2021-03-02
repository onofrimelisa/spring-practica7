package com.bootcamp.spring.service;

import com.bootcamp.spring.dto.CharacterDTO;
import com.bootcamp.spring.interfaces.ICharactersService;
import com.bootcamp.spring.repository.CharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharactersService implements ICharactersService {

    @Autowired
    private CharactersRepository charactersRepository;

    public List<CharacterDTO> searchCharacterByNameLike(String name){
        return charactersRepository.searchCharacterByNameLike(name);
    }
}
