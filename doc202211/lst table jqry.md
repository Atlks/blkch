lst table jqry

	<table class="layui-table" id="tbx">
				<colgroup>
					<col width="150">
					<col width="200">
					<col>
				</colgroup>
				<thead>
					<tr>
						<th><input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"></th>
						<th>id</th>
						<th>昵称</th>
						<th>状态</th>
						<th>加入时间</th>

					</tr>
				</thead>
				<tbody>


				</tbody>
			</table>

			<script type="text/javascript">
				$.get("http://localhost:8092//queryFrd", function (data, status) {
					console.log("Data: " + data + "\nStatus: " + status);
					$.each(data, function (idx, obj) {
						var fsttd = '<td><input type="checkbox" id="vehicle1" name="vehicle1" value="@id"></td>';
						var trs = "<tr>" + fsttd + "<td>@id</td><td>@nknm</td><td>正常</td><td></td>@crtm</tr>"
						trs = trs.replaceAll("@id", obj._id); trs = trs.replace("@nknm", obj.nickname);
						$("#tbx").append(trs)

					});  //each
				}); //get

			</script>

			<script type="text/javascript">
				function getFrdList() {
					var arr133 = [];
					 

					$("input[name='vehicle1']:checked").each(function (index, item) {
						arr133.push(item.value);
					});

					 
					var ids = arr133.join(",");
					console.log(arr133.join(","));
					var uid = getQueryVariable("uid");

					$.get("http://localhost:8092/btchFrd?uid=" + uid + "&addids=" + ids, function (data, status) {
						console.log("status:" + status)
						console.log(data)
						alert("ok")
						opener.refresh();

					})
					//	alert(frdx.value)
				}
			</script>
			<script type="text/javascript">


				function getQueryVariable(variable) {
					var query = window.location.search.substring(1);
					var vars = query.split("&");
					for (var i = 0; i < vars.length; i++) {
						var pair = vars[i].split("=");
						if (pair[0] == variable) { return pair[1]; }
					}
					return (false);
				}


			</script>
