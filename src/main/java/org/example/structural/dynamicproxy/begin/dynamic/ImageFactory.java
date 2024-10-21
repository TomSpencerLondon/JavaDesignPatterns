package org.example.structural.dynamicproxy.begin.dynamic;

import org.example.structural.dynamicproxy.begin.Image;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class ImageFactory {

    public static Image getImage() {
        return (Image) Proxy.newProxyInstance(
                org.example.structural.dynamicproxy.begin.ImageFactory.class.getClassLoader(),
                new Class[]{Image.class},
                new ImageInvocationHandler());
    }
}