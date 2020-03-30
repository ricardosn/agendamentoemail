# agendamentoemail
Curso EJB - Alura

## Configurando DataSource no Wildfly
```
.\jboss-cli.bat --connect
```
```
module add --name=com.mysql --resources=C:\mysql-connector-java-8.0.18.jar --dependencies=javax.api,javax.transaction.api
```
```
/subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql,driver-module-name=com.mysql,driver-xa-datasource-class-name=com.mysql.cj.jdbc.MysqlXADataSource)
```
```
data-source add --name=AgendamentoDS --jndi-name=java:jboss/datasources/AgendamentoDS --driver-name=mysql  --connection-url=jdbc:mysql://localhost:3306/agendamentobd --user-name=root --password=SUA-SENHA --min-pool-size=10 --max-pool-size=20
```
```
datasource="java:jboss/datasources/AgendamentoDS" 
```
```
SET @@global.time_zone = '+3:00';
```
**Link Útil**: https://lucasmarques.me/mysql-wildfly-datasource/

## Configurando JavaMail no Wildfly
```
/subsystem=mail/mail-session=agendamentoMailSession:add(jndi-name=java:jboss/mail/AgendamentoMailSession)
```
```
/socket-binding-group=standard-sockets/remote-destination-outbound-socket-binding=my-smtp-binding:add(host=smtp.mailtrap.io, port=2525)
```
```
/subsystem=mail/mail-session=agendamentoMailSession/server=smtp:add(outbound-socket-binding-ref= my-smtp-binding, username=bc82647d48b758, password=6320632ea13bd1, tls=true)
```

## Configurando JMS no WildFly
```
jms-queue add --queue-address=EmailQueue --entries=java:/jms/queue/EmailQueue
```
```
/subsystem=messaging-activemq/server=default/jms-queue=EmailQueue:list-messages
```
```
/subsystem=messaging-activemq/server=default/jms-queue=DLQ:list-messages
```
