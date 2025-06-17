package rgt.moonsh.api.domain.bookstore.business;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import rgt.moonsh.api.common.annotation.Business;
import rgt.moonsh.api.domain.bookstore.controller.model.BookCreateRequest;
import rgt.moonsh.api.domain.bookstore.controller.model.BookInfoRequest;
import rgt.moonsh.api.domain.bookstore.controller.model.BookInfoResponse;
import rgt.moonsh.api.domain.bookstore.controller.model.BookSummaryResponse;
import rgt.moonsh.api.domain.bookstore.converter.BookStoreConverter;
import rgt.moonsh.api.domain.bookstore.service.BookStoreService;
import rgt.moonsh.db.db.book.entity.TblBookInfoEntity;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Business
public class BookStoreBusiness {

    private final BookStoreService bookStoreService;
    private final BookStoreConverter bookStoreConverter;

    public List<BookSummaryResponse> findAll() {
        List<BookSummaryResponse> bookList= new ArrayList<>();
        var entities =bookStoreService.findAll();
        entities.forEach(entity -> {
            var bookSummery = bookStoreConverter.toResponseSummary(entity);
            bookList.add(bookSummery);
        });
        return bookList;
    }
    public BookInfoResponse modifyById(BookInfoRequest request, Long id) {
        var toEntity = bookStoreConverter.toEntity(request, id);
        var entity = bookStoreService.modifyById(toEntity);
        return bookStoreConverter.toResponse(entity);
    }

    public BookInfoResponse findById(Long id) {
        var toEntity = bookStoreConverter.toEntity(id);
        var entity = bookStoreService.findById(toEntity);
        return bookStoreConverter.toResponse(entity);
    }

    public BookInfoResponse save(BookCreateRequest request) {
        var toEntity = bookStoreConverter.toEntity(request);
        var entity = bookStoreService.save(toEntity);
        return bookStoreConverter.toResponse(entity);
    }

    public BookInfoResponse delete(Long id) {
        var toEntity = bookStoreConverter.toEntity(id);
        var entity = bookStoreService.delete(toEntity);
        return bookStoreConverter.toResponse(entity);
    }

    public Page<TblBookInfoEntity> search(String name, String author, Integer page, Integer size) {
        var entities =bookStoreService.search(name, author, page, size);
        return entities;
    }
}
