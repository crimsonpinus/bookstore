package rgt.moonsh.db.db.book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rgt.moonsh.db.db.book.entity.TblBookInfoEntity;

import java.util.Optional;

public interface TblBookInfoRepository extends JpaRepository<TblBookInfoEntity, Long> {
    Optional<TblBookInfoEntity> findFirstById(Long id);
    void deleteById(Long id);
    Page<TblBookInfoEntity> findByNameContainingAndAuthorContaining(String name, String author, Pageable pageable);

    @Query("SELECT b FROM TblBookInfoEntity b WHERE (:name is NULL or b.name LIKE %:name%) AND (:author is NULL or b.author LIKE %:author%)")
    Page<TblBookInfoEntity> search(@Param("name") String name, @Param("author") String author, Pageable pageable);
}