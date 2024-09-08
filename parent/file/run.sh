#!/bin/bash

# 进入上级目录
cd ..
# 清理并安装依赖
mvn clean install

cd common
mvn clean install -DskipTests

cd ../mybatis
mvn clean install -DskipTests

cd ../wx
mvn clean install -DskipTests

cd ../finance-biz
mvn clean install -DskipTests

cd ../finance-admin-api
mvn clean package -DskipTests

mvn spring-boot:run -DskipTests -Dspring-boot.run.profiles=local
