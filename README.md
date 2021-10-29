# Модель вну1треннего качества
- goupId maven-артефакта: `com.db.edu.teamXX`
- Код обязательно проходит code & design review, чтобы минимум трое участников команды могли обосновать любое решение в коде
- Automated test branch coverage ≥ 90%
- Mutation coverage ≥ 80%
- Все решения по дизайну обоснованы и задокументированы в javadoc
- Публичный API задокументирован в JavaDoc
- Cборка только через maven
- Код читабелен и соответствует Java Code Style Convention
- Отсутствуют dead code и dead comments
- Все рафакторинги делались только автоматически
- Код проходит проверки по установленному профилю качества в Sonar
- ~~Все ошибки и отказы журналируются в лог-файлы с ротацией~~(По желанию)

# Нефункциональные требования

## Deployability
- Клиентская и серверная части упакованы в uber jars
- Запуск клиента одним bat-/sh-скриптом.
- Запуск сервера одним bat-/sh-скриптом.
- Развертывание и запуск на prod-стенде осуществляется строго отчуждаемо:
```bash
$ git pull
$ mvn clean verify
```

# Метафора
Быстрый и лаконичный корпоративный консольный чат.


# Функциональные требования

## Посылка сообщения
### User Story
Я, как пользователь, хочу послать сообщение, чтобы его увидели другие пользователи чата.
### Acceptance Test
#### Given
- Запущены клиентское и серверное приложения.
#### When
- Я печатаю и отсылаю сообщение в чат с помощью команды "/snd <сообщение>"
#### Then
- Я вижу свое сообщение с датой и временем.
- Другие пользователи видят мое сообщение с датой и временем.
- Работа с часовыми поясами по желанию.

## Просмотр полной истории
### User Story
Я, как пользователь, хочу видеть все сообщения за все время существования чата, чтобы найти нужное мне сообщение.
### Acceptance Test
#### Given
- Запущены клиентское и серверное приложения.
#### When
- Я ввожу команду "/hist".
#### Then
- Я вижу полный список всех сообщений чата с датой и временем.

## Идентификация
### User Story
Я, как пользователь, хочу представиться системе, чтобы все участники чата ассоциировали мои сообщения со мной.
### Acceptance Test
#### Given
- Запущены клиентское и серверное приложения.
#### When
- Я ввожу команду "/chid <выбранный-ник>"
#### Then
- Все сообщения от меня снабжаются информацией о моем нике.
- Ник должен быть уникальным.
- Ник должен быть без пробельных символов.
- Обязательна идентификация перед началом общения.
