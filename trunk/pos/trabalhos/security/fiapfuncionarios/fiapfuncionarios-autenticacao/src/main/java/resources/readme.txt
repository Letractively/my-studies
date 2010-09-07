Tecnologias usadas

- java 1.6.x
- maven 2.2.1  
- jboss 5.1
- mysql 5.1
- como browser para teste da camada web firefox 3.5 ou superior

 > Resumo <
  
  O trabalho esta com a seguinte estrutura:
  
  fiapfuncionarios - super pom
	- fiapfuncionarios-autenticacao - modulo de autenticacao customizado 
	- fiapfuncionarios-gerenciamento - modulo de gerenciamento de funcionarios
	- fiapfuncionarios-dominio - modulo de dominio
	- fiapfuncionarios-web - camada web 		 
	- fiapfuncionarios-ear - modulo para empacotamento 

 - modulo de autenticacao customizado

	> Para a customizacao do login foi utilizado a classe org.jboss.security.auth.spi.UsernamePasswordLoginModule vista em aula , foi criado uma Inferface chamada FiapFuncionariosAutenticador com metodos que fornecam os dados necessarios para realizar o login, a ideia da interface e que podemos ter varias implementacoes de obter esse dados, e a implementacao utilizada foi com acesso ao banco de dados utilizando JDBC com a classe FiapFuncionariosAutenticadorJDBC essa classe alem de fornecer os recursos para realizar a autenticacao tambem realiza a gravacao do historico de acesso do usuario.
	  
 - modulo de gerenciamento de funcionarios

	  > Esse modulo possui as regras de negocio utilizada no trabalho, ( cadastrar , promover e remover funcionario ), basicamente o modulo tem um EJB(3.0) que realiza todas regras.
	  
- fiapfuncionarios-dominio - modulo de dominio

	  > Possui as entidades envolvidas no negocio do trabalho. que são Funcionario e seu HistoricoDeAcesso, foi utilizado JPA para realizar o ORM
	 	 
- fiapfuncionarios-web - camada web

	  > Camada de visualizacao construida com JSF, Faclets , RichFaces
	  
- fiapfuncionarios-ear - modulo para empacotamento 

	  > modulo utilizado para realizar o empacotamento e deploy do projeto no jboss	
	 


- implantando e executando 


 1 - copiar o login-config.xml para o diretorio conf do server criado no jboss

 2 - copiar e  mysql-ds.xml para o diretorio deploy do server criado , ficando a configuracao a ser feita conforme visto em aula 
 
 3 - copiar o drive do mysql para o diretorio lib do server criado no jboss
 
 4 - criar o banco conforme configurado ... 

 5 - subir o server 

 6 - entrar no diretorio fiabank-ear e editar o pom.xml fazendo a seguinte alteracao:
 
 
 		<jbossHome>C:\app\jboss-5.1.0.GA</jbossHome> // alterar para o local do jboss 
      		<serverName>fiapfuncionarios</serverName> // alterar para o server criado
 
   	

 7 - Via comando entrar no diretorio fiapfuncionarios e executar;

	mvn clean 

 8 - e depois

	mvn install
	
 9 - entrar no diretorio fiapfuncionarios-ear e executar
 
 	mvn jboss:hard-deploy
 	
 10 - realizar o insert abaixo na base:

 INSERT INTO FUNCIONARIO ( CARGO, EMAIL , LOGIN, NOME, SENHA ) VALUES ( 'FUNCIONARIO', 'incial@inicial.com.br', 'inicial' , 'inicial','e698545c928808dfa15e1e81770e3fcb' );
 	
 	
 11 -  acessar via browser a url abaixo e entrar com o login/senha:
 
 	http://localhost:8080/fiapfuncionarios
	
	login:inicial
	senha:inicial
	
 	
 	
 Algumas consideracoes:
 
 - Como desenvolvi o trabalho tanto em windows como em linux, tive alguns problemas de encoding entao
 resolvi nao utilizar acentos e caracteres especiais para evitar algum problema.
  
 - se tiver algum problema na execucao do trabalho segue o meu e-mail
  
	robson.o.d@gmail.com
   	 
 
 	 	
 	
 		 



 
