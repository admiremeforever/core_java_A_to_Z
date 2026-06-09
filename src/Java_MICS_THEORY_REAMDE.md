Java ClassLoaders are responsible for loading .class files into JVM memory. The loading process consists of Loading,
Linking (Verification, Preparation, Resolution), and Initialization. JVM uses a hierarchical delegation model consisting of
Bootstrap, Platform, and Application ClassLoaders. When a class is requested, a child loader delegates loading to its parent first,
ensuring core Java classes are loaded only by trusted loaders. This prevents malicious replacement of classes like java.lang.String. 
Class metadata is stored in Metaspace, and advanced frameworks such as Tomcat and Spring Boot use custom ClassLoaders for isolation
and dynamic loading.

Practice Stream API -> https://blog.stackademic.com/crack-the-code-top-java-stream-interview-questions-with-code-solutions-f8e4c1ed6160

and 

https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
