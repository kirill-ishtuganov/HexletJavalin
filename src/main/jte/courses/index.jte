@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
    title = "Courses",
    content = @`
        <h1>Programing Courses</h1>
        <form action="/courses" method="get">
            <input type="search" name="term" value="${page.getTerm()}" placeholder="Name" />
            <input type="search" name="description" value="${page.getTerm()}" placeholder="Description" />
            <input type="submit" value="Search" />
        </form>
        @if(page.getCourses().isEmpty())
            <p>Пока не добавлено ни одного курса</p>
        @else
            <table class="table table-striped">
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
    `
)
