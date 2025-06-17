package rgt.moonsh.api.domain.bookstore.controller.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class BookIdRequest {

    @NotNull
    public Long id;
}
