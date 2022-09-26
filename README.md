Run:
- Run `./gradlew test --tests 'TransactionalTest.testItWorks'` to get output of failing test (`transactional = true`)
- Run `./gradlew test --tests 'NonTransactionalTest.testItWorks'` to see workaround (`transactiona = false`) in action
- Run `./gradles test` to see that all together works
