package gg.jte.generated.ondemand.users;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,3,3,31,31,31,32,32,32,32,32,32};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <form action=\"/users\" method=\"post\">\n        <div>\n            <label>\n                Name\n                <input type=\"text\" name=\"name\" />\n            </label>\n        </div>\n        <div>\n            <label>\n                Email\n                <input type=\"email\" required name=\"email\" />\n            </label>\n        </div>\n        <div>\n            <label>\n                Password\n                <input type=\"password\" required name=\"password\" />\n            </label>\n        </div>\n        <div>\n            <label>\n                Password confirmation\n                <input type=\"password\" required name=\"passwordConfirmation\" />\n            </label>\n        </div>\n        <input type=\"submit\" value=\"Registration\" />\n    </form>\n");
			}
		}, "registration new user");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
