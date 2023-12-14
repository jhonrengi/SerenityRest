package io.petstore.swagger.questions.pet;
/*
 * @(#) BuildPet.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.petstore.swagger.models.pet.Category;
import io.petstore.swagger.models.pet.PostPetModel;
import io.petstore.swagger.models.pet.Tag;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class BuildPet implements Question<PostPetModel> {
    private final String id;
    private final String nameCategory;
    private final String namePet;

    public BuildPet(String id, String nameCategory, String namePet) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.namePet = namePet;
    }

    @Override
    public PostPetModel answeredBy(Actor actor) {
        List<Tag> tags=new ArrayList<>();
        Category category= Category.builder()
                .id(0)
                .name(nameCategory)
                .build();

        Tag tag= Tag.builder()
                .id(1)
                .name("")
                .build();

        tags.add(tag);

        PostPetModel petData= PostPetModel.builder()
                .id(Long.parseLong(id))
                .category(category)
                .name(namePet)
                .status("Vigente")
                .tags(tags)

                .build();
        return petData;
    }

    public static BuildPet was(String id, String nameCategory, String namePet){
        return  new BuildPet(id,nameCategory,namePet);

    }
}
