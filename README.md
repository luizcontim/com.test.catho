# com.test.catho

Este arquivo visa documentar o Teste para a Vaga de QA da Catho, no qual foi realizada a automação de testes de um formulário básico do site W3Schools.

## Tecnologias utilizadas

O teste foi realizado em linguagem Java no IDE de desenvolvimento Eclipse. Foram utilizadas as tecnologias JUnit e Selenium WebDrive. É necessário ter o navegador Firefox instalado na sua máquina.

## Como executar os testes

Para executar os testes, seguir as etapas abaixo:

1. Baixar o projeto "com.test.catho" do GitHub e importa-lo no Eclipe. As bibliotecas do Selenium, necessárias para executar os testes, já estão incluídas no projeto.

2. Baixar o driver do Firefox geckodriver no seu computador:

- Acessar https://github.com/mozilla/geckodriver/releases
- Fazer o download do geckodriver e extrair o arquivo geckodriver.exe
- Na arquivo "TesteFormulario", linha 30, substituir o PATH pelo PATH do geckodriver.exe no seu computador

3. No Eclipse, clicar com o botão direito do mouse sobre o projeto "com.test.catho" e selecionar "Run As > JUnit Test".

4. Aguardar a execução dos testes e verificar os resultados.

## Cenários de teste implementados

1. Formulário preenchido com sucesso
2. Nome em branco
3. Email em branco
4. Formato de email inválido
5. Website inválido
6. Gênero em branco
