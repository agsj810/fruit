//定义对象方法
var JDItemProp = {
	productid: "",
	categoryid: "",
}

//0到1之间
function validateInput(event) {
	const input = event.target;
	const value = parseFloat(input.value);

	// 如果值不是数字或者不在0到1之间，将值置空
	if (isNaN(value) || value < 0 || value > 1) {
		input.value = '';
	}
}

//大于或等于0的数字  
function validate(event) {
	const input = event.target;
	const value = parseFloat(input.value);

	// 如果值不是数字或者小于0，将值置空
	if (isNaN(value) || value < 0) {
		input.value = '';
	}
}

//模板下标
var templateIndex = 1;
var list = [];

var JDItem = {

	//重载点击
	reSetClick: function() {
		$("#reset").click(function() {
			location.reload()
		});
	}(),



	//结算
	sumType: function() {
		$("#sumType").click(function() {
			var mmoney = $('#mmoney').val();
			var jmoney = $('#jmoney').val();
			//默认值
			if (mmoney == "" || jmoney == "") {
				jmoney = 0;
				mmoney = 0;
			}
			if (mmoney < jmoney) {
				layer.msg("满元不能小于减元");
			}
			for (var i = 1; i <= templateIndex; i++) {
				var name = $('#brandName' + i).val();
				var price = $('#price' + i).val();
				var sale = $('#sale' + i).val();
				var amount = $('#amount' + i).val();
				//默认值
				if (sale == "") {
					sale = 1;
				}

				if (name == "" || price == "" || amount == "") {
					layer.msg("请核实，第" + i + "项的必填项");
					list.length = 0;
					return;
				}

				var map = {
					"name": name,
					"price": price,
					"sale": sale,
					"amount": amount
				};
				list.push(map);

			}
			var data = {
				"mmoney": mmoney,
				"jmoney": jmoney,
				"fruitList": list,
			};
			$.ajax({
				url: '/fruit/sum',
				type: 'POST',
				contentType: "application/json",
				data: JSON.stringify(data),
				success: function(json) {
					list.length = 0;
					layer.msg("总价：" + json.data + "元");

				},
				error: function(json) {

					list.length = 0;
					layer.msg("数据异常");
				}
			})
		});
	}(),

	//添加类型点击事件
	addType: function() {
		$('#addType').on('click', function() {
			//下标自增
			templateIndex++;
			JDItem.typetemplate(templateIndex);
		})
	}(),

	typetemplate: function(templateIndex) {
		let html = $(`<div class="layui-form-item type${templateIndex}" name="fruit${templateIndex}">
                                <div class="layui-inline1">
							    	<label class="layui-form-label"><span style="color: red;">*</span>商品名称</label>			    	
							    	<div class="layui-input-block">
							    		<input type="text" id="brandName${templateIndex}" placeholder="请输入" name="brandName${templateIndex}"  class="layui-input" >			    	
									</div>
							    </div>
							    <div class="layui-inline1">
									<label class="layui-form-label"><span style="color: red;">*</span>商品价格</label>
									<div class="layui-input-block">
										<input type="text" id="price${templateIndex}" placeholder="请输入数字" oninput="validate(event)"
											 name="price${templateIndex}" 
											class="layui-input">
									</div>
								</div>
				
								<div class="layui-inline1">
									<label class="layui-form-label">打折</label>
									<div class="layui-input-block">
										<input type="text" id="sale${templateIndex}" name="sale${templateIndex}" placeholder="请输入0到1之间的数" oninput="validateInput(event)"
											class="layui-input">
									</div>
								</div>
				
								<div class="layui-inline1">
									<label class="layui-form-label"><span style="color: red;">*</span>购买数量</label>
									<div class="layui-input-block">
										<input type="text" id="amount${templateIndex}" name="amount${templateIndex}" placeholder="请输入数字" oninput="validate(event)"
											class="layui-input">
									</div>
								</div>
                                <div class="layui-inline">
                                  <div class="layui-btn layui-btn-danger delType" lay-submit index="type${templateIndex}">删除</div>
                                </div>
                            </div>`);
		$('#addform').append(html);
		JDItem.deleteType();
	},
	//删除贺卡类型
	deleteType: function() {
		$('.delType').on('click', function() {
			let index = $(this).attr('index');
			let limittype = $('.' + index).attr('name');
			templateIndex--;
			$('.' + index).remove();
			$.each(greetingcarddtls, function(i, v) {
				if (v.limittype == limittype) {
					greetingcarddtls.splice(i, 1);
					return false;
				}
			});
			console.log(greetingcarddtls);
		})
	},

};