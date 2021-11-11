/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.services;

import gt.com.excalibur.models.Publisher;
import gt.com.excalibur.repositories.PublisherRepository;
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
public class PublisherServiceImp implements PublisherService {

    @Autowired
    public PublisherRepository publisherRepository;
    @Autowired
    public VideogameRepository videogameRepository;

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Publisher> getAll() {
        return (ArrayList<Publisher>) publisherRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Publisher getPublisherById(Integer id) {
        return publisherRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Publisher> getPublisherByVideogame(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    @Transactional
    public Publisher updatePublisher(Publisher publisher, Integer id) {
        return publisherRepository.findById(id)
                .map(newPublisher -> {
                    newPublisher.setName(publisher.getName());
                    return publisherRepository.save(newPublisher);
                }).orElseGet(() -> { return publisher; });
    }

    @Override
    @Transactional
    public void deletePublisher(Integer id) {
        publisherRepository.deleteById(id);
    }

}
