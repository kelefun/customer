<#macro json result=null callback=null>


    <#if result>
    {
        <#if !data>
            <#assign data = result.data/>
        </#if>
        "code": ${result.code!0},
        "msg": "${result.msg!""}",
        "data": <#nested>
    }
    </#if>

</#macro>