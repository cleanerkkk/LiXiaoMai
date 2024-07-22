package com.example.lixiaomai.backend.service;

import com.example.lixiaomai.backend.dao.WalletDao;
import com.example.lixiaomai.backend.entity.Coupon;
import com.example.lixiaomai.backend.entity.Wallet;

public class WalletService {
    static WalletDao walletDAO = new WalletDao();

    public Wallet getWalletById(int id){
        return walletDAO.getWalletById(id);
    }

    public boolean addWallet(Wallet wallet){
        return walletDAO.addWallet(wallet);
    }

    public boolean delWalletById(int id){
        return walletDAO.delWalletById(id);
    }

    public boolean updatePasswordById(int id,String newPassword){
        return walletDAO.updatePasswordById(id, newPassword);
    }

    public boolean updateBalanceById(int id, double newBalance){
        return walletDAO.updateBalanceById(id, newBalance);
    }

    public boolean addCouponById(int id, Coupon coupon){
        return walletDAO.addCouponById(id, coupon);
    }
}
