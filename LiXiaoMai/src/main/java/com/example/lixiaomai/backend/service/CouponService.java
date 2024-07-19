package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.CouponDAO;
import com.example.lixiaomai.backend.entity.Coupon;

public class CouponService {
    static CouponDAO couponDAO = new CouponDAO();

    public Coupon getAllInfoOfCoupon(int id){
        return couponDAO.getAllInfoOfCoupon(id);
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
