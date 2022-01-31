# refs-api

API para gerenciar referências de pesquisa feita com
Spring Boot e arquitetura REST.

Este projeto foi desenvolvido como parte do Bootcamp
Amdocs JAVA Developer da [DIO](https://www.dio.me/).

## Especificação

Atualmente há dois _endpoints_ implementados:
* `/api/v1/link/` para referências em forma de ligações da web
* `/api/v1/book/` para referências em livros

Ao acessar um endpoint diretamente você irá obter um _array_ contendo todos os dados
inseridos no banco de dados da API.

Para alterar os registros você pode fazer requisições `GET`, `POST`, `PUT` e `DELETE`.

### Estrutura de dados
#### Link
```json
{
"title": "",
  "author": "",
  "source": "",
  "url": "",
  "date": "YYYY-MM-DD",
  "language": "",
  "quotes": [
    {
      "type": "LINE",
      "quote": ""
    },
    {
      "type": "BLOCK",
      "quote": ""
    },
    {
      "type": "PARAGRAPH",
      "quote": ""
    }
  ]
}
```

#### Livro
```json
{
    "title": "",
    "author": "",
    "language": "",
    "url": "",
    "date": "YYYY-MM-DD",
    "edition": "",
    "volume": "",
    "isbn": "",
    "location": "",
    "quotes": [
        {
            "type": "LINE",
            "quote": ""
        },
        {
            "type": "BLOCK",
            "quote": ""
        },
        {
            "type": "PARAGRAPH",
            "quote": ""
        }
    ]
}
```

### Exemplos
#### Link sem citações
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

#### Link com citações
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

#### Livro com citações
```json
{
    "title": "Do Tratamento à Organização da Informação",
    "author": "Maria Graça Simões e Gercina Ângela de Lima",
    "language": "Portuguese",
    "url": "http://monographs.uc.pt/iuc/catalog/view/121/297/476-1",
    "date": "2020-10-01",
    "edition": "1",
    "location": "Coimbra, Portugal",
    "isbn": "9789892619439",
    "quotes": [
        {
            "type": "BLOCK",
            "quote": "a precariedade das regras compromete a qualidade das informações documentárias e a sua recuperação, sem que se possa estabelecer parâmetros confiáveis de avaliação. Pode-se, nessas circunstâncias, avaliar apenas a pobreza ou riqueza da recuperação, mas não o porquê ou o grau dos resultados atingidos"
        },
        {
            "type": "LINE",
            "quote": "o conhecimento reside na mente das pessoas e como tal a priori nem pode ser gerido nem pode ser organizado"
        }
    ]
}
```