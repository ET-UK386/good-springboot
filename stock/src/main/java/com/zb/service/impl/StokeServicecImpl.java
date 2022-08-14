package com.zb.service.impl;

import com.zb.mapper.StokeMapper;
import com.zb.pojo.DetailedPurchase;
import com.zb.pojo.Purchase;
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
    public List<DetailedPurchase> listPurchaseDetailedPurchaseBylistPurchaseId(Integer id) {
        return stokeMapper.listPurchaseDetailedPurchaseBylistPurchaseId(id);
    }

    @Override
    public List<DetailedPurchase> listPurchaseDetailedPurchase() {
        return stokeMapper.listPurchaseDetailedPurchase();
    }
}
