package hot.head.myAnnotationBeanPostProcessor;

import hot.head.annotation.MyInjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class InjectMyRamdomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields){
            MyInjectRandomInt myInjectRandomInt = field.getAnnotation(MyInjectRandomInt.class);
            if (myInjectRandomInt != null){
                int min = myInjectRandomInt.min();
                int max = myInjectRandomInt.max();
                Random random = new Random();
                int i = min + random.nextInt(max - min);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, i);
            }
        }
        return bean;
    }
}
