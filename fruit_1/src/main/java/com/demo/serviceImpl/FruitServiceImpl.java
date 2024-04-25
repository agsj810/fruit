package com.demo.serviceImpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.pojo.FruitList;
import com.demo.pojo.FruitVo;
import com.demo.service.FruitService;
import com.demo.utils.JsonResult;

@Service
public class FruitServiceImpl implements FruitService {

	@Override
	public JsonResult sum(FruitVo fruitVo) {
		BigDecimal sum = new BigDecimal(0);
		List<FruitList> fruitList = fruitVo.getFruitList();
		for (FruitList fruit : fruitList) {
			String name = fruit.getName();
			BigDecimal amount = new BigDecimal(fruit.getAmount());
			BigDecimal price = fruit.getPrice();
			BigDecimal sale = fruit.getSale();

			// 先算总价 = 水果数量*价格*几折
			BigDecimal fruitMoney = amount.multiply(price).multiply(sale);
			// 再算和
			sum = sum.add(fruitMoney);
		}
		// 满减
		BigDecimal totalPrice = new BigDecimal(0);
		BigDecimal mmoney = new BigDecimal(fruitVo.getMmoney());
		BigDecimal jmoney = new BigDecimal(fruitVo.getJmoney());
		if (mmoney.compareTo(BigDecimal.ZERO) != 0 && jmoney.compareTo(BigDecimal.ZERO) != 0) {
			// 一共便宜多少钱（sum/满元---取整）*减元
			totalPrice = sum.divideToIntegralValue(mmoney).multiply(jmoney);
		}

		BigDecimal result = sum.subtract(totalPrice);
		return new JsonResult(200, "成功", result);
	}

}
