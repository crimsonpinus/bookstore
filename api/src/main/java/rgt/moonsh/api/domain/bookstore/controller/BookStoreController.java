package rgt.moonsh.api.domain.bookstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rgt.moonsh.api.common.api.Api;
import rgt.moonsh.api.domain.bookstore.business.BookStoreBusiness;
import rgt.moonsh.api.domain.bookstore.controller.model.BookCreateRequest;
import rgt.moonsh.api.domain.bookstore.controller.model.BookInfoRequest;
import rgt.moonsh.api.domain.bookstore.controller.model.BookInfoResponse;
import rgt.moonsh.api.domain.bookstore.controller.model.BookSummaryResponse;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookStoreController {
    private final BookStoreBusiness bookStoreBusiness;

    @GetMapping("/")
    public Api<List<BookSummaryResponse>> findAll() {
        var res = bookStoreBusiness.findAll();
        return Api.SUCCESS(res);
    }
    @GetMapping("/{id}")
    public Api<BookInfoResponse> findById(@PathVariable Long id) {
        var res = bookStoreBusiness.findById(id);
        return Api.SUCCESS(res);
    }

    @PostMapping("/")
    public Api<BookInfoResponse> save(@RequestBody BookCreateRequest request) {
        var res = bookStoreBusiness.save(request);
        return Api.SUCCESS(res);
    }

    @PutMapping("/{id}")
    public Api<BookInfoResponse> findbyid(
            @PathVariable Long id,
            @RequestBody BookInfoRequest request
    ) {
        var res = bookStoreBusiness.modifyById(request, id);
        return Api.SUCCESS(res);
    }

    @DeleteMapping("/{id}")
    public Api<BookInfoResponse> delete(@PathVariable Long id) {
        var res = bookStoreBusiness.delete(id);
        return Api.SUCCESS(res);
    }
}
