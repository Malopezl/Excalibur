/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.controllers;

import gt.com.excalibur.models.Genre;
import gt.com.excalibur.services.GenreService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author malopez
 */
@RestController
@RequestMapping(value = "api/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("")
    List<Genre> getGenreList() {
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    Genre getGenre(@PathVariable Integer id) {
        return genreService.getGenreById(id);
    }

    @GetMapping("/videogame/{id}")
    Set<Genre> getGenreByVideogame(@PathVariable Integer id) {
        return genreService.getGenreByVideogame(id);
    }

    @PostMapping("")
    Genre createGenre(@RequestBody Genre genre) {
        return genreService.createGenre(genre);
    }

    @PutMapping("/{id}")
    Genre updateGenre(@PathVariable Integer id, @RequestBody Genre genre) {
        return genreService.updateGenre(genre, id);
    }

    @DeleteMapping("/{id}")
    void deleteGenre(@PathVariable Integer id) {
        genreService.deleteGenre(id);
    }

}
