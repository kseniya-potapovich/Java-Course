<#import "macros/common.ftl" as com>

<@com.common_macros "all users page">
    <#list users as user>
        <@com.user_macros user/>
        ------------------------
    </#list>
</@com.common_macros>