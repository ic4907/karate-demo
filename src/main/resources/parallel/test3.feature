@parallel=false
Feature:
  Background:
    * karate.callSingle('classpath:common/once.feature')
#    * call read('classpath:common/once.feature') {progress: 100}

  Scenario:
    * print 'test3'
    * karate.properties['name'] = 'JDP123-123123123'

  Scenario Outline:
    * print 'test3', <name>, karate.properties['name']

    Examples:
    |name|
    |12  |
    |1231|

  Scenario:
    * print 'test3 end'
