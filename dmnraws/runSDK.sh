#if you do not have java 11 configured in your environment variables, 
#you can change the path to the current terminal:

export JAVA_HOME='/c/Program Files/AdoptOpenJDK/jdk-11.0.9.101-hotspot'
export PATH=$JAVA_HOME/bin:$PATH

mvn exec:java -Dexec.mainClass="com.example.myapp.App"