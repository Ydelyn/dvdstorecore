package com.mycompany.dvdstore.web.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;

public class MovieForm {
    private Long id;
    @NotBlank (message = "Veuillez entrer un titre")
    @Size(max = 20, message = "Entrez un titre de 20 caractères au plus")
    private String title;
    @NotBlank (message = "Veuillez choisir un genre")
    private String genre;
    @Size(max = 255, message = "Entrez une description de 255 caractères au plus")
    private String description;
    @NotBlank (message = "Veuillez entrer un prénom")
    @Size(max = 20, message = "Entrez un prénom de moins de 20 caractères")
    private String firstName;
    @Size(max = 20, message = "Entrez un nom de moins de 20 caractères")
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @NotBlank(message = "Veuillez entrer un prénom") @Size(max = 20, message = "Entrez un prénom de moins de 20 caractères") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "Veuillez entrer un prénom") @Size(max = 20, message = "Entrez un prénom de moins de 20 caractères") String firstName) {
        this.firstName = firstName;
    }

    public @Size(max = 20, message = "Entrez un nom de moins de 20 caractères") String getLastName() {
        return lastName;
    }

    public void setLastName(@Size(max = 20, message = "Entrez un nom de moins de 20 caractères") String lastName) {
        this.lastName = lastName;
    }
}
