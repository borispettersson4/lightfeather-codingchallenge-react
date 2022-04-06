# lightfeather-codingchallenge-react
Lightfeather.io Coding Challenge using Springboot and React

This project showcases building a full-stack web-form application in under 48 hours using Springboot and React containerized using Docker.

### Overview (taken from challenge)
For this challenge, you will be building a simple form that will populate with data from an API
endpoint. After all validation on the form has been complete, the form response will be
submitted to another API endpoint. You will also be implementing this simple API which provides
a list of supervisors and accepts a registration to receive notifications from a given supervisor.

## What you need before downloading

If you haven't already, please have [Docker](https://docs.docker.com/get-docker/) installed in your local machine. This is the only
thing you need to have installed in your computer in order to be able to run this project.

## How to Run

After cloning this Git repository and making sure the folder is unzipped in your local machine, navigate to project directory using your command-line or favorite shell program.

```
lightfeather-codingchallenge-react
----------------------------------
.idea
reactApp  
springbootApp   
.gitattributes    
docker-compose.yml 
LICENSE
README.md
```
When you are ready to run the application, type in the following in the command line:

```
❯ docker-compose up
```
Since you likely never ran this docker compose before, it should initiate a docker-build such as:
```
[+] Building 20.2s (17/20)
 => [lightfeather-codingchallenge-react_app-react internal] load build definition from Dockerfile                                                                                      0.0s
 => => transferring dockerfile: 32B                                                                                                                                                    0.0s
 => [lightfeather-codingchallenge-react_app-springboot internal] load build definition from Dockerfile                                                                                 0.0s
 => => transferring dockerfile: 32B                                                                                                                                                    0.0s
 => [lightfeather-codingchallenge-react_app-react internal] load .dockerignore                                                                                                         0.0s
 => => transferring context: 34B                                                                                                                                                       0.0s
 => [lightfeather-codingchallenge-react_app-springboot internal] load .dockerignore                                                                                                    0.0s
 => => transferring context: 34B                                                                                                                                                       0.0s
 => [lightfeather-codingchallenge-react_app-react internal] load metadata for docker.io/library/node:14.16.0-alpine                                                                    1.7s
 => [lightfeather-codingchallenge-react_app-springboot internal] load metadata for docker.io/library/gradle:6.8-jdk11-openj9                                                           1.6s
 => [auth] library/gradle:pull token for registry-1.docker.io                                                                                                                          0.0s
 => [auth] library/node:pull token for registry-1.docker.io                                                                                                                            0.0s
 => [lightfeather-codingchallenge-react_app-springboot 1/4] FROM docker.io/library/gradle:6.8-jdk11-openj9@sha256:4939d0dee4b6bf9d8a55fb78d13f43a69cbfc9269de001e7ed2980090a26e302     0.0s
 => [lightfeather-codingchallenge-react_app-springboot internal] load build context                                                                                                    0.0s
 => => transferring context: 271.76kB                                                                                                                                                  0.0s
 => [lightfeather-codingchallenge-react_app-react 1/6] FROM docker.io/library/node:14.16.0-alpine@sha256:0a6a21d28509f56155007444075ef4fdd36eef0a97924623cb641d3766e3b8d3              0.0s
 => [lightfeather-codingchallenge-react_app-react internal] load build context                                                                                                         0.0s
 => => transferring context: 10.93kB                                                                                                                                                   0.0s
 => CACHED [lightfeather-codingchallenge-react_app-springboot 2/4] WORKDIR /home/gradle                                                                                                0.0s
 => [lightfeather-codingchallenge-react_app-springboot 3/4] COPY . .                                                                                                                   0.0s
 => CACHED [lightfeather-codingchallenge-react_app-react 2/6] WORKDIR /app                                                                                                             0.0s
 => [lightfeather-codingchallenge-react_app-react 3/6] COPY package.json ./                                                                                                            0.0s
 => [lightfeather-codingchallenge-react_app-springboot 4/4] RUN gradle bootJar                                                                                                        18.4s
```
Once SpringBoot and React are running, you are now ready to interact with the application!

## Interacting with the Application

To access the front-end and back-end of the application respectively, here are the URLs that interact with each one:

### React Application
To access the front-end portion of the application, open a web browser and type in the following URL:
```
http://localhost:3000
```
#### Submitting form data
When you submit a valid form after filling the required fields in the front-end. You can check the output logs in the command line 
containing the entries made in the front-end reflected in the server. Such as the example below:
```
lightfeather-codingchallenge-react-app-springboot-1  | ____________________________________________
lightfeather-codingchallenge-react-app-springboot-1  | New Employee Created :
lightfeather-codingchallenge-react-app-springboot-1  |
lightfeather-codingchallenge-react-app-springboot-1  | Employee First Name : John
lightfeather-codingchallenge-react-app-springboot-1  | Employee Last Name : Smith
lightfeather-codingchallenge-react-app-springboot-1  | Employee Email Address : johnsmith@gmail.com
lightfeather-codingchallenge-react-app-springboot-1  | Employee Phone Number: 8476657620
lightfeather-codingchallenge-react-app-springboot-1  |
lightfeather-codingchallenge-react-app-springboot-1  | Supervisor First Name : Maribel
lightfeather-codingchallenge-react-app-springboot-1  | Supervisor Last Name : D'Amore
lightfeather-codingchallenge-react-app-springboot-1  | Supervisor Phone Number : 800.768.4032 x7410
lightfeather-codingchallenge-react-app-springboot-1  | Supervisor Jurisdiction : x
lightfeather-codingchallenge-react-app-springboot-1  | ____________________________________________
```

### SpringBoot Application
To interact with the back-end portion of the application, open a web browser or a program like Postman and type in the following URL:
```
http://localhost:8080
```
#### RESTful functionality within the SpringBoot application
Returns a list of supervisors:
```
GET
http://localhost:8080/api/supervisors
```
Submits user-entered data to the server:
```
POST
http://localhost:8080/api/submit
```
### Shutting down the application
If you need to shut down the project, run the following command:
```
❯ docker-compose down
```
Or simply press CTRL+C in the command line to shut down the project.

## Conclusion
And that's it!
If you have any questions regarding this project or similar inquiries, please reach me at: 
borisruiz4@gmail.com


