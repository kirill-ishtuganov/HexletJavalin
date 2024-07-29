package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import org.example.hexlet.utilities.NamedRoutes;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,13,13,13,13,21,21,21,21,21,21,21,21,21,22,22,22,22,22,22,22,22,22,23,23,23,23,23,23,23,23,23,24,24,24,24,24,24,24,24,24,25,25,25,25,25,25,25,25,25,31,31,31,46,46,46,2,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, String title) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\" />\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\"\n          rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\"\n          crossorigin=\"anonymous\">\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</title>\n</head>\n<body>\n<div class=\"b-example-divider\"></div>\n\n<div class=\"container\">\n    <header class=\"d-flex justify-content-center py-3\">\n        <ul class=\"nav nav-pills\">\n            <li class=\"nav-item\"><a");
		var __jte_html_attribute_0 = NamedRoutes.mainPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" class=\"nav-link active\" aria-current=\"page\">Home</a></li>\n            <li class=\"nav-item\"><a");
		var __jte_html_attribute_1 = NamedRoutes.coursesPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" class=\"nav-link\">Courses</a></li>\n            <li class=\"nav-item\"><a");
		var __jte_html_attribute_2 = NamedRoutes.usersPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" class=\"nav-link\">Users</a></li>\n            <li class=\"nav-item\"><a");
		var __jte_html_attribute_3 = NamedRoutes.buildUserPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_3);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" class=\"nav-link\">Registration</a></li>\n            <li class=\"nav-item\"><a");
		var __jte_html_attribute_4 = NamedRoutes.buildSessionPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_4);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" class=\"nav-link\">Login</a></li>\n        </ul>\n    </header>\n</div>\n\n<div class=\"mx-auto p-4 py-md-5\" align=\"center\">\n    ");
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
