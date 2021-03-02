package com.bootcamp.spring.controler;

import com.bootcamp.spring.dto.CharacterDTO;
import com.bootcamp.spring.service.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharactersController {
    @Autowired
    private CharactersService charactersService;

    @PostMapping
    public List<CharacterDTO> searchCharacterByNameLike(@RequestParam String name) {
        return this.charactersService.searchCharacterByNameLike(name);
    }
}
