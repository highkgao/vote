#! /bin/sh
echo "mvn clean"
mvn clean
echo "stop tomcat"
/Users/gaofeng/Downloads/apache-tomcat-9.0.0.M26/bin/shutdown.sh
echo "start package" 
mvn package
echo "package end"
echo "-------------------------"
mv /Users/gaofeng/Documents/git/vote/web/target/voteweb.war ~/Downloads/apache-tomcat-9.0.0.M26/webapps/voteweb.war
echo "---------------------------"
sleep 3s
/Users/gaofeng/Downloads/apache-tomcat-9.0.0.M26/bin/startup.sh

