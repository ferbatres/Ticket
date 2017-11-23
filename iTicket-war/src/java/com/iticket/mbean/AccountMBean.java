/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.mbean;

import com.iticket.ejb.AccountSessionBean;
import com.iticket.model.Account;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;


/**
 *
 * @author Irvin.Sanchez
 */
@ManagedBean(name = "accountMBean")
@RequestScoped
public class AccountMBean {

    private static final long SerialVersionUIDAdder = 1l;

    @EJB
    private AccountSessionBean accountSessionBean;
    private Account account = new Account();
    private List<Account> accountList;

    public AccountMBean() {
    }

    @PostConstruct
    public void init() {
        accountList = accountSessionBean.findAll();
    }

    public List<Account> getList() {
        return accountList;
    }

    public String showNew() {
        this.account = new Account();
        return "form_account";
    }

    public Account getDetail() {
        return account;
    }

    public String showList() {
        return "list_account.xhtml";
    }

    public String showUpdate(Account account) {
        this.account = account;
        return "form_account";
    }
    
     public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        try {
            accountSessionBean.update(accountList.get(event.getRowIndex()));
            if (newValue != null && !newValue.equals(oldValue)) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String save() {
        try {
            if (this.account.getIdAccount() != null) {
                accountSessionBean.update(this.account);
            } else {
                accountSessionBean.persist(this.account);
            }
            return "list_account";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String delete(Account account) {
        try {
            accountSessionBean.delete(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list_account.xhtml";
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

}
