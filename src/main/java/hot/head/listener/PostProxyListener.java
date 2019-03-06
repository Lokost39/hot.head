package hot.head.listener;

//import com.sun.java.util.jar.pack.Package;
import hot.head.annotation.PostProxy;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.type.MethodMetadata;
import org.springframework.stereotype.Component;
//import org.springframework.core.type.MethodData;

import java.lang.reflect.Method;

@Component
public class PostProxyListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        String[] names = applicationContext.getBeanDefinitionNames();

        for (String name: names){
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);

            if (beanDefinition instanceof AnnotatedBeanDefinition){
                MethodMetadata factoryMethodData = ((AnnotatedBeanDefinition)beanDefinition).getFactoryMethodMetadata();
                if(factoryMethodData != null){
                    String originalClassName = factoryMethodData.getReturnTypeName();// извлекает интерфейс
//                    String originalClassName = factoryMethodData.getDeclaringClassName();
                    startBeanPostProxy(applicationContext, name, originalClassName);
                }
            }else{
                String originalClassName = beanDefinition.getBeanClassName();
                startBeanPostProxy(applicationContext, name, originalClassName);
            }
        }
    }

    private void startBeanPostProxy(ApplicationContext applicationContext, String name, String originalClassName) {
        try {
            Class<?> originalClass = Class.forName(originalClassName);
            Method[] methods = originalClass.getMethods();
            for (Method method : methods){
                if (method.isAnnotationPresent(PostProxy.class)) {

                    Object bean = applicationContext.getBean(name);
                    Method currentMethod = bean.getClass().getMethod(method.getName(),method.getParameterTypes());
                    currentMethod.invoke(bean);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
