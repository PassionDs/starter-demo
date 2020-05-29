/*
 * 四川生学教育科技有限公司
 * Copyright (c) 2015-2025 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 *
 */
package com.example.demo.bean.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

import java.util.Map;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/5/29 11:16
 */
public class RoutingBeanProxyFactory {

    private final static String DEFAULT_BEAN_NAME = "helloServiceImpl1";

    public static Object createProxy(String name, Class type, Map<String, Object> candidates) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(type);
        proxyFactory.addAdvice(new VersionRoutingMethodInterceptor(name, candidates));
        return proxyFactory.getProxy();
    }

    static class VersionRoutingMethodInterceptor implements MethodInterceptor {
        private Object targetObject;

        public VersionRoutingMethodInterceptor(String name, Map<String, Object> beans) {
            this.targetObject = beans.get(name);
            if (this.targetObject == null) {
                this.targetObject = beans.get(DEFAULT_BEAN_NAME);
            }
        }

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            return invocation.getMethod().invoke(this.targetObject, invocation.getArguments());
        }
    }
}