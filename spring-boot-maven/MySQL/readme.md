# Docker-Compose
## MySQL Container hochfahren
- docker-compose -f docker-compose-mysql.yml up

## Passwort einstellen
- docker exec -it spring_boot_mysql_database bin/bash
- mysql -uroot -p
- ALTER USER 'user' IDENTIFIED WITH mysql_native_password BY 'geheim';
- GRANT ALL PRIVILEGES ON *.* TO 'user' WITH GRANT OPTION;
- FLUSH PRIVILEGES;

## Install
- Docker / Docker-Compose
- MySQL Workbench