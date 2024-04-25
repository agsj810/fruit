package com.demo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pojo.FruitVo;
import com.demo.service.FruitService;
import com.demo.utils.JsonResult;

@RestController
@RequestMapping("fruit")
public class FruitControllrt extends BaseController {
	@Autowired
	private FruitService fruitService;

	@RequestMapping(value = "/sum", method = RequestMethod.POST, consumes = "application/json")
	public JsonResult sum(@RequestBody @Valid FruitVo fruitVo) {

		return fruitService.sum(fruitVo);
	}
}
