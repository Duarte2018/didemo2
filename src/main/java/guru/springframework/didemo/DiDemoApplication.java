package guru.springframework.didemo;

import guru.springframework.didemo.beans.FakeDataSource;
import guru.springframework.didemo.beans.FakeJmsBroker;
import guru.springframework.didemo.controllers.ConstructorInjectedController;
import guru.springframework.didemo.controllers.GetterInjectedController;
import guru.springframework.didemo.controllers.MyController;
import guru.springframework.didemo.controllers.PropertyInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");

        System.out.println(controller.hello());
        System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());

        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);

        System.out.println("\nfakedatasource properties: "+fakeDataSource.getUser() +" - "+fakeDataSource.getUrl()+"\n");

        FakeJmsBroker jmsBroker = ctx.getBean(FakeJmsBroker.class);

        System.out.println("\nJMS broker properties: "+jmsBroker.getUsername() +" - "+jmsBroker.getUrl()+"\n");
    }

}
