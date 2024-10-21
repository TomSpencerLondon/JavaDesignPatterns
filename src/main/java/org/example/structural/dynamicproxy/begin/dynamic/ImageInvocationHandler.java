package org.example.structural.dynamicproxy.begin.dynamic;

import javafx.geometry.Point2D;
import org.example.structural.dynamicproxy.begin.Image;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//Implement invocation handler. Your "proxy" code goes here.
public class ImageInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method setLocationMethod = Image.class.getMethod("setLocation", new Class[]{Point2D.class});

        if (setLocationMethod.equals(method)) {
            Point2D point2D = (Point2D) args[0];
            System.out.println("*******");
            System.out.println(point2D);
            System.out.println("*******");
        }

        return null;
    }
}
