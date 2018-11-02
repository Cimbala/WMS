<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
	var search_type = "none";
	var search_keyWord = "";
	var selectID;

	$(function() {
		optionAction();
		searchAction();
		orderInListInit();
		bootstrapValidatorInit();

		addOrderinAction();
		editOrderinAction();
		deleteOrderinAction();
	})

	// 下拉框選擇動作
	function optionAction() {
		$(".dropOption").click(function() {
			var type = $(this).text();
			$("#search_input").val("");
			if (type == "所有") {
				$("#search_input").attr("readOnly", "true");
                search_type = "searchAll";
			} else if (type == "进货单号") {
				$("#search_input").removeAttr("readOnly");
                search_type = "searchByOID";
			}else if (type == "供应商ID") {
                $("#search_input").removeAttr("readOnly");
                search_type = "searchBySID";
            } else if (type == "货物ID") {
				$("#search_input").removeAttr("readOnly");
                search_type = "searchByGID";
			} else if (type == "负责人名称") {
                $("#search_input").removeAttr("readOnly");
                search_type = "searchByName";
            } else {
				$("#search_input").removeAttr("readOnly");
			}

			$("#search_type").text(type);
			$("#search_input").attr("placeholder", type);
		})
	}

	// 搜索动作
	function searchAction() {
		$('#search_button').click(function() {
			search_keyWord = $('#search_input').val();
			tableRefresh();
		})
	}

	// 分页查询参数
	function queryParams(params) {
		var temp = {
			limit : params.limit,
			offset : params.offset,
			searchType : search_type,
			keyWord : search_keyWord
		}
		return temp;
	}

	// 表格初始化
	function orderInListInit() {
		$('#orderInList')
				.bootstrapTable(
						{
							columns : [
									{
										field : 'orderInId',
										title : '进货单号'
									},
									{
										field : 'orderInSupplierid',
										title : '供应商ID'
									},
                                    {
                                        field : 'supplierName',
                                        title : '供应商名称'
                                        //,visible : false
                                    },
									{
										field : 'orderInGoodid',
										title : '货物ID'
									},
                                    {
                                        field : 'goodName',
                                        title : '货物名称'
                                        //,visible : false
                                    },
									{
										field : 'orderInNumber',
										title : '货物数量'
									},
									{
										field : 'orderInPersion',
										title : '负责人'
										//,visible : false
									},
									{
										field : 'orderInTime',
										title : '订单时间',
                                        formatter : function (value, row, index) {
										    var datestr=new Date(parseInt(value)).toLocaleString();
										    //console.info(datestr);
                                            return datestr.substr(0,10);
                                        }
                                    },
									{
										field : 'operation',
										title : '操作',
										formatter : function(value, row, index) {
											var s = '<button class="btn btn-info btn-sm edit"><span>编辑</span></button>';
											var d = '<button class="btn btn-danger btn-sm delete"><span>删除</span></button>';
											var fun = '';
											return s + ' ' + d;
										},
										events : {
											// 操作列中编辑按钮的动作
											'click .edit' : function(e, value,
													row, index) {
												selectID = row.orderInId;
                                                console.info('selectID:'+selectID);
												rowEditOperation(row);
											},
											'click .delete' : function(e,
													value, row, index) {
												selectID = row.orderInId;
												$('#deleteWarning_modal').modal(
														'show');
											}
										}
									} ],
							url : 'orderInManage/getOrderInList',
							onLoadError:function(status){
								handleAjaxError(status);
							},
							method : 'GET',
							queryParams : queryParams,
							sidePagination : "server",
							dataType : 'json',
							pagination : true,
							pageNumber : 1,
							pageSize : 5,
							pageList : [ 5, 10, 25, 50, 100 ],
							clickToSelect : true
						});
	}

	// 表格刷新
	function tableRefresh() {
		$('#orderInList').bootstrapTable('refresh', {
			query : {}
		});
	}

	// 行编辑操作
	function rowEditOperation(row) {
		$('#edit_modal').modal("show");

		// load info
		$('#orderin_form_edit').bootstrapValidator("resetForm", true);
		$('#oid_edit').val(selectID);
		$('#sid_edit').val(row.orderInSupplierid);
		$('#gid_edit').val(row.orderInGoodid);
		$('#gnum_edit').val(row.orderInNumber);
		$('#name_edit').val(row.orderInPersion);
	}

	// 添加供应商模态框数据校验
	function bootstrapValidatorInit() {
		$("#orderin_form,#orderin_form_edit").bootstrapValidator({
			message : 'This is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			excluded : [ ':disabled' ],
			fields : {
				oid : {
					validators : {
						notEmpty : {
							message : '进货单号不能为空'
						},
                        regexp : {
                            regexp : '^\\d+$',
                            message : '进货单号必须是纯数字'
                        }
					}
				},
				sid : {
					validators : {
						notEmpty : {
							message : '供应商ID不能为空'
						},
                        regexp : {
                            regexp : '^\\d+$',
                            message : '供应商ID必须是纯数字'
                        }
					}
				},
				gid : {
					validators : {
						notEmpty : {
							message : '货物ID不能为空'
						},
						regexp : {
							regexp : '^\\d+$',
							message : '货物ID必须是纯数字'
						}
					}
				},
				gnum : {
					validators : {
						notEmpty : {
							message : '进货数量不能为空'
						},
                        regexp : {
                            regexp : '^\\d+$',
                            message : '进货数量必须是纯数字'
                        }
					}
				},
				name : {
					validators : {
						notEmpty : {
							message : '负责人名称不能为空'
						}
					}
				}
			}
		})
	}

	// 编辑进货单信息
	function editOrderinAction() {
		$('#edit_modal_submit').click(
				function() {
					$('#orderin_form_edit').data('bootstrapValidator')
							.validate();
					if (!$('#orderin_form_edit').data('bootstrapValidator')
							.isValid()) {
						return;
					};

					var data = {
						oid : selectID,
						gid : $('#gid_edit').val(),
						sid : $('#sid_edit').val(),
						gnum : $('#gnum_edit').val(),
						name : $('#name_edit').val()
					};

					// ajax
					$.ajax({
						type : "POST",
						url : 'orderInManage/updateOrderIn',
						dataType : "json",
						contentType : "application/json",
						data : JSON.stringify(data),
						success : function(response) {
							$('#edit_modal').modal("hide");
							var type;
							var msg;
							var append = '';
							if (response.result == "success") {
								type = "success";
								msg = "进货单信息更新成功";
							} else if (response.result == "error") {
								type = "error";
								msg = "进货单信息更新失败"
							}
							showMsg(type, msg, append);
							tableRefresh();
						},
						error : function(xhr, textStatus, errorThrown) {
							$('#edit_modal').modal("hide");
							// handle error
							handleAjaxError(xhr.status);
						}
					});
				});
	}

	// 刪除进货单信息
	function deleteOrderinAction(){
		$('#delete_confirm').click(function(){
			var data = {
				"orderin_Id" : selectID
			};
			// ajax
			$.ajax({
				type : "GET",
				url : "orderInManage/deleteOrderIn",
				dataType : "json",
				contentType : "application/json",
				data : data,
				success : function(response){
					$('#deleteWarning_modal').modal("hide");
					var type;
					var msg;
					var append = '';
					if(response.result == "success"){
						type = "success";
						msg = "进货单信息删除成功";
					}else{
						type = "error";
						msg = "进货单信息删除失败";
					}
					showMsg(type, msg, append);
					tableRefresh();
				},
				error : function(response){
					$('#deleteWarning_modal').modal("hide");
					// handle error
					handleAjaxError(xhr.status);
				}
			})
			
			$('#deleteWarning_modal').modal('hide');
		})
	}

	// 添加进货单信息
	function addOrderinAction() {
		$('#add_orderIn').click(function() {
			$('#add_modal').modal("show");
		});

		$('#add_modal_submit').click(function() {
			var data = {
				oid : $('#oid').val(),
				gid : $('#gid').val(),
				sid : $('#sid').val(),
				gnum : $('#gnum').val(),
                name:$("#name").val(),
				sysflag:1
			};

			$.ajax({
				type : "POST",
				url : "orderInManage/addOrderIn",
				dataType : "json",
				contentType : "application/json",
				data : JSON.stringify(data),
				success : function(response) {
					$('#add_modal').modal("hide");
					var msg;
					var type;
					var append = '';
					if (response.result == "success") {
						type = "success";
						msg = "进货单添加成功";
					} else if (response.result == "error") {
						type = "error";
						msg = "进货单添加失败";
					}
					showMsg(type, msg, append);
					tableRefresh();

					// reset
					$('#oid').val("");
					$('#sid').val("");
					$('#gid').val("");
					$('#gnum').val("");
                    $('#name').val("");
					$('#orderin_form').bootstrapValidator("resetForm", true);
				},
				error : function(xhr, textStatus, errorThrown) {
					$('#add_modal').modal("hide");
					// handle error
					handleAjaxError(xhr.status);
				}
			})
		})
	}

</script>
<div class="panel panel-default">
	<ol class="breadcrumb">
		<li>进货单信息管理</li>
	</ol>
	<div class="panel-body">
		<div class="row">
			<div class="col-md-1 col-sm-2">
				<div class="btn-group">
					<button class="btn btn-default dropdown-toggle"
						data-toggle="dropdown">
						<span id="search_type">查询方式</span> <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="javascript:void(0)" class="dropOption">进货单号</a></li>
						<li><a href="javascript:void(0)" class="dropOption">供应商ID</a></li>
						<li><a href="javascript:void(0)" class="dropOption">货物ID</a></li>
						<li><a href="javascript:void(0)" class="dropOption">负责人名称</a></li>
						<li><a href="javascript:void(0)" class="dropOption">所有</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-9 col-sm-9">
				<div>
					<div class="col-md-3 col-sm-4">
						<input id="search_input" type="text" class="form-control"
							placeholder="进货单号">
					</div>
					<div class="col-md-2 col-sm-3">
						<button id="search_button" class="btn btn-success">
							<span class="glyphicon glyphicon-search"></span> <span>查询</span>
						</button>
					</div>
				</div>
			</div>
		</div>

		<div class="row" style="margin-top: 25px">
			<div class="col-md-5">
				<button class="btn btn-sm btn-default" id="add_orderIn">
					<span class="glyphicon glyphicon-plus"></span> <span>添加进货单</span>
				</button>
			</div>
			<div class="col-md-5"></div>
		</div>

		<div class="row" style="margin-top: 15px">
			<div class="col-md-12">
				<table id="orderInList" class="table table-striped"></table>
			</div>
		</div>
	</div>
</div>

<!-- 新增进货单 信息模态框 -->
<div id="add_modal" class="modal fade" table-index="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	data-backdrop="static">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">新增进货单</h4>
			</div>
			<div class="modal-body">
				<!-- 模态框的内容 -->
				<div class="row">
					<div class="col-md-1 col-sm-1"></div>
					<div class="col-md-8 col-sm-8">
						<form class="form-horizontal" role="form" id="orderin_form"
							style="margin-top: 25px">
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>订单编号：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control" id="oid"
										name="oid" placeholder="订单编号">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>供应商ID：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control" id="sid"
										name="sid" placeholder="供应商ID">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>货物ID：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control" id="gid"
										name="gid" placeholder="货物ID">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>进货数量：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control" id="gnum"
										name="gnum" placeholder="进货数量">
								</div>
							</div>
                            <div class="form-group">
                                <label for="" class="control-label col-md-4 col-sm-4"> <span>负责人名称：</span>
                                </label>
                                <div class="col-md-8 col-sm-8">
                                    <input type="text" class="form-control" id="name"
                                           name="name" placeholder="负责人名称">
                                </div>
                            </div>
						</form>
					</div>
					<div class="col-md-1 col-sm-1"></div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" type="button" data-dismiss="modal">
					<span>取消</span>
				</button>
				<button class="btn btn-success" type="button" id="add_modal_submit">
					<span>提交</span>
				</button>
			</div>
		</div>
	</div>
</div>

<!-- 删除提示模态框 -->
<div class="modal fade" id="deleteWarning_modal" table-index="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">警告</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-3 col-sm-3" style="text-align: center;">
						<img src="media/icons/warning-icon.png" alt=""
							style="width: 70px; height: 70px; margin-top: 20px;">
					</div>
					<div class="col-md-8 col-sm-8">
						<h3>是否确认删除该条进货单信息</h3>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" type="button" data-dismiss="modal">
					<span>取消</span>
				</button>
				<button class="btn btn-danger" type="button" id="delete_confirm")>
					<span>确认删除</span>
				</button>
			</div>
		</div>
	</div>
</div>

<!-- 编辑进货单信息模态框 -->
<div id="edit_modal" class="modal fade" table-index="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	data-backdrop="static">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">编辑进货单信息</h4>
			</div>
			<div class="modal-body">
				<!-- 模态框的内容 -->
				<div class="row">
					<div class="col-md-1 col-sm-1"></div>
					<div class="col-md-8 col-sm-8">
						<form class="form-horizontal" role="form" id="orderin_form_edit"
							style="margin-top: 25px">
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>订单编号：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control" id="oid_edit"
										name="oid" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>供应商ID：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control"
										id="sid_edit" name="sid"
										placeholder="供应商ID">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>货物ID：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control" id="gid_edit"
										name="gid" placeholder="货物ID">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>货物数量：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control"
										id="gnum_edit" name="gnum"
										placeholder="货物数量">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>负责人名称：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control"
										id="name_edit" name="name"
										placeholder="负责人名称">
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-1 col-sm-1"></div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" type="button" data-dismiss="modal">
					<span>取消</span>
				</button>
				<button class="btn btn-success" type="button" id="edit_modal_submit">
					<span>确认更改</span>
				</button>
			</div>
		</div>
	</div>
</div>