# refs-api

API para gerenciar referências de pesquisa feita com
Spring Boot e arquitetura REST.

Este projeto foi desenvolvido como parte do Bootcamp
Amdocs JAVA Developer da [DIO](https://www.dio.me/).

## Especificação

Atualmente há apenas um _endpoint_ implementado, em `/api/v1/link/`.
Ao acessá-lo você irá obter um _array_ contendo todos os dados
inseridos no banco de dados da API.

Você pode fazer requisições `GET`, `POST`, `PUT` e `DELETE` usando a seguinte estrutura:

```json
{
    "title": "Conheça 10 artistas trans cearenses e seus trabalhos autorais",
    "author": "Roberta Souza",
    "source": "Diário do Nordeste",
    "url": "https://diariodonordeste.verdesmares.com.br/verso/conheca-10-artistas-trans-cearenses-e-seus-trabalhos-autorais-1.3179795",
    "date": "2022-01-17",
    "language": "Portuguese"
}
```

Você também pode inserir citações que ficarão vinculadas à entrada:

```json
{
    "title": "Difference Between @NotNull, @NotEmpty, and @NotBlank Constraints in Bean Validation",
    "author": "Alejandro Ugarte",
    "source": "Baeldung",
    "url": "https://www.baeldung.com/java-bean-validation-not-null-empty-blank",
    "date": "2022-01-23",
    "language": "English",
    "quotes": [
        {
            "type": "LINE",
            "quote": "the @NotNull constraint won't allow null values for the constrained field(s). However, the field(s) can be empty."
        }
    ]
}
```