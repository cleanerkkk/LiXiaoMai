package com.example.lixiaomai.backend.tools;

import com.example.lixiaomai.backend.entity.Wallet;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

public class WalletResultSetHandler implements ResultSetHandler<List<Wallet>> {
    @Override
    public List<Wallet> handle(ResultSet rs) throws SQLException {
        List<Wallet> wallets = new ArrayList<>();
        while(rs.next()){
            Wallet wallet = new Wallet();
            wallet.setId(rs.getInt("id"));
            wallet.setPassword(rs.getString("password"));
            wallet.setBalance(rs.getDouble("balance"));

            wallet.setDId(Tool.StringToList(rs.getString("dId"), Integer.class));
            wallet.setDiscountNum(Tool.StringToList(rs.getString("DISCOUNTNUM"), Integer.class));
            wallets.add(wallet);
        }
        return wallets;
    }
}
