/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AccountDAO;
import entities.TblAccount;

/**
 *
 * @author TiTi
 */
public class AccountService {
    public TblAccount login(String email, String password) {
        AccountDAO accountDAO = new AccountDAO();
        TblAccount account = accountDAO.getAccountByEmail(email);
        
        if (account.getPassword().equals(password)) {
            return account;
        }
        return null;
    }
    public void register(TblAccount account){
        AccountDAO accountDAO = new AccountDAO();
        accountDAO.insertAccount(account);
    }
}
