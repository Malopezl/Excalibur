/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.services;

import gt.com.excalibur.models.Genre;
import gt.com.excalibur.models.Videogame;
import gt.com.excalibur.repositories.GenreRepository;
import gt.com.excalibur.repositories.VideogameRepository;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author malopez
 */
@Service
public class GenreServiceImp implements GenreService{

    @Autowired
    public GenreRepository genreRepository;
    @Autowired
    public VideogameRepository videogameRepository;

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Genre> getAll() {
        return (ArrayList<Genre>) genreRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Genre getGenreById(Integer id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Genre> getGenreByVideogame(Integer id) {
        Videogame videogame = videogameRepository.findById(id).orElse(null);
        if (videogame == null) {
            return null;
        }
        return videogame.getGenres();
    }

    @Override
    @Transactional
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    @Transactional
    public Genre updateGenre(Genre genre, Integer id) {
        return genreRepository.findById(id)
                .map(newGenre -> {
                    newGenre.setName(genre.getName());
                    return genreRepository.save(newGenre);
                }).orElseGet(() -> { return genre; });
    }

    @Override
    @Transactional
    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }

}
