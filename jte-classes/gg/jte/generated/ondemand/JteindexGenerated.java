package gg.jte.generated.ondemand;
import org.example.hexlet.dto.MainPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,6,6,9,9,10,10,10,12,12,15,15,17,17,19,19,19,20,20,20,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, MainPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <h1>Home page</h1>\n        <div>\n            ");
				if (page.getCurrentUser() != null) {
					jteOutput.writeContent("\n                Welcome, ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getCurrentUser());
					jteOutput.writeContent(".\n                To log out, delete the JSESSIONID cookie from your browser\n            ");
				}
				jteOutput.writeContent("\n        </div>\n        <div>\n            ");
				if (!page.isVisited()) {
					jteOutput.writeContent("\n                <a>This message showed once. If you want to see it again, delete cookie</a>\n            ");
				}
				jteOutput.writeContent("\n        </div>\n    ");
			}
		}, "Main Page");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		MainPage page = (MainPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
