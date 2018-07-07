package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/10/13.
 *
 * invoiceType	String 	Y	发票类型：0.普通发票
 1.电子发票
 2.增值税发票
 invtelphone	String	Y	收票人联系电话
 invoiceName	String	Y	收票人姓名
 invAddress	String	Y	收票人地址
 companyName	String	N	公司名称
 companyAddress	String	N	公司地址
 companyPhone	String	N	公司电话
 bankName	String	N	银行名称
 companyAccount	String	N	公司银行账号
 taxCode	String	N	纳税人识别码
 title	String	N	抬头类型
 content	String	N	抬头内容
 *
 *
 */

public class TicketSubmitBean implements Serializable {
private String invoiceType;
private String invtelphone;
private String invoiceName;
private String invAddress;
private String companyName;
private String companyAddress;
private String companyPhone;
private String bankName;
private String companyAccount;
private String taxCode;
private String title;
private String content;


    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvtelphone() {
        return invtelphone;
    }

    public void setInvtelphone(String invtelphone) {
        this.invtelphone = invtelphone;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public String getInvAddress() {
        return invAddress;
    }

    public void setInvAddress(String invAddress) {
        this.invAddress = invAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TicketSubmitBean{" +
                "invoiceType='" + invoiceType + '\'' +
                ", invtelphone='" + invtelphone + '\'' +
                ", invoiceName='" + invoiceName + '\'' +
                ", invAddress='" + invAddress + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", bankName='" + bankName + '\'' +
                ", companyAccount='" + companyAccount + '\'' +
                ", taxCode='" + taxCode + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
