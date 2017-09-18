
windows项目运行步骤:
```

cd script

call install-jar.bat

cd ..

mvn clean package

start /b java -Xmx256m -jar platform-eureka-server/target/platform-eureka-server-1.0.0-SNAPSHOT.jar >.\log\eureka-server.log &
start /b java -Xmx256m -jar platform-zipkin-server/target/platform-zipkin-server-1.0.0-SNAPSHOT.jar >.\log\zipkin-server.log &
start /b java -Xmx256m -jar platform-admin-dashboard/target/platform-admin-dashboard-1.0.0-SNAPSHOT.jar >.\log\admin-dashboard.log &
start /b java -Xmx256m -jar platform-config-server/target/platform-config-server-1.0.0-SNAPSHOT.jar >.\log\config-server.log &

start /b java -Xmx256m -jar ui-admin/target/admin-ui-1.0.0-SNAPSHOT.jar >.\log\admin.log &
start /b java -Xmx256m -jar api/target/api-1.0.0-SNAPSHOT.jar >.\log\api.log &
start /b java -Xmx256m -jar service-hotel/target/hotel-service-1.0.0-SNAPSHOT.jar >.\log\hotel-service.log &
start /b java -Xmx256m -jar service-dict/target/dict-service-1.0.0-SNAPSHOT.jar  >.\log\dict-service.log &
start /b java -Xmx256m -jar service-line/target/line-service-1.0.0-SNAPSHOT.jar  >.\log\line-service.log &
start /b java -Xmx256m -jar service-scenery/target/scenery-service-1.0.0-SNAPSHOT.jar  >.\log\scenery-service.log &
start /b java -Xmx256m -jar service-member/target/member-service-1.0.0-SNAPSHOT.jar  >.\log\member-service.log &
start /b java -Xmx256m -jar service-visa\target\visa-service-1.0.0-SNAPSHOT.jar  >.\log\visa-service.log &
start /b java -Xmx256m -jar service-verify-code\target\verify-code-service-1.0.0-SNAPSHOT.jar  >.\log\verify-code-service.log &
start /b java -Xmx256m -jar service-sms\target\sms-service-1.0.0-SNAPSHOT.jar  >.\log\sms-service.log &
start /b java -Xmx256m -jar service-oss\target\oss-service-1.0.0-SNAPSHOT.jar  >.\log\oss-service.log &

```

linux
```

cd script

sh ./install-jar.sh

cd ..

mvn clean package

java -Xmx256m -jar platform-eureka-server\target\platform-eureka-server-1.0.0-SNAPSHOT.jar >./log/eureka-server.log &
java -Xmx256m -jar platform-zipkin-server\target\platform-zipkin-server-1.0.0-SNAPSHOT.jar >./log/zipkin-server.log &
java -Xmx256m -jar platform-admin-dashboard\target\platform-admin-dashboard-1.0.0-SNAPSHOT.jar >./log/admin-dashboard.log &
java -Xmx256m -jar platform-config-server\target\platform-config-server-1.0.0-SNAPSHOT.jar >./log/config-server.log &

java -Xmx256m -jar ui-admin\target\admin-ui-1.0.0-SNAPSHOT.jar >./log/admin.log &
java -Xmx256m -jar api\target\api-1.0.0-SNAPSHOT.jar >./log/api.log &
java -Xmx256m -jar service-hotel\target\hotel-service-1.0.0-SNAPSHOT.jar >./log/hotel-service.log &
java -Xmx256m -jar service-dict\target\dict-service-1.0.0-SNAPSHOT.jar  >./log/dict-service.log &
java -Xmx256m -jar service-line\target\line-service-1.0.0-SNAPSHOT.jar  >./log/line-service.log &
java -Xmx256m -jar service-scenery\target\scenery-service-1.0.0-SNAPSHOT.jar  >./log/scenery-service.log &
java -Xmx256m -jar service-member\target\member-service-1.0.0-SNAPSHOT.jar  >./log/member-service.log &
java -Xmx256m -jar service-visa\target\visa-service-1.0.0-SNAPSHOT.jar  >./log/visa-service.log &
java -Xmx256m -jar service-verify-code\target\verify-code-service-1.0.0-SNAPSHOT.jar  >./log/visa-service.log &
java -Xmx256m -jar service-sms\target\sms-service-1.0.0-SNAPSHOT.jar  >./log/sms-service.log &
java -Xmx256m -jar service-oss\target\oss-service-1.0.0-SNAPSHOT.jar  >./log/oss-service.log &

```

