package rgt.moonsh.api.domain.bookstore.controller.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookSummaryResponse {
    public Long id;
    public String name;
    public String author;
    public Integer stockQty;
}
