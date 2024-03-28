<#macro common_macros title>
    <html>
    <head>
        <title>${title}</title>
    </head>
    <body>
    <#nested>
    </body>
    </html>
</#macro>

<#macro user_macros user>
    <h4>${user.id}</h4>
    <h4>${user.username}</h4>
    <h4>${user.age}</h4>
    <h4>${user.changed}</h4>
    <h4>${user.created}</h4>
    <h4>${user.userPassword}</h4>
</#macro>