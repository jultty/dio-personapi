package one.digitalinnovation.refsapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuoteType {

    LINE("Line"),
    BLOCK("Block"),
    PARAGRAPH("Paragraph");

    private final String description;
}
