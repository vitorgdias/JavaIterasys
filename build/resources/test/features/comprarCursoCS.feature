Feature: Comprar Curso CS
  Scenario: Pesquisar Curso e Incluir no Carrinho
    Given que acesso o site da Iterasys
    When clico em cursos
    And pesquiso por "Python"
    Then visualizo a lista de resultados para "Python"
    When clico em matricule-se
    Then confirmo o nome como "Python" e o preco de "R$ 27,90"