FROM tomcat:8.0.21-jre8
MAINTAINER ramzi_abdoch@mckinsey.com

# Configure Tomcat Users
COPY docker/tomcat-users.xml /usr/local/tomcat/conf/

# Deploy WAR
COPY build/libs/spring-api-test-0.1.0.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]
