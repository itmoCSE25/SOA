sudo keytool -genkey -alias soa-service -keyalg RSA -validity 3650 -keysize 2048 -keystore server.keystore

keytool -export -alias soa-service -storepass changeit -file server.cer -keystore server.keystore

keytool -import -v -trustcacerts -alias server-alias -file server.cer -keystore cacerts.jks -keypass changeit -storepass changeit