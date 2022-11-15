package com.chenerzhu.crawler.proxy.pool.service.impl;

import com.chenerzhu.crawler.proxy.pool.entity.ProxyIp;
import com.chenerzhu.crawler.proxy.pool.repository.IProxyIpRepository;
import com.chenerzhu.crawler.proxy.pool.util.ProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import com.chenerzhu.crawler.proxy.pool.service.*;

/**
 * @author chenerzhu
 * @create 2018-08-30 19:05
 **/
@Service("proxyIpService")
public class ProxyIpServiceTestImpl implements IpServiceTest {
    @Autowired
    private IProxyIpRepository proxyIpRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ProxyIp save(ProxyIp proxyIp) {
        return proxyIpRepository.save(proxyIp);
    }

    /*@Transactional(rollbackFor = Exception.class)*/
    @Override
    public void batchUpdate(List<ProxyIp> proxyIpList) {
        for(int i = 0; i < proxyIpList.size(); i++) {
            update(proxyIpList.get(i));
        }
    }
    @Override
    public void update(ProxyIp proxyIp){
        proxyIpRepository.update(proxyIp.isAvailable(),
                proxyIp.getAvailableCount(),
                proxyIp.getAvailableRate(),
                proxyIp.getLastValidateTime(),
                proxyIp.getRequestTime(),
                proxyIp.getResponseTime(),
                proxyIp.getUnAvailableCount(),
                proxyIp.getUseTime(),
                proxyIp.getValidateCount(),
                proxyIp.getId()
        );

    }

    @Override
    public boolean testIp(String ip, int port){
        boolean available= ProxyUtils.validateIp(ip,port, ProxyUtils.ProxyType.HTTP);
        if(!available){
            available= ProxyUtils.validateIp(ip,port, ProxyUtils.ProxyType.HTTPS);
        }
        return available;
    }
    @Override
    public boolean testIp(String ip, int port, String type){
        if("http".equalsIgnoreCase(type)){
            return ProxyUtils.validateIp(ip,port, ProxyUtils.ProxyType.HTTP);
        }else{
            return ProxyUtils.validateIp(ip,port, ProxyUtils.ProxyType.HTTPS);
        }

    }
}