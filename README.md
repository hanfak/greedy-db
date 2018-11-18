TODO:

* (x) Task
    * Tests
        * (x) Yatspec setup for acceptance tests (test usecase)
        * (x) Integration tests with database and rest
        * (x) End to end tests (whole app up and dependecies up)
            * (x) ?? mock call to webserver
        * (*) Stub to continually update db with dummy data, and add specific data
    * (x) clean architecture
        * Core
            * Entity
                * Value types ie Employers; Clicks; Origin
                * Single Value types ie: Timestamp; id; page
            * Use case
                * store stream data point
                    - Validate json, timestamp  & stream exisits
                    - Store it
                    - Usecase for Employer and Clicks stream
                    - !!!! Decision - Do I give the click object to repository to store however it sees fit OR do i store origin, retrive foreign key, and store origin id and click ???
                * search stream at time for field
                    - field exists for stream
                    - timestamp exists with 30 minutes before going to dataprovider
                    - Ask dataprovider for value
                    - return it
                * search latest stream for field
                * search oldest stream for field
            * Interfaces/adapters
            * Logging
        * Infrastructure
            * dataproviders
                * (x) database, mysql or mongodb??, connection pool???,
            * entrypoints
                * (x) Web - Jetty webserver
                * (x) Scheduled Jobs
        * Configuration
            * (x) dependency injection/wiring (guice?)
            * (x) ApplicationRunner
            * (x) properties
    * (x) logs
        * (x)  stack trace preserved
    * (x) flyway migration
        - To setup db with relevent tables
        - tables:
            - employers: timestamp (non null); id; name; surname;
            - clicks: timestamp (non null); page; originId;
            - origin: id; brand; pos
        - cascade delete
        - (x) Add as part of maven build
    * (x) scheduled job for deleting data ???
        - Run a job every minute that deletes json objects in each stream greater than 30 minutes
        - Quartz
    * End points for services
        * (x) POST /import/{streamName}
            - Service to add single stream of json to db
                - for each streamName will go to specific usecase
            - Return 204
            - Sad Path: 404, Body: Could not store
            - ?? If Stream does not exist, add new table, else add available table
            - Sad Path: issues with database
            - Sad Path: timestamp not present
            - Sad Path: stream exist, but format of json is not compliant
        * (x) GET /query/{streamName}/{timestamp}/{jsonPath}
            - Service to return the value of the field specified with the JSON Path for the given stream on a given timestamp.
            - Happy Path: return 200 and json of key value pair
            - Sad Path: 404, Body: No stream
        * (x) GET /query/{streamName}/latest/{jsonPath}
            - Service to return the latest value of the field specified with the JSON Path for the given stream.
            - Happy Path: return 200 and json of key value pair
            - Sad Path: 404, Body: No stream
        * (x) GET /query/{streamName}/oldest/{jsonPath}
            - Service to return the oldest value of the field specified with the JSON Path for the given stream.
            - Happy Path: return 200 and json of key value pair
            - Sad Path: 404, Body: No stream
        * (*) DELETE /deleteOldData ????
            - Deletes all data greater than 30 minutes
            - Happy Path: 204
* (x) seperate acceptance tests into module
* (x) run via docker ???
    * (x) db container
    * (x) stub container, which populates db with data
* (x) Scripts to run
* (x) Use Kafka streams ???
* (x) Parallel processing for mass and/or concurrent numbers of imports
* (x) Build - Gradle

Links

* https://github.com/erh/mongo-jdbc/blob/master/examples/blog.java
* https://www.journaldev.com/2403/google-guice-dependency-injection-example-tutorial