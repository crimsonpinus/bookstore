package rgt.moonsh.api.domain.bookstore.converter;

import lombok.RequiredArgsConstructor;
import rgt.moonsh.api.common.annotation.Converter;
import rgt.moonsh.api.common.error.ErrorCode;
import rgt.moonsh.api.common.exception.ApiException;
import rgt.moonsh.api.domain.bookstore.controller.model.*;
import rgt.moonsh.db.db.book.entity.TblBookInfoEntity;

import java.util.Optional;

@RequiredArgsConstructor
@Converter
public class BookStoreConverter {

    public TblBookInfoEntity toEntity(BookIdRequest bookIdRequest) {
        return Optional.ofNullable(bookIdRequest)
                .map(it -> {
                    return TblBookInfoEntity.builder()
                            .id(it.getId())
                            .build();
                })
                .orElseThrow(() -> new ApiException(ErrorCode.BAD_REQUEST, "Wrong book id request"));
    }
    public TblBookInfoEntity toEntity(Long id) {
        return Optional.ofNullable(id)
                .map(it -> {
                    return TblBookInfoEntity.builder()
                            .id(it)
                            .build();
                })
                .orElseThrow(() -> new ApiException(ErrorCode.BAD_REQUEST, "Wrong book id request"));
    }
    public TblBookInfoEntity toEntity(BookInfoRequest bookInfoRequest, Long id) {
        return Optional.ofNullable(bookInfoRequest)
                .map(it -> {
                    var entity = TblBookInfoEntity.builder()
                            .id(id)
                            .name(it.getName())
                            .author(it.getAuthor())
                            .description(it.getDescription())
                            .inQty(it.getInQty())
                            .soldQty(it.getSoldQty())
                            .isbn(it.getIsbn())
                            .build();
                    return entity;
                })
                .orElseThrow(() -> new ApiException(ErrorCode.BAD_REQUEST, "Wrong book info request"));
    }
    public TblBookInfoEntity toEntity(BookCreateRequest bookCreateRequest) {
        return Optional.ofNullable(bookCreateRequest)
                .map(it -> {
                    var entity = TblBookInfoEntity.builder()
                            .name(it.getName())
                            .author(it.getAuthor())
                            .inQty(it.getInQty())
                            .soldQty(0)
                            .build();
                    if (bookCreateRequest.getDescription() != null && !bookCreateRequest.getDescription().isEmpty()) {
                        entity.setDescription(it.getDescription());
                    }
                    if (bookCreateRequest.getIsbn() != null && !bookCreateRequest.getIsbn().isEmpty()) {
                        entity.setIsbn(it.getIsbn());
                    }
                    if (bookCreateRequest.getPrice() != null && bookCreateRequest.getPrice() >= 0) {
                        entity.setPrice(it.getPrice());
                    }

                    return entity;
                })
                .orElseThrow(() -> new ApiException(ErrorCode.BAD_REQUEST, "Wrong book info request"));
    }



    public BookSummaryResponse toResponseSummary(TblBookInfoEntity tblBookInfoEntity) {
        return Optional.ofNullable(tblBookInfoEntity)
                .map(res -> {
                    return BookSummaryResponse.builder()
                            .id(res.getId())
                            .name(res.getName())
                            .author(res.getAuthor())
                            .stockQty(res.getInQty() - res.getSoldQty())
                            .build();
                })
                .orElseThrow(() -> new ApiException(ErrorCode.SERVER_ERROR, "Internal server error"));
    }

    public BookInfoResponse toResponse(TblBookInfoEntity tblBookInfoEntity) {
        return Optional.ofNullable(tblBookInfoEntity)
                .map(res -> {
                    return BookInfoResponse.builder()
                            .id(res.getId())
                            .name(res.getName())
                            .author(res.getAuthor())
                            .description(res.getDescription())
                            .inQty(res.getInQty())
                            .soldQty(res.getSoldQty())
                            .isbn(res.getIsbn())
                            .price(res.getPrice())
                            .regDate(res.getRegDate())
                            .build();
                })
                .orElseThrow(() -> new ApiException(ErrorCode.SERVER_ERROR, "Internal server error"));
    }
}
