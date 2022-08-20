package org.docuvault.docs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "docvault")
public class Docvault {
    private int id;
    private String docId;
    private String docName;
    private String docSource;
    private String certificationStatus;
    private String certificationRating;
    private String certificationHistory;
    private Date createdOn;

    public Docvault() {
    }

    public Docvault(int id, String docId, String docName, String docSource, String certificationStatus, String certificationRating, String certificationHistory, Date createdOn) {
        this.id = id;
        this.docId = docId;
        this.docName = docName;
        this.docSource = docSource;
        this.certificationStatus = certificationStatus;
        this.certificationRating = certificationRating;
        this.certificationHistory = certificationHistory;
        this.createdOn = createdOn;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//other setters and getters
}