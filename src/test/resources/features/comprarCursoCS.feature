Feature: Comprar Curso CS
  Scenario: Pesquisar Curso e Incluir no Carrinho
    Given que acesso o site da Iterasys
    When clico em cursos
    And pesquiso por "Python"
    Then visualizo a lista de resultados para "Python"
    When clico em matricule-se
    Then confirmo o nome como "Python" e o preco de "R$ 27,90"

  Scenario Outline: Pesquisar Curso e Incluir no Carrinho
    Given que acesso o site da Iterasys
    When clico em cursos
    And pesquiso por <curso>
    Then visualizo a lista de resultados para <curso>
    When clico em matricule-se
    Then confirmo o nome como <curso> e o preco de <preco>
    Examples:
      | curso     | preco      |
      | "Python"  | "R$ 27,90" |
      | "ao Java" | "R$ 27,90" |

    Scenario: Ver Detalhes de um curso
      Given que acesso o site da Iterasys
      When clico em cursos
      And clico na imagem do curso
      Then vejo a pagina com detalhes do curso
