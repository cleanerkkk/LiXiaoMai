package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.CouponDao;
import com.example.lixiaomai.backend.entity.Coupon;

import java.util.List;

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

    public List<Coupon> getAllCouponsByIdList(List<Integer> list){
        return couponDAO.getAllCouponsByIdList(list);
    }

    public double calculateDiscount(List<Integer> discountId, List<Integer> discountNum){
        if (discountId == null)
            return 0;
        double total = 0;
        for (int i = 0; i < discountId.size(); i++) {
            Coupon coupon = getCouponById(discountId.get(i));
            total += coupon.getDiscount() * discountNum.get(i);
        }
        return total;
    }
}
