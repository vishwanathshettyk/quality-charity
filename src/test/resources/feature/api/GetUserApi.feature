@API
Feature: API demo

  Scenario: Valid get endpoint
      When request submitted to response api
      Then response status is 200
