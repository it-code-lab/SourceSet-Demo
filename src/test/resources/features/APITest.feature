Feature: Validation of get method

  @GetStudentDetails
  Scenario Outline: Send a valid Request to get student details

    Given I send a request to the URL to get student details
    Then the response will return status "<rt_status>" and id <id> and name "<st_name>" and grade "<st_grade>"

    Examples:
      |id  |st_name        |st_grade   |rt_status|
      |1   |Ana            |One        |200|

