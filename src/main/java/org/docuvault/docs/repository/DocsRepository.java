package org.docuvault.docs.repository;

import org.docuvault.docs.model.Docvault;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocsRepository extends JpaRepository<Docvault, Integer>{
}