package cn.lonecloud.tool.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取上下文对象工具类
 * @author xujiaxing
 * @date 2018/7/31 9:44
 * @version v1.0
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }


    /**
     * 获取上下文对象
     * @return 返回Spring上下文对象
     */
    public static ApplicationContext getContext(){
        return context;
    }

    /**
     * 通过Bean类型直接获取Bean实例
     * @param clazz bean的类型
     * @param <T>
     * @return 返回Bean实例
     */
    public static <T> T getBean(Class<T> clazz){
        return context.getBean(clazz);
    }

    /**
     * 通过name值获取Bean实例
     * @param beanName bean全类名
     * @param <T>
     * @return 返回Bean实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName){
        return (T) context.getBean(beanName);
    }

}
