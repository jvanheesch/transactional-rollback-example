`ApplicationTest` demonstrates the default behavior of `@Transactional`:

```
In its default configuration, the Spring Framework’s transaction infrastructure code marks a transaction for rollback
only in the case of runtime, unchecked exceptions. That is, when the thrown exception is an instance or subclass of
RuntimeException. (Error instances also, by default, result in a rollback). Checked exceptions that are thrown from a
transactional method do not result in rollback in the default configuration.
```

See https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#transaction-declarative-rolling-back