
Subir o banco e zipkin:
Na raiz do projeto:

docker-compose up -d

**Swagger**

#http://localhost:8101/swagger-ui/index.html

**ZIPKIN*

http://localhost:9411

**EUREKA**
#http://localhost:8888/locacao/default


**PAPERTRAIL**
https://papertrailapp.com/
Logs to: logs2.papertrailapp.com:27925

Setar o profile name
<springProfile name="default">

logback.xml
<syslogHost>INSERIR_SERVIDOR</syslogHost>
<port>PORTA</port>

Desligar a máquina de logs no papertrail após os testes,
pois o consumo de logs é limitado


TODO

Passar novos parametros para o repositorio de config
