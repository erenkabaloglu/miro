# miro
miro web signup

pre reqs:
Java 8
Maven 3.6

running:
clone this repository to your workspace
at the project root directory run "mvn test"

alternatively you can run with args

mvn test -DargLine="-Denv=prod -Dlang=en -Dbrowser=firefox -Dheadless=y"

env: to run tests in different testing environments. default is "prod". currently no other environments defined
lang: for multilanguage support. default is "en".
browser: web driver type. default is "chrome". only chrome and firefox are added
headless: opens browser in headless mode if set to "y". default is n

project structure:
  cucumber for bdd
  feature file is associated with SignupStepDefs (one feature file and one spec file since single feature is tested)
  step definitions call page methods where page object pattern is used
  there is no selenium logic inside page models. for reusability they are implemented in page element classes
  
test cases:
  in scope: signup form functional cases
  out of scope: external signups(google, fb...), link verifications(terms, login, privacy)
  
  4 data driven functional scenarios implemented which execute 17 scenarios in total
    1. successful signup (combination of "how did you hear about miro" and "receive news and updates" are empty)
    2. invalid signup (combinations of missing required fields) more combinations can be added here
    3. invalid email input (testing against some of the invalid email entries)
    4. testing 4 states of password hint
    
  potential bugs:
    1. typo in reference dropdown tooltip "How did your hear about miro". Expected is "How did you hear about miro"
    2. reference dropdown does not load occasionally, not a blocker issue but makes some tests fail
    3. password hint is rendered under reference dropdown. Expected to render under password field
    4. if all required form fields are empty, when i click submit only "Please enter your password." field is displayed. Expected to see all required field messages(not sure if it is a bug or feature))
    
  
