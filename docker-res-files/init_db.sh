#!/bin/bash
/usr/bin/mysqld_safe &
sleep 5
mysql -u root -e "CREATE DATABASE kagenda"
sleep 5 
mysql -u root -e "CREATE USER 'khc'@'%' IDENTIFIED BY 'khc'"
sleep 5
mysql -u root -e "GRANT ALL PRIVILEGES ON kagenda.* TO 'khc'@'%'"
sleep 5
mysql -u root -e "FLUSH PRIVILEGES"