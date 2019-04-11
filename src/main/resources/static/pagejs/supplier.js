$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
});
// 共享的供应商id
var comm_supplierId;
// 是否点击了删除按钮
var isDelete;
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#bt_table').bootstrapTable({
            url: 'supplier',         //请求后台的URL（*）
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            columns: [{					//	align 	对齐方式（left、right、center）
                field: 'supplierId',
                title: '供应商编号',
                halign: 'center'
            }, {
                field: 'supplierName',
                title: '供应商名称',
                halign: 'center'
            }, {
                field: 'supplierPhone',
                title: '供应商电话',
                halign: 'center'
            }, {
                field: 'supplierAddress',
                title: '供应商地址',
                halign: 'center'
            }, {
            	title: '操作', 
            	halign: 'center', 
            	formatter(value, row, index) {
                    return [ 
                    	'<div class="btn-toolbar">',
                    	'<div class="btn-group"><button class="btn btn-info btn-xs" onclick = update('+index+')>修改</button></div>',
                        '<div class="btn-group"><button class="btn btn-danger btn-xs" onclick = remove('
                        	+row.supplierId+','+'"'+row.supplierName+'"'+')>删除</button></div>',
                    	'</div>'].join('')
                }
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        if(isDelete && $('#bt_table').bootstrapTable('getData',true).length == 1 && params.offset >=10){
            params.offset -= 10;
            isDelete = false;
        }
        var temp = {
            limit: params.limit, //页码
            offset: params.offset,   //页面大小
            supplierId: $("#queryTerm input[name='supplierId']").val(),
            supplierName: $("#queryTerm input[name='supplierName']").val(),
            supplierPhone: $("#queryTerm input[name='supplierPhone']").val(),
            supplierAddress: $("#queryTerm input[name='supplierAddress']").val()
        };
        return temp;
    };
    return oTableInit;
};


var ButtonInit = function () {
    var oInit = new Object();

    oInit.Init = function () {
    	// 查询按钮
    	$("#queryTerm .form-control").change(function(){
    		$('#bt_table').bootstrapTable('refresh');
    	});
        // 添加
        $("#add").click(function(){
            $("#addModal").modal();
        });
        // 添加验证提交
        $("#addSubmit").click(function(){
            var $supplierName = $("#addForm input[name='supplierName']");
            var $supplierPhone = $("#addForm input[name='supplierPhone']");
            var $supplierAddress = $("#addForm input[name='supplierAddress']");
            // 验证客户名称是否为空
            if($supplierName.val().trim() == ""){
                toastr.error("供应商名称不得为空");
                $supplierName.focus();
                return;
            }
            $.ajax({
                type:"POST",
                data: {"supplierName":$supplierName.val(),
                    "supplierPhone":$supplierPhone.val(),"supplierAddress":$supplierAddress.val()},
                url:"supplier",
                success(data){
                    if(data.status==0){
                        $('#addModal').modal('hide');
                        $('#bt_table').bootstrapTable('refresh');
                        $("#addForm")[0].reset();
                        toastr.success(data.message);
                    }else{
                        toastr.error(data.message);
                    }
                },
                error(){
                    toastr.error("添加超时，请稍后重试");
                },dataType:"json"
            });
        });
		// 修改验证提交
        $("#updateSubmit").click(function(){
            var $supplierName = $("#updateForm input[name='supplierName']");
            var $supplierPhone = $("#updateForm input[name='supplierPhone']");
            var $supplierAddress = $("#updateForm input[name='supplierAddress']");
            // 验证客户名称是否为空
			if($supplierName.val().trim() == ""){
    			toastr.error("供应商名称不得为空");
    			$supplierName.focus();
    			return;
    		}
			$.ajax({
				type:"PUT",
				data: {"supplierId":comm_supplierId,"supplierName":$supplierName.val(),
					"supplierPhone":$supplierPhone.val(),"supplierAddress":$supplierAddress.val()},
				url:"supplier",
				success(data){
					if(data.status==0){
				       	$('#updateModal').modal('hide');
				       	$('#bt_table').bootstrapTable('refresh');
						toastr.success(data.message);
					}else{
						toastr.error(data.message);
					}
				},
				error(){
					toastr.error("修改超时，请稍后重试");
				},dataType:"json"
			});
		});
		// 删除提交
		$("#deleteSubmit").click(function(){
			$.ajax({
				type:"DELETE",
				url:"supplier/"+comm_supplierId,
				success(data){
					if(data.status==0){
						toastr.success(data.message);
				       	$('#bt_table').bootstrapTable('refresh');
				       	isDelete = true;
					}else{
						toastr.error(data.message);
					}
				},
				error(){
					toastr.error("删除超时，请稍后重试");
				},dataType:"json"
			});
		});
    };
    return oInit;
};
// 数据修改按钮
function update(row) {
	var data = $("#bt_table").bootstrapTable('getData')[row];
    comm_supplierId = data.supplierId;
	// 赋值到模态框内
	$("#updateForm input[name='supplierId']").val(data.supplierId);
	$("#updateForm input[name='supplierName']").val(data.supplierName);
	$("#updateForm input[name='supplierPhone']").val(data.supplierPhone);
	$("#updateForm input[name='supplierAddress']").val(data.supplierAddress);
	// 打开模态框
	$("#updateModal").modal();
}
//删除模态框按钮
function remove(supplierId, supplierName){
    $("#deleteModal .modal-body p").html("确定要删除供应商ID为<font class='lead'>"+supplierId
    	+"</font>,供应商名称为<font class='lead'>"+supplierName+"</font>的供应商吗？");
    comm_supplierId = supplierId;
    $("#deleteModal").modal("show");
};