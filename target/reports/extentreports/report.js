$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("comprarCursoPO.feature");
formatter.feature({
  "line": 1,
  "name": "Comprar Curso PO",
  "description": "",
  "id": "comprar-curso-po",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2840456800,
  "status": "passed"
});
formatter.scenario({
  "line": 2,
  "name": "Pesquisar Curso e Incluir no Carrinho PO",
  "description": "",
  "id": "comprar-curso-po;pesquisar-curso-e-incluir-no-carrinho-po",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "que acesso o site da Iterasys PO",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "clico em cursos PO",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "pesquiso por \"Python\" PO",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "visualizo a lista de resultados para \"Python\" PO",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "clico em matricule-se PO",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "confirmo o nome como \"Python\" e o preco de \"R$ 27,90\" PO",
  "keyword": "Then "
});
formatter.match({
  "location": "comprarCursoPO.queAcessoOSiteDaIterasysPO()"
});
formatter.result({
  "duration": 157821600,
  "error_message": "java.lang.NullPointerException\r\n\tat stepsPO.comprarCursoPO.queAcessoOSiteDaIterasysPO(comprarCursoPO.java:20)\r\n\tat ✽.Given que acesso o site da Iterasys PO(comprarCursoPO.feature:3)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "comprarCursoPO.clicoEmCursosPO()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Python",
      "offset": 14
    }
  ],
  "location": "comprarCursoPO.pesquisoPorPO(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Python",
      "offset": 38
    }
  ],
  "location": "comprarCursoPO.visualizoAListaDeResultadosParaPO(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "comprarCursoPO.clicoEmMatriculeSePO()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Python",
      "offset": 22
    },
    {
      "val": "R$ 27,90",
      "offset": 44
    }
  ],
  "location": "comprarCursoPO.confirmoONomeComoEOPrecoDePO(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 972525800,
  "status": "passed"
});
});