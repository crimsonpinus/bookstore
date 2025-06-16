package rgt.moonsh.db.db.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rgt.moonsh.db.db.book.entity.TblBookInfoEntity;

import java.util.Optional;

public interface TblBookInfoRepository extends JpaRepository<TblBookInfoEntity, Long> {
    Optional<TblBookInfoEntity> findFirstById(Long id);

}
