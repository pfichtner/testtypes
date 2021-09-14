# testtypes

This is a Java showcase for different test types. Please note that it is based on a minimal example (FizzBuzz). Therefore, some parts are completely oversized for this little example: Nobody would seriously use property based or approval tests for such a manageable production code base. So the example tests can be kept simple and the important thing can be emphasized. 

What's inside? 
- unittest (JUnit5) (used to create the production code using TDD)
- parameterized tests (JUnit5)
- property based tests (using jqwik) 
- approval tests (approvals) ("hand written" approval test as well as approval tests in combination with jqwik)

Missing mutation tests? It's also inside! Just run ```./mvn org.pitest:pitest-maven:mutationCoverage```

