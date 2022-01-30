package one.digitalinnovation.refsapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.refsapi.enums.QuoteType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuoteDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private QuoteType type;

    private String quote;
}
