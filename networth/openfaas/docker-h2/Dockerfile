FROM openjdk:8-jdk-alpine

RUN apk add --no-cache curl
RUN apk add --no-cache lsof

COPY h2-2019-03-13.zip /h2.zip

RUN unzip h2.zip -d . && rm h2.zip

RUN ln -s $(ls /h2/bin/*jar) /h2/bin/h2.jar

RUN mkdir /docker-entrypoint-initdb.d

VOLUME /h2-data

EXPOSE 8082 1521

#COPY docker-entrypoint.sh /usr/local/bin/
#ENTRYPOINT ["docker-entrypoint.sh"]

#Reference
#CMD java $(agent-bond-opts) -cp /opt/h2/bin/h2*.jar org.h2.tools.Server -web -webAllowOthers -webPort 80 -tcp -tcpAllowOthers -tcpPort 1521 -baseDir /opt/h2-data
#jdbc:h2:tcp://localhost:1521/h2-data/test

CMD java -cp /h2/bin/h2.jar org.h2.tools.Server \
  -web -webAllowOthers -tcp -tcpPort 1521 -tcpAllowOthers -ifNotExists  -baseDir h2-data