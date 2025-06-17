package rgt.moonsh.db.db.book.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tbl_book_info")
public class TblBookInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_book_info_id_gen")
    @SequenceGenerator(name = "tbl_book_info_id_gen", sequenceName = "tbl_book_info_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Size(max = 50)
    @NotNull
    @Column(name = "author", nullable = false, length = 50)
    private String author;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ColumnDefault("0")
    @Column(name = "in_qty")
    private Integer inQty;

    @ColumnDefault("0")
    @Column(name = "sold_qty")
    private Integer soldQty;

    @Size(max = 150)
    @Column(name = "isbn", length = 150)
    private String isbn;

    @ColumnDefault("0")
    @Column(name = "price")
    private Integer price;

    @ColumnDefault("now()")
    @Column(name = "reg_date")
    private Instant regDate;

}