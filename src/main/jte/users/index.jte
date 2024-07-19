@import org.example.hexlet.dto.users.UsersPage
@import org.example.hexlet.UsersRepository
@param UsersPage page

@template.layout.page(
title = "Users",
content = @`
    <h1>Programing Courses</h1>
    <form action="/users?term=" method="get">
        <input type="search" name="term" value="${page.getTerm()}" placeholder="Name" />
        <input type="submit" value="Search" />
    </form>
    @if(UsersRepository.size() == 0)
        <p>Users not found</p>
    @else
        <table class="table table-striped">
            @for(var user : UsersRepository.search(page.getTerm()))
                <tr>
                    <td>${user.getId()}</td>
                    <td>
                        <a>${user.getName()}</a>
                    </td>
                    <td>
                        <p>${user.getEmail()}</p>
                    </td>
                </tr>
            @endfor
        </table>
    @endif
`
)
