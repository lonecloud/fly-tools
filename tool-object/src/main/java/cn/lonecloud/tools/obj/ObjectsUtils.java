package cn.lonecloud.tools.obj;

import cn.lonecloud.tools.obj.exception.ObjectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Object 工具类
 *
 * @author lonecloud
 * @version v1.0
 * @date 2018-09-17 19:46
 */
public class ObjectsUtils {

    private static Logger logger = LoggerFactory.getLogger(ObjectsUtils.class);

    /**
     * @param from
     * @param dist
     * @param clazz
     * @param <T>
     * @return
     */
    public static  <T> T getNosSameObj(Object from, Object dist, Class<T> clazz) {
        final T result = getInstance(clazz);
        Field[] fromFields = from.getClass().getDeclaredFields();
        Field[] distFields = dist.getClass().getDeclaredFields();
        List<String> sameNameList = new ArrayList<>();
        //获取相同Field
        for (Field field : fromFields) {
            String name = field.getName();
            for (Field fromField : distFields) {
                String fromName = fromField.getName();
                if (fromName.equals(name)) {
                    sameNameList.add(name);
                    break;
                }
            }
        }
        //然后进行比较咯
        sameNameList.forEach(name -> {
            PropertyDescriptor fromPd, distPd, resultPd;
            try {
                fromPd = new PropertyDescriptor(name, from.getClass());
                distPd = new PropertyDescriptor(name, dist.getClass());
                resultPd = new PropertyDescriptor(name, clazz);
                //获取对象
                Method fromMethod = fromPd.getReadMethod();
                Method distMethod = distPd.getReadMethod();
                Method writeMethod = resultPd.getWriteMethod();
                Object o1 = fromMethod.invoke(from);
                Object o2 = distMethod.invoke(dist);
                //比较
                if (Objects.nonNull(o1) && Objects.nonNull(o2) && o1.equals(o2)) {
                    writeMethod.invoke(result, o1);
                }
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        return result;
    }

    public static <T> T getInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error("can't new Instance a object{}", clazz.getName());
            throw new ObjectException("can't new Instance a object", e);
        }
    }
}
