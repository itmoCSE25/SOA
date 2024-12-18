# SOA

## Задание
### На основе разработанной в рамках лабораторной работы #1 спецификации реализовать два веб-сервиса и использующее их API клиентское приложение.

### Требования к реализации и развёртыванию сервисов:

Первый ("вызываемый") веб-сервис должен быть реализован на фреймворке JAX-RS и развёрнут в окружении под управлением сервера приложений Payara.
Второй веб-сервис должен быть реализован на фреймворке Spring MVC REST, развёрнут в окружении под управлением ещё одного экземпляра сервера приложений Payara и вызывать REST API первого сервиса.
Для обоих сервисов необходимо реализовать все функции, задокументированные в API, в строгом соответствии со спецификацией!
Доступ к обоим сервисам должен быть реализован по протоколу https с самоподписанным сертификатом сервера. Доступ к сервисам посредством http без шифрования должен быть запрещён.

### Требования к клиентскому приложению:

Клиентское приложение может быть написано на любом веб-фреймворке, который можно запустить на сервере helios.
Приложение должно обеспечить полный набор возможностей, предоставляемых API обоих сервисов -- включая сортировку, фильтрацию и постраничный вывод элементов коллекции.
Приложение должно преобразовывать передаваемые сервисами данные в человеко-читаемый вид -- параграф текста, таблицу и т.д.
Клиентское приложение должно информировать пользователя об ошибках, возникающих на стороне сервисов, в частности, о том, что сервису были отправлены невалиданые данные.
Оба веб-сервиса и клиентское приложение должны быть развёрнуты на сервере helios.

### Вопросы к защите лабораторной работы:

1) Разработка RESTful сервисов. Языки программирования, фреймворки и библиотеки.
2) RESTful сервисы на платформе Java EE. Технология JAX-RS.
3) Основные и вспомогательные аннотации JAX-RS.
4) Описание ресурсов в JAX-RS. 
5) Разработка RESTful веб-сервисов на платформе Spring. 
6) Технология Spring Web MVC REST. Отношение к Spring Web MVC, сходства и отличия от JAX-RS. 
7) Элементы архитектуры Spring Web MVC: Dispatcher Servlet, Handler Mapping, View Resolver. 
8) Аннотации Spring Web MVC. 
9) Сериализация / десериализация данных в Spring Web MVC REST. 
10) Технология Spring Data REST. Преимущества и недостатки относительно JAX-RS и Spring Web MVC REST. 
11) Spring Data REST: стратегии экспорта репозиториев, типы ресурсов, автоматическое описание сервисов. 
12) Интеграция веб-сервисов. Настройка защищённого соединения между узлами. Основы криптографии. 
13) TLS & SSL. Основные термины. 
14) Симметричное и асимметричное шифрование. Приватный и публичный ключи, сертификаты. Генерация сертификатов. 
15) Доверенные центры сертификации. Иерархия сертификатов, самоподписанные сертификаты. 
16) Настройка защищённого соединения в Java. Доверенные узлы, хранилища сертификатов. 
17) Keystore & Truststore. Утилита keytool.

## Запуск сервера
1) Поднять все необходимые докер контейнеры. Нужно чтобы был запущен процесс докера (docker-desktop/docker-cli)
```bash
bash start.sh
```
2) Проверить правильность инициализации
```bash
curl https://localhost:7171/soa-service/ping
curl https://localhost:8383/genocide-service/genocide/ping
```
3) Заполнение базы данных.
(Только для первого раза) Нужно подключиться к бд (данные можно найти в docker-compose.yaml)
и выполнить скрипт по пути soa/src/main/resources/init.sql
4) Поздравляю! Все работает

p.s. Если что-то не работает, а именно curl запросы не выдают ожидаемый ответ (code: 200, responseBody: pong), то идем 
и проверяем настройки по ссылкам https://localhost:4040/common/index.jsf и https://localhost:4949/common/index.jsf(логин: admin, пароль: admin).
Может быть такое что после авторизации мы получим страницу 404, тут нужно просто еще раз перейти по ссылке по которой происходила авторизация.
Там мы должны увидеть по одному приложению по каждой ссылке

![https://localhost:4040/common/index.jsf](docs/images/soa-service.png)

![https://localhost:4949/common/index.jsf](docs/images/genocide-service.png)

## Запуск клиента
```
npm i
npm start
```
