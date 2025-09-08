package com.xqcode.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dengxingquan
 * @date 2025-09-08 11:14
 * @description 用户类，使用链式调用构建对象
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private String address;

    // 1. 静态方法 builder()
    public static User builder() {
        return new User();
    }

    // 2. 链式调用
    public User name(String name) {
        this.name = name;
        return this;
    }
    public User age(int age) {
        this.age = age;
        return this;
    }
    public User address(String address) {
        this.address = address;
        return this;
    }
    // 3. 构建对象
    public User build() {
        return this;
    }
}
