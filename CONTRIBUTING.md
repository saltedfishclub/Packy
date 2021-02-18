# 向 MCPkg 展现你的才干

Fork ，Commit，Push，PR 一步走，但我们需要先约定好一些东西。

## 代码规范

1. 类名使用 Pascal 命名法，即接口以`I`开头，抽象类尽可能用`Abstract`开头(这貌似不是pascal规定的)，其余部分准寻Google代码规范
2. 实现类（除了 util 和 pojo ) 尽可能的放在 `org.serverct.mcpkg.impl` 里，并且根据对应实现分包。
3. API 尽可能不要直接以`实现/Impl`的形式暴露出来，*可以参考`MCPkg`和其他组件暴露出来的方式。*
4. 在写文件相关的命令时不要忘记了`通配符`和`资源ID支持`
5. 一个PR做一件事情，不要自己改版本号

## 需要注意的地方

- 写DSL命令时  
  请阅读`InstallScriptExecutorImpl`和`AbstractCommand`以及`ScriptEnv`的源码再下手。如果你认为`ScriptEnv`缺功能可以发 Issue 商讨一下。

- 写 Adaptor 时  
  请阅读 `CLI` 模块的源码，这将有助于你了解一个 Adaptor 需要`做什么，怎么做`

- 有问题  
  请发 Issue。您的 Issue 会被自动转发到 Server-CT 组群

- 版本号命名规范  
  https://semver.org/lang/zh-CN/