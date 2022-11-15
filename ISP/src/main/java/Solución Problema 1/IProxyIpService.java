package com.chenerzhu.crawler.proxy.pool.service;

import com.chenerzhu.crawler.proxy.pool.entity.ProxyIp;

import java.util.List;

/**
 * Created by chenerzhu on 2018/8/30.
 */
public interface IProxyIpService {
    
    ProxyIp save(ProxyIp proxyIp);

    void batchUpdate(List<ProxyIp> proxyIpList);

    void update(ProxyIp proxyIp);

}
