# 向 Packy 展现你的才干

Fork ，建立自己的分支，Commit，Push，PR 一步走，但我们需要先约定好一些东西。

## 代码规范

1. 类名使用 Pascal 命名法，即接口以`I`开头，抽象类尽可能用`Abstract`开头(这貌似不是pascal规定的)，其余部分准寻Google代码规范
2. 一个PR做一件事情，不要自己改版本号
3. 对于所有的公开接口，总是加上 `@ApiStatus.AvailableSince`，新版本添加新的对外公开接口时，总是在方法上标注上 `@ApiStatus.AvailableSince`
4. 不影响整洁的情况下，总是使用 Optional
5. 总是避免信息直接写入常量而不是使用Locale

## 需要注意的地方

- 有问题  
  请发 Issue。您的 Issue 会被自动转发到 Server-CT 组群

- 版本号命名规范  
  https://semver.org/lang/zh-CN/
  
- 关闭 Issue 时
  除非特殊原因，关闭 issue 时*必须附上*相关的 commithash 且在相关 commit 内提及这个 issue 的 id.