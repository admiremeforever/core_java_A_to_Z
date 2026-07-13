Java ClassLoaders are responsible for loading .class files into JVM memory. The loading process consists of Loading,
Linking (Verification, Preparation, Resolution), and Initialization. JVM uses a hierarchical delegation model consisting of
Bootstrap, Platform, and Application ClassLoaders. When a class is requested, a child loader delegates loading to its parent first,
ensuring core Java classes are loaded only by trusted loaders. This prevents malicious replacement of classes like java.lang.String. 
Class metadata is stored in Metaspace, and advanced frameworks such as Tomcat and Spring Boot use custom ClassLoaders for isolation
and dynamic loading.


Bootstrap ClassLoader
Native code (C/C++), part of JVM itself — not a Java object
Loads core classes: java.lang.*, Object, Class, ClassLoader
No parent (root)
getClassLoader() on core classes → null

Platform ClassLoader (was "Extension" pre-Java 9)

Real Java object (ClassLoader instance)
Loads JDK extension modules (java.sql, java.xml, etc.)
Parent = Bootstrap

Application ClassLoader (a.k.a. System ClassLoader)

Loads your app's classes from classpath/module path
Parent = Platform
ClassLoader.getSystemClassLoader()

Practice Stream API -> https://blog.stackademic.com/crack-the-code-top-java-stream-interview-questions-with-code-solutions-f8e4c1ed6160

and 

https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/





=================================================

"Comparable defines a class's single natural ordering by implementing compareTo inside the class. Comparator defines an external, arbitrary ordering via compare, without touching the class — and you can have as many Comparators as you need for different sort criteria."
