package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.UsersRepository;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,10,10,10,10,10,10,10,10,10,13,13,15,15,17,17,19,19,19,21,21,21,24,24,24,27,27,29,29,30,30,30,31,31,31,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h1>Programing Courses</h1>\n    <form action=\"/users?term=\" method=\"get\">\n        <input type=\"search\" name=\"term\"");
				var __jte_html_attribute_0 = page.getTerm();
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" value=\"");
					jteOutput.setContext("input", "value");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("input", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" placeholder=\"Name\" />\n        <input type=\"submit\" value=\"Search\" />\n    </form>\n    ");
				if (UsersRepository.size() == 0) {
					jteOutput.writeContent("\n        <p>Users not found</p>\n    ");
				} else {
					jteOutput.writeContent("\n        <table class=\"table table-striped\">\n            ");
					for (var user : UsersRepository.search(page.getTerm())) {
						jteOutput.writeContent("\n                <tr>\n                    <td>");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(user.getId());
						jteOutput.writeContent("</td>\n                    <td>\n                        <a>");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(user.getName());
						jteOutput.writeContent("</a>\n                    </td>\n                    <td>\n                        <p>");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(user.getEmail());
						jteOutput.writeContent("</p>\n                    </td>\n                </tr>\n            ");
					}
					jteOutput.writeContent("\n        </table>\n    ");
				}
				jteOutput.writeContent("\n");
			}
		}, "Users");
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
