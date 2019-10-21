# agendamentoemail
Curso EJB - Alura

```
.\jboss-cli.bat --connect

module add --name=com.mysql --resources=C:\mysql-connector-java-8.0.18.jar --dependencies=javax.api,javax.transaction.api

/subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql,driver-module-name=com.mysql,driver-xa-datasource-class-name=com.mysql.cj.jdbc.MysqlXADataSource)

data-source add --name=AgendamentoDS --jndi-name=java:jboss/datasources/AgendamentoDS --driver-name=mysql  --connection-url=jdbc:mysql://localhost:3306/agendamentobd --user-name=root --min-pool-size=10 --max-pool-size=20

datasource="java:jboss/datasources/AgendamentoDS" 
```
