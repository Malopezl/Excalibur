/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.controllers;

import gt.com.excalibur.models.Publisher;
import gt.com.excalibur.services.PublisherService;
import java.util.List;
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
@RequestMapping(value = "api/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("")
    List<Publisher> getPublisherList() {
        return publisherService.getAll();
    }

    @GetMapping("/{id}")
    Publisher getPublisher(@PathVariable Integer id) {
        return publisherService.getPublisherById(id);
    }

    @PostMapping("")
    Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherService.createPublisher(publisher);
    }

    @PutMapping("/{id}")
    Publisher updatePublisher(@PathVariable Integer id, @RequestBody Publisher publisher) {
        return publisherService.updatePublisher(publisher, id);
    }

    @DeleteMapping("/{id}")
    void deleteGenre(@PathVariable Integer id) {
        System.out.println(id.toString());
        publisherService.deletePublisher(id);
    }

}
