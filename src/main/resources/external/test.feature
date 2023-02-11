@parallel=true
Feature:
  Background:
    * call read('classpath:common/once.feature') {progress: 100}

  Scenario:
    * print 'test'

  Scenario Outline:
    * print 'external', <name>

    Examples:
    |name|
    |12  |
    |1231|

  Scenario: test
    * print 'after'
    * karate.properties['name'] = 'JDP123'

  Scenario: test123
    * print 'after'
    * print karate.properties['name']

  @setup
  Scenario:
    * def name = 123123
    * print 'setup11111'
