package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 1)
    private String title;

    @NotEmpty
    @Size(min = 1, max = 100)
    private String author;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String source;

    @NotEmpty
    private String url;

    @NotNull
    private String date;

    @NotEmpty
    private String language;

    @Valid
    private List<QuoteDTO> quotes;
}
