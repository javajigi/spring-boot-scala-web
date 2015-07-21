name := "spring-boot-scala-web"

version := "1.0"

scalaVersion := "2.11.6"

sbtVersion := "0.13.1"

seq(webSettings : _*)

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % "1.2.5.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-security" % "1.2.5.RELEASE",  
  "org.springframework.boot" % "spring-boot-starter-data-jpa" % "1.2.5.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-actuator" % "1.2.5.RELEASE",
  "org.springframework.boot" % "spring-boot-starter-test" % "1.2.5.RELEASE" % "test",
  "org.webjars" % "bootstrap" % "3.1.1",
  "org.webjars" % "jquery" % "2.1.0-2",
  "org.thymeleaf" % "thymeleaf-spring4" % "2.1.2.RELEASE",
  "org.hibernate" % "hibernate-validator" % "5.0.2.Final",
  "nz.net.ultraq.thymeleaf" % "thymeleaf-layout-dialect" % "1.2.1",
  "org.hsqldb" % "hsqldb" % "2.3.1",
  "junit" % "junit" % "4.11" % "test",
  "org.springframework" % "spring-test" % "4.1.7.RELEASE" % "test"
)
