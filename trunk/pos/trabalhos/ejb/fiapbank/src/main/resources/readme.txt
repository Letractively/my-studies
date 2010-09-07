Tecnologias usadas

- java 1.6.x
- maven 2.2.1  
- jboss 5.1
- mysql 5.1
- como browser para teste da camada web firefox 3.5 ou superior

Obs:

Albert, conforme combinei com vc, usei o maven para o trabalho  


- Estrutura do trabalho 

	fiapbank - super pom
		- fiababank-contas - modulo de contas
		- fiabank-creditos - modulo de creditos
		- fiabank-dominio - modulo de dominio 
		- fiabank-ear - modulo para empacotamento 
		- fiabank-web - camada web 


- implantando e executando 


 1 - copiar o login-config.xml para o diretorio conf do server criado no jboss

 2 - copiar e  mysql-ds.xml para o diretorio deploy do server criado , ficando a configuracao a ser feita conforme visto em aula 
 
 3 - copiar o drive do mysql para o diretorio lib do server criado no jboss
 
 4 - criar o banco conforme configurado ... 

 5 - subir o server 

 6 - entrar no diretorio fiabank-ear e editar o pom.xml fazendo a seguinte alteracao:
 
 
 			<jbossHome>C:\app\jboss-5.1.0.GA</jbossHome> // alterar para o local do jboss 
      		<serverName>fiapbank</serverName> // alterar para o server criado
 
  
 	

 7 - Via comando entrar no diretorio fiapbank e executar;

	mvn clean 

 8 - e depois

	mvn install
	
 9 - entrar no diretorio fiapbank-ear e executar
 
 	mvn jboss:hard-deploy
 	
 10 - realizar o insert abaixo na base:
 
 	INSERT INTO SEGURANCA ( LOGIN, SENHA , PERFIL ) VALUES ( 'gerente', 'gerente', 'GERENTE' );
 	
 	
 11 -  acessar via browser a url abaixo:
 
 	http://localhost:8080/fiapbank
 	
 	
 Algumas consideracoes:
 
 - Como desenvolvi o trabalho tanto em windows como em linux, tive alguns problemas de encoding entao
 resolvi nao utilizar acentos e caracteres especiais para evitar algum problema.
 
 - Nao tive tempo para adicionar validacoes de campos , mascaras .. etc. entao solicito para vc digitar todos
  campos
  
  - Para os campos decimais ( valores de credito .. ) utilizar o (.) como separador de casa decimal
  
  - se tiver algum problema na execucao do trabalho segue o meu e-mail
  
  		robson.o.d@gmail.com
   	 
 
 	 	
 	
 		 



 