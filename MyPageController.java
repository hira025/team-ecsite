package jp.co.internous.gaia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import jp.co.internous.gaia.model.domain.MstUser;
import jp.co.internous.gaia.model.mapper.MstUserMapper;
import jp.co.internous.gaia.model.session.LoginSession;

@Controller
@RequestMapping("/gaia/mypage")
public class MyPageController {
	
//セッション	
	@Autowired
	private LoginSession loginSession;
	
//ユーザー情報
	@Autowired
	private MstUserMapper userMapper;
	
	
	@RequestMapping("/")
//ログイン中のユーザー情報を取得
	public String index(Model m) {	
		MstUser user = userMapper.findByUserNameAndPassword(loginSession.getUserName(), loginSession.getPassword());
		m.addAttribute("user",user);
		m.addAttribute("loginSession",loginSession);
		return "my_page";
	}
}
