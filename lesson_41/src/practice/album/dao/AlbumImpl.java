package practice.album.dao;

import homework.documents.model.Document;
import practice.album.model.Photo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class AlbumImpl implements Album {

    //field
    private Photo[] photos;
    private int size;

    public AlbumImpl(int capacity) { //какое кол-во фото мы храним
        photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {
        if (photo == null || size == photos.length || getPhotoFromAlbum(photo.getPhotoId(), photo.getAlbumId()) != null) {
            return false;
        }
        //ищем индекс, куда вставить
        int index = Arrays.binarySearch(photos, 0, size, photo, comparator);
        //обработка индекса с помощью тернарного оператора
        index = index >= 0 ? index : -index - 1;
        //раздвигаем массив с индекса на 1 место вправо
        System.arraycopy(photos, index, photos, index + 1, size - index);
        photos[index] = photo;
        size++;
        return true;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        //ищем фото
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                //надвинем массив на найденную позицию i удаляемого фото
                System.arraycopy(photos, i + 1, photos, i, size - 1 - i);
                // последний элемент массива(пустой после сдвига) затираем и уменьшим размер массива
                photos[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePhoto(int photoId, int albumId, String url) {
        Photo photo = getPhotoFromAlbum(photoId, albumId); //нашли фото
        if (photo == null) {
            return false;
        }
        photo.setUrl(url); //обновили url
        return true;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
        Photo pattern = new Photo(albumId, photoId, null, null, null); //определили тот объект с которым сравниваем
        for (int i = 0; i < size; i++) {
            if (pattern.equals(photos[i])) {
                return photos[i];
            }
        }
        return null;
    }

    @Override
    public Photo[] getAllPhotoFromAlbum(int albumId) {
        return findByPredicate(p -> albumId == p.getAlbumId());
    }


    @Override
    public Photo[] getPhotoBetweenData(LocalDate dateFrom, LocalDate dateTo) {
        Photo patternFrom = new Photo(0, Integer.MIN_VALUE, null, null, dateFrom.atStartOfDay());
        int fromIndex = -Arrays.binarySearch(photos, 0, size, patternFrom, comparator) - 1;
        fromIndex = fromIndex > 0 ? fromIndex : -fromIndex - 1;

        Photo patternTo = new Photo(0, Integer.MAX_VALUE, null, null, LocalDateTime.of(dateTo, LocalTime.MAX));
        int toIndex = -Arrays.binarySearch(photos, 0, size, patternTo, comparator) - 1;
        toIndex = toIndex > 0 ? toIndex : -toIndex - 1;

        if (fromIndex == 0) {
            return new Photo[0];
        }
        Photo[] photosInRange = Arrays.copyOfRange(photos, fromIndex, toIndex);

        return photosInRange;
    }

    @Override
    public int size() {
        return size;
    }


    static Comparator<Photo> comparator = (p1, p2) -> {
        int res = p1.getDate().compareTo(p2.getDate()); // date field
        return res != 0 ? res : Integer.compare(p1.getPhotoId(), p2.getPhotoId()); // photoId field
    };


    private Photo[] findByPredicate(Predicate<Photo> predicate) {
        Photo[] res = new Photo[size];
        int j = 0; // счетчик найденных фото в альбоме
        for (int i = 0; i < size; i++) {
            if (predicate.test(photos[i])) {
                res[j] = photos[i];
                j++;
            }

        }
        //заполнили массив, но в нем после индекса j идут null
        return Arrays.copyOf(res, j); //вернули обрезанный массив без null
    }
}
