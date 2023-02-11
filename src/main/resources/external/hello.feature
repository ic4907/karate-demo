Feature:
  Background:
    * karate.callSingle('classpath:common/once.feature')

  Scenario:
    * print 'hello external'
    * print 'awefafef', karate.properties['name']

  Scenario:
    * print 'hello1 external'