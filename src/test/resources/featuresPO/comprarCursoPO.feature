Feature: Comprar Curso PO
  Scenario: Pesquisar Curso e Incluir no Carrinho PO
    Given que acesso o site da Iterasys PO
    When clico em cursos PO
    And pesquiso por "Python" PO
    Then visualizo a lista de resultados para "Python" PO
    When clico em matricule-se PO
    Then confirmo o nome como "Python" e o preco de "R$ 27,90" PO