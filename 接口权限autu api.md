autofltr.java



		//过滤静态文件
		String path = request.getRequestURI();
		if (path.endsWith(".html") ||
				path.endsWith(".css") ||
				path.endsWith(".js") ||
			path.equals("/v2/api-docs") ||path.equals("/swagger-resources")||
				path.endsWith(".png") ||
				path.endsWith(".ico")|| path.contains("/dbx/")
		) {
			arg2.doFilter(arg0, arg1);
			return;
		}


   app.prop
   #不需要访问令牌(access-token)即可访问的接口
authorizationfilter.requestUriList[0]=/user/register     