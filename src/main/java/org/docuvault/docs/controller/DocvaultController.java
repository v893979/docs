package org.docuvault.docs.controller;

import org.docuvault.docs.model.Docvault;
import org.docuvault.docs.service.DocvaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/docs")
public class DocvaultController {
    @Autowired
    DocvaultService docService;

    @GetMapping("")
    public List<Docvault> list() {
        return docService.listAllDocvault();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docvault> get(@PathVariable Integer id) {
        try {
            Docvault doc = docService.getDocvault(id);
            return new ResponseEntity<Docvault>(doc, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Docvault>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Docvault doc) {
        docService.saveDocvault(doc);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Docvault doc, @PathVariable Integer id) {
        try {
            Docvault existDoc = docService.getDocvault(id);
            doc.setId(id);            
            docService.saveDocvault(doc);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        docService.deleteDocvault(id);
    }
}