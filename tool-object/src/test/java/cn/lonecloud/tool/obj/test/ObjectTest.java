package cn.lonecloud.tool.obj.test;

import cn.lonecloud.tools.obj.ObjectsUtils;
import org.junit.Test;

import java.util.Date;

/**
 * @author lonecloud
 * @version v1.0
 * @date 2018-09-17 20:23
 */
public class ObjectTest {

    @Test
    public void testSameEqual(){
        Demo demo=new Demo();
        demo.setAge(10);
        demo.setName("demo");
        Demo2 demo2=new Demo2();
        demo2.setAge(10);
        demo2.setName("demo2");
        Result nosSameObj = ObjectsUtils.getNosSameObj(demo, demo2, Result.class);
        System.out.println(nosSameObj);
    }

}
