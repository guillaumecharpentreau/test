package com.nintendo.pokemon.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.nintendo.pokemon.dao.entity.PokemonEntity;
import com.nintendo.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonMutation implements GraphQLMutationResolver {

    @Autowired
    private PokemonService pokemonService;

    public PokemonEntity createPokemon(final String name, final String type, final String evolution1, final String evolution2) {
        return this.pokemonService.createPokemon(name, type, evolution1, evolution2);
    }
}
