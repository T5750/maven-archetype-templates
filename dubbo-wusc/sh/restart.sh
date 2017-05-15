## java env
export JAVA_HOME=/usr/local/java/jdk1.7.0_72
export JRE_HOME=$JAVA_HOME/jre

## restart tomcat
/home/wusc/edu/web/boss-tomcat/bin/shutdown.sh
sleep 3
rm -rf /home/wusc/edu/web/boss-tomcat/webapps/edu-web-boss
/home/wusc/edu/web/boss-tomcat/bin/startup.sh

