package com.nintendo.pokemon.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.nintendo.pokemon.dao.entity.PokemonEntity;
import com.nintendo.pokemon.service.PokemonService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PokemonQuery implements GraphQLQueryResolver {

    private final PokemonService pokemonService;

    PokemonQuery(final PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    public List<PokemonEntity> getPokemons(final int count) {
        return pokemonService.getPokemons(count);
    }

    public PokemonEntity getPokemon(final Long id) {
        return pokemonService.getPokemon(id);
    }
}
