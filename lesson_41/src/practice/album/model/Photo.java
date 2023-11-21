package practice.album.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Photo implements Comparable<Photo> {
    //fields
    private int albumId;
    private int photoId;
    private String title;
    private String url;
    private LocalDateTime date; //LocalDateTime будем преобразовывать в LocalDate

    //constructor
    public Photo(int albumId, int photoId, String title, String url, LocalDateTime date) {
        this.albumId = albumId;
        this.photoId = photoId;
        this.title = title;
        this.url = url;
        this.date = date;
    }
    //all getters & setters (url / title)

    public int getAlbumId() {
        return albumId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    // to string
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Photo {");
        sb.append("albumId = ").append(albumId);
        sb.append(", photoId = ").append(photoId);
        sb.append(", title = '").append(title).append('\'');
        sb.append(", url = '").append(url).append('\'');
        sb.append(", date = ").append(date);
        sb.append('}');
        return sb.toString();
    }

    // equals & hashCode by photoId and albumId
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return albumId == photo.albumId && photoId == photo.photoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumId, photoId);
    }

    @Override
    public int compareTo(Photo o) {
        //надо определит как сортировать объекты в массиве Photo
        //по двум полям: albumId и photoId
        int res = Integer.compare(albumId, o.albumId); //o.albumId пришел для сравнения
        return res != 0 ? res : Integer.compare(photoId, o.photoId);
        // if (res!=0){return res} else {return Integer.compare(photoId, o.photoId)} - возможно и так
    }
}
