package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.CouponDao;
import com.example.lixiaomai.backend.entity.Coupon;

public class CouponService {
    static CouponDao couponDAO = new CouponDao();

    public Coupon getCouponById(int id){
        return couponDAO.getCouponById(id);
    }

    public boolean addCoupon(Coupon coupon){
        return couponDAO.addCoupon(coupon);
    }

    public boolean delCoupon(int id){
        return couponDAO.delCoupon(id);
    }

    public boolean updateLimitById(int id, int newLimit){
        return couponDAO.updateLimitById(id, newLimit);
    }

    public boolean updateDiscountById(int id,double newDiscount){
        return couponDAO.updateDiscountById(id, newDiscount);
    }
}
