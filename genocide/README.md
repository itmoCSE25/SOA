# Generate
```bash
keytool -genkeypair -alias genocide -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore genocide.jks -validity 365
keytool -keystore genocide.jks -alias genocide -certreq -keyalg rsa -file genocide.crt
keytool -genkeypair -alias soa -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore soa.jks -validity 365
keytool -keystore soa.jks -alias soa -certreq -keyalg rsa -file soa.crt
```
