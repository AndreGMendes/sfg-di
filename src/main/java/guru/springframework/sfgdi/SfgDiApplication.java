package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController");                                       /*Nome da Classe do Controlador*/


		System.out.println("---------------------- MyController Test");
		System.out.println(myController.sayHello());


		System.out.println("---------------------- PropertyInjectedController Test");

		/*Vai dar erro porque:
			1) Precisa de @Component
			2) Precisa de Autowired senao dá null pointer no Service	*/

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());


		System.out.println("---------------------- SetterInjectedController Test");

		/*Vai dar erro porque:
			1) Precisa de @Component
			2) Precisa de Autowired senao dá null pointer no Service	*/

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());


		System.out.println("---------------------- ConstructorInjectedController Test");

		/*Vai dar erro porque:
			1) Precisa de @Component
			2) Precisa de Autowired senao dá null pointer no Service	*/

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());


		System.out.println("---------------------- I18nController Test");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayGreeting());

	}

}
