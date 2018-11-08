<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
	var search_type = "none";
	var search_keyWord = "";
    var search_keyWord2 = "";
	var selectID;
	var selectID2;
    var search_start_date = null;
    var search_end_date = null;

	$(function() {
	    datePickerInit();
		optionAction();
		searchAction();
		listInit();
		bootstrapValidatorInit();

		addAction();
		editAction();
		deleteAction();
	});

    // 日期选择器初始化
    function datePickerInit(){
        $('.form_date').datetimepicker({
            format:'yyyy-mm-dd',
            language : 'zh-CN',
            endDate : new Date(),
            weekStart : 1,
            todayBtn : 1,
            autoClose : 1,
            todayHighlight : 1,
            startView : 2,
            forceParse : 0,
            minView:2
        });
    }

	// 下拉框選擇動作
	function optionAction() {
		$(".dropOption").click(function() {
			var type = $(this).text();
			$("#search_input").val("");
			if (type == "所有") {
                search_type = "searchAll";
				$("#search_input").attr("readOnly", "true");
                $("#search_input2").attr("readOnly", "true");
                $("#search_start_date").attr("readOnly", "true");
                $("#search_end_date").attr("readOnly", "true");

                $("#search_input").attr("placeholder", type);
                $("#search_input2").attr("placeholder", "");
                $("#search_start_date").attr("placeholder", "");
                $("#search_end_date").attr("placeholder", "");
            } else if (type == "手动输入") {
                search_type = "searchByParams";
				$("#search_input").removeAttr("readOnly");
                $("#search_input2").removeAttr("readOnly");
                $("#search_start_date").removeAttr("readOnly");
                $("#search_end_date").removeAttr("readOnly");

                $("#search_input").attr("placeholder", "流水编号");
                $("#search_input2").attr("placeholder", "货物ID");
                $("#search_start_date").attr("placeholder", "开始日期");
                $("#search_end_date").attr("placeholder", "结束日期");
			}else {
				$("#search_input").removeAttr("readOnly");
			}

			$("#search_type").text(type);
		})
	}

	// 搜索动作
	function searchAction() {
		$('#search_button').click(function() {
			search_keyWord = $('#search_input').val();
            search_keyWord2 = $('#search_input2').val();
            search_start_date = $('#search_start_date').val();
            search_end_date = $('#search_end_date').val();
			tableRefresh();
		})
	}

	// 分页查询参数
	function queryParams(params) {
		var temp = {
			limit : params.limit,
			offset : params.offset,
			searchType : search_type,
			keyWord : search_keyWord,
            keyWord2 : search_keyWord2,
            startDate:search_start_date,
            endDate:search_end_date
		};
		return temp;
	}

	// 表格初始化
	function listInit() {
		$('#mainList')
				.bootstrapTable(
						{
							columns : [
									{
										field : 'saleId',
										title : '流水编号'
									},
									{
										field : 'goodId',
										title : '货物ID'
									},
                                    {
                                        field : 'saleNum',
                                        title : '售出数量'
                                        //,visible : false
                                    },
									{
										field : 'price',
										title : '单价'
									},
                                    {
                                        field : 'unit',
                                        title : '单位'
                                        //,visible : false
                                    },
									{
										field : 'saleAmount',
										title : '总销售额'
									},
                                    {
                                        field : 'saleDate',
                                        title : '记录时间',
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
												selectID = row.saleId;
                                                selectID2=row.goodId;
												rowEditOperation(row);
											},
											'click .delete' : function(e,
													value, row, index) {
												selectID = row.saleId;
                                                selectID2=row.goodId;
												$('#deleteWarning_modal').modal(
														'show');
											}
										}
									} ],
							url : 'saleRecordManage/getSaleRecordList',
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
		$('#mainList').bootstrapTable('refresh', {
			query : {}
		});
	}

	// 行编辑操作
	function rowEditOperation(row) {
		$('#edit_modal').modal("show");

		// load info
		$('#form_edit').bootstrapValidator("resetForm", true);
		$('#srid_edit').val(selectID);
		$('#gid_edit').val(selectID2);
		$('#snum_edit').val(row.saleNum);
		$('#price_edit').val(row.price);
		$('#unit_edit').val(row.unit);
        $('#samount_edit').val(row.saleAmount);
	}

	// 添加模态框的数据校验
	function bootstrapValidatorInit() {
		$("#form_add,#form_edit").bootstrapValidator({
			message : 'This is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			excluded : [ ':disabled' ],
			fields : {
				srid : {
					validators : {
						notEmpty : {
							message : '流水编号不能为空'
						},
                        regexp : {
                            regexp : '^\\d+$',
                            message : '流水编号必须是纯数字'
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
				snum : {
					validators : {
						notEmpty : {
							message : '售出数量不能为空'
						},
                        regexp : {
                            regexp : '^\\d+$',
                            message : '售出数量必须是纯数字'
                        }
					}
				},
				price : {
					validators : {
						notEmpty : {
							message : '销售单价不能为空'
						},
                        regexp : {
                            regexp : '^\\d+$',
                            message : '销售单价必须是纯数字'
                        }
					}
				},
                samount : {
                    validators : {
                        notEmpty : {
                            message : '总销售额不能为空'
                        },
                        regexp : {
                            regexp : '^\\d+$',
                            message : '总销售额必须是纯数字'
                        }
                    }
                }
			}
		})
	}

	// 编辑
	function editAction() {
		$('#edit_modal_submit').click(
				function() {
					$('#form_edit').data('bootstrapValidator')
							.validate();
					if (!$('#form_edit').data('bootstrapValidator')
							.isValid()) {
						return;
					};

					var data = {
						saleId : selectID,
						goodId : selectID2,
						saleNum : $('#snum_edit').val(),
						price : $('#price_edit').val(),
						unit : $('#unit_edit').val()
                        //,saleAmount : $('#samount_edit').val()
					};

					// ajax
					$.ajax({
						type : "POST",
						url : 'saleRecordManage/updateSaleRecord',
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
								msg = "销售信息更新成功";
							} else if (response.result == "error") {
								type = "error";
								msg = "销售信息更新失败"
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

	// 刪除
	function deleteAction(){
		$('#delete_confirm').click(function(){
			var data = {
				"sale_id" : selectID,
                "good_id":selectID2
			};
			$.ajax({
				type : "GET",
				url : "saleRecordManage/deleteSaleRecord",
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
						msg = "销售信息删除成功";
					}else{
						type = "error";
						msg = "销售信息删除失败";
					}
					showMsg(type, msg, append);
					tableRefresh();
				},
				error : function(response){
					$('#deleteWarning_modal').modal("hide");
					// handle error
					handleAjaxError(xhr.status);
				}
			});
			
			$('#deleteWarning_modal').modal('hide');
		})
	}

	// 新增
	function addAction() {
		$('#add_btn').click(function() {
			$('#add_modal').modal("show");
		});

		$('#add_modal_submit').click(function() {
			var data = {
                saleId : $('#srid').val(),
                goodId : $('#gid').val(),
                saleNum : $('#snum').val(),
                price : $('#price').val(),
                unit : $('#unit').val()
                //,saleAmount : $('#samount').val(),
			};

			$.ajax({
				type : "POST",
				url : "saleRecordManage/addSaleRecord",
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
						msg = "销售信息添加成功";
					} else if (response.result == "error") {
						type = "error";
						msg = "销售信息添加失败";
					}
					showMsg(type, msg, append);
					tableRefresh();

					// reset
					$('#srid').val("");
					$('#gid').val("");
					//$('#samount').val("");
					$('#snum').val("");
                    $('#price').val("");
                    $('#unit').val("");
					$('#form_add').bootstrapValidator("resetForm", true);
				},
				error : function(xhr, textStatus, errorThrown) {
					$('#add_modal').modal("hide");
					// handle error
                    console.error("ajax进入error："+textStatus);
					handleAjaxError(xhr.status);
				}
			})
		})
	}

</script>
<div class="panel panel-default">
	<ol class="breadcrumb">
		<li>销售流水信息管理</li>
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
						<li><a href="javascript:void(0)" class="dropOption">手动输入</a></li>
						<li><a href="javascript:void(0)" class="dropOption">所有</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-9 col-sm-9">
				<div>
					<div class="col-md-3 col-sm-4">
						<input id="search_input" type="text" class="form-control"
							placeholder="流水编号">
					</div>
                    <div class="col-md-3 col-sm-4">
                        <input id="search_input2" type="text" class="form-control"
                               placeholder="货物ID">
                    </div>
					<div class="col-md-2 col-sm-3">
						<button id="search_button" class="btn btn-success">
							<span class="glyphicon glyphicon-search"></span> <span>查询</span>
						</button>
					</div>
				</div>
			</div>
		</div>
        <div class="row" style="margin-top:20px">
            <div class="col-md-6">
                <form action="" class="form-inline">
                    <label class="form-label">日期范围：</label>
                    <input class="form_date form-control" value="" id="search_start_date" name="" placeholder="开始日期">
                    <label class="form-label">&nbsp;&nbsp;-&nbsp;&nbsp;</label>
                    <input class="form_date form-control" value="" id="search_end_date" name="" placeholder="结束日期">
                </form>
            </div>
        </div>

		<div class="row" style="margin-top: 25px">
			<div class="col-md-5">
				<button class="btn btn-sm btn-default" id="add_btn">
					<span class="glyphicon glyphicon-plus"></span> <span>添加销售流水信息</span>
				</button>
			</div>
			<div class="col-md-5"></div>
		</div>

		<div class="row" style="margin-top: 15px">
			<div class="col-md-12">
				<table id="mainList" class="table table-striped"></table>
			</div>
		</div>
	</div>
</div>

<!-- 新增 信息模态框 -->
<div id="add_modal" class="modal fade" table-index="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	data-backdrop="static">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">新增销售流水信息</h4>
			</div>
			<div class="modal-body">
				<!-- 模态框的内容 -->
				<div class="row">
					<div class="col-md-1 col-sm-1"></div>
					<div class="col-md-8 col-sm-8">
						<form class="form-horizontal" role="form" id="form_add"
							style="margin-top: 25px">
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>流水编号：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control" id="srid"
										name="srid" placeholder="流水编号">
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
								<label for="" class="control-label col-md-4 col-sm-4"> <span>售出数量：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control" id="snum"
										name="snum" placeholder="售出数量">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>销售单价：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control" id="price"
										name="price" placeholder="销售单价">
								</div>
							</div>
                            <div class="form-group">
                                <label for="" class="control-label col-md-4 col-sm-4"> <span>物品单位：</span>
                                </label>
                                <div class="col-md-8 col-sm-8">
                                    <input type="text" class="form-control" id="unit"
                                           name="unit" placeholder="物品单位">
                                </div>
                            </div>
                            <%--<div class="form-group">--%>
                                <%--<label for="" class="control-label col-md-4 col-sm-4"> <span>总销售额：</span>--%>
                                <%--</label>--%>
                                <%--<div class="col-md-8 col-sm-8">--%>
                                    <%--<input type="text" class="form-control" id="paddr"--%>
                                           <%--name="samount" placeholder="总销售额">--%>
                                <%--</div>--%>
                            <%--</div>--%>
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
				<h4 class="modal-title">警告</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-3 col-sm-3" style="text-align: center;">
						<img src="media/icons/warning-icon.png" alt=""
							style="width: 70px; height: 70px; margin-top: 20px;">
					</div>
					<div class="col-md-8 col-sm-8">
						<h3>是否确认删除该条销售流水信息</h3>
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

<!-- 编辑信息模态框 -->
<div id="edit_modal" class="modal fade" table-index="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	data-backdrop="static">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">编辑销售信息</h4>
			</div>
			<div class="modal-body">
				<!-- 模态框的内容 -->
				<div class="row">
					<div class="col-md-1 col-sm-1"></div>
					<div class="col-md-8 col-sm-8">
						<form class="form-horizontal" role="form" id="form_edit"
							style="margin-top: 25px">
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>流水编号：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control" id="srid_edit"
										name="srid" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>货物ID：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control"
										id="gid_edit" name="gid" readonly="readonly"
										placeholder="货物ID">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>售出数量：</span>
								</label>
								<div class="col-md-8 col-sm-8">
                                    <input type="text" class="form-control"
                                           id="snum_edit" name="snum"
                                           placeholder="售出数量">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>销售单价：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control"
										id="price_edit" name="price"
										placeholder="销售单价">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>物品单位：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control"
										id="unit_edit" name="unit"
										placeholder="物品单位">
								</div>
							</div>
                            <%--<div class="form-group">--%>
                                <%--<label for="" class="control-label col-md-4 col-sm-4"> <span>总销售额：</span>--%>
                                <%--</label>--%>
                                <%--<div class="col-md-8 col-sm-8">--%>
                                    <%--<input type="text" class="form-control"--%>
                                           <%--id="samount_edit" name="samount"--%>
                                           <%--placeholder="总销售额">--%>
                                <%--</div>--%>
                            <%--</div>--%>
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