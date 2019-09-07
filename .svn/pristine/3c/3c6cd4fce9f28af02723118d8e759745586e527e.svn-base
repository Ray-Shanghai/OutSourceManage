package com.sd.farmework.service.impl; 

import com.sd.farmework.pojo.SdSupplierContact;
import com.sd.farmework.pojo.SdSupplierInfo;
import com.sd.farmework.service.SdSupplierInfoService; 

import org.springframework.stereotype.Service; 

import com.sd.farmework.common.util.StringUtil;
import com.sd.farmework.mapper.SdSupplierContactMapper;
import com.sd.farmework.mapper.SdSupplierInfoMapper; 

import org.springframework.beans.factory.annotation.Autowired; 

/** 
 * test
 * @author Administrator 
 * 
 */ 
 @Service
public class SdSupplierInfoServiceImpl extends BaseInfoServiceImpl implements SdSupplierInfoService{ 
    private static final boolean String = false;
	@Autowired
    private SdSupplierInfoMapper baseMapper;
    public SdSupplierInfoMapper getBaseMapper(){
     return baseMapper;
    }
    public void setBaseMapper(SdSupplierInfoMapper baseMapper){
    	this.baseMapper = baseMapper;
    }
    
    @Autowired
    private SdSupplierContactMapper baseContactMapper;
	@Override
	public void add(SdSupplierInfo sdsupplierinfo,SdSupplierContact sdsuppliercontact) {
		try {
			//添加供应商信息
			baseMapper.addForMysql(sdsupplierinfo);
			//添加供应商联系人信息
			String [] isDefault = sdsuppliercontact.getisDefault().split(",");
			for(int i = 0;i< isDefault.length;i++){
				SdSupplierContact contact = new SdSupplierContact();
				contact.setsupplierId(sdsupplierinfo.getsupplierId());
				contact.setcontactName(sdsuppliercontact.getcontactName().split(",")[i]);
				contact.settelephone(sdsuppliercontact.gettelephone().split(",")[i]);
				contact.setmobilephone(sdsuppliercontact.getmobilephone().split(",")[i]);
				contact.setemail(sdsuppliercontact.getemail().split(",")[i]);
				contact.setqq(sdsuppliercontact.getqq().split(",")[i]);
				contact.setwechat(sdsuppliercontact.getwechat().split(",")[i]);
				contact.setisDefault(sdsuppliercontact.getisDefault().split(",")[i]);
				contact.setCreateUserId(sdsuppliercontact.getCreateUserId());
				contact.setCreateUserName(sdsuppliercontact.getCreateUserName());
				contact.setCreateDepartId(sdsuppliercontact.getCreateDepartId());
				contact.setCreateDepartName(sdsuppliercontact.getCreateDepartName());
				baseContactMapper.addForMysql(contact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(SdSupplierInfo sdsupplierinfo,SdSupplierContact sdsuppliercontact,String hidDelContactId) {
		try {
			//修改供应商信息
			baseMapper.updateForMysql(sdsupplierinfo);
			//修改供应商联系人信息
			String [] isDefault = sdsuppliercontact.getisDefault().split(",");
			for(int i = 0;i< isDefault.length;i++){
				SdSupplierContact contact = new SdSupplierContact();
				if(sdsuppliercontact.getcontactId() != null){
					contact.setcontactId(sdsuppliercontact.getcontactId().split(",")[i]);
				}else{
					contact.setcontactId("-1");
				}
				contact.setsupplierId(sdsupplierinfo.getsupplierId());
				contact.setcontactName(sdsuppliercontact.getcontactName().split(",")[i]);
				contact.settelephone(sdsuppliercontact.gettelephone().split(",")[i]);
				contact.setmobilephone(sdsuppliercontact.getmobilephone().split(",")[i]);
				contact.setemail(sdsuppliercontact.getemail().split(",")[i]);
				contact.setqq(sdsuppliercontact.getqq().split(",")[i]);
				contact.setwechat(sdsuppliercontact.getwechat().split(",")[i]);
				contact.setisDefault(sdsuppliercontact.getisDefault().split(",")[i]);
				if(contact.getcontactId().equals("-1")){
					contact.setCreateUserId(sdsuppliercontact.getCreateUserId());
					contact.setCreateUserName(sdsuppliercontact.getCreateUserName());
					contact.setCreateDepartId(sdsuppliercontact.getCreateDepartId());
					contact.setCreateDepartName(sdsuppliercontact.getCreateDepartName());
					baseContactMapper.addForMysql(contact);
				}else{
					contact.setLastUpdateUserId(sdsuppliercontact.getLastUpdateUserId());
					contact.setLastUpdateUserName(sdsuppliercontact.getLastUpdateUserName());
					contact.setLastUpdateDepartId(sdsuppliercontact.getLastUpdateDepartId());
					contact.setLastUpdateDepartName(sdsuppliercontact.getLastUpdateDepartName());
					baseContactMapper.updateForMysql(contact);
				}
			}
			String[] str = hidDelContactId.split(",");
			for (String id : str) {
				SdSupplierContact contact = new SdSupplierContact();
				if(StringUtil.isNotNullOrBlank(id))
				{
					contact.setcontactId(id);
					baseContactMapper.deleteForMysql(contact);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(SdSupplierInfo sdsupplierinfo){
		try {
			//删除供应商信息
			baseMapper.deleteForMysql(sdsupplierinfo);
			
			SdSupplierContact contact = new SdSupplierContact();
			contact.setsupplierId(sdsupplierinfo.getsupplierId());
			//删除供应商联系人信息
			baseContactMapper.deleteForMysql(contact);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}