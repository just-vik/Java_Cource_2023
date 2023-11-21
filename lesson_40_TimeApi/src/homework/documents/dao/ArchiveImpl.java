package homework.documents.dao;

import homework.documents.model.Document;


import java.time.LocalDate;
import java.util.Comparator;

public class ArchiveImpl implements Archive {

    static Comparator<Document> comparator = (p1, p2) -> {
        int res = p1.getDate().compareTo(p2.getDate()); // date field
        return res != 0 ? res : Integer.compare(p1.getDocumentId(), p2.getDocumentId());
    };

    //field
    private Document[] documents;
    private int size;

    public ArchiveImpl(int capacity) {
        documents = new Document[capacity];
    }

    @Override
    public boolean addDocument(Document document) {
        if (document == null || size >= documents.length) {
            return false;
        }
        documents[size++] = document;
        return true;
    }

    @Override
    public boolean updateDocument(int folderId, int documentId, String url) {
        for (Document doc: documents) {
            if (doc!=null && doc.getFolderId()==folderId && doc.getDocumentId() == documentId) {
// Проверяем, что текущий элемент массива не равен null и соответствует искомому документу.
                doc.setUrl(url);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeDocument(int documentId, int folderId) {
        return false;
    }

    @Override
    public Document getDocumentFromFolder(int documentId, int folderId) {
        return null;
    }

    @Override
    public Document[] getAllDocumentFromFolder(int folderId) {
        return new Document[0];
    }

    @Override
    public Document[] getDocumentBetweenData(LocalDate dateFrom, LocalDate dateTo) {
        return new Document[0];
    }

    @Override
    public int size() {
        return size;
    }
}
