package rgt.moonsh.api.domain.bookstore.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rgt.moonsh.api.common.error.BookErrorCode;
import rgt.moonsh.api.common.error.ErrorCode;
import rgt.moonsh.api.common.exception.ApiException;
import rgt.moonsh.api.domain.bookstore.controller.model.BookInfoRequest;
import rgt.moonsh.db.db.book.entity.TblBookInfoEntity;
import rgt.moonsh.db.db.book.repository.TblBookInfoRepository;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookStoreService {

    private final TblBookInfoRepository tblBookInfoRepository;

    public List<TblBookInfoEntity> findAll() {
        return tblBookInfoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Page<TblBookInfoEntity> search(String name, String author, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
//        return tblBookInfoRepository.findByNameContainingAndAuthorContaining(name, author, pageable);
        return tblBookInfoRepository.search(name, author, pageable);
    }

    public TblBookInfoEntity findById(TblBookInfoEntity entity) {
        return tblBookInfoRepository.findById(entity.getId())
                .orElseThrow(() -> new ApiException(BookErrorCode.BOOK_ID_NOT_FOUND, "Book id not found"));
    }

    @Transactional
    public TblBookInfoEntity modifyById(TblBookInfoEntity entity) {
        TblBookInfoEntity entityCheck = tblBookInfoRepository.findById(entity.getId())
                .orElseThrow(() -> new ApiException(BookErrorCode.BOOK_ID_NOT_FOUND, "Book id not found"));

        if (entity.getName() != null && !entity.getName().equals(entityCheck.getName())) {
            entityCheck.setName(entity.getName());
        }
        if (entity.getAuthor() != null && !entity.getAuthor().equals(entityCheck.getAuthor())) {
            entityCheck.setAuthor(entity.getAuthor());
        }
        if (entity.getDescription() != null && !entity.getDescription().equals(entityCheck.getDescription())) {
            entityCheck.setDescription(entity.getDescription());
        }
        if (entity.getInQty() != null && entity.getInQty() > 0) {
            entityCheck.setInQty(entity.getInQty());
        }
        if (entity.getSoldQty() != null && entity.getSoldQty() > -1) {
            entityCheck.setSoldQty(entity.getSoldQty());
        }
        if (entity.getIsbn() != null && !entity.getIsbn().equals(entityCheck.getIsbn())) {
            entityCheck.setIsbn(entity.getIsbn());
        }
        if (entity.getPrice() != null && entity.getPrice() >= 0) {
            entityCheck.setPrice(entity.getPrice());
        }
        return entityCheck;
    }
    public TblBookInfoEntity save(TblBookInfoEntity entity) {
        entity.setRegDate(Instant.now());
        return tblBookInfoRepository.save(entity);
    }

    @Transactional
    public TblBookInfoEntity delete(TblBookInfoEntity entity) {
        var entityCheck = tblBookInfoRepository.findById(entity.getId())
                .orElseThrow(() -> new ApiException(BookErrorCode.BOOK_ID_NOT_FOUND, "Book id not found"));
        tblBookInfoRepository.delete(entityCheck);
        return entityCheck;
    }
}
