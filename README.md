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
inseridos no banco de dados da API para aquele endpoint.

Ao acessar a página inicial (`localhost:8080` se estiver executando localmente)
será gerada uma página HTML. Você pode editá-la no diretório
`src/main/resources/templates` e o CSS em `src/main/resources/static/css`.

Para alterar os registros você pode fazer requisições `GET`, `POST`, `PUT` e `DELETE`.

### Detalhamento dos campos

* link
  * authorship: informação de autoria
  * source: nome do site ou instituição
  * url: endereço web (`http://www..."`)
  * date: data no formato `2022-01-31`
  * language: idioma
  * quotes
    * type: `LINE`, `BLOCK` ou `PARAGRAPH`
    * quote: citação em até 1000 caracteres
    * authorship: informação de autoria da citação

* book
  * title: título do livro
  * subtitle: subtítulo
  * authorship: informações de autoria 
  * organizer: organização, para trabalhos coletivos
  * language: idioma
  * url: link para acessar o livro ou informações sobre ele 
  * date: data no formato `2022-01-31`
  * edition: edição 
  * pages: número de páginas
  * volume: volume, para livros em múltiplos volumes
  * isbn: código ISBN (retorna erro para ISBN inválido)
  * location: país e/ou cidade da publicação 
  * quotes
    * type: `LINE`, `BLOCK` ou `PARAGRAPH`
    * quote: citação em até 1000 caracteres
    * page: página da citação
    * authorship: informação de autoria da citação

Os tipos `LINE`, `BLOCK` e `PARAGRAPH` não alteram o limite de caracteres
para as citações, servindo apenas como referência. `LINE` para citações curtas
de apenas uma linha de texto, `BLOCK` para blocos maiores e `PARAGRAPH` para
parágrafos inteiros até o limite de 1000 caracteres.

### Notação JSON
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
  "subtitle": "Reflexões sobre concepções, perspectivas e tendências",
  "authorship": "Maria Graça Simões e Gercina Ângela de Lima",
  "organizer": "Benildes Coura Moreira dos Santos Maculan e Célia da Consolação Dias",
  "url": "http://monographs.uc.pt/iuc/catalog/view/121/297/476-1",
  "language": "Portuguese",
  "edition": "1",
  "location": "Coimbra, Portugal",
  "date": "2020-10-01",
  "isbn": "9789892619439",
  "pages": "302",
  "quotes": [
    {
      "type": "BLOCK",
      "quote": "a precariedade das regras compromete a qualidade das informações documentárias e a sua recuperação, sem que se possa estabelecer parâmetros confiáveis de avaliação. Pode-se, nessas circunstâncias, avaliar apenas a pobreza ou riqueza da recuperação, mas não o porquê ou o grau dos resultados atingidos"
    },
    {
      "type": "LINE",
      "quote": "o conhecimento reside na mente das pessoas e como tal a priori nem pode ser gerido nem pode ser organizado",
      "page": "276",
      "authorship": "Maria Cristina Vieira de Freita, Olívia Pestana, Maria Aparecida Moura"
    }
  ]
}
```