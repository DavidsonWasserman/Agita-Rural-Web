# Sistema de Gestão de Projetos e Ações

Este repositório contém o código-fonte de um sistema web desenvolvido em **Java com Servlets, JSP e DAO**, seguindo o padrão **MVC**.
O projeto foi construído como entrega acadêmica, atendendo aos requisitos de separação de camadas, simulação de dados e disponibilização pública.

## Membros do Grupo

* **Davidson Freire Magalhães Wasserman** — 20240028451
* **Nicolas Duarte** — 20240018455 
* **Victor Hugo Tomaz Oliveira** — 20240028578

## Arquitetura do Projeto

O sistema utiliza:

* **Model** → classes Java representando Projetos, Ações, Unidades, Representantes, etc.
* **Controller** → **Servlets** responsáveis pelo fluxo de requisições e respostas.
* **View** → páginas **JSP**, incluindo componentes reutilizáveis.
* **DAO** → simulação de armazenamento dos dados da aplicação.

Estrutura baseada no padrão **MVC (Model-View-Controller)**.

**Credenciais de acesso (admin):**

* **Login:** admin@email.com
* **Senha:** senha123

## Funcionalidades — Visão Pública

## Home

* Exibe os **projetos cadastrados** de destaque.
* Mostra os **conjuntos de ações** de destaque.

## Ações

* Listagem completa de todas as ações registradas.

## Projetos

* Listagem completa de todos os projetos registrados.

## Ver Detalhes

* Tela dedicada com todas as informações de um **projeto** ou **ação** selecionados.

## Funcionalidades — Visão Administrativa

### Login

Autenticação de administradores.

## Painel de Controle

Permite:

* Deslogar
* **Criar uma ação**
* **Criar um projeto**
* Visualizar **ações criadas** pelo usuário logado
* Visualizar **projetos criados** pelo usuário logado

## Edição e Encerramento

Dentro das telas de gerenciamento, é possível:

* **Editar** projetos e ações em aberto.
* **Encerrar** para mudar o status do projeto ou ação.

