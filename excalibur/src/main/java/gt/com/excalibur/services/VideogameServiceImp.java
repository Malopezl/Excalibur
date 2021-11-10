/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.services;

import gt.com.excalibur.dtos.VideogameDto;
import gt.com.excalibur.models.Genre;
import gt.com.excalibur.models.Publisher;
import gt.com.excalibur.models.Videogame;
import gt.com.excalibur.repositories.GenreRepository;
import gt.com.excalibur.repositories.PublisherRepository;
import gt.com.excalibur.repositories.VideogameRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author malopez
 */
@Service
public class VideogameServiceImp implements VideogameService {

    @Autowired
    public GenreRepository genreRepository;
    @Autowired
    public PublisherRepository publisherRepository;
    @Autowired
    public VideogameRepository videogameRepository;

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Videogame> getAll() {
        return (ArrayList<Videogame>) videogameRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Videogame getVideogameById(Integer id) {
        return videogameRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Videogame> getVideogamesByGenre(Integer id) {
//        Genre genre = genreRepository.findById(id).orElse(null);
//        if (genre == null) {
//            return null;
//        }
//        return genre.getVideogames();
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Videogame> getVideogamesByPublisher(Integer id) {
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        if (publisher == null) {
            return null;
        }
        return publisher.getVideogames();
    }

    @Override
    @Transactional
    public Videogame createVideogame(VideogameDto videogame) {
        Videogame newVideogame = new Videogame();
        newVideogame.setName(videogame.getName());
        newVideogame.setReleaseDate(videogame.getRelease());
        newVideogame.setIdpublisher(videogame.getIdpublisher());
        Set<Genre> genres = new HashSet<>();
        videogame.getGenres().stream().map(id -> genreRepository.findById(id).get()).filter(genre -> (genre != null))
                .forEachOrdered(genre -> {
            genres.add(genre);
        });
        newVideogame.setGenres(genres);
        return videogameRepository.save(newVideogame);
    }

    @Override
    @Transactional
    public Videogame updateVideogame(VideogameDto videogame, Integer id) {
        Videogame oldVideogame = videogameRepository.findById(id).get();
        if (oldVideogame == null) {
            return null;
        }
        oldVideogame.setName(videogame.getName());
        oldVideogame.setReleaseDate(videogame.getRelease());
        oldVideogame.setIdpublisher(videogame.getIdpublisher());
        Set<Genre> genres = new HashSet<>();
        videogame.getGenres().stream().map(idpublisher -> genreRepository.findById(idpublisher).get())
                .filter(genre -> (genre != null)).forEachOrdered(genre -> {
            genres.add(genre);
        });
        oldVideogame.setGenres(genres);
        return videogameRepository.save(oldVideogame);
    }

    @Override
    @Transactional
    public void deleteVideogame(Integer id) {
        videogameRepository.deleteById(id);
    }

}
