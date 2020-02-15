/**
 * Copyright (C), 2018-2019,
 * FileName: MyHandler
 * Author:   Administrator
 * Date:     2019/8/24 20:52
 * Description:
 */
package JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

    private Object object;

    public MyHandler(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("代理前");
        Object invoke = method.invoke(object,args);

        System.out.println("代理后");
        return invoke;
    }
}