<h3>Acesso ao banco em memória H2</h3>

http://localhost:8080/h2-console/

<h3>Acesso à documentação da API</h3>

http://localhost:8080/swagger-ui.html

<h4> Autenticação: </h4>

Foi utilizada autenticação do tipo OAuth2.

 * Para fazer um requisição no postman com autentição, é preciso ir na aba Authorization.
 * Escolher o Type OAuth 2.0 e clicar em Get New Access Token.
 * Depois é só utilizar as configurações abaixo para gerar o token

<h4>Postman Configurações: </h4>

* Type OAuth 2.0

* Grant Type: Password Credentials

* Access Token URL: http://localhost:8080/oauth/token

* Username: admin
* Password: admin

* Client ID: locadora
* Client Secret: locadora
* Scope: password

- Client Authentication: Send as Basic Auth header


Após preencher todos os campos acima, clique em Request Token e copie o token gerado no campo Acces Token.

Feche a Janela e cole o token no campo Access Token do postman, após isso clique em send para efetuar a requisição.

* Caso já exista algum outro usuário já criado no banco, você pode alterar os campos Username e Password para as
  credencias deste outro usuário, caso não exista siga o passo a passo padrão, caso desejado você poderá criar um outro usuário.

<h4> Banco de dados: </h4>

* Banco de dados utilizado foi o H2, para facilitar o processo de desenvolvimento e os testes.
* Dentro da pasta resource no projeto, existe um arquivo chamado import.sql, no qual está sendo inserido alguns filmes
  para facilitar os testes.