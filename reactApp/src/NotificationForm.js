import React from 'react'
import axios from 'axios'
class NotificationForm extends React.Component{

        constructor(){
            super();

            this.state = {
                'supervisorList': [],
                firstName: '',
                lastName: '',
                email: '',
                phone: '',
                supervisor: '',
                errorLog:''
            }
        }

        async componentDidMount(){
            const url = 'http://localhost:8080/api/supervisors/';
            const response = await fetch(url);
            const data = await response.json();
            console.log(data);
            this.setState({"supervisorList": data});
        }

        changeHandler = (e) => {
            this.setState({[e.target.name]: e.target.value})
        }

        submitHandler = (e) => {
            e.preventDefault()
            console.log(this.state)
            axios.post('http://localhost:8080/api/submit/', this.state)
            .then(response => {
                console.log(response)
                this.setState({errorLog: response.data});
            })
            .catch(response => {
                console.log(response)
                this.setState({errorLog: "error"});
            })
        }



        render(){

            const {firstName,lastName,email,phone,supervisor} = this.state


            return (
            <div className="nForm">
                <h2>Notification Form</h2>

                <form onSubmit={this.submitHandler}>
                    <div class="row">
                        <div class="column">
                        <label>First Name</label>
                        <input
                            type="text"
                            name="firstName"
                            value={firstName}
                            onChange={this.changeHandler}
                            required
                        />
                        </div>
                        <div class="column">
                        <label>Last Name</label>
                        <input
                            type="text"
                            name="lastName"
                            value={lastName}
                            onChange={this.changeHandler}
                            required
                        />
                        </div>
                    </div>

                            <div class="row">
                                <div class="column">

                                <div class="sameLine">
                                    <div class="optionalEntries">
                                        <label for="emailCheck">Email</label>
                                        <span for="emailCheck">(optional)</span>
                                    </div>
                                </div>
                                <input
                                    type="text"
                                    name="email"
                                    value={email}
                                    onChange={this.changeHandler}
                                />
                                </div>

                                <div class="column">

                                    <div class="sameLine">
                                        <div class="optionalEntries">
                                            <label for="phoneCheck">Phone Number</label>
                                            <span for="emailCheck">(optional)</span>
                                        </div>
                                    </div>

                                <input
                                    type="text"
                                    name="phone"
                                    value={phone}
                                    onChange={this.changeHandler}
                                />
                                </div>
                            </div>

                    <label>Supervisor:</label>
                             <div>
                                <select name="supervisor" onChange={this.changeHandler} required>
                                    <option selected disabled="true">--- Select Supervisor ---</option>
                                    {
                                       this.state.supervisorList.map((result)=>(<option id={result.Id}>{result.displayName}</option>))
                                    }
                                </select>
                            </div>
                    <input type="submit" value="Submit"></input>
                </form>

                <div class="optionalEntries">
                    <span for="errorMessage" name="errorMessage">{this.state.errorLog}</span>
                </div>


            </div>



            );

        }
}

export default NotificationForm;