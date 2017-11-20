/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.mbean;

import com.iticket.ejb.AccountSessionBean;
import com.iticket.model.Account;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Irvin.Sanchez
 */
@ManagedBean
@RequestScoped
public class AccountMBean {
    
    @EJB
    private AccountSessionBean accountSessionBean;
    private Account account;
    
    public AccountMBean() {
    }
    
    public List<Account> getList() {
        return accountSessionBean.findAll();
    }
    
    public String showNew(){
        this.account = new Account();
        return "form";
    }
    
    public Account getDetail(){
        return account;
    }
    
    public String list(){
        return "list";
    }
    
    public String save(Account account){
        try{
            if(this.account.getIdAccount() != null){
                accountSessionBean.update(this.account);
            }else{
                accountSessionBean.persist(this.account);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        this.account = null;
        return "list";
    }
    
    public String delete(Account account){
        try{
            accountSessionBean.delete(account);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "list";
    }
    
    public Account getAccount(){
        return account;
    }
    
    public void setAccount(Account account){
        this.account = account;
    }
    
}
