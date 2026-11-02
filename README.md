# projeto-01-sistema-restaurante
Sistema de gerenciamento de restaurante desenvolvido em Java como projeto da formação #ElasTech.

# 🍔 Projeto 01 – Sistema de Restaurante

## 📌 Sobre o projeto

Sistema de gerenciamento de restaurante desenvolvido em **Java**, como parte da formação **#ElasTech – SoulCode Academy + PagBank | Java + Inteligência Artificial**.

O projeto tem como objetivo aplicar conceitos de Programação Orientada a Objetos (POO), Collections, tratamento de exceções, testes unitários e padrões de projeto (*Design Patterns*).

A aplicação funciona por meio de um menu interativo no console, permitindo registrar e gerenciar pedidos, personalizar lanches e consultar os resultados do restaurante.

## 🚀 Funcionalidades

- Cadastro de pedidos com identificação do cliente e numeração automática.
- Seleção de lanches a partir de um cardápio.
- Inclusão de vários lanches em um mesmo pedido.
- Personalização dos lanches com retirada de ingredientes.
- Inclusão de adicionais, como cheddar e bacon extra.
- Remoção de itens individuais de um pedido.
- Cancelamento de pedidos.
- Listagem dos pedidos registrados.
- Cálculo do valor total de cada pedido e do total do dia.
- Identificação de combinações únicas de lanches a partir de suas descrições.
- Tratamento de entradas inválidas.
- Encerramento do restaurante com apresentação do resumo do dia.

## 🛠️ Tecnologias e ferramentas

- **Java:** linguagem utilizada no desenvolvimento.
- **Maven:** gerenciamento do projeto e das dependências.
- **JUnit 5:** execução de testes unitários.
- **IntelliJ IDEA:** ambiente de desenvolvimento.
- **Git e GitHub:** versionamento e hospedagem do código-fonte.

## 🧩 Padrões de projeto utilizados

### Factory

O padrão Factory foi aplicado por meio da classe `LancheFactory`, responsável pela criação dos diferentes tipos de lanches.

Essa abordagem centraliza a criação dos objetos e evita espalhar a lógica de instanciação pela aplicação.

### Facade

A classe `RestauranteFacade` atua como ponto central de acesso às funcionalidades do restaurante, intermediando as operações entre o menu e as classes responsáveis pelas regras do sistema.

O objetivo é simplificar a interação entre os componentes e reduzir o acoplamento.

### Decorator

O padrão Decorator permite acrescentar funcionalidades aos lanches sem modificar diretamente suas classes originais.

Foram implementados os adicionais:

- `ComCheddar`
- `ComBaconExtra`

Os adicionais podem ser combinados, modificando a descrição e o preço final do lanche.

## 📚 Collections utilizadas

**ArrayList:** armazenamento dos itens de cada pedido, permitindo adicionar, percorrer e remover lanches.

**HashMap:** gerenciamento dos pedidos, utilizando o número de cada pedido como chave.

**HashSet:** identificação de descrições únicas de lanches, evitando duplicidades no relatório de fechamento quando as descrições são idênticas.

## 📁 Organização do código

O projeto está organizado nos seguintes packages:

### `org.example.app`

- `Main`: execução da aplicação e controle do fluxo principal.
- `MenuConsole`: interação com o usuário pelo terminal.
- `RestauranteFacade`: interface simplificada para as operações do restaurante.

### `org.example.cardapio`

- `ItemCardapio`: interface dos itens do cardápio.
- `Lanche`: representação dos lanches e seus ingredientes.
- `LancheFactory`: criação dos tipos de lanches.
- `ComCheddar`: adicional implementado com Decorator.
- `ComBaconExtra`: adicional implementado com Decorator.

### `org.example.pedido`

- `Pedido`: representação de um pedido e seus itens.
- `GerenciadorPedidos`: armazenamento, consulta e gerenciamento dos pedidos.

## ▶️ Como executar

1. Clone o repositório do GitHub.
2. Abra o projeto no IntelliJ IDEA.
3. Aguarde o carregamento das dependências do Maven.
4. Execute a classe `Main`, localizada no package `org.example.app`.
5. Utilize as opções do menu para interagir com o sistema.

## 🧪 Testes unitários

Foram implementados testes com **JUnit 5**, na classe `LancheTest`.

Os testes verificam:

- O cálculo do preço de um lanche com cheddar.
- O cálculo do preço com cheddar e bacon extra.
- A atualização da descrição ao adicionar ingredientes extras.
- A retirada de queijo sem alteração do preço original.

Os quatro testes foram executados com sucesso durante o desenvolvimento.

## 🎥 Vídeo de apresentação

O vídeo demonstra as principais funcionalidades do Sistema de Restaurante e apresenta os conceitos de Java, Collections e padrões de projeto utilizados no desenvolvimento.

**▶️ [Assistir ao vídeo de apresentação no Google Drive](https://drive.google.com/file/d/1dXGsUZ9ktHnXJgcfW7w-z_o3K0mxAG8T/view?usp=drive_link)**

**Duração:** 4min45s.

## 💡 Possibilidade de melhoria

Uma oportunidade de evolução está na identificação das combinações únicas de lanches.

Atualmente, o `HashSet` utiliza as descrições textuais para identificar duplicidades. Por isso, combinações com os mesmos adicionais inseridos em ordens diferentes podem ser consideradas distintas.

Uma melhoria futura seria padronizar a representação dos adicionais, permitindo reconhecer combinações equivalentes independentemente da ordem de inclusão.

## 🎓 Contexto acadêmico

Projeto desenvolvido como atividade prática da formação **#ElasTech – SoulCode Academy + PagBank**, com foco na aplicação dos conhecimentos adquiridos nas aulas de Java.

O desenvolvimento permitiu exercitar a organização do código, a separação de responsabilidades entre classes e a aplicação prática de padrões de projeto.

## 👩‍💻 Autoria

**Rosaline Helenna de Souza**

Formação #ElasTech | SoulCode Academy + PagBank – Java + IA.
