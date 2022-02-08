FROM chotire/h2:1.4.200
ADD ./data /opt/h2-data


#FROM openjdk:11
#
#MAINTAINER CHO Yongsang <chotire@gmail.com>
#
#ENV DOWNLOAD https://h2database.com/h2-2019-10-14.zip
#ENV DATA_DIR /opt/h2-data
#
#RUN mkdir -p ${DATA_DIR} \
#    && curl ${DOWNLOAD} -o h2.zip \
#    && unzip h2.zip -d /opt/ \
#    && rm h2.zip
#
#EXPOSE 8082 9092
#
#WORKDIR ${DATA_DIR}
#
#CMD java -cp /opt/h2/bin/h2*.jar org.h2.tools.Server \
# 	-web -webAllowOthers -webPort 8082 \
# 	-tcp -tcpAllowOthers -tcpPort 9092 \
# 	-baseDir ${DATA_DIR} ${H2_OPTIONS}

# docker build -t chotire/h2:1.4.200 .
# docker run -d -p 8082:8082 -p 9092:9092 --name h2 chotire/h2:1.4.200