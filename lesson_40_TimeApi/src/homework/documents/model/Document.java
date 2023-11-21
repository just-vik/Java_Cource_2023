package homework.documents.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Document implements Comparable<Document> {
    //fields
    private int folderId;
    private int documentId;
    private String title;
    private String url;
    private LocalDateTime date;

    //constructor
    public Document(int folderId, int documentId, String title, String url, LocalDateTime date) {
        this.folderId = folderId;
        this.documentId = documentId;
        this.title = title;
        this.url = url;
        this.date = date;
    }

    //getters & setters
    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    // to string
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Documents { ");
        sb.append("folderId = ").append(folderId);
        sb.append(", documentId = ").append(documentId);
        sb.append(", title = '").append(title).append('\'');
        sb.append(", url = '").append(url).append('\'');
        sb.append(", date = ").append(date);
        sb.append('}');
        return sb.toString();
    }

    // equals & hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document documents = (Document) o;
        return folderId == documents.folderId && documentId == documents.documentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(folderId, documentId);
    }


    @Override
    public int compareTo(Document o) {
        int res = Integer.compare(folderId, o.folderId);
        return res != 0 ? res : Integer.compare(documentId, o.documentId);
    }
}
