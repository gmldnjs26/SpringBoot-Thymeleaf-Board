/**
 * 
 */

$(document).ready(function(){
	$('.table .eBtn').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		
		$.get(href,function(boardVO,status){
			console.log("get"+href);
			$('.mymodal #id').val(boardVO.b_code);
			$('.mymodal #name').val(boardVO.b_title);
			$('.mymodal #capital').val(boardVO.b_content);
		});
	
		$('.mymodal #exampleModal').modal('show');
	});
	
	$('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
        $(this).toggleClass('active');
    });
	
	$('.nav-login').on('click',function() {
		$('.mymodal #elegantModalForm').modal('show');
	})
	
	$('.nav-join').on('click',function() {
		$('.mymodal #JoinModalForm').modal('show');
	});;
	$('.nav-logout').on('click',function(){
		$.ajax({
			url:"/logout",
			type:'post',
			
			
		})
	});
	$('.Recomment').hide();
	$('.comment_info_button').on('click',function(){
		$('.Recomment').show();
	});
})

function view_board(b_code){
	$.get("/findOne?b_code="+b_code,function(result,status){
		console.log(result);
	})
}