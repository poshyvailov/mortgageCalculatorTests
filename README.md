This repository contains different UI autotests (Acceptance, E2E and Negative tests for the "mortgage-calculator" website - https://www.zillow.com/mortgage-calculator)<br/> 
All tests were automated using Java, Selenide and TestNG.<br/> 

Tech Stack:<br/> 
	•	Java 17<br/> 
	•	Selenide<br/> 
	•	TestNG<br/> 
 	•	Allure<br/> 
	•	Maven for build and dependency management<br/> 

Getting Started<br/> 
	1.	Ensure you have Java 17 and Maven installed.<br/> 
	2.	Clone the repository:<br/> 
 `git clone https://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@github.com/poshyvailov/mortgageCalculatorTests.git`<br/>
 	3.	Navigate to the project directory:
  `cd mortgageCalculatorTests`<br/>
  4.	Run the tests:<br/>
  `mvn clean test`<br/>
  <br/>
Test Reports<br/>
The project uses Allure for reporting. After the tests have run, you can generate and view reports locally<br/>
Use next commands:<br/>
`mvn test -Dallure.results.directory=target/allure-results`<br/>
`mvn allure:serve `<br/>
This command will start a local server and open the generated report in your default browser.<br/>
<br/>
Future Considerations and Expansion<br/>
	•	Parallel Execution:<br/>
As the test suite grows, consider running tests in parallel to reduce overall execution time.<br/> 
	•	Page Object Model (POM) Refinement:<br/>
 In the future we can add "BasePage" class where we will add common methods and elements that will be used on different pages of our test application<br/>
	•	CI/CD Integration:<br/>
We should integrate our tests with CI/CD process (e.g., Jenkins, GitHub Actions, GitLab CI) it will help ensure quick feedback on code changes.<br/>
	•	Scalability & Cloud-based Testing:<br/>
As the number of tests grows, we should consider running them on a cloud-based testing platform (e.g.: Selenium Grid).<br/>
	•	Error Handling & Retry Logic:<br/>
For flakey tests (often due to network latency, dynamic elements, or API delays), we should add a retry mechanism for flacky tests<br/>


  
 
