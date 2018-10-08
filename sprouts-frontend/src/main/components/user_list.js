import React from 'react';
import { connect } from 'react-redux';
import User from './user';

const UserList = (props) => (
    <div>
        <h3>User List:</h3>
        <br />
        <table border="1">
          <thead>
            <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email Id</th>
            <th>Phone Number</th>
            <th>Time Created</th>
            <th>Time Updated</th>
            </tr>
          </thead>
          <tbody>
            {props.users.map(user => {
                return (
                     <User {...user} key={user.id}/>
                );
            })}
          </tbody>
        </table>

    </div>
);

const mapStateToProps = (state) => {
    return {
        users: state
    };
}

export default connect(mapStateToProps)(UserList);