package org.docuvault.docs.service;

import org.docuvault.docs.model.Docvault;
import org.docuvault.docs.repository.DocsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@Transactional
public class DocvaultService {
    @Autowired
    private DocsRepository docsRepository;
    public List<Docvault> listAllDocvault() {
        return docsRepository.findAll();
    }

    public void saveDocvault(Docvault docvault) {
        docsRepository.save(docvault);
    }

    public Docvault getDocvault(Integer id) {
        return docsRepository.findById(id).get();
    }

    public void deleteDocvault(Integer id) {
        docsRepository.deleteById(id);
    }
}