package com.service.user.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.base.BaseDao;
import com.entity.user.UserInfo;
import com.service.base.impl.BaseServiceImpl;
import com.service.user.UserService;
@Service
public class UserServiceImpl extends BaseServiceImpl<UserInfo> implements UserService{
	@Autowired
    private BaseDao<UserInfo> userInfoDao;
	@Override
	public UserInfo findUserInfoByPhone(String userPhone) {
		String hql = "from UserInfo u where u.userPhone =:phone";
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("phone", userPhone);
		List<UserInfo> listUser = userInfoDao.find(hql, params, 1,1);
		if(listUser == null  || listUser.size() <= 0){
			return  null;
			}
		return listUser.get(0);
	}
           
}
