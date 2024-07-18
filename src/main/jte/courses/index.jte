@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
    title = "Courses",
    content = @`
        <h1>${page.getHeader()}</h1>
        @if(page.getCourses().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            <table>
                @for(var course : page.getCourses())
                    <tr>
                        <td>
                            <a href="/courses/${course.getId()}">${course.getName()}</a>
                            <p>${course.getDescription()}</p>
                        </td>
                    </tr>
                @endfor
            </table>
        @endif
    `,
    footer = @`
        <a href="https://github.com/kirill-ishtuganov">My GitHub</a>
    `
)
