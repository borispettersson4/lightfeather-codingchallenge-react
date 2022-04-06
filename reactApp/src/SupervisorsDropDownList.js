import React from 'react'
class SupervisorsDropDownList extends React.Component{

        constructor(){
            super();

            this.state = {
                'supervisorList': []
            }

        }

        getList(){
            fetch('http://localhost:8080/api/supervisors/')
            .then(results => results.json())
            .then(results => console.log(results))
            .then(results => this.setState({supervisorList: results}))
            .then(results => this.setState({person: results[0]}));

            console.log("Saved Data:");
            //console.log(person + "");

        }

        async componentDidMount(){
            console.log("gETTING dATA");
            const url = 'http://localhost:8080/api/supervisors/';
            const response = await fetch(url);
            const data = await response.json();
            console.log(data);
            this.setState({"supervisorList": data});
            this.setState({person: data[0]});
/*
            console.log("Supervisor List :");
            console.log(this.getState("supervisorList"));

            console.log("Person :");
            console.log(this.state.person);
            */
        }



        render(){
            return(
                <div>
                    <select>
                        <option selected disabled="true">--- Select Supervisor ---</option>
                        {
                           this.state.supervisorList.map((result)=>(<option>{result.displayName}</option>))
                        }

                    </select>


                </div>
            );
        }
}

export default SupervisorsDropDownList;