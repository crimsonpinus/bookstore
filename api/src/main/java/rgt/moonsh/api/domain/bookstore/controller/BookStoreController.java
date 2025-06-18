package rgt.moonsh.api.domain.bookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import rgt.moonsh.api.common.api.Api;
import rgt.moonsh.api.domain.bookstore.business.BookStoreBusiness;
import rgt.moonsh.api.domain.bookstore.controller.model.BookCreateRequest;
import rgt.moonsh.api.domain.bookstore.controller.model.BookInfoRequest;
import rgt.moonsh.api.domain.bookstore.controller.model.BookInfoResponse;
import rgt.moonsh.api.domain.bookstore.controller.model.BookSummaryResponse;
import rgt.moonsh.db.db.book.entity.TblBookInfoEntity;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookStoreController {
    private final BookStoreBusiness bookStoreBusiness;

    @Operation(
            summary = "전체 목록 보기",
            description = """
                    ***DB내의 모든 데이터 표출***
                    """
    )
    @GetMapping("/")
    public Api<List<BookSummaryResponse>> findAll() {
        var res = bookStoreBusiness.findAll();
        return Api.SUCCESS(res);
    }

    @Operation(
            summary = "id 검색"
    )
    @GetMapping("/{id}")
    public Api<BookInfoResponse> findById(@PathVariable Long id) {
        var res = bookStoreBusiness.findById(id);
        return Api.SUCCESS(res);
    }

    @Operation(
            summary = "제목, 작가, 검색 및 페이징 처리",
            description = """
                    ***제목, 작가 입력 없는경우 전체를 페이징(기본 10개) 검색*** \n
                        - 한개 또는 두개 다 넣어서 검색 가능
                        - 프론트에서는 한개만 검색가능하게 구현
                    
                    """
    )
    @GetMapping("/search")
    public Api<Page<TblBookInfoEntity>> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String author,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        var res = bookStoreBusiness.search(name, author, page, size);
        return Api.SUCCESS(res);
    }

    @Operation(
            summary = "새책 저장"
    )
    @PostMapping("/")
    public Api<BookInfoResponse> save(@RequestBody BookCreateRequest request) {
        var res = bookStoreBusiness.save(request);
        return Api.SUCCESS(res);
    }

    @Operation(
            summary = "책 정보 변경"
    )
    @PutMapping("/{id}")
    public Api<BookInfoResponse> findbyid(
            @PathVariable Long id,
            @RequestBody BookInfoRequest request
    ) {
        var res = bookStoreBusiness.modifyById(request, id);
        return Api.SUCCESS(res);
    }

    @Operation(
            summary = "책 정보 삭제",
            description = """
                    ***우선 정보있는지 확인 후 삭제 하는 로직***
                    """
    )
    @DeleteMapping("/{id}")
    public Api<BookInfoResponse> delete(@PathVariable Long id) {
        var res = bookStoreBusiness.delete(id);
        return Api.SUCCESS(res);
    }
}
