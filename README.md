# Submissão do desafio Desenvolvedor BackEnd Attornatus

## Como rodar o projeto:

### Aqui já vai uma ressalva, se você utiliza IDEs como o IntelliJ, quase todo o processo abaixo já é feito automaticamente.

1. Primeiro de tudo, clone esse repositório;
2. Entre na pasta raiz do projeto pelo terminal;
3. Digite o comando abaixo para instalar as dependências do maven.
   ```
   mvn install
   ```
4. Após o processo terminar, rode a aplicação;
5. Assim que o servidor subir, a aplicação pode ser acessada no endereço "localhost:8080"
6. Caso queira visualizar os dados no banco, a url de acesso do banco é "localhost:8080/h2", os dados de login do
   banco estão no arquivo application.properties
7. Para fins de teste e melhor visualização do fluxo das rotas, deixei um script que eu fiz no insomnia para analisar as
   responses da aplicação. O script pode ser importado no seu insomnia e ele se encontra na pasta main deste projeto.
