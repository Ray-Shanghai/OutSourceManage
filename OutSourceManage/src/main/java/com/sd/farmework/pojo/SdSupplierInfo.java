package com.sd.farmework.pojo; 

import java.util.List;

import com.sd.farmework.common.BaseInfo; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
public class SdSupplierInfo extends BaseInfo{ 
	//供应商主键 
	private int supplierId; 
	//供应商地址 
	private String supplierName; 
	//供应商地址 
	private String supplierAddress; 
	//结算方式 
	private String balanceType; 
	//银行账号 
	private String bankAccount; 
	//开户人 
	private String accountHolder; 
	//开户行 
	private String openingBank; 
	//联系人
	private String contactName;
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	//手机
	private String mobilephone;
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	// 
	private String sdId; 
	
    public SdSupplierInfo(){
	}
    public SdSupplierInfo(int supplierId,String supplierName,String supplierAddress,String balanceType,String bankAccount,String accountHolder,String openingBank,String sdId){
		this.supplierId=supplierId;
		this.supplierName=supplierName;
		this.supplierAddress=supplierAddress;
		this.balanceType=balanceType;
		this.bankAccount=bankAccount;
		this.accountHolder=accountHolder;
		this.openingBank=openingBank;
		this.sdId=sdId;
	}
    public SdSupplierInfo(String supplierName,String supplierAddress,String balanceType,String bankAccount,String accountHolder,String openingBank,String sdId){
		this.supplierName=supplierName;
		this.supplierAddress=supplierAddress;
		this.balanceType=balanceType;
		this.bankAccount=bankAccount;
		this.accountHolder=accountHolder;
		this.openingBank=openingBank;
		this.sdId=sdId;
	}
	public void setsupplierId(int supplierId){ 
		this.supplierId=supplierId;
	}
	public int getsupplierId(){ 
		return this.supplierId;
	}
	public void setsupplierName(String supplierName){ 
		this.supplierName=supplierName;
	}
	public String getsupplierName(){ 
		return this.supplierName;
	}
	public void setsupplierAddress(String supplierAddress){ 
		this.supplierAddress=supplierAddress;
	}
	public String getsupplierAddress(){ 
		return this.supplierAddress;
	}
	public void setbalanceType(String balanceType){ 
		this.balanceType=balanceType;
	}
	public String getbalanceType(){ 
		return this.balanceType;
	}
	public void setbankAccount(String bankAccount){ 
		this.bankAccount=bankAccount;
	}
	public String getbankAccount(){ 
		return this.bankAccount;
	}
	public void setaccountHolder(String accountHolder){ 
		this.accountHolder=accountHolder;
	}
	public String getaccountHolder(){ 
		return this.accountHolder;
	}
	public void setopeningBank(String openingBank){ 
		this.openingBank=openingBank;
	}
	public String getopeningBank(){ 
		return this.openingBank;
	}
	public void setsdId(String sdId){ 
		this.sdId=sdId;
	}
	public String getsdId(){ 
		return this.sdId;
	}
	@Override
	public String toString() {
		return "SdSupplierInfo[supplierId=" + supplierId+",supplierName=" + supplierName+",supplierAddress=" + supplierAddress+",balanceType=" + balanceType+",bankAccount=" + bankAccount+",accountHolder=" + accountHolder+",openingBank=" + openingBank+",sdId=" + sdId+"]";
	}
}