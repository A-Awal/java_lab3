#! /bin/bash
#CHECK IF JAVA IS INSTALLED
#if [-f $JAVA_HOME/bin/java]; then
java --version
#else
#	echo "YOU MUST INSTALL JAVA"
#fi

#CHECK IF MAVEN IS INSTALLED
#if [-f $MAVEN_HOME/bin/mvn]; then
#	echo "You are running on"
$MAVEN_HOME/bin/mvn -v
#else
#	echo "You don\'t have maven installed"
#	exit

#fi


#BUILD APP



this=$TOMCAT_HOME
echo "$this is tomcat directory"

echo "$(pwd)"

$MAVEN_HOME/bin/mvn clean package

	

ls C:/Users/AbdulaiAwal/Downloads/Java_first/lab1/lab1/target
cd $this 
cd webapps
cp C:/Users/AbdulaiAwal/Downloads/Java_first/lab1/lab1/target/*.war ./


#COPY THE TOMCAT WEBAPP DIRECTORY 
#START SERVER
$this/bin/catalina.sh run
