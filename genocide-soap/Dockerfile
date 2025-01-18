#FROM payara/server-full
#
##COPY keys/soa.jks /opt/payara/appserver/glassfish/domains/domain1/config
##COPY keys/genocide.crt genocide.crt
##
##USER root
##RUN keytool -importcert -keystore /opt/payara/appserver/glassfish/domains/domain1/config/cacerts.p12 -storepass changeit -alias genocide -trustcacerts -file genocide.crt -noprompt
##USER payara
#
#COPY target/soa-service.war /opt/payara/deployments
FROM openjdk:17
ARG JAR_FILE=target/genocide-soap-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]