/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.services;

import gt.com.excalibur.models.Genre;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author malopez
 */
public interface GenreService {

    public ArrayList<Genre> getAll();

    public Genre getGenreById(Integer id);

    public Set<Genre> getGenreByVideogame(Integer id);

    public Genre createGenre(Genre genre);

    public Genre updateGenre(Genre genre, Integer id);

    public void deleteGenre(Integer id);

}
