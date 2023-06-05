package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController");                                       /*Nome da Classe do Controlador*/

		String greeting = myController.sayHello();

		System.out.println(greeting);



		System.out.println("PropertyInjectedController Test ----------------------");

		/*Vai dar erro porque:
			1) Precisa de @Component
			2) Precisa de Autowired senao dá null pointer no Service	*/

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		propertyInjectedController.getGreeting();


		System.out.println("SetterInjectedController Test ----------------------");

		/*Vai dar erro porque:
			1) Precisa de @Component
			2) Precisa de Autowired senao dá null pointer no Service	*/

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		setterInjectedController.getGreeting();


		System.out.println("ConstructorInjectedController Test ----------------------");

		/*Vai dar erro porque:
			1) Precisa de @Component
			2) Precisa de Autowired senao dá null pointer no Service	*/

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		constructorInjectedController.getGreeting();

	}

}
