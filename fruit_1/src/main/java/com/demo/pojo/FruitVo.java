package com.demo.pojo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FruitVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2463434925129182370L;

	// 满元
	@NotNull(message = "满元必填")
	private Integer mmoney;

	// 减元
	@NotNull(message = "减元必填")
	private Integer jmoney;

	// 水果信息

	private List<FruitList> fruitList;

	public Integer getMmoney() {
		return mmoney;
	}

	public void setMmoney(Integer mmoney) {
		this.mmoney = mmoney;
	}

	public Integer getJmoney() {
		return jmoney;
	}

	public void setJmoney(Integer jmoney) {
		this.jmoney = jmoney;
	}

	public List<FruitList> getFruitList() {
		return fruitList;
	}

	public void setFruitList(List<FruitList> fruitList) {
		this.fruitList = fruitList;
	}

	@Override
	public String toString() {
		return "FruitVo [mmoney=" + mmoney + ", jmoney=" + jmoney + ", fruitList=" + fruitList + "]";
	}

}
