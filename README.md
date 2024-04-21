# Projeto backend criação de um webservice para consumo de API em Java

## ROTAS API JAVA:

- `@DeleteMapping("/deletar/{id}")`
- `@PostMapping("/inserirProduto")`
- `@GetMapping("/listaporprodutos/{id}")`
- `@GetMapping("/listatodos")`

## ROTAS API EXTERNA EM DELPHI

- `/listarprodutos`
- `/listartodos`
- `/inserirproduto`
- `/deleteproduto`

## BANCO DE DADOS EM SQL SERVER:
- Nome do banco: `api_backend`
- Nome da tabela: `Produtos`

## REPOSITÓRIO CONTÉM:

- Pasta projeto API Delphi
- Executável da API Delphi
- Pasta projeto API Java

## PARA ABRI O PROJETO DELHI CASO O EXECUTAVEL NÃO RODE POR CAUSA DO BANCO:
- Necessário ter o Delphi instalado na maquina versão 10 ++
- colocar dentro do caminho : C:\Users\seu usuario\Documents\Embarcadero\Studio\Projects
- ABRIR O PROJETO : C:\Users\seu usuario\Documents\Embarcadero\Studio\Projects\API\API-Pesquisa\Projeto   abrir APIDelphi.dproj e alterar a configuração do componente de banco Conn dentro da do form Base.
