@parallel=false
Feature:
  Background:
    * karate.callSingle('classpath:common/once.feature')
#    * call read('classpath:common/once.feature') {progress: 100}

  Scenario:
    * print 'test2'

  Scenario Outline:
    * print 'test2', <name>

    Examples:
    |name|
    |12  |
    |1231|

  Scenario:
    * print 'test2 end'