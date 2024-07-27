@import org.example.hexlet.dto.MainPage
@param MainPage page

@template.layout.page(
    title = "Main Page",
    content = @`
        <h1>Welcome to Home page!</h1>
    @if(!page.isVisited())
        <a>This message showed once. If you want to see it again, delete cookie</a>
    @endif
    `
)
