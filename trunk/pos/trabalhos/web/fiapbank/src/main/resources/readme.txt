Tecnologias usadas

- java 1.6.x
- maven 2.2.1  
- tomcat 6
- mysql 5.1
- como browser para teste da camada web firefox 3.5 ou superior

 > Resumo <
  
  O trabalho esta com a seguinte estrutura:
  
  fiapbank - super pom
	- fiapbank-negocio - modulo com as regras de negocio 
	- fiapbank-dominio - modulo de dominio
	- fiapbank-persistencia - modulo de persitencia
	- fiapbank-web - camada web 		 


 >> fiapbank-negocio 

	possui as regras de negocio para as operacoes realizadas pelos caixa / gerente e cliente

>> fiapbank-dominio - modulo de dominio
	
	possui as entidades do dominio do sistema, para realizar o ORM foi usado JPA 1.0

>> fiapbank-persistencia - modulo de persitencia
	
	possui a camada de acesso aos dados, para provider do JPA utilizado no dominio , foi utilizado o Hibernate
	
>> fiapbank-web - camada web
 	
	A camda web foi feita utilizando JSF 1.2 / RichFaces / Facelets e JQuery
	 


- implantando e executando 


 1 - alterar o persistence.xml que esta em fiapbank-persistencia/src/main/resources/META-INF , para os dados do banco criado
   	
	OBS: para executar os comandos abaixo e necessario ter acesso a internet

 2 - Via comando entrar no diretorio fiapbank e executar; 

	mvn clean 

 8 - e depois

	mvn install
	
 9 - entrar no diretorio fiapbank-web e executar
 
 	mvn tomcat:run-war
 	
 10 - realizar o insert abaixo na base:

 INSERT INTO FUNCIONARIO ( CARGO, LOGIN, SENHA ) VALUES ( 'GERENTE', 'gerente' , 'gerente');
 INSERT INTO FUNCIONARIO ( CARGO, LOGIN, SENHA ) VALUES ( 'CAIXA', 'caixa' , 'caixa');
 	
 	
 11 -  acessar via browser a url abaixo e entrar com o login/senha:
 
 	http://localhost:8080/fiapbank
		
 Algumas consideracoes:
 
 - Como desenvolvi o trabalho tanto em windows como em linux, tive alguns problemas de encoding entao
 resolvi nao utilizar acentos e caracteres especiais para evitar algum problema.
  
 - se tiver algum problema na execucao do trabalho segue o meu e-mail
  
	robson.o.d@gmail.com
   	 
 
 	 	
 	
 		 



 
