$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
});
var isDelete = false;
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#bt_table').bootstrapTable({
            url: 'emp',         //请求后台的URL（*）
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            columns: [ {
                field: 'empId',
                title: '员工编号',
                halign: 'center'
            }, {
                field: 'empName',
                title: '员工名称',
                halign: 'center'
            }, {
                field: 'empNickName',
                title: '员工昵称',
                halign: 'center'
            }, {
                field: 'empPassword',
                title: '员工密码',
                halign: 'center'
            }, {
                field: 'empTelephone',
                title: '电话号码',
                halign: 'center'
            } , {
            	title: '操作', 
            	halign: 'center', 
            	formatter(value, row, index) {
                    return [ 
                    	'<div class="btn-toolbar">',
                    	'<div class="btn-group"><button class="btn btn-info btn-xs" onclick = update('+index+')>修改</button></div>',
                        '<div class="btn-group"><button class="btn btn-danger btn-xs" onclick = remove('
                        	+row.empId+','+'"'+row.empName+'"'+')>删除</button></div>',
                    	'</div>'].join('')
                }
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        //解决删除的bug
        if(isDelete && $('#bt_table').bootstrapTable('getData',true).length == 1 && params.offset >=10){
            params.offset -= 10;
            isDelete = false;
        }
        //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        var temp = {
            limit: params.limit, //页码
            offset: params.offset,   //页面大小
            empId: $("#queryTerm input[name='empId']").val(),
            empName: $("#queryTerm input[name='empName']").val(),
            empNickName: $("#queryTerm input[name='empNickName']").val(),
            empTelephone: $("#queryTerm input[name='empTelephone']").val()
        };
        return temp;
    };
    return oTableInit;
};


var ButtonInit = function () {
    var oInit = new Object();
    oInit.Init = function () {
        // $('#bt_table').on('load-success.bs.table',function(){
        //     var bsData = $(this).bootstrapTable('getData',true);
        //     var bsOptions = $(this).bootstrapTable('getOptions');
        //     if(bsData.length==0 && bsOptions.pageNumber>=1) {
        //         $(this).bootstrapTable('selectPage',1); // 跳到第一页
        //         $(this).bootstrapTable("refresh");
        //         //$(this).bootstrapTable('prevPage');  // 跳到上一页 这句有bug会跳两页
        //     }
        // });
        //验证数据
        function verify(formNameSelect){
            var $empName = $(formNameSelect+" input[name='empName']");
            var $empPassword = $(formNameSelect+" input[name='empPassword']");
            var $empNickName = $(formNameSelect+" input[name='empNickName']");
            var $empTelephone = $(formNameSelect+" input[name='empTelephone']");
            if($empName.val() == ''){
                toastr.error("用户登录名不得为空");
                $empName.focus();
                return false;
            }
            if($empNickName.val() == ''){
                toastr.error("用户名昵称不得为空");
                $empNickName.focus();
                return false;
            }
            if($empPassword.val() == ''){
                toastr.error("用户名密码不得为空");
                $empPassword.focus();
                return false;
            }
            // 电话号码的正则表达式
            var telephoneReg = /^[1][3,4,5,7,8][0-9]{9}$/;
            if(!telephoneReg.test($empTelephone.val())){
                toastr.error("请输入一个正确的电话号码");
                $empTelephone.val("");
                $empTelephone.focus();
                return false;
            }
            return true;
        }
    	// 查询按钮
    	$("#queryTerm .form-control").change(function(){
    		$('#bt_table').bootstrapTable('refresh');
    	});
        // 头像预览
        $("input[name='empFace']").change(function () {
            // 获取上传文件对象
            var file = this.files[0];
            // 读取文件URL
            var reader = new FileReader();
            reader.readAsDataURL(file);
            // 阅读文件完成后触发的事件
            reader.onload = function () {
                // 读取的URL结果：this.result
                $("img[name='empFace_img']").attr("src", this.result);
            }
        });
        // 添加按钮
        $("#add").click(function(){
            $("#addModal").modal();
            $("#addModal img[name='empFace_img']").attr("src", "");
        });
        // 添加验证提交
        $("#addSubmit").click(function(){
            if(verify("#addForm")){
                $.ajax({
                    type:"POST",
                    data: new FormData($("#addForm")[0]),
                    url:"emp",
                    // 告诉jQuery不要去处理发送的数据
                    processData: false,
                    // 告诉jQuery不要去设置Content-Type请求头
                    contentType: false,
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
            }
        });
		// 修改验证提交
        $("#updateSubmit").click(function(){
            if(verify("#updateForm")){
                $.ajax({
                    type:"PUT",
                    data: new FormData($("#updateForm")[0]),
                    url:"emp",
                    // 告诉jQuery不要去处理发送的数据
                    processData: false,
                    // 告诉jQuery不要去设置Content-Type请求头
                    contentType: false,
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
            }
		});
		// 删除提交
		$("#deleteSubmit").click(function(){
			$.ajax({
				type:"DELETE",
				url:"emp/"+comm_empId,
				success(data){
					if(data.status==0){
					    isDelete = true;
						toastr.success(data.message);
				       	$('#bt_table').bootstrapTable('refresh');
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
    comm_empId = data.empId;
	// 赋值到模态框内
    $("#updateForm img[name='empFace_img']").attr("src", data.empFaceUrl);
    $("#updateForm input[name='empId']").val(data.empId);
	$("#updateForm input[name='empPassword']").val(data.empPassword);
	$("#updateForm input[name='empName']").val(data.empName);
	$("#updateForm input[name='empNickName']").val(data.empNickName);
	$("#updateForm input[name='empTelephone']").val(data.empTelephone);
	// 打开模态框
	$("#updateModal").modal();
}
//删除模态框按钮
function remove(empId, empName){
    $("#deleteModal .modal-body p").html("确定要删除员工编号为<font class='lead'>"+empId
    	+"</font>,员工名称为<font class='lead'>"+empName+"</font>的员工吗？");
    comm_empId = empId;
    $("#deleteModal").modal("show");
};