@parallel=true
Feature:
  Background:
#    * karate.callSingle('classpath:common/once.feature')
    * call read('classpath:common/once.feature') {progress: 100}

  Scenario:
    * print 'test'

  Scenario Outline:
    * print 'order', <name>

    Examples:
    |name|
    |12  |
    |1231|
