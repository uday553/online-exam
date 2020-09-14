# Online Exam Service
Components : Examinar , Candidate , Test
### Examinar
Examinar can create tests and share them with the candidates. Examinar can see the results of candidates for that test. 
### Test
Test will have list questions and answers. Each test will have an expiry date, time limit. Question will be accessed one after the other, If any question is not followed the order, then we have to send an error response. Once it’s submitted or the time limit is over or the test expires then we have to end the test.
### Candidate
Candidate has to login with the password sent for that test. That password should be unique based on the test and candidate.


## API Design
## Examinar
### Login Api
      Api type : 		Post
      Service URL:	    /examinar/v1/login
      Service Name:	    ExaminerLoginService
      Payload:		    {
                              username:  name,
                              password:  xxxx
                        }
      response: 		{
                              token:  xxxxx
                        }
### List Tests
      Api type : 		Get
      Service URL:	    /examinar/v1/test/list/<offset>
      Service Name:	    ExaminerTestService
      Headers:		    examinerToken
      PayLoad:		    {
                        }
      response: 		{
                                    [
                                      {
                                        Testname: abc
                                        testID:  111
                                      }
                                    ]
                        }
### Create Test
      Api type : 		Post
      Service URL:	    /examinar/v1/test/new
      Headers:		    examinerToken
      Service Name:	    ExaminerTestService
      PayLoad:		    {
                              name:      Test Name,
                              visibleDate:  dd-mm-yyyy,
                              expiryDate:  dd-mm-yyyy,
                              timeLimit: <no of minutes>
                        }
      response: 		{
                                    message : “test created”
                        }
### Delete Test
      Api type : 		Get
      Service URL:	    /examinar/v1/test/remove/<test-id>
      Headers:		    examinerToken
      Service Name:	    ExaminerTestService
      PayLoad:		    {
                        }
      response: 		{
                                    message : “test deleted”
                        }
### List Test Results
      Api type : 		Get
      Service URL:	    /examinar/v1/test/result/<testId>
      Service Name:	    LoginService
      Headers:		    ExaminerTestService
      PayLoad:		    {
                        }
      response: 		{
                                    noQuestions:  <number of question> 
                                    results:  [
                                                {	
                                                studentid:
                                                result:
                                                }
                                          ]
                        }
### Mapping test to candidates
    Api type : 		    Post
    Service URL:		/examinar/v1/test/candidate/map/<testid>
    Service Name:	    ExaminerTestService
    Payload:		    {
                            candidateList: [ candidate1, candidate2, candidate3]
                        }
    response: 		    {
                              message : “test mapped successfully”
                        }
### Add questions to test
    Api type : 		    Post
    Service URL:		/examinar/v1/test/questions/new/<test-id>
    Service Name:	    QuestionsService
    Headers:		    examinerToken
    PayLoad:		    {
                            question: ”------------- “,
                            options:  [ option1, option2, option3, option4]
                            answer: [option1]
                        }
    response: 		    {
                                        message : “question/s added successfully”
                        }
    Remove questions from test
### Api type : 		    Post
    Service URL:		/examinar/v1/test/questions/remove/<test-id>
    Service Name:	    QuestionsService
    Headers:		    examinerToken
    PayLoad:		    {
                                    questions: [questionId1, questionId2]
                        }
    response: 		    {
                                        message : “question/s removed deleted”
                        }
## Candidate
### Test login
      Api type : 		Post
      Service URL:	    /candidate/v1/login/<testid>
      Service Name:	    CandidateLoginService
      Payload:		    {
                              username:  name,
                              password:  xxxx
                        }
      response: 		{
                              token:  xxxxx
                        }
### Test Start
    Api type : 		    Get
    Service URL:		/candidate/v1/test/start
    Service Name:	      CandidateTestService
    Headers:		    candidateTestToken
    Payload:		    {}
    response: 		    {
                                    message:”Test Sarted”
                        }
### Test Submit
    Api type : 		    Post
    Service URL:		/candidate/v1/test/question/submit
    Service Name:	    CandidateQuestionService
    Headers:		    candidateTestToken
    Payload:		    {
                            username:  name,
                            password:  xxxx
                        }
    response:     	    {
                                        message: “test submitted”
                        }
### Answer Submit
    Api type : 		    Post
    Service URL:		/candidate/v1/test/answer/submit
    Service Name:	    CandidateQuestionService
    Headers:		    candidateTestToken
    Payload:		    {
                            questionid: <questionid>,
                            answer: [option1,option2]
                        }
                        response: 		{
                                        message: “answer updated”
                        }


# Database Design
## Entities
### examinar
    id
    name
    email_id
    password
    status
    created_at
### test
    id
    name
    Status <ACTIVE/ EXPIRED/ SUBMITTED>
    time_limit 
    created_at
    visible_at
    expired_at
### question
    id
    test_id
    question 
    options <json string>
    answer <json string>
    status
    created_at
### candidate_auth
    id
    test_id
    email_id
    password
    status<ACTIVE /INACTIVE>
    created_at
    expired_at
### candidate_test
    id
    test_id
    email_id
    password
    status <ACTIVE/ STARTED/ EXPIRED/ SUBMITTED>
    result
    created_at
    expired_at
### candidate_question_answer
  id
  candidate_test_id
  sequence
  question_id
  answer <json string>
  is_right_answer
  created_at
  Deleted_at

## Cache

ExaminerToken cache
CandidateTestToken cache
LastAttemptedQuestion cache
