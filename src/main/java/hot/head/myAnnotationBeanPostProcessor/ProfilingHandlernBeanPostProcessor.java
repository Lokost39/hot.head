package hot.head.myAnnotationBeanPostProcessor;

import hot.head.annotation.MyProfile;
import hot.head.annotation.controllers.ProfilengController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProfilingHandlernBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> map = new HashMap<>();
    private ProfilengController profilengController = new ProfilengController();

    public ProfilingHandlernBeanPostProcessor() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(profilengController, new ObjectName("profiling", "name", "controler"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(MyProfile.class)){

            map.put(beanName, beanClass);
        }
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = map.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if(profilengController.isEnable()){
                        System.out.println("Прошилирую...");
                        Object retVal = method.invoke(bean, args);
                        System.out.println("ВсЁ!!!");
                        return retVal;
                    }else {
                        return method.invoke(bean, args);
                    }

                }
            });
        }
        return bean;
    }
}
