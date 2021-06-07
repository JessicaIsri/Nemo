<div align="center">
      <img src="/uploads/d3295be8d95140beb572615b52a02a87/Nemo_API__1_.png" width="300" height="300">
</div>
<hr>
<div align="center">
      <h2>Menu</h2>
      <p>
            :small_orange_diamond:<a href="#introducao">Introdução</a>
            :small_orange_diamond:<a href="#comousar">Como usar</a>
            :small_orange_diamond:<a href="#arquitetura">Arquitetura</a>
            :small_orange_diamond:<a href="#backlog">Backlog</a>
            :small_orange_diamond:<a href="#bd">Banco de Dados</a>
            :small_orange_diamond:<a href="#equipe">Equipe</a>
      </p>
</div>

<a name="introducao"></a>
## Introdução

Organizado pela Fatec de São José dos Campos em conjunto com as melhores empresas da região do Vale do Paraíba, o API é uma iniciativa que envolve os alunos da fatec em projetos reais. 

Para cada semestre do curso de Banco de Dados é selecionado uma empresa que apresenta um problema para ser desenvolvido pelos alunos, e para a turma do 4º semestre de Banco de Dados foi apresentado o seguinte problema: Desenvolver uma aplicação que resolva o problema de "match" entre candidatos e vagas, onde se possa alcançar, de maneira escalável e ágil a contratação dos melhores candidatos para as vagas apresentadas, através de uma gestão simples e eficiente.

### :dart: 1.1. Visão do Projeto

O projeto Nemo visa ser uma solução simples, versátil, escalável e open source para pessoas e empresas que precisam de um sistema escalável, simples e versátil para fazer a gestão dos currículos de candidatos relacionando eles às vagas disponíveis pela empresa.

### :camera: 1.2. Apresentação da Evolução do Projeto
:heavy_check_mark: Sprint 1  | :heavy_check_mark: Sprint 2 | :heavy_check_mark: Sprint 3 | Sprint 4 :information_source:  
--------- |--------- |--------- |--------- |
[Entrega](https://gitlab.com/felipemessibraga/pi-1sem-2021/-/wikis/4-Entrega-Sprint-1) |[Entrega](https://gitlab.com/felipemessibraga/pi-1sem-2021/-/wikis/6-Entrega-Sprint-2) |[Entrega](https://gitlab.com/felipemessibraga/pi-1sem-2021/-/wikis/8-Entrega-Sprint-3) |[Entrega](https://gitlab.com/felipemessibraga/pi-1sem-2021/-/wikis/9.1-Entrega-Sprint-4-(Final)) |


### :clipboard: 1.3. Planejamento

Para fazer o planejamento foi utilizado a metodologia de "Design Thinking". Segundo o wikipedia, Design Thinking é o conjunto de ideias e insights para abordar problemas, relacionados a futuras aquisições de informações, análise de conhecimento e propostas de soluções.

:arrows_counterclockwise:O design thinking consiste em 5 partes ciclicas: empatia, definição, ideação, prototipo, teste.

- A primeira etapa (empatia) do primeiro ciclo foi realizada junto ao cliente.
- A etapa de definição é realizada durante as plannings do projeto.
- A etapa de ideação e prototipo são realizadas durante a sprint e 
- A etapa de teste é realizada sempre que um prototipo vira funcionalidade através do fluxo de CI (continuous integration) e CD (continuous deploy/delivery) do projeto.


### :calendar: 1.4. Cronograma

- [x] 28/02/2021 até 06/03/2021 - Kick Off do Projeto
- [x] 08/03/2021 até 28/03/2021 - Sprint 1
- [x] 29/03/2021 até 18/04/2021 - Sprint 2
- [x] 26/04/2021 até 16/05/2021 - Sprint 3
- [x] 17/05/2021 até 05/06/2021 - Sprint 4
- [ ] 07/06/2021 até 11/06/2021 - Sprint Apresentação Final
- [ ] 14/06/2021 até 18/06/2021 - Sprint Feira de Soluções


### :hammer: 1.5. Tecnologias Utilizadas

<div align="center">
      <img src="/uploads/130e4d8da8a8daa4d9876b41e2568552/Design_sem_nome.png">
</div>

### :bulb: 1.6. Wiki do Projeto
Nesta [Wiki](https://gitlab.com/felipemessibraga/pi-1sem-2021/-/wikis/home) você irá encontrar todo o passo a passo de desenvolvimento do projeto, várias informações úteis, bem como o SETUP do Projeto e a documentação de todas as reuniões de planejamento.

Destacamos em negrito os principais requisitos de cada sprint.

<a name="comousar"></a>
## 2. Como usar

### 2.1 No seu ambiente

- 2.1.1 - Para que você possa utilizar o projeto, primeiro é legal dar uma olhada no [SETUP](https://gitlab.com/felipemessibraga/pi-1sem-2021/-/wikis/2-Setup-do-Projeto), lá você conseguirá configurar o ambiente para executar a aplicação. 

- 2.1.2 - Após configurar o ambiente, será necessário também ter o _**docker**_ e o _**docker compose**_ na sua máquina.

- 2.1.3 - Abra a pasta do projeto e navegue para a pasta "docker" que fica em: "./nemo/main/docker" e execute o seguinte comando:<br>
`docker-compose -d -f postgresql.yml up`<br>
Este comando irá inicializar o banco de dados na sua máquina.

- 2.1.4 - Execute o programa no IntelliJ

- 2.1.5 - Agora acesse através do POSTMAN ou do INSOMNIA a rota: "localhost:8081/nemo/v1/authentication" para se autenticar,

- 2.1.6 - Copie o token e agora insira ele no header da requisição para fazer requisições para as outras rotas da aplicação. (Para saber sobre as outras rotas, você pode acessar a nossa [documentação](). )

### 2.1 Na cloud do projeto

- Momentaneamente desativado


<a name="arquitetura"></a>
## 3. Arquitetura do Projeto

### 3.1. Arquitetura do MVP:

![MVP_Architecture](/uploads/da23ece3ab6a514cc11ec02a9a0adea7/MVP_Architecture.png)

----------------------------------------------------------------------------------------------

### 3.2. Design da aplicação:

![MVP_System_Design](/uploads/6cbd2856fb40b82e08d19ecca5133ab5/MVP_System_Design.png)

<a name="backlog"></a>
## 4. Backlog

### 4.1. Requisitos Funcionais (Story Cards)

Na descrição dos story cards, entende-se como usuário o recrutador ou responsável por analisar os currículos e como candidato a pessoa que deseja se candidatar à uma vaga.

#### :white_check_mark: 4.1.1 Sprint 1
<strong>RF_01</strong> - O usuário poderá realizar as pesquisas simples ou compostas com os seguintes parâmetros de buscas: genero, pais, cidade, código postal e/ou habilidades;<br>

#### :white_check_mark: 4.1.2 Sprint 2
<strong>RF_02- O usuário poderá realizar as pesquisas simples ou compostas com utilizando como parâmetro todos os campos dos currículos;</strong> 

<strong>RF_03 - O usuário poderá realizar pesquisa dos candidatos para determinada vaga e receber como resposta os currículos de maneira ordenada, com os que tem mais afinidade com a vaga sendo retornados nas primeiras posições;</strong>

<strong>RF_04</strong> - O usuário poderá cadastrar uma vaga;

<strong>RF_05</strong> - O usuário poderá consultar todas as vagas cadastradas;

<strong>RF_06</strong> - O usuário poderá cadastrar um currículo.

####  :white_check_mark: 4.1.3 Sprint 3
<strong>RF_07 - O usuário poderá escolher os parâmetros de ranqueamento de currículo e de vagas de acordo com sua necessidade, podendo utilizar uma regra padrão ou definindo sua própria regra;</strong>

<strong>RF_08 - O usuário poderá registrar e consultar a jornada do candidato na aplicação à uma vaga;</strong>

#### :white_check_mark: 4.1.4 Sprint 4
<strong>RF_10 - O usuário poderá exportar os dados dos candidatos à uma vaga;</strong>

<strong>RF_11 - O usuário poderá fazer pesquisa por dados complexos de localização;</strong>

<strong>RF_09</strong> - O usuário será capaz de consultar à que vagas um candidato se aplicou;


### :arrow_forward: 4.2. Requisitos não Funcionais

- Documentação completa e clara
- Relatórios de desempenho
- Segurança
- Escalabilidade
- Performance
- Testes

<a name="bd"></a>
## :floppy_disk: 5. Diagrama do Banco de Dados

<img src="/uploads/d4f43a9bca078511acc3a0f18e82192c/WhatsApp_Image_2021-04-18_at_23.14.01.jpeg" alt="diagrama do banco de dados"/>

<a name="equipe"></a>
## 6. Equipe

| André Lars | Daniel Delgado | Felipe Braga | Giovanni Guidace | Jéssica Isri  |
|---|---|---|---|---|
| [linkedIn](https://www.linkedin.com/in/andre-lars-da-cunha/) | [linkedIn](https://www.linkedin.com/in/daniel-delgado-274096194/) | [linkedIn](https://www.linkedin.com/in/felipegbraga/) |  [linkedIn](https://www.linkedin.com/in/giovanni-guidace-61982812a/) | [linkedIn](https://www.linkedin.com/in/jessica-dias1/) |
| <img src="/uploads/6e46b1dc126eb671d33186f9d9c7fa09/WhatsApp_Image_2021-05-16_at_20.31.30.jpeg" width="100px"> | <img src="/uploads/2d4aea38bb9a385745b3e41d4215a10a/Design_sem_nome.jpg" width="100px"> | <img src="/uploads/ee6db8a1a1670e1dc9053729b7b9609a/Design_sem_nome.jpg" width="100px"> | <img src="/uploads/1cdb3a51a8986e89a8062bdc58ecd5c7/WhatsApp_Image_2021-05-16_at_20.58.08.jpeg" width="100px"> | <img src="/uploads/29f076952b263b95660b2fb532f5e5ef/WhatsApp_Image_2021-05-16_at_20.33.44.jpeg" width="100px"> |


