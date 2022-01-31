# refs-api

API para gerenciar referências de pesquisa feita com
o Spring Framework e seguindo uma arquitetura REST.

Este projeto foi desenvolvido como parte do Bootcamp
Amdocs JAVA Developer da [DIO](https://www.dio.me/).

Há uma versão em nuvem no
[Heroku](http://refs-api.herokuapp.com) mas ela costuma estar 
desabilitada por padrão. Você pode entrar em contato se desejar
utilizá-la.

## Domínio

Uma API que cataloga referências de pesquisa em diferentes formatos
e as disponibiliza em notação JSON em um acesso público na página
inicial. É capaz de servir páginas HTML e de receber, retornar,
atualizar e apagar entradas via requisições HTTP.

## Especificação

Atualmente há dois _endpoints_ implementados:

* `/api/v1/link/` para referências em forma de páginas web
* `/api/v1/book/` para referências em livros

Ao acessar um endpoint diretamente você irá obter um _array_ contendo
todos os dados inseridos no banco de dados da API para aquela entidade.

Ao acessar a página inicial (`localhost:8080` se estiver executando
localmente) será gerada uma página HTML. Você pode editá-la no diretório
`src/main/resources/templates` e o CSS em `src/main/resources/static/css`.

Para alterar os registros você pode fazer requisições `GET`, `POST`,
`PUT` e `DELETE` usando o
[Postman](https://www.postman.com/) ou sua própria aplicação.

### Entidades e campos

* **link**
    * **title** - título (obrigatório)
    * **authors** - autoria com um ou mais nomes
    * **source** - nome do site ou instituição (obrigatório)
    * **url** - endereço web (`https://www..."`) (obrigatório)
    * **date** - data no formato `2022-12-31`
    * **language** - idioma (obrigatório)
    * **quotes**
      * **type** - `LINE`, `BLOCK` ou `PARAGRAPH`
      * **quote** - citação em até 1000 caracteres
      * **authors** - autoria da citação
      * **page** - página da citação

* book
  * **title** - título do livro (obrigatório)
  * **subtitle** - subtítulo
  * **authors** - autoria com um ou mais nomes (obrigatório)
  * **organizers** - organização, para trabalhos coletivos
  * **url** - link para acessar o livro ou informações sobre ele 
  * **language** - idioma (obrigatório)
  * **volume** - volume, para livros em múltiplos volumes
  * **edition** - edição
  * **location** - país e/ou cidade da publicação
  * **date** - data no formato `2022-12-31`
  * **isbn** - código ISBN (retorna erro para ISBN inválido)
  * **pages** - número de páginas
  * **quotes**
    * **type** - `LINE`, `BLOCK` ou `PARAGRAPH`
    * **quote** - citação em até 1000 caracteres
    * **page** - página da citação
    * **authors** - autoria da citação

Os tipos `LINE`, `BLOCK` e `PARAGRAPH` não alteram o limite de caracteres
para as citações, servindo apenas como referência do tamanho: `LINE` para
citações curtas de apenas uma linha de texto, `BLOCK` para blocos maiores
e `PARAGRAPH` para parágrafos inteiros até o limite de 1000 caracteres.

### Notação JSON
#### Link
```json
{
"title": "",
  "authors": "",
  "source": "",
  "url": "",
  "date": "YYYY-MM-DD",
  "language": "",
  "quotes": [
    {
      "type": "",
      "quote": "",
      "authors": "",
      "page": ""
    }
  ]
}
```

#### Livro
```json
{
  "title": "",
  "subtitle": "",
  "authors": "",
  "organizers": "",
  "url": "",
  "language": "",
  "volume": "",
  "edition": "",
  "location": "",
  "date": "YYYY-MM-DD",
  "isbn": "",
  "pages": "",
  "quotes": [
    {
      "type": "",
      "quote": "",
      "page": "",
      "authors": ""
    }
  ]
}
```

### Exemplos
#### Link sem citações
```json
{
  "title": "Conheça 10 artistas trans cearenses e seus trabalhos autorais",
  "authors": "Roberta Souza",
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
  "authors": "Alejandro Ugarte",
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
  "authors": "Maria Graça Simões, Gercina Ângela de Lima",
  "organizers": "Benildes Coura Moreira dos Santos Maculan, Célia da Consolação Dias",
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
      "quote": "a precariedade das regras compromete a qualidade das informações documentárias e a sua recuperação, sem que se possa estabelecer parâmetros confiáveis de avaliação. Pode-se, nessas circunstâncias, avaliar apenas a pobreza ou riqueza da recuperação, mas não o porquê ou o grau dos resultados atingidos",
      "page": "155",
      "authors": "Cristina Dotta Ortega, Mariângela Spotti Lopes Fujita, Maria da Graça Simões"
    },
    {
      "type": "LINE",
      "quote": "o conhecimento reside na mente das pessoas e como tal a priori nem pode ser gerido nem pode ser organizado",
      "page": "276",
      "authors": "Maria Cristina Vieira de Freita, Olívia Pestana, Maria Aparecida Moura"
    }
  ]
}
```