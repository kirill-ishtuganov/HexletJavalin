package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,12,12,12,12,27,27,27,42,42,42,1,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, String title) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\"\n          rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\"\n          crossorigin=\"anonymous\">\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</title>\n</head>\n<body>\n<div class=\"b-example-divider\"></div>\n\n<div class=\"container\">\n    <header class=\"d-flex justify-content-center py-3\">\n        <ul class=\"nav nav-pills\">\n            <li class=\"nav-item\"><a href=\"/\" class=\"nav-link active\" aria-current=\"page\">Home</a></li>\n            <li class=\"nav-item\"><a href=\"/courses\" class=\"nav-link\">Courses</a></li>\n        </ul>\n    </header>\n</div>\n\n<div class=\"mx-auto p-4 py-md-5\">\n    ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n</div>\n\n<div class=\"container\">\n    <footer class=\"d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top\">\n        <div class=\"col-md-4 d-flex align-items-center\">\n            <a href=\"/\" class=\"mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1\">\n                <svg class=\"bi\" width=\"30\" height=\"24\"><use xlink:href=\"#bootstrap\"/></svg>\n            </a>\n            <a href=\"https://github.com/kirill-ishtuganov\" class=\"text-muted\">My GitHub</a>\n        </div>\n    </footer>\n</div>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		String title = (String)params.get("title");
		render(jteOutput, jteHtmlInterceptor, content, title);
	}
}
