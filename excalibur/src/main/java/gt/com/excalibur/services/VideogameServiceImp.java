/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.services;

import gt.com.excalibur.models.Publisher;
import gt.com.excalibur.models.Videogame;
import gt.com.excalibur.repositories.GenreRepository;
import gt.com.excalibur.repositories.PublisherRepository;
import gt.com.excalibur.repositories.VideogameRepository;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author malopez
 */
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
    public Videogame createVideogame(Videogame videogame) {
        return videogameRepository.save(videogame);
    }

    @Override
    @Transactional
    public Videogame updateVideogame(Videogame videogame, Integer id) {
        return videogameRepository.findById(id)
                .map(newVideogame -> {
                    newVideogame.setName(videogame.getName());
                    newVideogame.setReleaseDate(videogame.getReleaseDate());
                    return videogameRepository.save(newVideogame);
                }).orElseGet(() -> { return videogame; });
    }

    @Override
    @Transactional(readOnly = true)
    public void deleteVideogame(Integer id) {
        videogameRepository.deleteById(id);
    }

}
