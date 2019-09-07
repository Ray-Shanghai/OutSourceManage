var sd = {};
sd.initTableEvent = function() {

	$('#article.selecteds tr').click(function() {
		if($(this).hasClass('bg-blue-selected')) {
			$(this).removeClass('bg-blue-selected');
			$(this).children().children('.layui-form-checkbox').removeClass('layui-form-checked');
		} else {
			$(this).addClass('bg-blue-selected');
			$(this).children().children('.layui-form-checkbox').addClass('layui-form-checked');
		}

	});

	//user click single 
	$('#article.selected tr').click(function() {
		var index = $(this).index();
		$('#content tr').removeClass('bg-blue-selected').eq(index).addClass('bg-blue-selected');
		$('#content tr').children().children('.layui-form-checkbox').removeClass('layui-form-checked').eq(index).addClass('layui-form-checked');

	});

}
//Get the contents selected by the table
sd.getSelected = function() {
	var jsonArrays = [];

	$('.bg-blue-selected').each(function(i, obj) {
		var jsonObj = [];
		$(obj).find("td").each(function(i1, obj1) {
			jsonObj[i1] = $(obj1).text();
		});
		jsonArrays[i] = jsonObj;

	});

	return jsonArrays;
}