# FabricKotlinBase
A Legacy Fabric Mod Base Using The Kotlin DSL

# Credit
[Lunasa's Bridge Base](https://github.com/refactorinqq/BridgeBase)

# How It Works

1: Make Your Bridge Interface

```kotlin
interface ITest {
   fun doSomething()
}
```

2: Implement It

```kotlin
class TestImpl : ITest {

  override fun doSomething() {
      TestInstance.doSomething()
  }
}
```

Or implement it in a mixin if you need to (KeyBinding bridge etc)

# All Credit Goes To [Refactoring](https://github.com/refactorinqq) (Now [Lunasa](https://github.com/Luna0x01)) For The Original [Bridge Base](https://github.com/refactorinqq/BridgeBase)
