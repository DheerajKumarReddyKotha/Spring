package com.asura.spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asura.spring.autowire.Animals;
import com.asura.spring.autowire.TestAutowire;

public class TestSpringApp {

	public static void main(String[] args) {
		//load spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		TestFortuneImpl testFortuneImpl = context.getBean("testFortuneImpl", TestFortuneImpl.class);

		
		System.out.println(testFortuneImpl.getFortune());
		System.out.println(testFortuneImpl.getFortune());
		System.out.println(testFortuneImpl.getFortune());
		
		Animals animals = context.getBean("pig", Animals.class);
		
		System.out.println(animals.getColor());
		
		TestAutowire testAuto = context.getBean("testAutowire", TestAutowire.class);
		System.out.println(testAuto.getAnimalColor());
		
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

**/
