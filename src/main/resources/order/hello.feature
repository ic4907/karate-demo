Feature:
  Background:
    * karate.callSingle('classpath:common/once.feature')

  Scenario:
    * print 'hello order'
    * print 'awefafef', karate.properties['name']

  Scenario:
    * print 'hello1'