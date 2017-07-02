package com.rsuser.utils;

import com.rsuser.domain.User.ROLE;
import com.rsuser.domain.User;

public class Constant {
	/**
	 * 用户角色
	 */
	public final static ROLE HAS_AUTH_STATUS = User.ROLE.USER;
	
	public final static ROLE UN_AUTH_STATUS = User.ROLE.VISITOR;
}
