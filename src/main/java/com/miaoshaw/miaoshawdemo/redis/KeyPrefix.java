package com.miaoshaw.miaoshawdemo.redis;

public interface KeyPrefix {
    public int expireSeconds();

    public String getPrefix();
}
