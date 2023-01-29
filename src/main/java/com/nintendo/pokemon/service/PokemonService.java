package com.nintendo.pokemon.service;

import com.nintendo.pokemon.dao.entity.PokemonEntity;
import com.nintendo.pokemon.dao.repository.PokemonRepository;
import com.nintendo.pokemon.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(final PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Transactional
    public PokemonEntity createPokemon(final String name, final String type, final String evolution1, final String evolution2) {
        final PokemonEntity pokemonEntity = new PokemonEntity();
        pokemonEntity.setName(name);
        pokemonEntity.setType(type);
        pokemonEntity.setEvolution1(evolution1);
        pokemonEntity.setEvolution2(evolution2);
        return this.pokemonRepository.save(pokemonEntity);
    }

    @Transactional(readOnly = true)
    public List<PokemonEntity> getPokemons(final int count) {
        return pokemonRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PokemonEntity getPokemon(final Long id) {
        return pokemonRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Pokemon with id " + id + " not found.", "id"));
    }
}
