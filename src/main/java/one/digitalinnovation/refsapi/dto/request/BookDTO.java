package one.digitalinnovation.refsapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;

    @NotEmpty
    @Size(min = 1)
    private String title;

    private String subtitle;

    @NotEmpty
    @Size(min = 1)
    private String authors;

    private String organizers;
    private String url;

    @NotEmpty
    private String language;

    private int volume;
    private String edition;
    private String location;
    private LocalDate date;
    private String isbn;
    private int pages;

    @Valid
    private List<QuoteDTO> quotes;

}
