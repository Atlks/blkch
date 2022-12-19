java mcrsvr frm cmpr

spark is good，smptl
sprbt isjust ok
vertx bhaoyon mafe

package pkg1;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import spark.Spark;

import static spark.Spark.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.synth.SynthOptionPaneUI;

@SpringBootApplication
public class sprbt {
	public static void main(String[] args) throws Exception {

		new Thread(() -> {
			System.out.println("sttt");

		}).start();

		new Thread(() -> {
			Spark.exception(RuntimeException.class, (exception, request, response) -> {
				//exception.printStackTrace();
				throw exception;
			});
			port(8888);
			get("/h", (req, res) -> "Hel..");
			 get("/hh", (req, res) -> "Hel222.");
			// get("/hh", extracted());
			get("/p",

					(req, res) -> {

						// HttpServletRequest req2 = (HttpServletRequest) req;
						// spark.http.matching.RequestWrapper req2=req;
//							System.out.println(req2.getSession().getServletContext().getRealPath("/"));
//							;
						HttpServletRequest req2 = req.raw();

						String path = req2.getServletContext().getContextPath();
						System.out.println(path);
						String realPath = req2.getServletContext().getRealPath("/uploadFile");
						System.out.println(realPath);
						return 1;

					});

		}).start();

		new Thread(() -> {

			new HelloWorldVerticle().start();

		}).start();

		// SpringApplication.run(sprbt.class, args);

		SpringApplication app = new SpringApplication(sprbt.class);

		Map<String, Object> singletonMap = Collections.singletonMap("server.port", "7777");
		// singletonMap .put("debug", "true");
		app.setDefaultProperties(singletonMap);
		app.run(args);
	}
}

// vertx
class HelloWorldVerticle extends AbstractVerticle {

	@Override
	public void start() {
		Vertx vertx = Vertx.vertx();

		HttpServer server = vertx.createHttpServer();
		Router router = Router.router(vertx);

//        router
//        .get("/some/path")
//        // this handler will ensure that the response is serialized to json
//        // the content type is set to "application/json"
//        .respond(
//          ctx -> Future.succeededFuture(new JsonObject().put("hello", "world")));

		// 处理http://localhost:8080/
		Route route = router.route("/");
		route.handler(routingContext -> {
			routingContext.response().end("He!");
		});

		// 处理http://localhost:8080/date
		route = router.route("/date");
		route.handler(routingContext -> {
			HttpServerResponse response = routingContext.response();
			response.putHeader("content-type", "text/plain");
			response.end("date: " + new java.util.Date());
		});

		// server.requestHandler(router::accept).listen(8888);
		server.requestHandler(router).listen(9999);

	}
}

@RestController
class HelloWorldController2 {
	@RequestMapping("/a")
	public Object hello(HttpServletRequest req) throws IOException {

//		System.out.println(req2.getSession().getServletContext().getRealPath("/"));
//		;

		String path = req.getServletContext().getContextPath();
		System.out.println(path);// empty
		String realPath = req.getServletContext().getRealPath("/");
		System.out.println(realPath); // C:\Users\tom\AppData\Local\Temp\tomcat-docbase.8083.5249766534941135781

		Map m = new HashMap<>();
		m.put("Test.class.getResource (\"/\") ", sprbt.class.getResource("/"));

		URL u = sprbt.class.getClassLoader().getResource("/application.properties");
		String t = FileUtils.readFileToString(new File(u.getFile()));
		System.out.println(t);

		return m;
	}
}