FROM payara/server-full:6.2024.9-jdk17

#COPY keys/soa.jks /opt/payara/appserver/glassfish/domains/domain1/config
#COPY keys/genocide.crt genocide.crt

#USER root
#RUN keytool -importcert -keystore /opt/payara/appserver/glassfish/domains/domain1/config/cacerts.p12 -storepass changeit -alias genocide -trustcacerts -file genocide.crt -noprompt
USER payara

COPY target/soa-service.war /opt/payara/deployments