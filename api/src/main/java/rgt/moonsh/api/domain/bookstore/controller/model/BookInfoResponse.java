package rgt.moonsh.api.domain.bookstore.controller.model;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class BookInfoResponse {

    public Long id;
    public String name;
    public String author;
    public String description;
    public Integer inQty;
    public Integer soldQty;
    public String isbn;
    public Integer price;
    public Instant regDate;
}
