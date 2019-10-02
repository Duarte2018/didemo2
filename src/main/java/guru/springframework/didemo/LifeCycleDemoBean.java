package guru.springframework.didemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean  implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware,
        ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println(">>>Instantiate: LifecyleBean constructor");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(">>>setBeanFactoryAware: LifecyleBean beanFactory set");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println(">>>setbeanName aware: LifecyleBean name: " + s);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(">>>LifecyleBean destruction");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(">>>LifecyleBean after properties set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(">>>LifecyleBean setApplicationContext");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println(">>>LifecyleBean postConstruct method call");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println(">>>LifecyleBean preDestroy method call");
    }

    public void beforeInit(){
        System.out.println(">>> Pre Initialization (Bean PostProcessor): LifecyleBean beforeInit method call");
    }

    public void afterInit(){
        System.out.println(">>> Post Initialization (Bean PostProcessor): LifecyleBean afterInit method call");
    }
}
