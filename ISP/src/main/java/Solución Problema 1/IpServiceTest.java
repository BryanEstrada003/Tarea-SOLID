package com.chenerzhu.crawler.proxy.pool.service;

import com.chenerzhu.crawler.proxy.pool.entity.ProxyIp;

import java.util.List;

/**
 * Created by chenerzhu on 2018/8/30.
 */
public interface IpServiceTest extends IProxyIpService{
    
    boolean testIp(String ip, int port);

    boolean testIp(String ip, int port, String type);
}
