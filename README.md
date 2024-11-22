# SOA

# Как поднять дев базу
```
initdb --pgdata=pg_data --username=postgres
pg_ctl -D pg_data start
```
# Генерация ключа
PKS
Мы можем хранить любое количество пар ключей в одном и том же хранилище ключей, каждый из которых идентифицируется уникальным псевдонимом.
```
keytool -genkeypair -alias foreach -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore foreach.p12 -validity 3650
```
# Запуск клиента
```
npm i
npm start
```
