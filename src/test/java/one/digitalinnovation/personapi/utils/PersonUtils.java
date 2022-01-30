package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.LinkDTO;
import one.digitalinnovation.personapi.entities.Link;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String AUTHOR = "Alejandro Ugarte";
    private static final String SOURCE = "Baeldung";
    private static final String URL = "https://www.baeldung.com/java-bean-validation-not-null-empty-blank";
    private static final long ID = 1L;
    public static final LocalDate DATE = LocalDate.of(2022, 1, 23);
    private static final String LANGUAGE = "English";

    public static LinkDTO createFakeDTO() {
        return LinkDTO.builder()
                .author(AUTHOR)
                .source(SOURCE)
                .url(URL)
                .date("2022-01-23")
                .language("English")
                .quotes(Collections.singletonList(QuoteUtils.createFakeDTO()))
                .build();
    }

    public static Link createFakeEntity() {
        return Link.builder()
                .id(ID)
                .author(AUTHOR)
                .source(SOURCE)
                .url(URL)
                .date(DATE)
                .language(LANGUAGE)
                .quotes(Collections.singletonList(QuoteUtils.createFakeEntity()))
                .build();
    }




}
