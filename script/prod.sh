#!/usr/bin/env bash
#shutdown platforms
ps -ef|grep platform |grep -v grep|cut -c 9-15|xargs kill -9

#shutdown services
ps -ef|grep service |grep -v grep|cut -c 9-15|xargs kill -9

#shutdown all
ps -ef|grep runnable-jars |grep -v grep|cut -c 9-15|xargs kill -9

#\cp platform-zuul/target/platform-zuul-1.0.0-SNAPSHOT.jar                       runnable-jars/platform-zuul.jar
#java -Xmx256m -jar runnable-jars/platform-zuul.jar                      --server.port=8502 --spring.profiles.active=prod    >../zuul.log &

\cp platform-config-server/target/platform-config-server-1.0.0-SNAPSHOT.jar     runnable-jars/platform-config-server.jar
\cp platform-eureka-server/target/platform-eureka-server-1.0.0-SNAPSHOT.jar     runnable-jars/platform-eureka-server.jar
\cp platform-zipkin-server/target/platform-zipkin-server-1.0.0-SNAPSHOT.jar     runnable-jars/platform-zipkin-server.jar
\cp platform-admin-dashboard/target/platform-admin-dashboard-1.0.0-SNAPSHOT.jar runnable-jars/platform-admin-dashboard.jar

java -Xmx256m -jar runnable-jars/platform-config-server.jar             --server.port=8505                                  >../config-server.log &
java -Xmx256m -jar runnable-jars/platform-eureka-server.jar             --server.port=8101 --spring.profiles.active=prod    >../eureka-server.log &
java -Xmx256m -jar runnable-jars/platform-zipkin-server.jar             --server.port=9411 --spring.profiles.active=prod    >../zipkin-server.log &
java -Xmx256m -jar runnable-jars/platform-admin-dashboard.jar           --server.port=81  --spring.profiles.active=prod    >../admin-dashboard.log &

\cp ui-admin/target/admin-ui-1.0.0-SNAPSHOT.jar                         runnable-jars/ui-admin.jar
\cp api/target/api-1.0.0-SNAPSHOT.jar                                   runnable-jars/api.jar
\cp service-hotel/target/hotel-service-1.0.0-SNAPSHOT.jar               runnable-jars/hotel-service.jar
\cp service-dict/target/dict-service-1.0.0-SNAPSHOT.jar                 runnable-jars/dict-service.jar
\cp service-line/target/line-service-1.0.0-SNAPSHOT.jar                 runnable-jars/line-service.jar
\cp service-scenery/target/scenery-service-1.0.0-SNAPSHOT.jar           runnable-jars/scenery-service.jar
\cp service-member/target/member-service-1.0.0-SNAPSHOT.jar             runnable-jars/member-service.jar
\cp service-visa/target/visa-service-1.0.0-SNAPSHOT.jar                 runnable-jars/visa-service.jar
\cp service-sms/target/sms-service-1.0.0-SNAPSHOT.jar                   runnable-jars/sms-service.jar
\cp service-verify-code/target/verify-code-service-1.0.0-SNAPSHOT.jar   runnable-jars/verify-code-service.jar
\cp service-oss/target/oss-service-1.0.0-SNAPSHOT.jar                   runnable-jars/oss-service.jar

java -Xmx256m -jar runnable-jars/ui-admin.jar                           --spring.profiles.active=prod --server.port=80   >../admin-ui.log &
java -Xmx256m -jar runnable-jars/api.jar                                --spring.profiles.active=prod --server.port=8080 >../api.log &
java -Xmx256m -jar runnable-jars/hotel-service.jar                      --spring.profiles.active=prod --server.port=8601 >../service-hotel.log &
java -Xmx256m -jar runnable-jars/dict-service.jar                       --spring.profiles.active=prod --server.port=8602 >../service-dict.log &
java -Xmx256m -jar runnable-jars/line-service.jar                       --spring.profiles.active=prod --server.port=8603 >../service-line.log &
java -Xmx256m -jar runnable-jars/scenery-service.jar                    --spring.profiles.active=prod --server.port=8604 >../service-scenery.log &
java -Xmx256m -jar runnable-jars/member-service.jar                     --spring.profiles.active=prod --server.port=8605 >../service-member.log &
java -Xmx256m -jar runnable-jars/visa-service.jar                       --spring.profiles.active=prod --server.port=8606 >../service-visa.log &
java -Xmx256m -jar runnable-jars/sms-service.jar                        --spring.profiles.active=prod --server.port=8607 >../service-sms.log &
java -Xmx256m -jar runnable-jars/verify-code-service.jar                --spring.profiles.active=prod --server.port=8608 >../service-verify-code.log &
java -Xmx256m -jar runnable-jars/oss-service.jar                        --spring.profiles.active=prod --server.port=8609 >../service-oss-code.log &
