package com.bootcamp.spring.repository;

import com.bootcamp.spring.dto.CharacterDTO;
import com.bootcamp.spring.interfaces.ICharacterRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class CharactersRepository implements ICharacterRepository {
    private List<CharacterDTO> characters;

    public CharactersRepository() {
        this.characters = this.loadDatabase();
    }

    public List<CharacterDTO> loadDatabase() {
        File file = null;

        try{
            file = ResourceUtils.getFile("classpath:starwars.json");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
        List<CharacterDTO> characteresList = null;

        try{
            characteresList = objectMapper.readValue(file, typeRef);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return characteresList;
    }

    public List<CharacterDTO> searchCharacterByNameLike(String name){
        return characters
            .stream()
            .filter(characterDTO -> characterDTO.getName().toUpperCase(Locale.ROOT)
            .contains(name.toUpperCase(Locale.ROOT)))
            .collect(Collectors.toList());
    }
}
