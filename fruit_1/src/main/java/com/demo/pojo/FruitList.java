package com.demo.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FruitList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4605246995077508741L;

	// 商品名称
	@NotBlank
	private String name;

	// 商品价格
	@NotNull
	private BigDecimal price;

	// 打折
	@NotNull
	private BigDecimal sale;

	// 购买数量
	@NotNull
	private Integer amount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSale() {
		return sale;
	}

	public void setSale(BigDecimal sale) {
		this.sale = sale;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
