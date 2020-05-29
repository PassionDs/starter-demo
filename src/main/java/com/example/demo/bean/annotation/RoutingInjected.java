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
package com.example.demo.bean.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author di.mao
 * @version 1.0
 * Copyright: Copyright (c) 2020
 * @date 2020/5/29 11:14
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RoutingInjected {
    String value() default "helloServiceImpl1";
}
