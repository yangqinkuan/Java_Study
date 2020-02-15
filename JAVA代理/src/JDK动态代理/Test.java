/**
 * Copyright (C), 2018-2019,
 * FileName: Test
 * Author:   Administrator
 * Date:     2019/8/24 20:55
 * Description:
 */
package JDK动态代理;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Service serviceProxy = (Service) Proxy.newProxyInstance(Service.class.getClassLoader(),
                new Class[]{Service.class},new MyHandler(new MyService()));

        serviceProxy.sayHello();
        serviceProxy.sayBye();
    }
}