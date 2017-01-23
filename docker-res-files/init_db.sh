#!/bin/bash
/usr/bin/mysqld_safe &
sleep 5
mysql -u root -e "CREATE DATABASE kagenda"
sleep 5 
mysql -u root -e "CREATE USER 'khc'@'localhost' IDENTIFIED BY 'khc'"
sleep 5
mysql -u root -e "GRANT ALL PRIVILEGES ON kagenda.* TO 'khc'@'localhost'"
sleep 5
mysql -u root -e "FLUSH PRIVILEGES"