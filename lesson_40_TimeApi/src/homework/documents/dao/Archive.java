package homework.documents.dao;

import homework.documents.model.Document;
import java.time.LocalDate;

public interface Archive {
    boolean addDocument(Document documents);
    boolean updateDocument(int folderId, int documentId, String url);
    boolean removeDocument(int documentId, int folderId);

    Document getDocumentFromFolder(int documentId, int folderId);

    Document[] getAllDocumentFromFolder(int folderId);

    Document[] getDocumentBetweenData(LocalDate dateFrom, LocalDate dateTo);

    int size(); //qty of documents in all folders
}
