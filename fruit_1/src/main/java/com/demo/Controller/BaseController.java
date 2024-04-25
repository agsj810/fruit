package com.demo.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.utils.JsonResult;


/**
 * 控制器类的基类
 */
@RestController
public class BaseController {

	/**
	 * 响应成功的标识码
	 */
	public static final int SUCCESS = 2000;

	/**
	 * 响应失败的标识码
	 */
	public static final int FAILURE = 0;

	/**
	 * 用户是否标记为已删除 0-否 1-是
	 */
	public static final Long STATUS = 0L;

	/**
	 * 从Session中获取当前登录的用户的operid
	 * 
	 * @param string Session对象
	 * @return 当前登录的用户的operid
	 */
	protected Long getIdFromSession(HttpSession session) {
		return (Long) (session.getAttribute("operid"));
	}

	/**
	 * 从Session中获取当前登录的用户的operName
	 * 
	 * @param string Session对象
	 * @return 当前登录的用户的operName
	 */
	protected String getNameFromSession(HttpSession session) {
		return session.getAttribute("operName").toString();
	}

	/**
	 * 从Session中获取当前用户的权限
	 * 
	 * @param session Session对象
	 * @return 当前用户的权限
	 */
	protected String getStatusFromSession(HttpSession session) {
		return session.getAttribute("status").toString();
	}


	/**
	 * 无用
	 * 
	 * @return
	 */
	@RequestMapping("test")
	public JsonResult<Void> UploadData() {
		return new JsonResult<Void>(SUCCESS);
	}

}
