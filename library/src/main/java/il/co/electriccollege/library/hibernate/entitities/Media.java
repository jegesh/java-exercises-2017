package il.co.electriccollege.library.hibernate.entitities;


import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.TABLE;

/**
 * Created by yaakov on 8/22/17.
 */
@Entity
@Table(name="media")
public class Media {
    private long id;
    private String name;
    private Date publicationDate;
    private MediaStatus status;
    private MediaType mediaType;

    private Library library;

    @ManyToOne
    @JoinColumn(name = "library_id")
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "publication_date")
    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Column(name="media_status")
    public String getStatus() {
        return status.name();
    }

    public void setStatus(String status) {
        this.status = MediaStatus.valueOf(status);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    public long getId() {
        return this.id;
    }

    @Column(name = "media_type")
    public String getMediaType(){
        return mediaType.name();
    }

    public void setMediaType(String mediaType){
        this.mediaType = MediaType.valueOf(mediaType);
    }

    public void setId(long id){
        this.id = id;
    }

    @Override
    public String toString() {
        String desc = "Type: %s, Title: %s, published on: %s, id: %s, status: %s";
        return String.format(desc, mediaType, name, publicationDate, id, status);
    }
}
