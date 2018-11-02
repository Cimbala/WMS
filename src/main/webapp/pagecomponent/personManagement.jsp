<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
	var search_type = "none";
	var search_keyWord = "";
	var selectID;

	$(function() {
		optionAction();
		searchAction();
		listInit();
		bootstrapValidatorInit();

		addAction();
		editAction();
		deleteAction();
	})

	// 下拉框選擇動作
	function optionAction() {
		$(".dropOption").click(function() {
			var type = $(this).text();
			$("#search_input").val("");
			if (type == "所有") {
				$("#search_input").attr("readOnly", "true");
                search_type = "searchAll";
			} else if (type == "员工编号") {
				$("#search_input").removeAttr("readOnly");
                search_type = "searchByPID";
			}else if (type == "员工姓名") {
                $("#search_input").removeAttr("readOnly");
                search_type = "searchByNAME";
            } else if (type == "员工职务") {
				$("#search_input").removeAttr("readOnly");
                search_type = "searchByJOB";
			}else {
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
	function listInit() {
		$('#mainList')
				.bootstrapTable(
						{
							columns : [
									{
										field : 'personId',
										title : '员工编号'
									},
									{
										field : 'personName',
										title : '员工姓名'
									},
                                    {
                                        field : 'personGender',
                                        title : '员工性别'
                                        //,visible : false
                                    },
									{
										field : 'personJob',
										title : '员工职务'
									},
                                    {
                                        field : 'personTel',
                                        title : '联系电话'
                                        //,visible : false
                                    },
									{
										field : 'personAddress',
										title : '联系地址'
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
												selectID = row.personId;
                                                console.info('selectID:'+selectID);
												rowEditOperation(row);
											},
											'click .delete' : function(e,
													value, row, index) {
												selectID = row.personId;
												$('#deleteWarning_modal').modal(
														'show');
											}
										}
									} ],
							url : 'personManage/getPersonList',
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
		$('#pid_edit').val(selectID);
		$('#pname_edit').val(row.personName);
		$('#pgender_edit').val(row.personGender);
		$('#pjob_edit').val(row.personJob);
		$('#ptel_edit').val(row.personTel);
        $('#paddr_edit').val(row.personAddress);
	}

	// 添加供应商模态框数据校验
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
				pid : {
					validators : {
						notEmpty : {
							message : '员工编号不能为空'
						},
                        regexp : {
                            regexp : '^\\d+$',
                            message : '员工编号必须是纯数字'
                        }
					}
				},
				pname : {
					validators : {
						notEmpty : {
							message : '姓名不能为空'
						}
					}
				},
				// pgender : {
				// 	validators : {
				// 		notEmpty : {
				// 			message : '性别不能为空'
				// 		}
				// 	}
				// },
				pjob : {
					validators : {
						notEmpty : {
							message : '职务不能为空'
						}
					}
				},
				ptel : {
					validators : {
						notEmpty : {
							message : '联系电话不能为空'
						}
					}
				},
                paddr : {
                    validators : {
                        notEmpty : {
                            message : '地址不能为空'
                        }
                    }
                },
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
						personId : selectID,
						personName : $('#pname_edit').val(),
						personGender : $('#pgender_edit').val(),
						personJob : $('#pjob_edit').val(),
						personTel : $('#ptel_edit').val(),
                        personAddress : $('#paddr_edit').val()
					};

					// ajax
					$.ajax({
						type : "POST",
						url : 'personManage/updatePerson',
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
								msg = "员工信息更新成功";
							} else if (response.result == "error") {
								type = "error";
								msg = "员工信息更新失败"
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
				"person_id" : selectID
			};
			$.ajax({
				type : "GET",
				url : "personManage/deletePerson",
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
						msg = "员工信息删除成功";
					}else{
						type = "error";
						msg = "员工信息删除失败";
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
                personId : $('#pid').val(),
                personName : $('#pname').val(),
                personGender : $('#pgender').val(),
                personJob : $('#pjob').val(),
                personTel : $('#ptel').val(),
                personAddress : $('#paddr').val(),
				systemFlag:1
			};

			$.ajax({
				type : "POST",
				url : "personManage/addPerson",
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
						msg = "员工信息添加成功";
					} else if (response.result == "error") {
						type = "error";
						msg = "员工信息添加失败";
					}
					showMsg(type, msg, append);
					tableRefresh();

					// reset
					$('#pid').val("");
					$('#pname').val("");
					//$('#pgender').val("");
					$('#pjob').val("");
                    $('#ptel').val("");
                    $('#paddr').val("");
					$('#form_add').bootstrapValidator("resetForm", true);
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
		<li>人员信息管理</li>
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
						<li><a href="javascript:void(0)" class="dropOption">员工编号</a></li>
						<li><a href="javascript:void(0)" class="dropOption">员工姓名</a></li>
						<li><a href="javascript:void(0)" class="dropOption">员工职务</a></li>
						<li><a href="javascript:void(0)" class="dropOption">所有</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-9 col-sm-9">
				<div>
					<div class="col-md-3 col-sm-4">
						<input id="search_input" type="text" class="form-control"
							placeholder="员工编号">
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
				<button class="btn btn-sm btn-default" id="add_btn">
					<span class="glyphicon glyphicon-plus"></span> <span>添加员工信息</span>
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
				<h4 class="modal-title">新增员工信息</h4>
			</div>
			<div class="modal-body">
				<!-- 模态框的内容 -->
				<div class="row">
					<div class="col-md-1 col-sm-1"></div>
					<div class="col-md-8 col-sm-8">
						<form class="form-horizontal" role="form" id="form_add"
							style="margin-top: 25px">
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>员工编号：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control" id="pid"
										name="pid" placeholder="员工编号">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>员工姓名：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control" id="pname"
										name="pname" placeholder="员工姓名">
								</div>
							</div>
                            <div class="form-group">
                                <label for="" class="control-label col-md-4 col-sm-4"> <span>性别：</span>
                                </label>
                                <div class="col-md-8 col-sm-8">
                                    <select name="pgender" id="pgender" class="form-control">
                                        <option value="男">男</option>
                                        <option value="女">女</option>
                                    </select>
                                </div>
                            </div>
							<%--<div class="form-group">--%>
								<%--<label for="" class="control-label col-md-4 col-sm-4"> <span>性别：</span>--%>
								<%--</label>--%>
								<%--<div class="col-md-8 col-sm-8">--%>
									<%--<input type="text" class="form-control" id="pgender"--%>
										<%--name="pgender" placeholder="性别">--%>
								<%--</div>--%>
							<%--</div>--%>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>职务：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control" id="pjob"
										name="pjob" placeholder="职务">
								</div>
							</div>
                            <div class="form-group">
                                <label for="" class="control-label col-md-4 col-sm-4"> <span>联系电话：</span>
                                </label>
                                <div class="col-md-8 col-sm-8">
                                    <input type="text" class="form-control" id="ptel"
                                           name="ptel" placeholder="联系电话">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="" class="control-label col-md-4 col-sm-4"> <span>联系地址：</span>
                                </label>
                                <div class="col-md-8 col-sm-8">
                                    <input type="text" class="form-control" id="paddr"
                                           name="paddr" placeholder="联系地址">
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
						<h3>是否确认删除该条员工信息</h3>
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
				<h4 class="modal-title" id="myModalLabel">编辑员工信息</h4>
			</div>
			<div class="modal-body">
				<!-- 模态框的内容 -->
				<div class="row">
					<div class="col-md-1 col-sm-1"></div>
					<div class="col-md-8 col-sm-8">
						<form class="form-horizontal" role="form" id="form_edit"
							style="margin-top: 25px">
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>员工编号：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control" id="pid_edit"
										name="pid" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>员工姓名：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control"
										id="pname_edit" name="pname"
										placeholder="员工姓名">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>性别：</span>
								</label>
								<div class="col-md-8 col-sm-8">
                                    <select name="pgender" id="pgender_edit" class="form-control">
                                        <option value="男">男</option>
                                        <option value="女">女</option>
                                    </select>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>职务：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control"
										id="pjob_edit" name="pjob"
										placeholder="职务">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="control-label col-md-4 col-sm-4"> <span>联系电话：</span>
								</label>
								<div class="col-md-8 col-sm-8">
									<input type="text" class="form-control"
										id="ptel_edit" name="ptel"
										placeholder="联系电话">
								</div>
							</div>
                            <div class="form-group">
                                <label for="" class="control-label col-md-4 col-sm-4"> <span>联系地址：</span>
                                </label>
                                <div class="col-md-8 col-sm-8">
                                    <input type="text" class="form-control"
                                           id="paddr_edit" name="paddr"
                                           placeholder="联系地址">
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