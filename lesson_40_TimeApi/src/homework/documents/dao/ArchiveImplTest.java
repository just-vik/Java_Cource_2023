package homework.documents.dao;

import homework.documents.model.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.album.model.Photo;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ArchiveImplTest {

    Archive archive;
    Document[] doc;
    LocalDateTime now = LocalDateTime.now();

    @BeforeEach
    void setUp() {
        archive = new ArchiveImpl(7);
        doc = new Document[6];
        doc[0] = new Document(1, 1, "doc_1", "url_1", now.minusDays(5));
        doc[1] = new Document(1, 2, "doc_2", "url_2", now.minusDays(4));
        doc[2] = new Document(1, 3, "doc_3", "url_3", now.minusDays(7));
        doc[3] = new Document(2, 4, "doc_1", "url_4", now.minusDays(6));
        doc[4] = new Document(2, 5, "doc_2", "url_5", now.minusDays(5));
        doc[5] = new Document(2, 6, "doc_3", "url_6", now.minusDays(5));

        for (Document document : doc) {
            archive.addDocument(document);
        }
    }

    @Test
    void addDocument() {
        //нельзя добавить null
        assertFalse(archive.addDocument(null));
        //нельзя добавить имеющееся
        assertFalse(archive.addDocument(doc[1]));
        //проверить возможность добавления
        Document document = new Document(3, 1, "doc", "url", now);
        assertTrue(archive.addDocument(document));
        //проверить ожидаемое кол-во после добавления(проверка size)
        assertEquals(7, archive.size());
        //нельзя превысить capacity
        document = new Document(3, 2, "doc", "url", now);
        assertFalse(archive.addDocument(document));
    }

    @Test
    void updateDocument() {
//        Document documentUpd = doc[1];
//        Document updDoc = new Document(documentUpd.getFolderId(), documentUpd.getDocumentId(), "doc", "url", now);
//        assertTrue(archive.updateDocument(documentUpd, updDoc));
    }

    @Test
    void removeDocument() {
    }

    @Test
    void getDocumentFromFolder() {
    }

    @Test
    void getAllDocumentFromFolder() {
    }

    @Test
    void getDocumentBetweenData() {
    }

    @Test
    void size() {
        assertEquals(6,archive.size());
    }
}