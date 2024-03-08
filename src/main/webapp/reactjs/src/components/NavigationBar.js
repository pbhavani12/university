import React, {Component} from 'react';
import {Navbar,Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom'

class NavigationBar extends Component {
    render() {
        return (

           <Navbar bg="dark" variant="dark">
               <Link to={""} className="navbar-brand">
                   <img src="https://image.flaticon.com/icons/svg/1157/1157044.svg" width="25" height="25" alt="brand"/>{' '}
                    University Management system
               </Link>

               <Nav className="mr-auto">
                   {/*<Link to={""} className="navbar-link">Home</Link>*/}
                   {/*<Link to={""} className="navbar-link">Add Student</Link>*/}
                   {/*<Link to={""} className="navbar-link">Add Course</Link>*/}
                   <Link to={"add-professor"} className="nav-link">Add Professor </Link>
                   <Link to={"professors"} className="nav-link"> List Professor</Link>{'  '}
                   <Link to={"add-course"} className="nav-link">Add Course </Link>
                   <Link to={"courses"} className="nav-link"> List Courses</Link>
                   <Link to={"add-student"} className="nav-link">Add Student </Link>
                   <Link to={"students"} className="nav-link"> List Student</Link>

               </Nav>

           </Navbar>
        );
    }
}

export default NavigationBar;