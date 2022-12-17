<project xmlns="http://maven.apache.org/POM/4.0.0" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>grpid</groupId>
  <artifactId>artid</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  
  
    <dependencies>
     
       <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>2.6.0</version>
</dependency>

 
      
            <!-- https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver -->
            <dependency>
                <groupId>org.mongodb</groupId>
                <artifactId>mongo-java-driver</artifactId>
                <version>3.12.11</version>
            </dependency>
            
            <!-- https://mvnrepository.com/artifact/org.eclipse.jetty/example-jetty-embedded -->
 
 
 

<!-- https://mvnrepository.com/artifact/org.mongodb/mongodb-driver -->
<dependency>
    <groupId>org.mongodb</groupId>
    <artifactId>mongodb-driver</artifactId>
    <version>3.12.0</version>
</dependency>


        </dependencies>
 
    
    
</project>



。。。。。。。。。。。


package pkg1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class sprbt {
	public static void main(String[] args) {
		SpringApplication.run(sprbt.class, args);
	}
}

@RestController
class HelloWorldController2 {
	@RequestMapping("/a")
	public String hello() {
		return "halo a reps";
	}
}


............
package pkg1;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
@RestController  
public class HelloWorldController   
{  
@RequestMapping("/")  
public String hello()   
{  
return "Hello javaTpoint";  
}  
}  




...............
package pkg1;

import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;  
@SpringBootApplication  
public class sprbt  
{  
public static void main(String[] args)   
{  
SpringApplication.run(sprbt.class, args);  
}  
} 