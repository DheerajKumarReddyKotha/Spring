package com.asura.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		//load spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		Coach baseBallCoach = context.getBean("baseBallCoach",Coach.class); //Coach interface is specified so that spring will cast the object for you.
		
		//call methods on the bean
		System.out.println(baseBallCoach.getDailyWorkout());
		
		System.out.println(baseBallCoach.getDailyFortune());
		
		Coach trackCoach = context.getBean("trackCoach", Coach.class);
		
		System.out.println(trackCoach.getDailyWorkout());
		System.out.println(trackCoach.getDailyFortune());
		
		CricketCoach cricketCoach = context.getBean("cricketCoach",CricketCoach.class);
		
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		System.out.println(cricketCoach.getEmailAddress());
		System.out.println(cricketCoach.getTeam());
		
		//Scope:Prototype test
		BaseballCoach baseBallCoachOne = context.getBean("baseBallCoach",BaseballCoach.class); 
		BaseballCoach baseBallCoachTwo = context.getBean("baseBallCoach",BaseballCoach.class); 
		
		Boolean result = (baseBallCoachOne == baseBallCoachTwo);
		System.out.println(result);
		
		System.out.println("\n Memory Location for baseBallCoachOne: "+baseBallCoachOne);
		System.out.println("\n Memory Location for baseBallCoachTwo: "+baseBallCoachTwo);
		
		//Annotation based TennisCoach class
		Coach theTennisCoach = context.getBean("tennisCoach", Coach.class);
		
		System.out.println(theTennisCoach.getDailyWorkout());
		System.out.println(theTennisCoach.getDailyFortune());
		
		//close context.
		context.close();
	}

}

/*
What is Spring?
a) It is a framework, accurately it is a light weight framework.
b) It is also known as framework of frameworks as it provides support to various other frameworks like 
JSF,EJB,HIBERNATE,STRUTS etc.

What is a Spring Bean?
It is simply a java object.
When java objects are created by spring container, the spring refers to them as "Spring Beans".

What are the different modules available in Spring Framework?
1. Spring Core Container
	a) Core - This module provides support for IOC and Dependency Injection features.
	b) Beans - This module provides support for IOC and Dependency Injection features.
	c) Context - This module supports internationalization (I18N), EJB, JMS, Basic Remoting.
	d) Expression Language - It is an extension to the EL defined in JSP. It provides support to setting 
	and getting property values, method invocation, accessing collections and indexers, named variables, 
	logical and arithmetic operators, retrieval of objects by name etc.
2. Aspect Oriented Programming - These modules support aspect oriented programming implementation where you 
	can use Advices, Pointcuts etc. to decouple the code.
3. Aspects - The aspects module provides support to integration with AspectJ.
4. Instrumentation - The instrumentation module provides support to class instrumentation and classloader 
	implementations.
5. Data Access/Integration - These modules basically provide support to interact with the database.
	a)JDBC
	b) ORM
	c) JMS
	d) OXM
	e) Transactions
6. WEB - These modules provide support to create web application.
	a) web
	b) Servlet
	c) Portlet
	d) Struts
7. Test - This layer provides support for JUnit and TestNG.

What is Inversion Of Control container?
a) It is responsible to instantiate, configure and assemble the objects.
b) It gets information from XML File.
c) The main tasks performed by IOC Containers are i) instantiate the application class 
												 ii) configure the object 
												 iii) assemble dependencies between objects
Step 1: Instantiating a Spring Container
a) Spring container is generally known as Application Context
b) Specialized implementations
    i)ClassPathXmlApplicationContext
    ii) AnnotationConfigApplicationContext
    iii) Generic web application Context
    
    ClassPathXmlApplicationContext context = new ClassPathApplicationContext("applicationContext.xml");
    
Step 2: Configuring your spring beans
There are three ways to configuring Spring Container
a) XML configuration file
b) Java Annotations
c) Java Source Code

<beans>
	<bean id="myCoach"
		class="com.asura.spring.BaseballCoach">
	</bean>
</beans>
    
Step 3: Retrieve bean from configuration file.
Coach theCoach = context.getBean("myCoach",Coach.class)
Types of IOC Containers:
a) BeanFactory
b) ApplicationContext

Difference between BeanFactory and ApplicationContext?
Both are interfaces and acts as IOC Containers. Application Context is build on top of BeanFactory and 
has some additional features like AOP,Message source handling and event propagation.

Using BeanFactory:
XmlBeanFactory is the implementation class for BeanFactory.
Resource resource=new ClassPathResource("applicationContext.xml");  
BeanFactory factory=new XmlBeanFactory(resource); 

Using ApplicationContext:
ClassPathXmlApplicationContext class is the implementation class of ApplicationContext Interface.
ApplicationContext context =   
    new ClassPathXmlApplicationContext("applicationContext.xml");  

What is Dependency Injection?
It is a design pattern that removes the dependency of programming code so that it can be easily manage and 
test the application.It makes our code loosely coupled.

There are two ways to inject dependency:
a) Constructor Injection - It is injected using <constructor-arg> sub element in bean.

Step 1: Define the dependency interface and class
a) Declare interface
b) Declare a class which implements above interface

Step 2: Create a constructor in your class for injections

b) Setter Injection

Step 1: create setter methods in your class for injections.
Step 2: Configure the dependency injection in spring config file

Inject Literal values, like email address etc.
Step 1: Create setter methods in class for injection
Step 2: Configure the injection in spring configuration

Inject values from properties file
Step 1: Create the properties file
Step 2: Load properties file in spring config file
Step 3: Reference values from properties file.

What are Bean Scopes?
a) Scope refers to life cycle of bean
b) How long does bean live?
c) How many instances are created?
d) How is bean shared?

Default scope of bean is singleton.
What is singleton?
Spring container creates one instance of bean , it is cached and is shared among all who requests that.
It is a stateless bean.

Different scopes
a) Singleton - creates a single shared instance of bean
b) Prototype - creates an instance every time it gets a request.
c) request - scope to HTTP web request.
d) session - scope to HTTP web session.
e) global-session - scope to global HTTP web session.

Bean Lifecycle:

Container Started -> Bean Instantiated -> Dependencies Injected -> Internal Spring Processing -> your custom Init Method
-> Bean is ready for use/Container ShutDown -> custom destroy method -> Stop

Step 1: Define methods for init and destroy. (these methods should be public void and should not have any 
		constructor)
Step 2: Configure the method names in spring config file.

Note: In case of prototype scope, spring does not call destroy method, it creates the bean and hands it to 
client. 

Spring with JAVA Annotations

1. Special labels/markers added to Java classes.
2. Provide meta-data about the class.
3. Processed at compile-time or run-time for special processing.

Why Spring Configuration withAnnotations?
a) XML Configuration can be verbose.
b) Configure your spring beans with Annotations
c) Annotations minimizes XML Configurations

Scanning for Component Classes
a) Spring will scan your java classes for special annotations.
b) Automatically register beans in the spring container.

Development Process for Annotations:
Step 1: Enable Component scanning in spring config file.
<beans>
	<context:component-scan base-package="com.asura.spring" />
</beans>

Step 2: Add the @Component Annotation to your java classes.
@Component("tennisCoach")
public class TennisCoach implements Coach {

@Override
public String getDailyWorkout(){
	return "Practice your back hand volley";
}
}

Step 3: Retrieve bean from spring container
Coach theTennisCoach = context.getBean("tennisCoach", Coach.class);

Spring dependency Injection with Annotations and Auto wiring:

1. What is Spring AutoWiring?
a) For dependency injection, Spring can use auto wiring.
b) Spring will look for the class that matches that property
	matches by type: class or interface
c) Spring will inject it automatically...hence it is auto wired.

Auto wiring injection Types
a) Constructor

Step 1: Define the dependency interface and class
Step 2: Create a constructor in your class for injections
Step 3: Configure the dependency injection with @Autowired Annotation.

Note: @Autowired annotation is not needed if a class has only one constructor, as per Spring 4.3+

b) Setter

Step 1: Create a setter method in your class for injections
Step 2: Configure the dependency injection with @Autowired annotation

c) Field (Java Reflection takes care of it)
Step 1: Configure the auto wiring directly on the field.

Note:
Choose one injection what you are comfortable with and make use of it consistent.
How to inject values from properties file?
@value("${asura.email}")
private String email;
**/
