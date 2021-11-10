/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.services;

import gt.com.excalibur.models.Publisher;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author malopez
 */
public interface PublisherService {

    public ArrayList<Publisher> getAll();

    public Publisher getPublisherById(Integer id);

    public Set<Publisher> getPublisherByVideogame(Integer id);

    public Publisher createPublisher(Publisher publisher);

    public Publisher updatePublisher(Publisher publisher, Integer id);

    public void deletePublisher(Integer id);

}
