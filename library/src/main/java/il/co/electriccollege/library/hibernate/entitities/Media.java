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
    private String status;
    private String mediaType;

    private Library library;

    @Column
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
    public MediaStatus getStatus() {
        return MediaStatus.valueOf(status);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    public long getId() {
        return this.id;
    }

    @Column(name = "media_type")
    public MediaType getMediaType(){
        return MediaType.valueOf(mediaType);
    }

    public void setMediaType(String mediaType){
        this.mediaType = mediaType;
    }

    public void setId(long id){
        this.id = id;
    }

}
