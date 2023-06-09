# MobileBankBackend
This is backend part of mobile bank application.
# Краткое описание проекта:
Backend-часть простого мобильного приложения банка, написанная на Java с использованием Spring Framework, предоставляет REST API для управления банковскими счетами, транзакциями и пользователями.
# Установка и запуск:
1. Клонируйте репозиторий на свой локальный компьютер: git clone https://github.com/your-repository.
2. Перейдите в директорию проекта: cd project-directory.
3. Установите необходимые зависимости.
4. Сконфигурируйте базу данных в файле application.properties.
5. Запустите приложение.
# 'REST API' методы:
* GET /accounts - возвращает список всех банковских счетов.
* GET /accounts/{accountId} - возвращает данные о банковском счете с указанным идентификатором.
* POST /accounts - создает новый банковский счет.
* DELETE /accounts/{accountId} - закрывает банковский счет с указанным идентификатором.
* GET /transactions - возвращает список всех транзакций.
* GET /transactions/users/{userId} - возвращает список всех транзакций для указанного пользователя.
* GET /transactions/accounts/{accountId} - возвращает список всех транзакций для указанного счета.
* POST /transactions - осуществляет перевод денежных средств между банковскими счетами.
* POST /users/login - авторизует пользователя в системе.
* POST /users/register - регистрирует нового пользователя в системе.
* DELETE /users/{userId} - удаляет пользователя из системы.
# Требования к системе:
Java 17 или выше.
СУБД PostgreSQL для хранения данных.
