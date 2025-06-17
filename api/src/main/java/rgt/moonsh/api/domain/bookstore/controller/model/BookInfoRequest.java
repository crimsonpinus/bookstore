package rgt.moonsh.api.domain.bookstore.controller.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class BookInfoRequest {


    @NotNull
    public String name;

    @NotNull
    public String author;

    public String description;

    @NotNull
    public Integer inQty;

    public Integer soldQty;

    public String isbn;

    public Integer price;

}
