/**
 * Copyright (C), 2018-2019,
 * FileName: MyService
 * Author:   Administrator
 * Date:     2019/8/24 20:56
 * Description:
 */
package JDK动态代理;

public class MyService implements Service {

    @Override
    public void sayHello() {
        System.out.println("你好");
    }

    @Override
    public void sayBye() {
        System.out.println("再见");
    }
}