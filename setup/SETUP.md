# DOWNLOAD IntelliJ IDEA
link: https://www.jetbrains.com/idea/download/
Selecione seu OS e baixe a versão da comunidade do IntelliJ IDEA

![description](setup/img/01.png)

Nas opções de instalação não é necessário marcar nenhum desses checkboxes se você não quiser e termine a instalação.

![description](setup/img/02.png)

Quando o IntelliJ IDEA iniciar, primeiro o programa vai pedir para você selecionar algumas preferencias de temas de UI e para desabilitar ou instalar plugins, você pode pular tudo até aparecer a tela de abrir um projeto

![description](setup/img/03.png)

Depois que você clonou este repositório, no IntelliJ clique na opção Abrir e selecione o arquivo pom.xml dentro do repositório clonado.

![description](setup/img/04.png)

Selecionado o arquivo clique em OK e abrirá uma nova janela, nessa janela clique em Abrir como Projeto.

![description](setup/img/05.png)

A tela principal do IntelliJ irá abrir e alguns processos e notificações vão aparecer. Agora a primeira coisa que precisamos fazer é checar o resto das configurações:
1º - Entre na aba File -> Settings (Ctrl + Alt + S)
Dentro da janela de Settings entre na aba Build, Execution, Deployment -> Compiler -> Java Compiler. Mude a versão do bytecode do projeto para 11 (Java 11) e clique em Apply.

![description](setup/img/06.png)

Na mesma janela de Settings entre na aba Build, Execution, Deployment -> Compiler -> Annotation Processors. Marque o checkbox "Enable annotation processing", assim o IntelliJ conseguirá processar as anotações que usaremos com Spring e Lombok, etc. Clique em Apply.

![description](setup/img/07.png)

Ultima etapa na janela de Settings é ir na aba Plugins. Clique em Marketplace para procurar plugins para baixar, o que queremos é o plugin do Lombok. Na barra de busca digite Lombok e instale o plugin. Reinicie o IntelliJ se for requisitado.

![description](setup/img/08.png)

2º - Entre na aba File -> Project Structure (Ctrl + Alt + Shift + S)
Dentro da janela de Project Structure na primeira tela Project você pode baixar a SDK do Java 11

![description](setup/img/09.png)

![description](setup/img/10.png)

Selecione o Project language level 11, clique em apply e o IntelliJ irá baixar e indexar seu projeto com a sdk baixada.

![description](setup/img/11.png)

Na mesma janela na aba SDKs verifique se está selecionada a opção da nova SDK instalada.

![description](setup/img/12.png)

Clique em apply e em OK para fechar a janela.

Na tela principal da IDE na raíz do projeto entre no arquivo pom.xml
No canto direito da tela entre na aba do Maven

![description](setup/img/13.png)

Clique no botão para recarregar o projeto maven, o maven então vai baixar todas as dependencias definidas no arquivo pom.xml para sua máquina (Essa etapa pode demorar bastante)

![description](setup/img/14.png)

![description](setup/img/15.png)

Quando finalizar essa etapa com sucesso aparecerá um check verde ao lado do Sync

![description](setup/img/16.png)

Depois que recarregado entre na aba do projeto nemo -> Lifecycle e selecione ambas opções clean e install (comandos maven), clique no botão do raio azul para pular os testes e por fim clique no botão de run para o maven rodar os comandos.

![description](setup/img/17.png)

Caso sucesso, aparecerá nos logs como BUILD SUCCESS

![description](setup/img/18.png)

Finalmente, para rodar o projeto entre em src -> main -> java -> br.gov.sp.fatec.nemo -> NemoApplication, clique com o botão direito no arquivo e clique em Run 'NemoApplication.main()'

![description](setup/img/19.png)


-- NO MOMENTO DA CRIAÇÃO DESSE SETUP O PROJETO NÃO IRÁ RODAR AINDA --
