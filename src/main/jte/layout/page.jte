@import gg.jte.Content

@param String title
@param Content content
@param Content footer = null

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>${title}</title>
</head>
<body>
    <div>
        <p>
            <a href="/">Main</a>
            <a href="/courses">Courses</a>
        </p>
    </div>
    <div>${content}</div>
    <div>
        @if (footer != null)
            <div class="footer">
                ${footer}
            </div>
        @endif
    </div>
</body>
</html>
