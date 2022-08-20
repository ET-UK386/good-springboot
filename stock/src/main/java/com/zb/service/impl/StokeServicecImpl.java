package com.zb.service.impl;

import com.zb.mapper.StokeMapper;
import com.zb.pojo.*;
import com.zb.service.StokeServicec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StokeServicecImpl implements StokeServicec {

    @Autowired(required = false)
    private StokeMapper stokeMapper;

    @Override
    public List<Purchase> listPurchase() {
        return stokeMapper.listPurchase();
    }

    @Override
    public List<DetailedPurchase> listPurchaseDetailedPurchaseBylistPurchaseId(Long id) {
        return stokeMapper.listPurchaseDetailedPurchaseBylistPurchaseId(id);
    }

    @Override
    public Integer listMaxPurchaseId() {
        return stokeMapper.listMaxPurchaseId();
    }

    @Override
    public Integer addPurchase(Purchase p) {
        return stokeMapper.addPurchase(p);
    }

    @Override
    public List<DetailedPurchase> listPurchaseDetailedPurchase() {
        return stokeMapper.listPurchaseDetailedPurchase();
    }

    @Override
    public Integer addDetailedPurchase(DetailedPurchase d) {
        return stokeMapper.addDetailedPurchase(d);
    }

    @Override
    public List<Goodsku> listGoodSku() {
        return stokeMapper.listGoodSku();
    }

    @Override
    public Price listPriceById(Integer id) {
        return stokeMapper.listPriceById(id);
    }

    @Override
    public Goodsku listGoodSkuById(Integer id) {
        return stokeMapper.listGoodSkuById(id);
    }

    @Override
    public List<Vendor> listVendor() {
        return stokeMapper.listVendor();
    }
}
