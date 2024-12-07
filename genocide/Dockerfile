FROM payara/server-full:6.2024.9-jdk17

#COPY keys/genocide.jks /opt/payara/appserver/glassfish/domains/domain1/config
#COPY keys/soa.crt soa.crt

#USER root
#RUN keytool -importcert -keystore /opt/payara/appserver/glassfish/domains/domain1/config/cacerts.p12 -storepass changeit -alias soa -trustcacerts -file soa.crt -noprompt
#USER payara

COPY target/genocide-service.war /opt/payara/deployments