<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<script>
$(function(){
	quickAccessInit();
});
// 快捷方式
function quickAccessInit(){
	$('.shortcut').click(function(){
	    debugger;
		var title = $(this).find('.title').text();
		var url = $('.menu_item:contains('+ title + ')').attr('name');
		$('#panel').load(url);
	})
}
</script>
<!-- 欢迎界面 -->
<div class="panel panel-default">
	<!-- 面包屑 -->
	<ol class="breadcrumb">
		<li>主页</li>
	</ol>

	<div class="panel-body">

            <div class="row" style="margin-top: 100px; margin-bottom: 100px">
                <div class="col-md-1"></div>
                <div class="col-md-10" style="text-align: center">
                    <div class="col-md-4 col-sm-4">
                        <a href="javascript:void(0)" class="thumbnail shortcut"> <img
                            src="media/icons/stock_search-512.png" alt="库存查询"
                            class="img-rounded link" style="width: 150px; height: 150px;">
                            <div class="caption">
                                <h3 class="title">库存查询</h3>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 col-sm-4">
                        <a href="javascript:void(0)" class="thumbnail shortcut"> <img
                            src="media/icons/people_512.png" alt="客户管理"
                            class="img-rounded link" style="width: 150px; height: 150px;" >
                            <div class="caption">
                                <h3 class="title">客户信息管理</h3>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-4 col-sm-4">
                        <a href="javascript:void(0)" class="thumbnail shortcut"> <img
                            src="media/icons/stock_out-512.png" alt="货物出库"
                            class="img-rounded link" style="width: 150px; height: 150px;">
                            <div class="caption">
                                <h3 class="title">货物出库</h3>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-md-1"></div>
            </div>

	</div>
</div>
